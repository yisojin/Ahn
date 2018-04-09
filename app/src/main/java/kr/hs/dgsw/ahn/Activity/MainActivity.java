package kr.hs.dgsw.ahn.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.hs.dgsw.ahn.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMealInfo(View view){
        Intent intent = new Intent(MainActivity.this,MealActivity.class);
        startActivity(intent);
    }

    public void onClickApplication(View view){
        Intent intent = new Intent(MainActivity.this,MealActivity.class);
        startActivity(intent);
    }


}
