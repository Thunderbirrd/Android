package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
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
    TextView txt1, txt2;
    Button start, stop;
    NumberTick tick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                            break;
                        }
                        break;
                }
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
    }
}
