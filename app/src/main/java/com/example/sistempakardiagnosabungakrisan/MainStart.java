package com.example.sistempakardiagnosabungakrisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainStart extends AppCompatActivity {

    Button btMulai, btAbout, btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        btMulai = findViewById(R.id.bt_mulai);
        btAbout = findViewById(R.id.bt_about);
        btExit = findViewById(R.id.bt_exit);

        btMulai.setOnClickListener(v -> {
            Intent main_activity = new Intent(MainStart.this, MainActivity.class);
            startActivity(main_activity);
        });

        btAbout.setOnClickListener(v -> {
            Intent main_about = new Intent(MainStart.this, MainAbout.class);
            startActivity(main_about);
        });

        btExit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }
}