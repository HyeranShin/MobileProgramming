package com.hyeran.android.part4_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText edit_id;
    private EditText edit_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_id = findViewById(R.id.et_id);
        edit_pw = findViewById(R.id.et_pw);

        Button btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext;
                String pwtext;

                // EditText 내용 추출
                idtext = edit_id.getText().toString();
                pwtext = edit_pw.getText().toString();

                // extra 데이터를 담은 intent를 명시적으로 호출
                Intent intent = new Intent(LoginActivity.this, NextActivity.class);

                Bundle extras = new Bundle();
                extras.putInt("test", 2017);
                extras.putString("lecture", "Mobile Programming by yiyoon");
                extras.putString("id", idtext);
                extras.putString("pw", pwtext);

                // intent에 extra를 담는다.
                intent.putExtras(extras);

                startActivity(intent);
            }
        });
    }
}
