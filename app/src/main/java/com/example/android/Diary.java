package com.example.android;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Diary extends AppCompatActivity {

    TextView txt;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        txt = (TextView) findViewById(R.id.Schedule);
        bt = (Button) findViewById(R.id.button);

        View.OnClickListener listener =  new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Мамка пошла за ремнём!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        };
        bt.setOnClickListener(listener);
    }
}

