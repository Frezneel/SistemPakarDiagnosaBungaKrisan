package com.example.sistempakardiagnosabungakrisan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {
    LinearLayout l_soal1,l_soal2,l_soal3,l_soal4,l_soal5,l_soal6,l_soal7,
            l_soal8,l_soal9,l_soal10,l_soal11,l_soal12,l_soal13,l_soal14;
    TextView gejala1,gejala2,gejala3,gejala4,gejala5,gejala6,gejala7,gejala8,
            gejala9, gejala10,gejala11,gejala12,gejala13,gejala14;
    Button chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10,chk11,chk12,chk13,chk14;
    String opsi1,opsi2,opsi3,opsi4,opsi5,opsi6,opsi7,opsi8,opsi9,opsi10,
            opsi11,opsi12,opsi13,opsi14,opsi15,opsi16,opsi17,opsi18,opsi19,opsi20,
            opsi21,opsi22,opsi23,opsi24,opsi25,opsi26,opsi27,opsi28,opsi29;
    int jawab1,jawab2,jawab3,jawab4,jawab5,jawab6,jawab7,jawab8,jawab9,jawab10,
            jawab11,jawab12,jawab13,jawab14,jawab15,jawab16,jawab17,jawab18,jawab19,
            jawab20, jawab21,jawab22,jawab23,jawab24,jawab25,jawab26,jawab27,jawab28,jawab29;
    String db_hasilAnalisa, db_hasilSolusi, hasilAnalisa, hasilSolusi;
    DatabaseReference BaseSistemPakar;
    Button btDiagnosa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l_soal1 = findViewById(R.id.soal_1);
        l_soal2 = findViewById(R.id.soal_2);
        l_soal3 = findViewById(R.id.soal_3);
        l_soal4 = findViewById(R.id.soal_4);
        l_soal5 = findViewById(R.id.soal_5);
        l_soal6 = findViewById(R.id.soal_6);
        l_soal7 = findViewById(R.id.soal_7);
        l_soal8 = findViewById(R.id.soal_8);
        l_soal9 = findViewById(R.id.soal_9);
        l_soal10 = findViewById(R.id.soal_10);
        l_soal11 = findViewById(R.id.soal_11);
        l_soal12 = findViewById(R.id.soal_12);
        l_soal13 = findViewById(R.id.soal_13);
        l_soal14 = findViewById(R.id.soal_14);

        //Teks Pertanyaan Gejala
        gejala1 = findViewById(R.id.gejala_1);
        gejala2 = findViewById(R.id.gejala_2);
        gejala3 = findViewById(R.id.gejala_3);
        gejala4 = findViewById(R.id.gejala_4);
        gejala5 = findViewById(R.id.gejala_5);
        gejala6 = findViewById(R.id.gejala_6);
        gejala7 = findViewById(R.id.gejala_7);
        gejala8 = findViewById(R.id.gejala_8);
        gejala9 = findViewById(R.id.gejala_9);
        gejala10 = findViewById(R.id.gejala_10);
        gejala11 = findViewById(R.id.gejala_11);
        gejala12 = findViewById(R.id.gejala_12);
        gejala13 = findViewById(R.id.gejala_13);
        gejala14 = findViewById(R.id.gejala_14);

        //CheckBox
        chk1 = findViewById(R.id.chk_1);
        chk2 = findViewById(R.id.chk_2);
        chk3 = findViewById(R.id.chk_3);
        chk4 = findViewById(R.id.chk_4);
        chk5 = findViewById(R.id.chk_5);
        chk6 = findViewById(R.id.chk_6);
        chk7 = findViewById(R.id.chk_7);
        chk8 = findViewById(R.id.chk_8);
        chk9 = findViewById(R.id.chk_9);
        chk10 = findViewById(R.id.chk_10);
        chk11 = findViewById(R.id.chk_11);
        chk12 = findViewById(R.id.chk_12);
        chk13 = findViewById(R.id.chk_13);
        chk14 = findViewById(R.id.chk_14);

        //Button
        btDiagnosa = findViewById(R.id.bt_diagnosa);

        hasilAnalisa = "";
        hasilSolusi = "";

        LoadPertanyaan();
        btDiagnosa.setVisibility(View.VISIBLE);

        chk1.setOnClickListener(v -> {
            PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk1);
            OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
            OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    String a = String.valueOf(item.getTitleCondensed());
                    switch (a) {
                        case "iya":
                            chk1.setText("Iya");
                            chk2.setText("Opsi");
                            chk3.setText("Opsi");
                            chk4.setText("Opsi");
                            chk5.setText("Opsi");
                            chk6.setText("Opsi");
                            chk7.setText("Opsi");
                            chk8.setText("Opsi");
                            chk9.setText("Opsi");
                            chk10.setText("Opsi");
                            chk11.setText("Opsi");
                            chk12.setText("Opsi");
                            chk13.setText("Opsi");
                            chk14.setText("Opsi");
                            jawab1 = 1;
                            l_soal2.setVisibility(View.GONE);
                            l_soal3.setVisibility(View.GONE);
                            l_soal4.setVisibility(View.GONE);
                            l_soal5.setVisibility(View.GONE);
                            l_soal6.setVisibility(View.GONE);
                            l_soal7.setVisibility(View.GONE);
                            l_soal8.setVisibility(View.GONE);
                            l_soal9.setVisibility(View.GONE);
                            l_soal10.setVisibility(View.GONE);
                            l_soal11.setVisibility(View.GONE);
                            l_soal12.setVisibility(View.GONE);
                            l_soal13.setVisibility(View.GONE);
                            l_soal14.setVisibility(View.GONE);
                            gejala2.setText(opsi2);
                            l_soal2.setVisibility(View.VISIBLE);
                            break;
                        case "tidak":
                            chk1.setText("Tidak");
                            chk2.setText("Opsi");
                            chk3.setText("Opsi");
                            chk4.setText("Opsi");
                            chk5.setText("Opsi");
                            chk6.setText("Opsi");
                            chk7.setText("Opsi");
                            chk8.setText("Opsi");
                            chk9.setText("Opsi");
                            chk10.setText("Opsi");
                            chk11.setText("Opsi");
                            chk12.setText("Opsi");
                            chk13.setText("Opsi");
                            chk14.setText("Opsi");
                            jawab1 = 0;
                            l_soal2.setVisibility(View.GONE);
                            l_soal3.setVisibility(View.GONE);
                            l_soal4.setVisibility(View.GONE);
                            l_soal5.setVisibility(View.GONE);
                            l_soal6.setVisibility(View.GONE);
                            l_soal7.setVisibility(View.GONE);
                            l_soal8.setVisibility(View.GONE);
                            l_soal9.setVisibility(View.GONE);
                            l_soal10.setVisibility(View.GONE);
                            l_soal11.setVisibility(View.GONE);
                            l_soal12.setVisibility(View.GONE);
                            l_soal13.setVisibility(View.GONE);
                            l_soal14.setVisibility(View.GONE);
                            gejala2.setText(opsi4);
                            l_soal2.setVisibility(View.VISIBLE);
                            break;
                    }
                    return false;
                }
            });
            OpsiPilih.show();
            });

        chk2.setOnClickListener(v -> {
            if(gejala2.getText() == opsi2) {
                PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk2);
                OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String a = String.valueOf(item.getTitleCondensed());
                        switch (a) {
                            case "iya":
                                jawab2 = 1;
                                chk2.setText("Iya");
                                chk3.setText("Opsi");
                                gejala3.setText(opsi3);
                                l_soal3.setVisibility(View.VISIBLE);
                                break;
                            case "tidak":
                                jawab2 = 0;
                                chk2.setText("Tidak");
                                chk3.setText("Opsi");
                                gejala3.setText(opsi3);
                                l_soal3.setVisibility(View.VISIBLE);
                                break;
                        }
                        return false;
                    }
                });
                OpsiPilih.show();
            }
            if(gejala2.getText() == opsi4) {
                PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk2);
                OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String a = String.valueOf(item.getTitleCondensed());
                        switch (a) {
                            case "iya":
                                jawab4 = 1;
                                chk2.setText("Iya");
                                chk3.setText("Opsi");
                                chk4.setText("Opsi");
                                chk5.setText("Opsi");
                                chk6.setText("Opsi");
                                chk7.setText("Opsi");
                                chk8.setText("Opsi");
                                chk9.setText("Opsi");
                                chk10.setText("Opsi");
                                chk11.setText("Opsi");
                                chk12.setText("Opsi");
                                chk13.setText("Opsi");
                                chk14.setText("Opsi");
                                l_soal3.setVisibility(View.GONE);
                                l_soal4.setVisibility(View.GONE);
                                l_soal5.setVisibility(View.GONE);
                                l_soal6.setVisibility(View.GONE);
                                l_soal7.setVisibility(View.GONE);
                                l_soal8.setVisibility(View.GONE);
                                l_soal9.setVisibility(View.GONE);
                                l_soal10.setVisibility(View.GONE);
                                l_soal11.setVisibility(View.GONE);
                                l_soal12.setVisibility(View.GONE);
                                l_soal13.setVisibility(View.GONE);
                                l_soal14.setVisibility(View.GONE);
                                gejala3.setText(opsi5);
                                l_soal3.setVisibility(View.VISIBLE);
                                break;
                            case "tidak":
                                jawab4 = 0;
                                chk2.setText("Tidak");
                                chk3.setText("Opsi");
                                chk4.setText("Opsi");
                                chk5.setText("Opsi");
                                chk6.setText("Opsi");
                                chk7.setText("Opsi");
                                chk8.setText("Opsi");
                                chk9.setText("Opsi");
                                chk10.setText("Opsi");
                                chk11.setText("Opsi");
                                chk12.setText("Opsi");
                                chk13.setText("Opsi");
                                chk14.setText("Opsi");
                                l_soal3.setVisibility(View.GONE);
                                l_soal4.setVisibility(View.GONE);
                                l_soal5.setVisibility(View.GONE);
                                l_soal6.setVisibility(View.GONE);
                                l_soal7.setVisibility(View.GONE);
                                l_soal8.setVisibility(View.GONE);
                                l_soal9.setVisibility(View.GONE);
                                l_soal10.setVisibility(View.GONE);
                                l_soal11.setVisibility(View.GONE);
                                l_soal12.setVisibility(View.GONE);
                                l_soal13.setVisibility(View.GONE);
                                l_soal14.setVisibility(View.GONE);
                                gejala3.setText(opsi5);
                                l_soal3.setVisibility(View.VISIBLE);
                                break;
                        }
                        return false;
                    }
                });
                OpsiPilih.show();
            }
        });

        chk3.setOnClickListener(v -> {
            if(gejala3.getText() == opsi5) {
                PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk3);
                OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String a = String.valueOf(item.getTitleCondensed());
                        String j4 = String.valueOf(jawab4);
                        switch (j4) {
                            case "0":
                                switch (a) {
                                    case "iya":
                                        jawab5 = 1;
                                        chk3.setText("Iya");
                                        chk4.setText("Opsi");
                                        chk5.setText("Opsi");
                                        chk6.setText("Opsi");
                                        chk7.setText("Opsi");
                                        chk8.setText("Opsi");
                                        chk9.setText("Opsi");
                                        chk10.setText("Opsi");
                                        chk11.setText("Opsi");
                                        chk12.setText("Opsi");
                                        chk13.setText("Opsi");
                                        chk14.setText("Opsi");
                                        l_soal4.setVisibility(View.GONE);
                                        l_soal5.setVisibility(View.GONE);
                                        l_soal6.setVisibility(View.GONE);
                                        l_soal7.setVisibility(View.GONE);
                                        l_soal8.setVisibility(View.GONE);
                                        l_soal9.setVisibility(View.GONE);
                                        l_soal10.setVisibility(View.GONE);
                                        l_soal11.setVisibility(View.GONE);
                                        l_soal12.setVisibility(View.GONE);
                                        l_soal13.setVisibility(View.GONE);
                                        l_soal14.setVisibility(View.GONE);
                                        chk4.setText("Opsi");
                                        gejala4.setText(opsi6);
                                        l_soal4.setVisibility(View.VISIBLE);
                                        break;
                                    case "tidak":
                                        jawab5 = 0;
                                        chk3.setText("Tidak");
                                        chk4.setText("Opsi");
                                        chk5.setText("Opsi");
                                        chk6.setText("Opsi");
                                        chk7.setText("Opsi");
                                        chk8.setText("Opsi");
                                        chk9.setText("Opsi");
                                        chk10.setText("Opsi");
                                        chk11.setText("Opsi");
                                        chk12.setText("Opsi");
                                        chk13.setText("Opsi");
                                        chk14.setText("Opsi");
                                        l_soal4.setVisibility(View.GONE);
                                        l_soal5.setVisibility(View.GONE);
                                        l_soal6.setVisibility(View.GONE);
                                        l_soal7.setVisibility(View.GONE);
                                        l_soal8.setVisibility(View.GONE);
                                        l_soal9.setVisibility(View.GONE);
                                        l_soal10.setVisibility(View.GONE);
                                        l_soal11.setVisibility(View.GONE);
                                        l_soal12.setVisibility(View.GONE);
                                        l_soal13.setVisibility(View.GONE);
                                        l_soal14.setVisibility(View.GONE);
                                        chk4.setText("Opsi");
                                        gejala4.setText(opsi9);
                                        l_soal4.setVisibility(View.VISIBLE);
                                        break;
                                }
                                break;
                            case "1":
                                switch (a) {
                                    case "iya":
                                        jawab5 = 1;
                                        chk3.setText("Iya");
                                        break;
                                    case "tidak":
                                        jawab5 = 0;
                                        chk3.setText("Tidak");
                                        break;
                                }
                                break;
                        }
                        return false;
                    }
                });
                OpsiPilih.show();
            }

            if(gejala3.getText() == opsi3) {
                PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk3);
                OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String a = String.valueOf(item.getTitleCondensed());
                        switch (a) {
                            case "iya":
                                jawab3 = 1;
                                chk4.setText("Opsi");
                                chk3.setText("Iya");
                                break;
                            case "tidak":
                                jawab3 = 0;
                                chk4.setText("Opsi");
                                chk3.setText("Tidak");
                                break;
                        }
                        return true;
                    }
                });
                OpsiPilih.show();
            }
        });

        chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala4.getText() == opsi9) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk4);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk4.setText("Iya");
                                    jawab9 = 1;
                                    chk5.setText("Opsi");
                                    chk6.setText("Opsi");
                                    chk7.setText("Opsi");
                                    chk8.setText("Opsi");
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal5.setVisibility(View.GONE);
                                    l_soal6.setVisibility(View.GONE);
                                    l_soal7.setVisibility(View.GONE);
                                    l_soal8.setVisibility(View.GONE);
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala5.setText(opsi10);
                                    l_soal5.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    chk4.setText("Tidak");
                                    jawab9 = 0;
                                    chk5.setText("Opsi");
                                    chk6.setText("Opsi");
                                    chk7.setText("Opsi");
                                    chk8.setText("Opsi");
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal5.setVisibility(View.GONE);
                                    l_soal6.setVisibility(View.GONE);
                                    l_soal7.setVisibility(View.GONE);
                                    l_soal8.setVisibility(View.GONE);
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala5.setText(opsi14);
                                    l_soal5.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala4.getText() == opsi6) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk4);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab6 = 1;
                                    chk4.setText("Iya");
                                    gejala5.setText(opsi7);
                                    l_soal5.setVisibility(View.VISIBLE);

                                    break;
                                case "tidak":
                                    jawab6 = 0;
                                    chk4.setText("Tidak");
                                    gejala5.setText(opsi7);
                                    l_soal5.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        chk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala5.getText() == opsi14) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk5);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk5.setText("Iya");
                                    jawab14 = 1;
                                    chk6.setText("Opsi");
                                    chk7.setText("Opsi");
                                    chk8.setText("Opsi");
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal6.setVisibility(View.GONE);
                                    l_soal7.setVisibility(View.GONE);
                                    l_soal8.setVisibility(View.GONE);
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    break;
                                case "tidak":
                                    chk5.setText("Tidak");
                                    jawab14 = 0;
                                    chk6.setText("Opsi");
                                    chk7.setText("Opsi");
                                    chk8.setText("Opsi");
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal6.setVisibility(View.GONE);
                                    l_soal7.setVisibility(View.GONE);
                                    l_soal8.setVisibility(View.GONE);
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala6.setText(opsi15);
                                    l_soal6.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala5.getText() == opsi7) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk5);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab7 = 1;
                                    chk5.setText("Iya");
                                    gejala6.setText(opsi8);
                                    l_soal6.setVisibility(View.VISIBLE);

                                    break;
                                case "tidak":
                                    jawab7 = 0;
                                    chk5.setText("Tidak");
                                    gejala6.setText(opsi8);
                                    l_soal6.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }

                if(gejala5.getText() == opsi10) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk5);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab10 = 1;
                                    chk5.setText("Iya");
                                    gejala6.setText(opsi11);
                                    l_soal6.setVisibility(View.VISIBLE);

                                    break;
                                case "tidak":
                                    jawab10 = 0;
                                    chk5.setText("Tidak");
                                    gejala6.setText(opsi11);
                                    l_soal6.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        chk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala6.getText() == opsi15) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk6);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk6.setText("Iya");
                                    jawab15 = 1;
                                    chk7.setText("Opsi");
                                    chk8.setText("Opsi");
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal7.setVisibility(View.GONE);
                                    l_soal8.setVisibility(View.GONE);
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala7.setText(opsi16);
                                    l_soal7.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    chk6.setText("Tidak");
                                    jawab15 = 0;
                                    chk7.setText("Opsi");
                                    chk8.setText("Opsi");
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal7.setVisibility(View.GONE);
                                    l_soal8.setVisibility(View.GONE);
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala7.setText(opsi17);
                                    l_soal7.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala6.getText() == opsi8) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk6);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab8 = 1;
                                    chk6.setText("Iya");
                                    break;
                                case "tidak":
                                    jawab8 = 0;
                                    chk6.setText("Tidak");
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }

                if(gejala6.getText() == opsi11) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk6);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab11 = 1;
                                    chk6.setText("Iya");
                                    gejala7.setText(opsi12);
                                    l_soal7.setVisibility(View.VISIBLE);

                                    break;
                                case "tidak":
                                    jawab11 = 0;
                                    chk6.setText("Tidak");
                                    gejala7.setText(opsi12);
                                    l_soal7.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        chk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala7.getText() == opsi17) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk7);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk7.setText("Iya");
                                    jawab17 = 1;
                                    chk8.setText("Opsi");
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal8.setVisibility(View.GONE);
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala8.setText(opsi6);
                                    l_soal8.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    chk7.setText("Tidak");
                                    jawab17 = 0;
                                    chk8.setText("Opsi");
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal8.setVisibility(View.GONE);
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala8.setText(opsi20);
                                    l_soal8.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala7.getText() == opsi12) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk7);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab12 = 1;
                                    chk7.setText("Iya");
                                    gejala8.setText(opsi13);
                                    l_soal8.setVisibility(View.VISIBLE);

                                    break;
                                case "tidak":
                                    jawab12 = 0;
                                    chk7.setText("Tidak");
                                    gejala8.setText(opsi13);
                                    l_soal8.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala7.getText() == opsi16) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk7);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab16 = 1;
                                    chk7.setText("Iya");
                                    break;
                                case "tidak":
                                    jawab16 = 0;
                                    chk7.setText("Tidak");
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        chk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala8.getText() == opsi20) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk8);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk8.setText("Iya");
                                    jawab20 = 1;
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala9.setText(opsi6);
                                    l_soal9.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    chk8.setText("Tidak");
                                    jawab20 = 0;
                                    chk9.setText("Opsi");
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal9.setVisibility(View.GONE);
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala9.setText(opsi21);
                                    l_soal9.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala8.getText() == opsi13) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk8);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab13 = 1;
                                    chk8.setText("Iya");
                                    break;
                                case "tidak":
                                    jawab13 = 0;
                                    chk8.setText("Tidak");
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala8.getText() == opsi6) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk8);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab6 = 1;
                                    chk8.setText("Iya");
                                    gejala9.setText(opsi18);
                                    l_soal9.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    jawab6 = 0;
                                    chk8.setText("Tidak");
                                    gejala9.setText(opsi18);
                                    l_soal9.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        chk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala9.getText() == opsi21) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk9);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk9.setText("Iya");
                                    jawab21 = 1;
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala10.setText(opsi9);
                                    l_soal10.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    chk9.setText("Tidak");
                                    jawab21 = 0;
                                    chk10.setText("Opsi");
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal10.setVisibility(View.GONE);
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala10.setText(opsi22);
                                    l_soal10.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala9.getText() == opsi18) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk9);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab18 = 1;
                                    chk9.setText("Iya");
                                    gejala10.setText(opsi19);
                                    l_soal10.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    jawab18 = 0;
                                    chk9.setText("Tidak");
                                    gejala10.setText(opsi19);
                                    l_soal10.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala9.getText() == opsi6) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk9);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab6 = 1;
                                    chk9.setText("Iya");
                                    break;
                                case "tidak":
                                    jawab6 = 0;
                                    chk9.setText("Tidak");
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        chk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala10.getText() == opsi22) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk10);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk10.setText("Iya");
                                    jawab22 = 1;
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala11.setText(opsi23);
                                    l_soal11.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    chk10.setText("Tidak");
                                    jawab22 = 0;
                                    chk11.setText("Opsi");
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala11.setText(opsi25);
                                    l_soal11.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala10.getText() == opsi19) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk10);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab19 = 1;
                                    chk10.setText("Iya");
                                    break;
                                case "tidak":
                                    jawab19 = 0;
                                    chk10.setText("Tidak");
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala10.getText() == opsi9) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk10);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab9 = 1;
                                    chk10.setText("Iya");
                                    break;
                                case "tidak":
                                    jawab9 = 0;
                                    chk10.setText("Tidak");
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });


        chk11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala11.getText() == opsi25) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk11);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk11.setText("Iya");
                                    jawab25 = 1;
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala12.setText(opsi26);
                                    l_soal12.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    chk4.setText("Tidak");
                                    jawab25 = 0;
                                    chk12.setText("Opsi");
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal11.setVisibility(View.GONE);
                                    l_soal12.setVisibility(View.GONE);
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala12.setText(opsi27);
                                    l_soal12.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala11.getText() == opsi23) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk11);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab23 = 1;
                                    chk11.setText("Iya");
                                    gejala12.setText(opsi24);
                                    l_soal12.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    jawab23 = 0;
                                    chk11.setText("Tidak");
                                    gejala12.setText(opsi24);
                                    l_soal12.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        chk12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala12.getText() == opsi27) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk12);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk12.setText("Iya");
                                    jawab27 = 1;
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    gejala13.setText(opsi28);
                                    l_soal13.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    chk12.setText("Tidak");
                                    jawab27 = 0;
                                    chk13.setText("Opsi");
                                    chk14.setText("Opsi");
                                    l_soal13.setVisibility(View.GONE);
                                    l_soal14.setVisibility(View.GONE);
                                    Toast.makeText(MainActivity.this, "Tekan Button Detail untuk lebih lanjut mengdiagnosa", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala12.getText() == opsi24) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk12);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab24 = 1;
                                    chk12.setText("Iya");
                                    break;
                                case "tidak":
                                    jawab6 = 0;
                                    chk12.setText("Tidak");
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
                if(gejala12.getText() == opsi26) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk12);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    jawab26 = 1;
                                    chk12.setText("Iya");
                                    break;
                                case "tidak":
                                    jawab26 = 0;
                                    chk12.setText("Tidak");
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        chk13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala13.getText() == opsi28) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk13);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk13.setText("Iya");
                                    jawab28 = 1;
                                    gejala14.setText(opsi29);
                                    l_soal14.setVisibility(View.VISIBLE);
                                    break;
                                case "tidak":
                                    chk13.setText("Tidak");
                                    jawab28 = 0;
                                    gejala14.setText(opsi29);
                                    l_soal14.setVisibility(View.VISIBLE);
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        chk14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gejala14.getText() == opsi29) {
                    PopupMenu OpsiPilih = new PopupMenu(getApplicationContext(), chk14);
                    OpsiPilih.getMenuInflater().inflate(R.menu.opsi_dd, OpsiPilih.getMenu());
                    OpsiPilih.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String a = String.valueOf(item.getTitleCondensed());
                            switch (a) {
                                case "iya":
                                    chk14.setText("Iya");
                                    jawab29 = 1;
                                    break;
                                case "tidak":
                                    chk14.setText("Tidak");
                                    jawab29 = 0;
                                    break;
                            }
                            return true;
                        }
                    });
                    OpsiPilih.show();
                }
            }
        });

        btDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jawab1 == 0 && jawab2 == 0 && jawab3 == 0 && jawab4 == 0 && jawab5 == 0 && jawab6 == 0 && jawab7 == 0 && jawab8 == 0 && jawab9 == 0 &&
                        jawab10 == 0 && jawab11 == 0 && jawab12 == 0 && jawab13 == 0 && jawab14 == 0 && jawab15 == 0 && jawab16 == 0 && jawab17 == 0 &&
                        jawab18 == 0 && jawab19 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 0 && jawab23 == 0 && jawab24 == 0 && jawab25 == 0 &&
                        jawab26 == 0 && jawab27 == 0 && jawab28 == 0 && jawab29 == 0 ){
                    Toast.makeText(MainActivity.this, "Minimal 1 jawaban \"IYA\", jika tidak ada gejala berarti tumbuhan SEHAT", Toast.LENGTH_LONG).show();
                }
                else if (jawab1 == 1 && jawab2 == 0 && jawab3 == 0){
                    getData("P001");
                }
                else if (jawab1 == 1 && jawab2 == 0 && jawab3 == 1){
                    getData("P001");
                }
                else if (jawab1 == 1 && jawab2 == 1 && jawab3 == 0){
                    getData("P001");
                }
                else if (jawab1 == 1 && jawab2 == 1 && jawab3 == 1){
                    getData("P001"); }

                else if (jawab1 == 0 && jawab4 == 1 && jawab5 == 0){
                    getData("P002");
                }
                else if (jawab1 == 0 && jawab4 == 1 && jawab5 == 1){
                    getData("P002");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 1 && jawab6 == 0 && jawab7 == 0 && jawab8 == 0){
                    getData("P003");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 1 && jawab6 == 0 && jawab7 == 1 && jawab8 == 0){
                    getData("P003");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 1 && jawab6 == 0 && jawab7 == 0 && jawab8 == 1){
                    getData("P003");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 1 && jawab6 == 0 && jawab7 == 1 && jawab8 == 1){
                    getData("P003");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 1 && jawab6 == 1 && jawab7 == 0 && jawab8 == 0){
                    getData("P003");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 1 && jawab6 == 1 && jawab7 == 1 && jawab8 == 0){
                    getData("P003");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 1 && jawab6 == 1 && jawab7 == 0 && jawab8 == 1){
                    getData("P003");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 1 && jawab6 == 1 && jawab7 == 1 && jawab8 == 1){
                    getData("P003");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 0 && jawab11 == 0 && jawab12 == 0 && jawab13 == 0){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 1 && jawab11 == 0 && jawab12 == 0 && jawab13 == 0){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 1 && jawab11 == 1 && jawab12 == 0 && jawab13 == 0){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 1 && jawab11 == 1 && jawab12 == 1 && jawab13 == 0){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 1 && jawab11 == 1 && jawab12 == 1 && jawab13 == 1){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 0 && jawab11 == 1 && jawab12 == 0 && jawab13 == 0){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 0 && jawab11 == 1 && jawab12 == 1 && jawab13 == 0){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 0 && jawab11 == 1 && jawab12 == 1 && jawab13 == 1){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 0 && jawab11 == 0 && jawab12 == 1 && jawab13 == 0){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 0 && jawab11 == 0 && jawab12 == 1 && jawab13 == 1){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 1 && jawab11 == 0 && jawab12 == 1 && jawab13 == 1){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 0 && jawab11 == 0 && jawab12 == 0 && jawab13 == 1){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 1 && jawab11 == 0 && jawab12 == 0 && jawab13 == 1){
                    getData("P004");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 1 && jawab10 == 1 && jawab11 == 1 && jawab12 == 0 && jawab13 == 1){
                    getData("P004");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 1 && jawab5 == 0){
                    getData("P005");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 1 && jawab5 == 1){
                    getData("P005");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 1 && jawab16 == 0){
                    getData("P006");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 1 && jawab16 == 1){
                    getData("P006");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 1 && jawab18 == 0 && jawab19 == 0){
                    getData("P007");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 1 && jawab18 == 1 && jawab19 == 0){
                    getData("P007");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 1 && jawab18 == 0 && jawab19 == 1){
                    getData("P007");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 1 && jawab18 == 1 && jawab19 == 1){
                    getData("P007");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 1){
                    getData("P008");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 1){
                    getData("P009");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 1 && jawab23 == 0 && jawab24 == 0){
                    getData("P010");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 1 && jawab23 == 1 && jawab24 == 0){
                    getData("P010");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 1 && jawab23 == 0 && jawab24 == 1){
                    getData("P010");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 1 && jawab23 == 1 && jawab24 == 1){
                    getData("P010");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 0 && jawab25 == 1 && jawab26 == 0){
                    getData("P011");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 0 && jawab25 == 1 && jawab26 == 1){
                    getData("P011");
                }

                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 0 && jawab25 == 0 && jawab27 == 1 && jawab28 == 0 && jawab29 == 0){
                    getData("P012");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 0 && jawab25 == 0 && jawab27 == 1 && jawab28 == 1 && jawab29 == 0){
                    getData("P012");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 0 && jawab25 == 0 && jawab27 == 1 && jawab28 == 0 && jawab29 == 1){
                    getData("P012");
                }
                else if (jawab1 == 0 && jawab4 == 0 && jawab5 == 0 && jawab9 == 0 && jawab14 == 0 && jawab15 == 0 && jawab17 == 0 && jawab20 == 0 && jawab21 == 0 && jawab22 == 0 && jawab25 == 0 && jawab27 == 1 && jawab28 == 1 && jawab29 == 1){
                    getData("P012");
                }
            }
        });

    }


    private void LoadPertanyaan(){
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G001").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya1 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi1 = "1. ";
            opsi1 += db_tanya1 + "?";
            gejala1.setText(opsi1);
            l_soal1.setVisibility(View.VISIBLE);
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G002").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya2 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi2 = "2. ";
            opsi2 += db_tanya2 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G003").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya3 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi3 = "3. ";
            opsi3 += db_tanya3 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G004").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya4 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi4 = "4. ";
            opsi4 += db_tanya4 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G005").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya5 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi5 = "5. ";
            opsi5 += db_tanya5 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G006").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya6 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi6 = "6. ";
            opsi6 += db_tanya6 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G007").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya7 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi7 = "7. ";
            opsi7 += db_tanya7 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G008").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya8 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi8 = "8. ";
            opsi8 += db_tanya8 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G009").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya9 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi9 = "9. ";
            opsi9 += db_tanya9 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G010").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya10 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi10 = "10. ";
            opsi10 += db_tanya10 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G011").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya11 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi11 = "11. ";
            opsi11 += db_tanya11 + "?";
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G012").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya12 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi12 = "12. ";
            opsi12 += db_tanya12 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G013").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya13 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi13 = "13. ";
            opsi13 += db_tanya13 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G014").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya14 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi14 = "14. ";
            opsi14 += db_tanya14 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G015").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya15 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi15 = "15. ";
            opsi15 += db_tanya15 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G0016").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya16 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi16 = "16. ";
            opsi16 += db_tanya16 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G017").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya17 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi17 = "17. ";
            opsi17 += db_tanya17 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G018").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya18 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi18 = "18. ";
            opsi18 += db_tanya18 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G019").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya19 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi19 = "19. ";
            opsi19 += db_tanya19 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G020").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya20 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi20 = "20. ";
            opsi20 += db_tanya20 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G021").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya21 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi21 = "21. ";
            opsi21 += db_tanya21 + "?";
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G022").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya22 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi22 = "22. ";
            opsi22 += db_tanya22 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G023").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya23 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi23 = "23. ";
            opsi23 += db_tanya23 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G024").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya24 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi24 = "24. ";
            opsi24 += db_tanya24 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G025").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya25 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi25 = "25. ";
            opsi25 += db_tanya25 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G026").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya26 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi26 = "26. ";
            opsi26 += db_tanya26 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G027").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya27 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi27 = "27. ";
            opsi27 += db_tanya27 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G028").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya28 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi28 = "28. ";
            opsi28 += db_tanya28 + "?" ;
        });
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("gejala");
        BaseSistemPakar.child("G029").get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_tanya29 = String.valueOf(dataSnapshot.child("nama").getValue());
            opsi29 = "29. ";
            opsi29 += db_tanya29 + "?" ;
        });
    }

    private void getData(String getPenyakit){
        BaseSistemPakar = FirebaseDatabase.getInstance().getReference("penyakit");
        BaseSistemPakar.child(getPenyakit).get().addOnCompleteListener(task -> {
            DataSnapshot dataSnapshot = task.getResult();
            String db_penyakit1 = String.valueOf(dataSnapshot.child("nama").getValue());
            String db_solusi1 = String.valueOf(dataSnapshot.child("solusi").getValue());
            db_hasilAnalisa = db_penyakit1;
            db_hasilSolusi = db_solusi1;
            hasilAnalisa += "(" + getPenyakit + ") " + db_hasilAnalisa + "\n";
            hasilSolusi +="(" + getPenyakit + ") " + db_hasilSolusi + "\n\n";
            saveData();
        });
    }

    private final void saveData(){
        if(hasilAnalisa != "null"){
            TampilHasilAnalisa();
        }
        else{
            Toast.makeText(MainActivity.this, "Data Tidak Ada", Toast.LENGTH_SHORT).show();
        }
    }

    private final void TampilHasilAnalisa(){
        Intent intent = new Intent(MainActivity.this, TampilAnalisa.class);
        intent.putExtra("HasilAnalisa", hasilAnalisa);
        intent.putExtra("HasilSolusi", hasilSolusi);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}