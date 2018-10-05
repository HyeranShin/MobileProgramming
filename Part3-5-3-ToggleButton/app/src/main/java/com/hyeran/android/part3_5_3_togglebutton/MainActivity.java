package com.hyeran.android.part3_5_3_togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton objButton = findViewById(R.id.tglOnOff);
        objButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(objButton.isChecked()) {
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
