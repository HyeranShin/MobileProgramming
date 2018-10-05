package com.hyeran.android.part3_5_hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText01;
    Button btnCall, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰를 소스코드에 연결
        editText01 = findViewById(R.id.editTexxt01);
        btnCall = findViewById(R.id.button01);
        btnStop = findViewById(R.id.button02);

        setSelection(); // EditText 커서 위치 끝으로 변경

        // Call 버튼 클릭 시
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText01.setText("통화중...");
                setSelection();
            }
        });

        // Stop 버튼 클릭 시
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText01.setText("통화종료...");
                setSelection();
            }
        });
    }

    // EditText 커서 위치 끝으로 변경
    protected void setSelection() {
        editText01.setSelection(editText01.getText().toString().length());
    }
}
