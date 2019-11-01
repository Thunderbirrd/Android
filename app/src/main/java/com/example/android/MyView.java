package com.example.android;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.*;
import android.view.View;

public class MyView extends View {
    int N = 10;
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    boolean started;
    public MyView(Context context) {
        super(context);
        if(!started) {
            for (int i = 0; i < N; i++) {
                x[i] = (float) (Math.random() * 500);
                y[i] = (float) (Math.random() * 500);
                vx[i] = (float) (Math.random() * 6 - 3);
                vy[i] = (float) (Math.random() * 6 - 3);
            }
            started = true;
        }
    }

    Paint paint = new Paint();
    //long lastTime = System.currentTimeMillis();
    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.RED);
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 25, paint);
        }
        for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
        }
        invalidate();
    }
}
