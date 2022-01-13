package com.example.ayotajwid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class BelajarActivity extends AppCompatActivity {

    private StorageReference mStorageReference;
    ImageButton nun, mim, mad, lam, ra, idgham, ghunnah, qalqalah, back;
    Animation scaleUp, scaleDown;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        nun = findViewById(R.id.nunSukun);
        mim = findViewById(R.id.mimSukun);
        mad = findViewById(R.id.mad);
        lam = findViewById(R.id.lam);
        ra = findViewById(R.id.ra);
        idgham = findViewById(R.id.idgham);
        ghunnah = findViewById(R.id.ghunnah);
        qalqalah = findViewById(R.id.qalqalah);
        back = findViewById(R.id.back);

        nun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BelajarActivity.this, NunActivity.class);
                startActivity(intent);
            }
        });

        mim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BelajarActivity.this, MimActivity.class);
                startActivity(intent);
            }
        });

        mad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BelajarActivity.this, MadActivity.class);
                startActivity(intent);
            }
        });

        lam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BelajarActivity.this, LamActivity.class);
                startActivity(intent);
            }
        });

        ra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BelajarActivity.this, RaActivity.class);
                startActivity(intent);
            }
        });

        idgham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BelajarActivity.this, IdghamActivity.class);
                startActivity(intent);
            }
        });

        ghunnah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BelajarActivity.this, GhunnahActivity.class);
                startActivity(intent);
            }
        });

        qalqalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BelajarActivity.this, QalqalahActivity.class);
                startActivity(intent);
            }
        });

        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(BelajarActivity.this, MainActivity.class);
                startActivity(intent);

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    back.startAnimation(scaleUp);
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    back.startAnimation(scaleDown);
                }

                return true;
            }
        });

//        mStorageReference = FirebaseStorage.getInstance().getReference().child("images/btn_back.png");
//
//        try {
//            final File localFile = File.createTempFile("btn_back", "png");
//
//            mStorageReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                    ((ImageButton) findViewById(R.id.back)).setImageBitmap(bitmap);
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}