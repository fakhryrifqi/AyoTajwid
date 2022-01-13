package com.example.ayotajwid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class LamActivity extends AppCompatActivity {

    ImageButton tafkhim, tarqiq, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tafkhim = findViewById(R.id.lamTafkhim);
        tarqiq = findViewById(R.id.lamTarqiq);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LamActivity.this, BelajarActivity.class);
                startActivity(intent);
            }
        });
    }
}