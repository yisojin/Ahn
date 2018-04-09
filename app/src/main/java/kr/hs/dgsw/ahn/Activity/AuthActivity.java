package kr.hs.dgsw.ahn.Activity;

import android.content.Intent;
import android.graphics.Region;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import kr.hs.dgsw.ahn.R;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        css();
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
