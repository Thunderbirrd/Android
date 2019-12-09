package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String PASSWORD = "123";
    String LOGIN = "Artem";
    Button button;
    EditText etxt1, etxt2;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bt1);
        etxt1 = (EditText) findViewById(R.id.etxt1);
        etxt2 = (EditText) findViewById(R.id.etxt2);
        txt= (TextView) findViewById(R.id.txt1);

        View.OnClickListener listener =  new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.bt1:
                        if(etxt2.getText().toString().equals(PASSWORD) && etxt1.getText().toString().equals(LOGIN)){
                            Intent i;
                            i = new Intent(MainActivity.this, Diary.class);
                            startActivity(i);
                            break;
                        }else{
                            Intent i;
                            i = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(i);
                            break;
                        }
                }
                etxt2.setText("");
                etxt2.setText("");
            }
        };
        button.setOnClickListener(listener);
    }
}
