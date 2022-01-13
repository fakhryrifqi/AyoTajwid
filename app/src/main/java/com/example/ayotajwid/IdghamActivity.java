package com.example.ayotajwid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class IdghamActivity extends AppCompatActivity {

    ImageButton mutamatsilain, mutaqaribain, mutajanisain, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idgham);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mutamatsilain = findViewById(R.id.idghamMutamatsilain);
        mutaqaribain = findViewById(R.id.idghamMutaqaribain);
        mutajanisain = findViewById(R.id.idghamMutajanisain);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdghamActivity.this, BelajarActivity.class);
                startActivity(intent);
            }
        });
    }
}