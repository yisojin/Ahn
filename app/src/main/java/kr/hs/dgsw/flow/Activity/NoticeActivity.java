package kr.hs.dgsw.flow.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kr.hs.dgsw.flow.Database.DBManagerAuth;
import kr.hs.dgsw.flow.Model.GoOut;
import kr.hs.dgsw.flow.Model.JoinAuth;
import kr.hs.dgsw.flow.Model.LoginAuth;
import kr.hs.dgsw.flow.Model.Notice;
import kr.hs.dgsw.flow.Model.NoticeListData;
import kr.hs.dgsw.flow.Model.ResponseFormat;
import kr.hs.dgsw.flow.Model.ResponseFormatNotice;
import kr.hs.dgsw.flow.Network.Network;
import kr.hs.dgsw.flow.R;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class NoticeActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        getSupportActionBar().hide();

        ListView listView = (ListView) findViewById(R.id.lvNotice);
        final List<JSONObject> Jlist = new ArrayList<JSONObject>();

        final DBManagerAuth auth = new DBManagerAuth(getApplicationContext());

        final Network network = Network.retrofit.create(Network.class);
        Log.e("token", ">> " + auth.getLast());
        Call<ResponseFormatNotice> call = network.list(auth.getLast());
        call.enqueue(new Callback<ResponseFormatNotice>() {
            @Override
            public void onResponse(Response<ResponseFormatNotice> response, Retrofit retrofit) {
                Log.e("list", response.message());


//                List<Notice> lst = new ArrayList<Notice>();
//                for(Notice n : response.body().getData().getList()){
//                    lst.add(n);
//
//                    Log.e("data",n.toString());
//                }

//                Log.e("data",);


//                list.add(response.body().getData().toString());

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("error", t.getMessage());
            }
        });


        adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.text1,list);

        listView.setAdapter(adapter);
    }
}