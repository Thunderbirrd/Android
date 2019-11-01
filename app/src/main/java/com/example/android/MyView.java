package com.example.android;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.*;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(10);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawLine(100, 10, 100, 800, paint);
        paint.setColor(Color.MAGENTA);
        canvas.drawLine(0, 500, this.getWidth(), 600, paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(400, 10, 400, 900, paint);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        canvas.drawLine(500, 10, 500, 800, paint);
        paint.setColor(Color.CYAN);
        canvas.drawRect(800, 800, getHeight(), getHeight(), paint);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(600, 200, 150, paint);
    }

}
