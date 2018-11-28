package com.hyeran.android.part8_2_2_sendbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getAction();

        if(name.equals("com.hyeran.android.part8_2_2_sendbroadcast.gogogo")) {
            Toast.makeText(context, "정상적으로 값을 받았습니다", Toast.LENGTH_SHORT).show();
        }
    }
}
