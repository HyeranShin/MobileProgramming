package com.hyeran.android.part4_intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        TextView result = findViewById(R.id.result);

        // LoginActivity에서 전달한 extras 값을 Bundle 객체를 통해 얻어낸다.
        // getInt(), getString() 등
        Bundle extras = getIntent().getExtras();
        result.setText(
                extras.getInt("test")+" "
                + extras.getString("lecture")+"\n"
                + "id = " + extras.getString("id")+"\n"
                + "pw = " + extras.getString("pw")
        );
    }
}
