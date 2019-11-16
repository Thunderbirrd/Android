package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    EditText etxt1, etxt2;
    Button bt1;
    String LOGIN = "Artem";
    String PASSWORD = "123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt1);
        etxt1 = (EditText) findViewById(R.id.etxt1);
        etxt2 = (EditText) findViewById(R.id.etxt2);
        bt1 = (Button) findViewById(R.id.bt1);
        View.OnClickListener listener =  new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.bt1:
                        if(etxt1.getText().toString().equals(LOGIN) && etxt2.getText().toString().equals(PASSWORD)){
                            txt.setText("Верно");
                            txt.setTextColor(Color.GREEN);
                            break;
                        }else{
                            txt.setText("Неправильный логин или пароль");
                            txt.setTextColor(Color.RED);
                            break;
                        }
                }
                etxt1.setText("");
                etxt2.setText("");
            }
        };
        bt1.setOnClickListener(listener);
    }
}
