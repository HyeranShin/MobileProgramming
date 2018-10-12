package com.hyeran.android.part5_2_1_bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ViewWithBitmap extends View {
    public ViewWithBitmap(Context context) {
        super(context);
    }

    public ViewWithBitmap(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewWithBitmap(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);

        Bitmap jayPic = BitmapFactory.decodeResource(getResources(), R.drawable.myphoto);

        Bitmap jayPicMedium = Bitmap.createScaledBitmap(jayPic, 200, 300, false);
        canvas.drawBitmap(jayPicMedium, 60, 75, null);

        Bitmap jayPicSmall = Bitmap.createScaledBitmap(jayPic, 50, 75, false);

        Matrix maxTopLeft = new Matrix();
        maxTopLeft.preRotate(30);

        Matrix maxBottomLeft = new Matrix();
        maxBottomLeft.preRotate(-30);

        Matrix maxTopRight = new Matrix();
        maxTopRight.preRotate(-30);
        maxTopRight.preScale(-1, -1);

        Matrix maxBottomRight = new Matrix();
        maxBottomRight.preRotate(30);
        maxBottomRight.preScale(-1, 1);

        Bitmap jayPicTopLeft = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxTopLeft, false);
        Bitmap jayPicBottomLeft = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxBottomLeft, false);

        Bitmap jayPicTopRight = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxTopRight, false);
        Bitmap jayPicBottomRight = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxBottomRight, false);

        jayPicSmall.recycle();
        jayPic.recycle();

        canvas.drawBitmap(jayPicTopLeft, 30, 30, null);
        canvas.drawBitmap(jayPicBottomLeft, 30, 325, null);
        canvas.drawBitmap(jayPicTopRight, 225, 30, null);
        canvas.drawBitmap(jayPicBottomRight, 225, 325, null);
    }
}
