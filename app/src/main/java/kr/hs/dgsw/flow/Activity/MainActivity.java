package kr.hs.dgsw.flow.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}
