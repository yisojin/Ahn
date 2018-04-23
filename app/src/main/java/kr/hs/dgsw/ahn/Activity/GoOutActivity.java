package kr.hs.dgsw.ahn.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import kr.hs.dgsw.ahn.R;

public class GoOutActivity extends AppCompatActivity {

    final int DIALOG_DATE = 1;
    final int DIALOG_TIME = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_out);

        EditText etStartDate = (EditText)findViewById(R.id.etStartDate);
        EditText etStartTime = (EditText)findViewById(R.id.etStartTime);

        EditText etEndDate = (EditText)findViewById(R.id.etEndDate);
        EditText etEndTime = (EditText)findViewById(R.id.etEndTime);

        EditText etReason = (EditText)findViewById(R.id.etReason);

        Button btnSubmit = (Button)findViewById(R.id.btnSubmit);

        etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_DATE);
            }
        });

        etStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_TIME);
            }
        });

    }

    @Deprecated
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case DIALOG_DATE:
                DatePickerDialog dpd = new DatePickerDialog(GoOutActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.e("Date", year+"-"+month+"-"+dayOfMonth);
                    }
                }, 2018,4,23);
                return dpd;
            case DIALOG_TIME:
                TimePickerDialog tpd = new TimePickerDialog(GoOutActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.e("Time", hourOfDay+":"+minute);

                    }
                },16,26,true);
                return tpd;
        }
        return super.onCreateDialog(id);
    }
}
