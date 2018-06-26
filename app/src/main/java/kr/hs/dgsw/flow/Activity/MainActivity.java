package kr.hs.dgsw.flow.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.messaging.FirebaseMessaging;

import kr.hs.dgsw.flow.Model.GoOut;
import kr.hs.dgsw.flow.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Button btnMeal = (Button) findViewById(R.id.btnMeal);
        Button btnApplication = (Button) findViewById(R.id.btnApplication);
        Button btnNotice = (Button) findViewById(R.id.btnNotice);
        Button btnDB = (Button) findViewById(R.id.btnDatabase);

        btnApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GoOutActivity.class);
                startActivity(intent);
            }
        });

        btnMeal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MealActivity.class);
                startActivity(intent);
            }
        });

        btnNotice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });
        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DbCheckActivity.class);
                startActivity(intent);
            }
        });
    }
}
