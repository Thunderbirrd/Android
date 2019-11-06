package ru.samsung.itschool.book.cells;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;


public class CellsActivity extends Activity implements OnClickListener,
        OnLongClickListener {

    int WIDTH = 4;
    int HEIGHT =10;
    int total = WIDTH * HEIGHT;
    int count1 = 0;
    int count2 = 0;

    Button[][] cells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();
        generate();
    }

    void generate() {
        int num = 1;
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setText(num + "");
                num++;
                if (Math.random() >= 0.5) {
                    cells[i][j].setBackgroundColor(Color.CYAN);
                    count1++;
                }else{
                    cells[i][j].setBackgroundColor(Color.YELLOW);
                    count2++;
                }
            }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onClick(View v) {
        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        int color = ((ColorDrawable)cells[tappedY][tappedX].getBackground()).getColor();
        if(color == Color.CYAN) {
            cells[tappedY][tappedX].setBackgroundColor(Color.YELLOW);
            count2++;
        }else{
            cells[tappedY][tappedX].setBackgroundColor(Color.CYAN);
            count1++;
        }
        if(color == Color.CYAN) {
            cells[tappedY][tappedX].setBackgroundColor(Color.YELLOW);
            count2++;
        }else{
            cells[tappedY][tappedX].setBackgroundColor(Color.CYAN);
            count1++;
        }
        if(count1 == total || count2 == total){
            // Пытаюсь сделать рестарт, но не получается
            onCreate(Bundle.EMPTY);
        }
    }

    int getX(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    void makeCells() {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(WIDTH);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }

}