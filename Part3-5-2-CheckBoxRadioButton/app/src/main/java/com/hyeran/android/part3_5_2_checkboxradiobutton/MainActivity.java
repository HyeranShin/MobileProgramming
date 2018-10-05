package com.hyeran.android.part3_5_2_checkboxradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView01, textView02, textView03;
    RadioButton rdoScreenSet, rdoScreenReset;
    CheckBox checkBox01, checkBox02, checkBox03;
    int bkColor = 0xFF000000;   // 배경색 저장
    String strData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        textView01 = findViewById(R.id.textView01);
        textView02 = findViewById(R.id.textView02);
        textView03 = findViewById(R.id.textView03);

        rdoScreenSet = findViewById(R.id.radioButton01);
        rdoScreenReset = findViewById(R.id.radioButton02);
        rdoScreenSet.setOnClickListener(rdoScreen_listener);
        rdoScreenReset.setOnClickListener(rdoScreen_listener);

        checkBox01 = findViewById(R.id.checkBox01);
        checkBox02 = findViewById(R.id.checkBox02);
        checkBox03 = findViewById(R.id.checkBox03);
        checkBox01.setOnClickListener(setColor_listener);
        checkBox02.setOnClickListener(setColor_listener);
        checkBox03.setOnClickListener(setColor_listener);

    }

    View.OnClickListener rdoScreen_listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if(rdoScreenSet.isChecked()) {
                strData = "Color Setting Mode : " + rdoScreenSet.getText().toString();
            } else {
                strData = "Color Setting Mode : " + rdoScreenReset.getText().toString();
                checkBox01.setChecked(false);
                checkBox02.setChecked(false);
                checkBox03.setChecked(false);
                textView01.setBackgroundColor(0xFFFFFFFF);
                linearLayout.setBackgroundColor(0xFFFFFFFF);
                textView01.setTextColor(0xFF00000);
            }
            textView01.setText(strData);
        }
    };

    View.OnClickListener setColor_listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            CheckBox chkColor = (CheckBox)v;
            if(rdoScreenSet.isChecked()) {
                strData = "Color Setting Mode: " + rdoScreenSet.getText().toString();
                if(checkBox01.isChecked()) bkColor |= 0xFFFF0000;
                if(checkBox02.isChecked()) bkColor |= 0xFF00FF00;
                if(checkBox03.isChecked()) bkColor |= 0xFF0000FF;

                textView01.setBackgroundColor(bkColor);
                textView01.setTextColor(0xFF000000);
                linearLayout.setBackgroundColor(bkColor);
                bkColor = 0xFF000000;
            } else {
                textView01.setTextColor(0xFF000000);
                textView01.setText("Color Setting Mode를 Set으로 지정하세요.");
                chkColor.setChecked(false);
            }
        }
    };
}
