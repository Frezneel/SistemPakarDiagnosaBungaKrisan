package com.example.sistempakardiagnosabungakrisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainStart extends AppCompatActivity {

    Button btMulai, btRiwayat, btAbout, btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        btMulai = findViewById(R.id.bt_mulai);
        btRiwayat = findViewById(R.id.bt_riwayat);
        btAbout = findViewById(R.id.bt_about);
        btExit = findViewById(R.id.bt_exit);

        

        btAbout.setOnClickListener(v -> {
            Intent main_about = new Intent(MainActivity.this, MainAbout.class);
            startActivity(main_about);
        });

        btExit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }
}