package com.hyeran.android.part3_5_1_eventhandler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText objET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnCall = (Button)findViewById(R.id.button01);
        objET = (EditText)findViewById(R.id.editText01);
        setSelection();

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objET.setText("통화중...");
                setSelection();
            }
        });
    }

    // EditText 클릭 시 커서 위치 끝으로 변경
    protected void setSelection() {
        objET.setSelection(objET.getText().toString().length());
    }
}
