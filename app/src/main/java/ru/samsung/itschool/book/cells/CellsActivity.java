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

import java.util.Arrays;

import task.Task;




public class CellsActivity extends Activity implements OnClickListener,
        OnLongClickListener {

    int WIDTH = 9;
    int HEIGHT = 14;

    Button[][] cells;
    int[][] isBomb = new int[HEIGHT][WIDTH];
    int[][] flags = new int[HEIGHT][WIDTH];
    int[][] isDrawn = new int[HEIGHT][WIDTH];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();
        generate();
    }

    void generate() {
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                isBomb[i][j] = 0;
                isDrawn[i][j] = 0;
                cells[i][j].setBackgroundColor(Color.BLACK);
                if(Math.random() <= 0.2){
                    isBomb[i][j] = 1;
                }
            }
    }

    @Override
    public boolean onLongClick(View v) {
        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);

        cells[tappedY][tappedX].setBackgroundColor(Color.YELLOW);
        flags[tappedY][tappedX] = 1;

        if(Arrays.equals(flags, isBomb)){
            Task.showMessage(this, "Вы победили! Поздравляем!");
            makeCells();
            generate();
        }


        return true;
    }

    private void area(int i, int j){
        if(i < 0 || i >= HEIGHT || j < 0 || j >= WIDTH || isDrawn[i][j] == 1 || isBomb[i][j] == 1){
            return;
        }
        cells[i][j].setBackgroundColor(Color.WHITE);
        isDrawn[i][j] = 1;
        flags[i][j] = 0;
        int bCount = 0;
        for(int i1 = i - 1; i1 <= i + 1; i1++) {
            for (int j1 = j - 1; j1 <= j + 1; j1++) {
                if (i1 >= 0 && i1 < HEIGHT && j1 >= 0 && j1 < WIDTH) {
                    bCount += isBomb[i1][j1];
                }
            }
        }
        if(bCount == 0){
            area(i - 1, j - 1);
            area(i - 1, j);
            area(i - 1, j + 1);
            area(i, j - 1);
            area(i, j + 1);
            area(i + 1, j - 1);
            area(i + 1, j);
            area(i + 1, j + 1);
        }else {
            cells[i][j].setText(bCount + "");
        }
    }

    @Override
    public void onClick(View v) {
        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        flags[tappedY][tappedX] = 0;
        if(isBomb[tappedY][tappedX] == 1){
            Task.showMessage(this, "Вы взорвались...");
            makeCells();
            generate();
        }else{
            cells[tappedY][tappedX].setBackgroundColor(Color.WHITE);
            isDrawn[tappedY][tappedX] = 1;
            int bCount = 0;
            for(int i = tappedY - 1; i <= tappedY + 1; i++){
                for(int j = tappedX - 1; j <= tappedX + 1; j++){
                    if(i >= 0 && i < HEIGHT && j >= 0 && j < WIDTH){
                        bCount += isBomb[i][j];
                    }
                }
            }
            if(bCount == 0){
                area(tappedY - 1, tappedX - 1);
                area(tappedY - 1, tappedX);
                area(tappedY - 1, tappedX + 1);
                area(tappedY, tappedX - 1);
                area(tappedY, tappedX + 1);
                area(tappedY + 1, tappedX - 1);
                area(tappedY + 1, tappedX);
                area(tappedY + 1, tappedX + 1);
            }else {
                cells[tappedY][tappedX].setText(bCount + "");
            }
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