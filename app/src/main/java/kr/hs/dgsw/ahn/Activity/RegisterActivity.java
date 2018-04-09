package kr.hs.dgsw.ahn.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kr.hs.dgsw.ahn.Database.DBManager;
import kr.hs.dgsw.ahn.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final DBManager dbManager = new DBManager(getApplicationContext(), "flow.db",null,1);

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
                String classIdx = etClassIdx.getText().toString();
                String classNum = etClassNum.getText().toString();

                dbManager.insert("insert into register value("+email+","+password+","+name+","+gender+","+tel+","+classIdx+","+classNum+");");

                Intent intent = new Intent(RegisterActivity.this, DbCheckActivity.class);
            }


        });
    }

}
