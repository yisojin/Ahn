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
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Calendar;
import java.util.GregorianCalendar;

import kr.hs.dgsw.flow.Database.DBManagerApplication;
import kr.hs.dgsw.flow.Database.DBManagerAuth;
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
    int year = 0, month = 0, day = 0, hour = 0, minute = 0;
    RadioButton go, sleep;
    EditText etReason;
    GoOut goOut;
    int flagNum = 0;
    // flag number 이 1 이면 외출, 2면 외박.

    protected void onCreate(Bundle savedInstanceState) {

        final DBManagerAuth auth = new DBManagerAuth(getApplicationContext());
        final DBManagerApplication application = new DBManagerApplication(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_out);
        getSupportActionBar().hide();

        go = (RadioButton) findViewById(R.id.rbGoOut);
        sleep = (RadioButton) findViewById(R.id.rbSleepOut);

        go.setOnClickListener(radioBtnClick);
        sleep.setOnClickListener(radioBtnClick);

        final Button btnStartDate = (Button) findViewById(R.id.btnStartDate);
        final Button btnStartTime = (Button) findViewById(R.id.btnStartTime);
        final Button btnEndDate = (Button) findViewById(R.id.btnEndDate);
        final Button btnEndTime = (Button) findViewById(R.id.btnEndTime);
        etReason = (EditText) findViewById(R.id.etReason);
        final Button btnCheck = (Button) findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SDATETIME = s();
                EDATETIME = e();
                final String reason = etReason.getText().toString();

                goOut = new GoOut();
                goOut.setStart_time(SDATETIME);
                goOut.setEnd_time(EDATETIME);
                goOut.setReason(reason);

                Network network = Network.retrofit.create(Network.class);

                String token = auth.getLast();

                switch (flagNum) {
                    case 1:
                        Call<ResponseFormat> goCall = network.goout(token, goOut);

                        goCall.enqueue(new Callback<ResponseFormat>() {
                            @Override
                            public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                                Log.e("response", response.body().toString());

                                if(response.body().getStatus() == 200){
                                    //success
                                    application.insert("INSERT INTO application(kind,start_time,end_time,reason) VALUES(\'외출\',\'"+SDATETIME+"\',\'"+EDATETIME+"\',\'"+reason+"\');");
                                    Intent intent = new Intent(GoOutActivity.this, TestGoOutActivity.class);
                                    startActivity(intent);
                                }
                                if(response.body().getStatus() == 409){
                                    Toast.makeText(GoOutActivity.this, "이미 신청 하셨습니다.", Toast.LENGTH_SHORT).show();
                                }
                                if(response.body().getStatus() == 412){
                                    Toast.makeText(GoOutActivity.this,"신청 날짜가 유효하지 않습니다",Toast.LENGTH_SHORT).show();
                                }
                                if(response.body().getStatus() == 400){
                                    Toast.makeText(GoOutActivity.this, "입력양식을 맞춰주세요.", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Throwable t) {
                                Log.e("response", t.getMessage());
                            }
                        });
                        break;
                    case 2:
                        Call<ResponseFormat> sleepCall = network.sleepout(token, goOut);

                        sleepCall.enqueue(new Callback<ResponseFormat>() {
                            @Override
                            public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                                Log.e("response", response.body().toString());
                                if(response.body().getStatus() == 200){
                                    //success
                                    application.insert("INSERT INTO application(kind,start_time,end_time,reason) VALUES(\'외박\',\'"+SDATETIME+"\',\'"+EDATETIME+"\',\'"+reason+"\');");
                                    Intent intent = new Intent(GoOutActivity.this, TestGoOutActivity.class);
                                    startActivity(intent);
                                }
                                if(response.body().getStatus() == 409){
                                    Toast.makeText(GoOutActivity.this, "이미 신청 하셨습니다.", Toast.LENGTH_SHORT).show();
                                }
                                if(response.body().getStatus() == 412){
                                    Toast.makeText(GoOutActivity.this,"신청 날짜가 유효하지 않습니다",Toast.LENGTH_SHORT).show();
                                }
                                if(response.body().getStatus() == 400){
                                    Toast.makeText(GoOutActivity.this, "입력양식을 맞춰주세요.", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Throwable t) {
                                Log.e("response", t.getMessage());
                            }
                        });
                        break;
                }
            }
        });

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
    }

    RadioButton.OnClickListener radioBtnClick = new RadioButton.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (go.isChecked()) {

                flagNum = 1;

            } else if (sleep.isChecked()) {

                flagNum = 2;

            }
        }
    };

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month += 1;
            String mmmm = "";
            String dddd = "";
            if(month<10){
                mmmm = "0"+month;
            }else{
                mmmm = month+"";
            }
            if(dayOfMonth<10){
                dddd = "0"+dayOfMonth;
            }else{
                dddd = dayOfMonth+"";
            }
            SDATE = year + "-" + mmmm + "-" + dddd;
        }

    };

    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String hhhh="";
            String mmmm  ="";
            if(hourOfDay<10){
                hhhh = "0"+hourOfDay;
            }else{
                hhhh=hourOfDay+"";
            }
            if (minute < 10) {
                mmmm = "0"+minute;
            }else{
                mmmm = minute+"";
            }
            STIME = hourOfDay + ":" + minute;
        }
    };

    private DatePickerDialog.OnDateSetListener EdateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month += 1;
            String mmmm = "";
            String dddd = "";
            if(month<10){
                mmmm = "0"+month;
            }else{
                mmmm = month+"";
            }
            if(dayOfMonth<10){
                dddd = "0"+dayOfMonth;
            }else{
                dddd = dayOfMonth+"";
            }
            EDATE = year + "-" + mmmm + "-" + dddd;
        }

    };

    private TimePickerDialog.OnTimeSetListener EtimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String hhhh="";
            String mmmm  ="";
            if(hourOfDay<10){
                hhhh = "0"+hourOfDay;
            }else{
                hhhh = hourOfDay+"";
            }
            if (minute < 10) {
                mmmm = "0"+minute;
            }else{
                mmmm = minute+"";
            }
            ETIME = hourOfDay + ":" + minute;
        }
    };

    // start time simple date format
    // yyyy-MM-dd HH:mm:ss
    public String s() {
        return SDATE + " " + STIME;
    }

    //end time
    public String e() {
        return EDATE + " " + ETIME;
    }
}

