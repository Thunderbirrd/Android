package com.example.android;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyCompanyAdapter adapter = new MyCompanyAdapter(this, makeCompanies());
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
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

        return arr;
    }
}

