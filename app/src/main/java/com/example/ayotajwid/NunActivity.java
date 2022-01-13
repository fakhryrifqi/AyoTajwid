package com.example.ayotajwid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class NunActivity extends AppCompatActivity {

    ImageButton idzhar, ikhfa, iqlab, idghamBighunnah, idghamBilaghunnah, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nun);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        idzhar = findViewById(R.id.idzhar);
        ikhfa = findViewById(R.id.ikhfa);
        iqlab = findViewById(R.id.iqlab);
        idghamBighunnah = findViewById(R.id.idghamBigunnah);
        idghamBilaghunnah = findViewById(R.id.idghamBilagunnah);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NunActivity.this, BelajarActivity.class);
                startActivity(intent);
            }
        });
    }
}