package com.hyeran.android.part5_2_2_photobook;

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
        setTitle("My Photo 목록");
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
