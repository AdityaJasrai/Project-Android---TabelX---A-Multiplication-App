package com.example.tablex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int a=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
//                // Toast
//                Toast.makeText(MainActivity.this, "Populating table of " + progress, Toast.LENGTH_SHORT).show();
//                populate(progress);

                a = progress;
                textView.setText("Multiplication Table of " + a);

                populate(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void populate(int table){
        ArrayList<String> mulTable = new ArrayList<>();
        for (int i=1 ; i<=10 ; i++) {
            mulTable.add(table + " * " + i + " = " + table*i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mulTable);
        listView.setAdapter(arrayAdapter);

    }
}