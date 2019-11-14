package com.example.android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();
    }

    public void solveEquation(View view) {
        double a = Double.parseDouble(((EditText)
                findViewById(R.id.coefficient_a)).getText().toString());
        double b = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_b)).getText().toString());
        double c = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_c)).getText().toString());
        TextView result = (TextView) findViewById(R.id.result);

        if(a == 0){
            if(b != 0) {
                if(c != 0) {
                    result.setText("x = " + String.valueOf(c / b * (-1)));
                }else{
                    result.setText("x = 0");
                }
            }else{
                if(c != 0){
                    result.setText("Нет корней");
                }else{
                    result.setText("Бесконечное можество решений");
                }
            }
        }else if(b == 0){
            if(a != 0){
                if(-c / a > 0){
                    result.setText("x1 = " + String.valueOf(Math.sqrt(-c / a)) + "\nx2 = "
                            + String.valueOf(-Math.sqrt(-c / a)));
                }else if(c == 0){
                    result.setText("x = 0");
                }else{
                    result.setText("Нет корней");
                }
            }
        }else if(c == 0){
            result.setText("x1 = " + String.valueOf(0) + " x2 = " + String.valueOf(-b / a));
        }else{
            double D = b * b - (4 * a * c);
            if(D > 0){
                result.setText("x1 = " + String.valueOf((-b + Math.sqrt(D))/ (2 * a))
                        + "\nx2 = " + String.valueOf((-b - Math.sqrt(D))/ (2 * a)));
            }else if(D == 0){
                result.setText("x = " + String.valueOf(Math.sqrt(-b / 2 * a)));
            }else{
                result.setText("Нет корней");
            }
        }
    }
}
