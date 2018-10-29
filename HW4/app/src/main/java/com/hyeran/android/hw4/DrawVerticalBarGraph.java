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

class DrawVerticalBarGraph extends View {

    public DrawVerticalBarGraph(Context context) {
        super(context);
    }

    public DrawVerticalBarGraph(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawVerticalBarGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        int startLine = 1500;

        paint.setColor(Color.parseColor(color17));
        canvas.drawRect(0, startLine-classOf17*60, 100, startLine, paint);
        paint.setColor(Color.parseColor(color16));
        canvas.drawRect(200, startLine-classOf16*60, 300, startLine, paint);
        paint.setColor(Color.parseColor(color15));
        canvas.drawRect(400, startLine-classOf15*60, 500, startLine, paint);
        paint.setColor(Color.parseColor(color14));
        canvas.drawRect(600, startLine-classOf14*60, 700, startLine, paint);

    }
}
