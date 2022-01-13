package com.example.ayotajwid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MimActivity extends AppCompatActivity {

    ImageButton idzhar, ikhfa, idgham, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mim);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        idzhar = findViewById(R.id.idzharSyafawi);
        ikhfa = findViewById(R.id.ikhfaSyafawi);
        idgham = findViewById(R.id.idghamMimi);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MimActivity.this, BelajarActivity.class);
                startActivity(intent);
            }
        });
    }
}