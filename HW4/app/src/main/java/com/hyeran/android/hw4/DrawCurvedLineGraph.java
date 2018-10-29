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

public class DrawCurvedLineGraph extends View {

    public DrawCurvedLineGraph(Context context) {
        super(context);
    }

    public DrawCurvedLineGraph(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCurvedLineGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        Paint blackLine = new Paint();
        blackLine.setColor(Color.BLACK);
        blackLine.setStrokeWidth(5);

        int startLine = 1500;

        canvas.drawLine(50, startLine-classOf17*60, 270, startLine-classOf16*60, blackLine);
        canvas.drawLine(270, startLine-classOf16*60, 485, startLine-classOf15*60, blackLine);
        canvas.drawLine(485, startLine-classOf15*60, 700, startLine-classOf14*60, blackLine);

        paint.setColor(Color.parseColor(color17));
        canvas.drawCircle(50, startLine-classOf17*60, 30, paint);
        paint.setColor(Color.parseColor(color16));
        canvas.drawCircle(270, startLine-classOf16*60, 30, paint);
        paint.setColor(Color.parseColor(color15));
        canvas.drawCircle(485, startLine-classOf15*60, 30, paint);
        paint.setColor(Color.parseColor(color14));
        canvas.drawCircle(700, startLine-classOf14*60, 30, paint);
    }
}
