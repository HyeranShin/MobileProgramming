package com.hyeran.android.part8_2_1_smsbroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class SmsDisplayActivity extends AppCompatActivity {
    Button titleButton, closeButton;
    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sms_display);

        titleButton = findViewById(R.id.titleButton);
        closeButton = findViewById(R.id.closeButton);
        messageTextView = findViewById(R.id.messageTextView);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent passedIntent = getIntent();
        if(passedIntent != null) {
            processIntent(passedIntent);
        }
    }

    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {
        String number = intent.getStringExtra("number");
        String message = intent.getStringExtra("message");
        String timestamp = intent.getStringExtra("timestamp");

        if (number != null) {
            titleButton.setText(number + "번호");
            messageTextView.setText("[" + timestamp + "]" + message);
            messageTextView.invalidate();
        }
    }
}
