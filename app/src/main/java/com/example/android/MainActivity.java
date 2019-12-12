package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.content.Intent;
=======
import android.os.AsyncTask;
>>>>>>> develop
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD

    String PASSWORD = "123";
    String LOGIN = "Artem";
    Button button;
    EditText etxt1, etxt2;
    TextView txt;

=======
    TextView txt1, txt2;
    Button start, stop;
    NumberTick tick;
>>>>>>> develop
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
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
=======

        txt1 = (TextView) findViewById(R.id.status);
        txt2 = (TextView) findViewById(R.id.number);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.start:
                        if(tick != null) {
                            if (!tick.getStatus().toString().equals("RUNNING")) {
                                tick = new NumberTick();
                                tick.execute();
                                break;
                            }
                            break;
                        }else{
                            tick = new NumberTick();
                            tick.execute();
                            break;
                        }
                    case R.id.stop:
                        if(tick.getStatus().toString().equals("RUNNING")) {
                            cancelTask();
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
>>>>>>> develop
                            break;
                        }
                        break;
                }
<<<<<<< HEAD
                etxt2.setText("");
                etxt2.setText("");
            }
        };
        button.setOnClickListener(listener);
=======
            }
        };
        start.setOnClickListener(listener);
        stop.setOnClickListener(listener);
    }

    private void cancelTask() {
        if (tick == null) return;
        tick.cancel(false);
    }


    private class NumberTick extends AsyncTask<Void, Integer, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i <= 100; i++){
                try {
                    if(isCancelled()) return null;
                    TimeUnit.MILLISECONDS.sleep(500);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            txt2.setText("" + values[0]);
        }

        @Override protected void onCancelled() {
            super.onCancelled();
        }
>>>>>>> develop
    }
}
