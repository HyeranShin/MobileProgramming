package com.hyeran.android.part5_2_3_imagehanding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton ibZoomin, ibZoomout, ibRotateLeft, ibRotateRight, ibBright, ibDark, ibGray;
    MyGraphicView graphicView;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static float satur = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Image Handling");

        LinearLayout pictureLayout = findViewById(R.id.imageLayout);
        graphicView = new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private void clickIcons() {
        ibZoomin = findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();   // 화면 갱신
            }
        });
        ibZoomout = findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();   // 화면 갱신
            }
        });
        ibRotateLeft = findViewById(R.id.ibRotateLeft);
        ibRotateLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle = angle - 20;
                graphicView.invalidate();
            }
        });
        ibRotateRight = findViewById(R.id.ibRotateRight);
        ibRotateRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });
        ibBright = findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = color + 0.2f;
                graphicView.invalidate();
            }
        });
        ibDark = findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = color - 0.2f;
                graphicView.invalidate();
            }
        });
        ibGray = findViewById(R.id.ibGray);
        ibGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (satur == 0)
                    satur = 1;
                else
                    satur = 0;
                graphicView.invalidate();
            }
        });
    }
}
