package kr.hs.dgsw.flow.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import kr.hs.dgsw.flow.Database.DBManagerApplication;
import kr.hs.dgsw.flow.Database.DBManagerAuth;
import kr.hs.dgsw.flow.R;

public class DbCheckActivity extends AppCompatActivity {


    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_check);


        DBManagerAuth dbManagerAuth = new DBManagerAuth(getApplicationContext());
        DBManagerApplication dbManagerApplication = new DBManagerApplication(getApplicationContext());

        ListView listView = (ListView) findViewById(R.id.listView);

        for(String item: dbManagerAuth.PrintData()){
            list.add(item);
        }
//        for(String item: dbManagerApplication.PrintData()){
//            list.add(item);
//        }

        adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.text1,list);

        listView.setAdapter(adapter);

    }
}
