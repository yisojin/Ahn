package kr.hs.dgsw.ahn.Activity;

import android.content.Intent;
import android.graphics.Region;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

import kr.hs.dgsw.ahn.Model.ResponseFormat;
import kr.hs.dgsw.ahn.Model.UserAuth;
import kr.hs.dgsw.ahn.Network.Network;
import kr.hs.dgsw.ahn.R;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        css();

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button btnSubmit = (Button) findViewById(R.id.btnSignIn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                UserAuth user = new UserAuth();

                user.setEmail(email);
                user.setPassword(password);

                final Network network = Network.retrofit.create(Network.class);
                Call<ResponseFormat> call = network.signin(user);
                call.enqueue(new Callback<ResponseFormat>() {
                    @Override
                    public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                        Log.e("response", response.body().toString());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("response",t.getMessage());
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
