package com.example.android;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.content.Intent;
=======
import android.os.AsyncTask;
>>>>>>> develop
=======
>>>>>>> develop
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
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
=======
>>>>>>> develop
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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

<<<<<<< HEAD
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
=======
        MyCompanyAdapter adapter = new MyCompanyAdapter(this, makeCompanies());
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
>>>>>>> develop
    }

    MyCompany[] makeCompanies(){
        MyCompany[] arr = new MyCompany[16];

        String[] names = {
                "Coca cola",
                "Google",
                "Apple",
                "Facebook",
                "Tesla",
                "Microsoft",
                "Сбербанк",
                "Аэрофлот",
                "Oracle",
                "Blizzard",
                "Газпром",
                "Яндекс",
                "Samsung",
                "IBM",
                "Ubisoft",
                "Electronic Arts"
        };

        int[] pictures = {
                R.drawable.cola,
                R.drawable.google,
                R.drawable.apple,
                R.drawable.facebook,
                R.drawable.tesla,
                R.drawable.microsoft,
                R.drawable.sberbank,
                R.drawable.aeroflot,
                R.drawable.oracle,
                R.drawable.blizzard,
                R.drawable.gazprom,
                R.drawable.yandex,
                R.drawable.samsung,
                R.drawable.ibm,
                R.drawable.ubisoft,
                R.drawable.electronic_arts,
        };

        double[] costs = {
                1012.29,
                1214.77,
                1277.17,
                658.38,
                653.54,
                492.12,
                2.71,
                10.43,
                97.06,
                170.28,
                1.05,
                33.94,
                107.95,
                47.93,
                59.04,
                116.76,
        };

        for (int i = 0; i < arr.length; i++){
            arr[i] = new MyCompany();
            arr[i].name = names[i];
            arr[i].picture = pictures[i];
            arr[i].cost = costs[i];
        }

<<<<<<< HEAD
        @Override protected void onCancelled() {
            super.onCancelled();
        }
>>>>>>> develop
=======
        return arr;
>>>>>>> develop
    }
}

