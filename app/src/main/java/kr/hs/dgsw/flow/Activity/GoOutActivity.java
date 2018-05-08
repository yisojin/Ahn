package kr.hs.dgsw.flow.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
    int year=0, month=0, day=0, hour=0, minute=0;
    RadioButton go, sleep;
    RadioGroup radioGroup;
    Network network;
    GoOut goOut;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_out);

        go = (RadioButton) findViewById(R.id.rbGoOut);
        sleep = (RadioButton) findViewById(R.id.rbSleepOut);

        radioGroup = (RadioGroup) findViewById(R.id.rbGroup);
        radioGroup.setOnCheckedChangeListener(GroupChangeListener);


        final Button btnStartDate = (Button) findViewById(R.id.btnStartDate);
        final Button btnStartTime = (Button) findViewById(R.id.btnStartTime);
        final Button btnEndDate = (Button) findViewById(R.id.btnEndDate);
        final Button btnEndTime = (Button) findViewById(R.id.btnEndTime);
        final EditText etReason = (EditText) findViewById(R.id.etReason);
        final Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);



        btnStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(GoOutActivity.this, dateSetListener, year, month, day).show();
            }
        });
        btnStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(GoOutActivity.this, timeSetListener, hour, minute, true).show();
            }
        });
        btnEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(GoOutActivity.this, EdateSetListener, year, month, day).show();
            }
        });
        btnEndTime.setOnClickListener(new View.OnClickListener() {
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

                goOut = new GoOut();
                goOut.setStart_time("'"+SDATETIME+"'");
                goOut.setEnd_time("'"+EDATETIME+"'");
                goOut.setReason(reason);

                network = Network.retrofit.create(Network.class);


            }
        });
    }


    RadioGroup.OnCheckedChangeListener GroupChangeListener = new RadioGroup.OnCheckedChangeListener() {

        Call<ResponseFormat> call = network.goout(goOut);
        Call<ResponseFormat> call2 = network.sleepout(goOut);
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {


            if (checkedId == R.id.rbGoOut) {

                call.enqueue(new Callback<ResponseFormat>() {
                    @Override
                    public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                        Log.e("response",response.body().toString());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("response",t.getMessage());
                    }
                });
            } else if (checkedId == R.id.rbSleepOut) {

                call2.enqueue(new Callback<ResponseFormat>() {
                    @Override
                    public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                        Log.e("response",response.body().toString());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("response",t.getMessage());
                    }
                });
            }


        }
    };

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
        return  SDATE + " " + STIME;
    }
    //end time
    public String e() {
        return EDATE + " " + ETIME;
    }

    }

