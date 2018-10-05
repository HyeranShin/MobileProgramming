package com.hyeran.android.part3_5_hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_id, et_pw;
    Button btn_login, btn_logout;
    TextView tv_id, tv_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);
        btn_login = findViewById(R.id.btn_login);
        btn_logout = findViewById(R.id.btn_logout);
        tv_id = findViewById(R.id.tv_id);
        tv_pw = findViewById(R.id.tv_pw);

        // Login 버튼 클릭 시
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "로그인되었습니다.", Toast.LENGTH_SHORT).show();
                tv_id.setText(et_id.getText()); // 입력한 ID 값 가져오기
                tv_pw.setText(et_pw.getText()); // 입력한 PW 값 가져오기
            }
        });

        // Logout 버튼 클릭 시
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "로그아웃되었습니다.", Toast.LENGTH_SHORT).show();
                // text 값 없애기
                et_id.setText(null);
                et_pw.setText(null);
                tv_id.setText(null);
                tv_pw.setText(null);
            }
        });
    }
}
