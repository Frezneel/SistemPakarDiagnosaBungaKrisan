package com.example.sistempakardiagnosabungakrisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainAbout extends AppCompatActivity {

    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_about);

        home = findViewById(R.id.home_2);
        home.setOnClickListener(v -> {
            Intent home = new Intent(MainAbout.this, MainStart.class);
            finish();
            startActivity(home);
        });
    }
}