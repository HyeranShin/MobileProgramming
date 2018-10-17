package com.hyeran.android.part5_2_3_imagehanding;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;

import static com.hyeran.android.part5_2_3_imagehanding.MainActivity.angle;
import static com.hyeran.android.part5_2_3_imagehanding.MainActivity.satur;
import static com.hyeran.android.part5_2_3_imagehanding.MainActivity.scaleX;
import static com.hyeran.android.part5_2_3_imagehanding.MainActivity.scaleY;
import static com.hyeran.android.part5_2_3_imagehanding.MainActivity.color;

public class MyGraphicView  extends View {
    public MyGraphicView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int cenX = this.getWidth()/2;
        int cenY = this.getHeight()/2;
        canvas.scale(scaleX, scaleY, cenX, cenY);
        canvas.rotate(angle, cenX, cenY);

        Paint paint = new Paint();
        float[] array = { color, 0, 0, 0, 0, 0, color, 0, 0, 0, 0, 0,
        color, 0, 0, 0, 0, 0, 1, 0 };
        ColorMatrix cm = new ColorMatrix(array);
        /*
        ColorMatrix: 색상, 밝기를 조절하기 위한 클래스

        { Red(1), 0, 0, 0, Brightness(0),
        0, Green(1), 0, 0, Brightness(0),
        0, 0, Blue(1), 0, Brightness(0),
        0, 0, 0, Alpah(1), 0}
         */


        if (satur == 0)
            cm.setSaturation(satur);

        paint.setColorFilter(new ColorMatrixColorFilter(cm));

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.myphoto);
        Bitmap scaledPicture = Bitmap.createScaledBitmap(picture, 500, 500, false);
        int picX = (this.getWidth() - scaledPicture.getWidth()) / 2;
        int picY = (this.getHeight() - scaledPicture.getHeight()) / 2;
        canvas.drawBitmap(scaledPicture, picX, picY, paint);

        scaledPicture.recycle();    // 비트맵 메모리 공간 재활용
    }
}
