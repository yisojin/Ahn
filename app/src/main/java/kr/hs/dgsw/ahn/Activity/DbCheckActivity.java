package kr.hs.dgsw.ahn.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.hs.dgsw.ahn.Database.DBManager;
import kr.hs.dgsw.ahn.R;

public class DbCheckActivity extends AppCompatActivity {


    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_check);


        DBManager dbManager = new DBManager(getApplicationContext());

        ListView listView = (ListView) findViewById(R.id.listView);

        for(String item: dbManager.PrintData()){
            list.add(item);
        }

        adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.text1,list);

        listView.setAdapter(adapter);

    }
}
