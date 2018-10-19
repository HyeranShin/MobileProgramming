package com.hyeran.android.part5_3;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Line Button -- added
        final Button lineButton = findViewById(R.id.ButtonLine);
        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a line from a rectangle
                ShapeDrawable d = new ShapeDrawable(new RectShape());
                d.setIntrinsicHeight(5);
                d.setIntrinsicWidth(250);
                d.getPaint().setColor(Color.BLUE);
                setShapeByDrawable(d);
            }
        });

        // Handle Rectangle Button
        final Button recButton = findViewById(R.id.ButtonRect);
        recButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setShapeByResourceId(R.drawable.green_rect);
            }
        });

        // Handle Oval Button
        final Button ovalButton = findViewById(R.id.ButtonOval);
        ovalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setShapeByResourceId(R.drawable.red_oval);
                // Or Drawa an oval programatically
                /*
                ShapeDrawable d = new ShapeDrawable(new OvalShape());
                d.setIntrinsicHeight(40);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.GREEN);
                setShapeByDrawable(d);
                */
            }
        });

        // Handle Round Rectangle Button
        final Button roundRecButton = findViewById(R.id.ButtonRoundRect);
        roundRecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShapeDrawable d = new ShapeDrawable(new RoundRectShape(
                        new float[]{10, 10, 5, 5, 5, 5, 15, 15}, null, null
                ));
                d.setIntrinsicHeight(50);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.CYAN);
                setShapeByDrawable(d);
            }
        });

        // Handle Path Button
        final Button pathButton = findViewById(R.id.ButtonPath);
        pathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Let's a draw a star
                Path p = new Path();
                p.moveTo(50, 0);
                p.lineTo(25, 100);
                p.lineTo(100, 50);
                p.lineTo(0, 50);
                p.lineTo(75, 100);
                p.lineTo(50, 0);

                ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.YELLOW);
                setShapeByDrawable(d);
            }
        });

        // Handle Path Button
        final Button path2Button = findViewById(R.id.ButtonPath2);
        path2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Let's a draw a star
                Path p = new Path();
                p.setFillType(Path.FillType.EVEN_ODD);
                p.moveTo(50, 0);
                p.lineTo(25, 100);
                p.lineTo(100, 50);
                p.lineTo(0, 50);
                p.lineTo(75, 100);
                p.lineTo(50, 0);

                ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.YELLOW);
                setShapeByDrawable(d);
            }
        });

        // Handle Round Rectangle Button
        final Button path3Button = findViewById(R.id.ButtonPath3);
        path3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Let's a draw a star
                Path p = new Path();
                p.moveTo(50, 0);
                p.lineTo(25, 100);
                p.lineTo(100, 50);
                p.lineTo(0, 50);
                p.lineTo(75, 100);
                p.lineTo(50, 0);

                ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.YELLOW);
                d.getPaint().setStyle(Paint.Style.STROKE);
                setShapeByDrawable(d);
            }
        });

        final Button arcButton = findViewById(R.id.ButtonArc);
        arcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a arc. pacman style
                ShapeDrawable d = new ShapeDrawable(new ArcShape(0, 345));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.MAGENTA);
                setShapeByDrawable(d);
            }
        });
    }

    private void setShapeByDrawable(Drawable drawable) {
        // We will animate the imageview
        ImageView reusableImageView = findViewById(R.id.ImageViewForShape);
        reusableImageView.setImageDrawable(drawable);
    }

    private void setShapeByResourceId(int resourceId) {
        // We will animate the imageview
        ImageView reusableImageView = findViewById(R.id.ImageViewForShape);
        reusableImageView.setImageResource(resourceId);
    }

}
