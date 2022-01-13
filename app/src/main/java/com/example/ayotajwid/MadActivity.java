package com.example.ayotajwid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MadActivity extends AppCompatActivity {

    ImageButton thabii, wajib, jaiz, mukhaffafKilmi, mutsaqqalKilmi, mukhaffafHarfi, mutsaqqalHarfi, qashirah, thawilah, arid, badal, farqi, layyin, tamkin, iwadl, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        thabii = findViewById(R.id.madThobii);
        wajib = findViewById(R.id.madWajibMuttasil);
        jaiz = findViewById(R.id.madJaizMunfasil);
        mukhaffafKilmi = findViewById(R.id.madMukhaffafKilmi);
        mutsaqqalKilmi = findViewById(R.id.madMutsaqqalKilmi);
        mukhaffafHarfi = findViewById(R.id.madLazimHarfiMukhaffaf);
        mutsaqqalHarfi = findViewById(R.id.madLazimHarfiMutsaqqal);
        qashirah = findViewById(R.id.madShilahQashirah);
        thawilah = findViewById(R.id.madShilahThawilah);
        arid = findViewById(R.id.madAridLissukun);
        badal = findViewById(R.id.madBadal);
        farqi = findViewById(R.id.madFarqi);
        layyin = findViewById(R.id.madLayyin);
        tamkin = findViewById(R.id.madTamkin);
        iwadl = findViewById(R.id.madIwadl);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MadActivity.this, BelajarActivity.class);
                startActivity(intent);
            }
        });
    }
}