package com.example.sistempakardiagnosabungakrisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TampilAnalisa extends AppCompatActivity {

    TextView diagPenyakit, diagSolusi;
    Button btMulaiLagi, home1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_analisa);

        diagPenyakit = findViewById(R.id.diag_penyakit);
        diagSolusi = findViewById(R.id.diag_solusi);
        btMulaiLagi = findViewById(R.id.bt_mulai_lagi);
        home1 = findViewById(R.id.home_1);

        Bundle bundle = getIntent().getExtras();
        String hasilDiagPenyakit = bundle.getString("HasilAnalisa");
        String hasilDiagSolusi = bundle.getString("HasilSolusi");

        diagPenyakit.setText(hasilDiagPenyakit);
        diagSolusi.setText(hasilDiagSolusi);


        btMulaiLagi.setOnClickListener(v -> {
            Intent main_activity = new Intent(TampilAnalisa.this, MainActivity.class);
            startActivity(main_activity);
        });

        home1.setOnClickListener(v -> {
            Intent home = new Intent(TampilAnalisa.this, MainStart.class);
            finish();
            startActivity(home);
        });

    }
}