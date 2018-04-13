package kr.hs.dgsw.ahn.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import kr.hs.dgsw.ahn.Database.DBManager;
import kr.hs.dgsw.ahn.Model.ResponseFormat;
import kr.hs.dgsw.ahn.Model.UserAuth;
import kr.hs.dgsw.ahn.Network.Network;
import kr.hs.dgsw.ahn.R;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final DBManager dbManager = new DBManager(getApplicationContext());

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etTel = (EditText) findViewById(R.id.etTel);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etGender = (EditText) findViewById(R.id.etGender);
        final EditText etClassIdx = (EditText) findViewById(R.id.etClassIdx);
        final EditText etClassNum = (EditText) findViewById(R.id.etClassNum);

        final Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // submit 버튼을 눌렀을때 일어나야 할 이벤트 처리
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String tel = etTel.getText().toString();
                String password = etPassword.getText().toString();
                String gender = etGender.getText().toString();
                int classIdx = Integer.parseInt(etClassIdx.getText().toString());
                int classNum = Integer.parseInt(etClassNum.getText().toString());

                UserAuth user = new UserAuth();

                user.setName(name);
                user.setEmail(email);
                user.setMobile(tel);
                user.setPassword(password);
                user.setGender(gender);
                user.setClass_idx(classIdx);
                user.setClass_number(classNum);

                final Network network = Network.retrofit.create(Network.class);
                Call<ResponseFormat> call = network.signup(user);
                call.enqueue(new Callback<ResponseFormat>() {
                    @Override
                    public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                        Log.e("result", response.body().toString());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("result", t.getMessage());
                    }
                });

                //database
                dbManager.insert("INSERT INTO " +
                        "register(email,password,name,gender,mobile,class_idx,class_number)" +
                        " VALUES('" + email + "','" + password + "','" + name + "','" + gender + "','" + tel + "'," + classIdx + "," + classNum + ");" +
                        "");

            }


        });
    }


}
