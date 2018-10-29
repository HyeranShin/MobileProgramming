package com.hyeran.android.hw4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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

public class DrawCircleGraph extends View {
    public DrawCircleGraph(Context context) {
        super(context);
    }

    public DrawCircleGraph(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircleGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        int total = classOf17+classOf16+classOf15+classOf14;

        float angle17 = classOf17*360/total;
        float angle16 = classOf16*360/total;
        float angle15 = classOf15*360/total;
        float angle14 = classOf14*360/total;

        RectF rect = new RectF();
        rect.set(0, 0, 1000, 1000);

        paint.setColor(Color.parseColor(color17));
        canvas.drawArc(rect, 0, angle17+0.7f, true, paint);
        // useCenter - false: 호, true: 부채꼴
        paint.setColor(Color.parseColor(color16));
        canvas.drawArc(rect, angle17+0.7f, angle16+0.7f, true, paint);
        paint.setColor(Color.parseColor(color15));
        canvas.drawArc(rect, angle17+angle16+1.4f, angle15+0.7f, true, paint);
        paint.setColor(Color.parseColor(color14));
        canvas.drawArc(rect, angle17+angle16+angle15+2.1f, angle14+0.8f, true, paint);

    }
}
