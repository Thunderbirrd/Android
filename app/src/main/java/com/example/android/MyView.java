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

        int y = 0;
        while(y < getHeight()){
            canvas.drawLine(0, y, this.getWidth(), y, paint);
            y += 35;
        }
    }

}
