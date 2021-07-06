package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Homescreen extends AppCompatActivity {

        TextView t_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        t_name = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        t_name.setText(name);
    }
}