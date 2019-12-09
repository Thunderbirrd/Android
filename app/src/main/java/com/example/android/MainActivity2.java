package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private static final int REQ_C = 0;
    Button button;
    EditText etxt1, etxt2;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.bt1);
        etxt1 = (EditText) findViewById(R.id.etxt1);
        etxt2 = (EditText) findViewById(R.id.etxt2);
        txt= (TextView) findViewById(R.id.txt1);

        View.OnClickListener listener =  new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity2.this, Diary.class);
                startActivity(i);
            }
        };
        button.setOnClickListener(listener);
    }

}
