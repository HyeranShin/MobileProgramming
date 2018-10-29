package com.hyeran.android.hw4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static com.hyeran.android.hw4.MainActivity.classOf14;
import static com.hyeran.android.hw4.MainActivity.classOf15;
import static com.hyeran.android.hw4.MainActivity.classOf16;
import static com.hyeran.android.hw4.MainActivity.classOf17;
import static com.hyeran.android.hw4.MainActivity.color14;
import static com.hyeran.android.hw4.MainActivity.color15;
import static com.hyeran.android.hw4.MainActivity.color16;
import static com.hyeran.android.hw4.MainActivity.color17;

public class DrawHorizontalBarGraph extends View {
    public DrawHorizontalBarGraph(Context context) {
        super(context);
    }

    public DrawHorizontalBarGraph(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawHorizontalBarGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        super.onDraw(canvas);

        Paint paint = new Paint();

        paint.setColor(Color.parseColor(color17));
        canvas.drawRect(0, 500, classOf17*60, 600, paint);
        paint.setColor(Color.parseColor(color16));
        canvas.drawRect(0, 700, classOf16*60, 800, paint);
        paint.setColor(Color.parseColor(color15));
        canvas.drawRect(0, 900, classOf15*60, 1000, paint);
        paint.setColor(Color.parseColor(color14));
        canvas.drawRect(0, 1100, classOf14*60, 1200, paint);
    }
}
