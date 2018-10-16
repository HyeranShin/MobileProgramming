package com.hyeran.android.part5_hw3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("혜란이의 눈사람 만들기");

        SnowMan snowMan = new SnowMan(MainActivity.this);
        setContentView(snowMan);
    }

}

class SnowMan extends View {

    public SnowMan(Context context) {
        super(context);
    }

    public SnowMan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SnowMan(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect dest = new Rect(0, 0, getWidth(), getHeight());
        Paint paint = new Paint();

        // 배경 이미지
        Bitmap backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.winter_background);
        canvas.drawBitmap(backgroundImg, null, dest, paint);

        paint.setColor(Color.WHITE);

        // 눈사람 머리 그리기
        canvas.drawCircle(getWidth() / 2, getHeight() - 1100, 300, paint);
        // 눈사람 몸 그리기
        canvas.drawCircle(getWidth() / 2, getHeight() - 500, 400, paint);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);

        // 눈사람 눈 그리기
        // 왼쪽 눈
        canvas.drawLine(getWidth() / 2 - 180, getHeight() - 1150, getWidth() / 2 - 110, getHeight() - 1250, paint);
        canvas.drawLine(getWidth() / 2 - 115, getHeight() - 1250, getWidth() / 2 - 45, getHeight() - 1150, paint);
        // 오른쪽 눈
        canvas.drawLine(getWidth() / 2 + 180, getHeight() - 1150, getWidth() / 2 + 110, getHeight() - 1250, paint);
        canvas.drawLine(getWidth() / 2 + 115, getHeight() - 1250, getWidth() / 2 + 45, getHeight() - 1150, paint);

        // 눈사람 코 이미지
        Bitmap carrotImg = BitmapFactory.decodeResource(getResources(), R.drawable.carrot);
        Bitmap nose = Bitmap.createScaledBitmap(carrotImg, 260, 140, false);
        canvas.drawBitmap(nose, getWidth() / 2 - 210, getHeight() / 2 - 160, null);


        // 단추 이미지
        Bitmap buttonImg1 = BitmapFactory.decodeResource(getResources(), R.drawable.button1);
        Bitmap button1 = Bitmap.createScaledBitmap(buttonImg1, 100, 100, false);

        Bitmap buttonImg2 = BitmapFactory.decodeResource(getResources(), R.drawable.button2);
        Bitmap button2 = Bitmap.createScaledBitmap(buttonImg2, 100, 100, false);

        canvas.drawBitmap(button1, getWidth() / 2 - 50, getHeight() / 2 + 250, null);
        canvas.drawBitmap(button2, getWidth() / 2 - 50, getHeight() / 2 + 400, null);
        canvas.drawBitmap(button1, getWidth() / 2 - 50, getHeight() / 2 + 550, null);
        canvas.drawBitmap(button2, getWidth() / 2 - 50, getHeight() / 2 + 700, null);

        // 목도리 이미지
        Bitmap scarfImg = BitmapFactory.decodeResource(getResources(), R.drawable.scarf);
        Bitmap scarf = Bitmap.createScaledBitmap(scarfImg, 850, 500, false);
        canvas.drawBitmap(scarf, 350, 950, null);

        // 장갑 이미지
        // 좌우반전 시킬 때 사용
        Matrix sideInversion = new Matrix();
        sideInversion.setScale(-1, 1);

        Bitmap globeImg = BitmapFactory.decodeResource(getResources(), R.drawable.globe);
        // 왼쪽 장갑
        Bitmap globeL = Bitmap.createScaledBitmap(globeImg, 250, 250, false);
        // 오른쪽 장갑
        Bitmap globeR = Bitmap.createBitmap(globeL, 0, 0, globeL.getWidth(), globeL.getHeight(), sideInversion, false); // 좌우 반전
        canvas.drawBitmap(globeL, getWidth() / 2 - 570, 990, null);
        canvas.drawBitmap(globeR, getWidth() / 2 + 320, 990, null);

        // 모자 이미지
        Bitmap hatImg = BitmapFactory.decodeResource(getResources(), R.drawable.hat);
        Bitmap hat = Bitmap.createScaledBitmap(hatImg, 500, 500, false);
        canvas.drawBitmap(hat, getWidth() / 2-200, getHeight() / 2-800 , null);

    }

}