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

        // Я не уверен, что это надо сдавать, но на всякий случай))
        /* Много обычных линий
        int y = 0;
        while(y < canvas.getHeight()){
            canvas.drawLine(0, y, this.getWidth(), y, paint);
            y += 35;
        } */

        /* Красная линия
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        int y = 30;
        canvas.drawLine(0, y, this.getWidth(), y + 40, paint);
         */

        /* Круг с ободком
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(350, 350, 300, paint);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(25);
        canvas.drawCircle(350, 350, 300, paint);
         */

        /* Квадрат
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(200, 200, 800, 800, paint);
         */

        //1.7.7
        /* Диагонали
        paint.setColor(Color.CYAN);
        int y = 0;
        while(y < getHeight() - 20){
            canvas.drawLine(0, y, this.getWidth(), y + 35, paint);
            y += 45;
        }
         */
        //1.7.7
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
