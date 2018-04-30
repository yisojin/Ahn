package kr.hs.dgsw.flow.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import kr.hs.dgsw.flow.Model.GoOut;
import kr.hs.dgsw.flow.Model.ResponseFormat;
import kr.hs.dgsw.flow.Network.Network;
import kr.hs.dgsw.flow.R;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class GoOutActivity extends AppCompatActivity {

    String SDATE = "";
    String STIME = "";
    String SDATETIME = "";
    String EDATE = "";
    String ETIME = "";
    String EDATETIME = "";
    int year, month, day, hour, minute;

    EditText etStartDate, etStartTime, etEndDate, etEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_out);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rbGroup);
        final RadioButton go = (RadioButton) findViewById(R.id.rbGoOut);
        final RadioButton sleep = (RadioButton) findViewById(R.id.rbSleepOut);

        etStartDate = (EditText) findViewById(R.id.etStartDate);
        etStartTime = (EditText) findViewById(R.id.etStartTime);
        etEndDate = (EditText) findViewById(R.id.etEndDate);
        etEndTime = (EditText) findViewById(R.id.etEndTime);
        final EditText etReason = (EditText) findViewById(R.id.etReason);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(GoOutActivity.this, dateSetListener, year, month, day).show();
            }
        });
        etStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(GoOutActivity.this, timeSetListener, hour, minute, true).show();
            }
        });
        etEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(GoOutActivity.this, EdateSetListener, year, month, day).show();
            }
        });
        etEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(GoOutActivity.this, EtimeSetListener, hour, minute, true).show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SDATETIME = s();
                EDATETIME = e();
                String reason = etReason.getText().toString();

                GoOut goOut = new GoOut();
                goOut.setStart_time(SDATETIME);
                goOut.setEnd_time(EDATETIME);
                goOut.setReason(reason);

                final Network network = Network.retrofit.create(Network.class);
                Call<ResponseFormat> call = null;

                if (go.isChecked()) {
                    call = network.goout(goOut);
                    call.enqueue(new Callback<ResponseFormat>() {
                        @Override
                        public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                            Log.e("response", response.body().toString());
//                            Toast.makeText(GoOutActivity.this, "success to go out!!!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(GoOutActivity.this, TestGoOutActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Log.e("response", t.getMessage());
                        }
                    });
                } else if (sleep.isChecked()) {
                    call = network.sleepout(goOut);
                    call.enqueue(new Callback<ResponseFormat>() {
                        @Override
                        public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                            Log.e("response",response.body().toString());
                            Toast.makeText(GoOutActivity.this, "success to sleep out!!!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(GoOutActivity.this, TestSleepOutActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Log.e("response",t.getMessage());
                        }
                    });
                }
            }
        });
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month += 1;
            SDATE = year + "-" + month + "-" + dayOfMonth;
        }

    };

    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            STIME = hourOfDay + ":" + minute;
        }
    };

    private DatePickerDialog.OnDateSetListener EdateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month += 1;
            EDATE = year + "-" + month + "-" + dayOfMonth;
        }

    };

    private TimePickerDialog.OnTimeSetListener EtimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            ETIME = hourOfDay + ":" + minute;
        }
    };

// start time simple date format
    // yyyy-MM-dd HH:mm:ss
    public String s() {
       return  SDATE + " " + STIME+":00";
    }
//end time
    public String e() {
        return EDATE + " " + ETIME+":00";
    }


}
