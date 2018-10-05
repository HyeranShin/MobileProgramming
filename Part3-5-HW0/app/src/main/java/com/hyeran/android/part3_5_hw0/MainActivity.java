package com.hyeran.android.part3_5_hw0;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    TextView textView01, textView02, textView03;    // RGB 값을 표시할 TextView
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰를 소스코드에 연결
        relativeLayout = findViewById(R.id.relativeLayout);
        textView01 = findViewById(R.id.textView01);
        textView02 = findViewById(R.id.textView02);
        textView03 = findViewById(R.id.textView03);
        button = findViewById(R.id.button);

        // 이벤트 처리
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = 0;  // 배경색

                // 랜덤으로 RGB 값 생성
                Random random = new Random();
                int color1 = random.nextInt(255);
                int color2 = random.nextInt(255);
                int color3 = random.nextInt(255);

                color = Color.rgb(color1, color2, color3);

                relativeLayout.setBackgroundColor(color);

                // 랜덤으로 생성한 RGB 값 TextView로 넘겨주기
                textView01.setText(color1+"");
                textView02.setText(color2+"");
                textView03.setText(color3+"");
            }
        });
    }
}


