package com.hyeran.android.part5_hw4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("IT공학과의 최신 소식을 알려드립니다!");
    }

    public void displayPicture(View v) {
        int id = v.getId();
        LinearLayout layout = v.findViewById(id);
        String tag = (String)layout.getTag();

        Intent it = new Intent(this, Photo.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
    }
}