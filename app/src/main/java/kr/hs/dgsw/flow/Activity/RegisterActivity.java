package kr.hs.dgsw.flow.Activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kr.hs.dgsw.flow.Database.DBManager;
import kr.hs.dgsw.flow.Model.JoinAuth;
import kr.hs.dgsw.flow.Model.ResponseFormat;
import kr.hs.dgsw.flow.Network.Network;
import kr.hs.dgsw.flow.R;
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
        final EditText etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);

        final Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // submit 버튼을 눌렀을때 일어나야 할 이벤트 처리
                String name = etName.getText().toString();
                String email = etEmail.getText().toString().trim();
                String tel = etTel.getText().toString();
                String firPassword = etPassword.getText().toString();
                String gender = etGender.getText().toString();
                int classIdx = Integer.parseInt(etClassIdx.getText().toString());
                int classNum = Integer.parseInt(etClassNum.getText().toString());
                String re_password = etConfirmPassword.getText().toString();
                String password = "";
                String emailPattern = "[a-zA-Z0-9._-]+@[dgsw]{4}+\\.+[hs]{2}+\\.+[kr]{2}+";

                if (email.matches(emailPattern) && firPassword.equals(re_password)) {

                    //이메일 형식이 맞고
                    //비밀번호 확인이 완료되었을때
                    JoinAuth user = new JoinAuth();

                    user.setName(name);
                    user.setEmail(email);
                    user.setMobile(tel);
                    user.setPw(password);
                    user.setGender(gender);
                    user.setClass_idx(classIdx);
                    user.setClass_number(classNum);

                    final Network network = Network.retrofit.create(Network.class);
                    Call<ResponseFormat> call = network.signup(user);
                    call.enqueue(new Callback<ResponseFormat>() {
                        @Override
                        public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                            Log.e("result", response.body().toString());
                            Intent intent = new Intent(RegisterActivity.this, AuthActivity.class);
                            startActivity(intent);
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


                } else if (!email.matches(emailPattern) && firPassword.equals(re_password)) {

                    //이메일 형식이 아니고
                    //비밀번호 확인이 완료되었을때

                    Toast.makeText(RegisterActivity.this, "이메일 형식을 확인 해 주세요.", Toast.LENGTH_SHORT).show();


                } else if (email.matches(emailPattern) && !firPassword.equals(re_password)) {

                    // 이메일 형식이 맞고
                    // 비밀번호 확인이 완료되지 않았을때 ( pw1 과 pw2 가 다름)

                    Toast.makeText(RegisterActivity.this, "비밀번호를 확인 해 주세요.", Toast.LENGTH_SHORT).show();

                } else {
                    //둘다 안맞을때

                    Toast.makeText(RegisterActivity.this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();

                }



            }


        });
    }


}
