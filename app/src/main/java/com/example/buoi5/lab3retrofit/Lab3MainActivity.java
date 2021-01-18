package com.example.buoi5.lab3retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.buoi5.R;

public class Lab3MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_main);
        textView = findViewById(R.id.textView);
        LoadData loadData = new LoadData();
        loadData.loadJSON(textView);
        textView.setText(loadData.jSONStr);
    }
}