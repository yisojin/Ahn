package kr.hs.dgsw.flow.Activity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import kr.hs.dgsw.flow.DateTime.FindDate;
import kr.hs.dgsw.flow.Network.RunTask;
import kr.hs.dgsw.flow.Network.RunTask2;
import kr.hs.dgsw.flow.R;

public class MealActivity extends AppCompatActivity {

    int year, month, day;
    FindDate findDate = new FindDate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        getSupportActionBar().hide();

        GregorianCalendar calendar = new GregorianCalendar();

        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);

        day = calendar.get(Calendar.DAY_OF_MONTH);

        new RunTask(this.findViewById(android.R.id.content), findDate.dates()).execute();
    }

    public void onClickDatePickerOpen(View view) {

        new DatePickerDialog(MealActivity.this, dateSetListener, year, month, day).show();

    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            List<Integer> date = new ArrayList<Integer>();
            date.add(year);
            date.add(month + 1);
            date.add(dayOfMonth);

            new RunTask2(findViewById(android.R.id.content), date).execute();
        }

    };
}
