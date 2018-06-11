package kr.hs.dgsw.flow.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

import kr.hs.dgsw.flow.Model.LoginAuth;
import kr.hs.dgsw.flow.Model.ResponseFormat;
import kr.hs.dgsw.flow.Network.Network;
import kr.hs.dgsw.flow.R;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AuthActivity extends AppCompatActivity {

    private FirebaseApp firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        firebaseAuth = FirebaseApp.getInstance();
        css();

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button btnSubmit = (Button) findViewById(R.id.btnSignIn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                LoginAuth user = new LoginAuth();

                user.setEmail(email);
                user.setPw(password);
                user.setRegistration_token(FirebaseInstanceId.getInstance().getToken());

                Log.v("token",FirebaseInstanceId.getInstance().getToken());

                final Network network = Network.retrofit.create(Network.class);
                Call<ResponseFormat> call = network.signin(user);
                call.enqueue(new Callback<ResponseFormat>() {
                    @Override
                    public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                        Log.e("response", response.body().toString());
                        Log.e("status",Integer.toString(response.body().getStatus()));

                        if(response.body().getStatus() == 401){
                            Toast.makeText(AuthActivity.this,"아이디나 비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT);
                        }
                        else if(response.body().getStatus() == 400){
                            Toast.makeText(AuthActivity.this,"해당 계정이 존재하지 않습니다.",Toast.LENGTH_SHORT);

                        }

                        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("response", t.getMessage());
                    }
                });
            }
        });

    }

    public void css() {
        TextView tvToSignUp = findViewById(R.id.tvToSignUp);

        SpannableString content = new SpannableString("Don't you have account?");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tvToSignUp.setText(content);
    }

    public void onClickRegister(View view) {
        Intent intent = new Intent(AuthActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

}
