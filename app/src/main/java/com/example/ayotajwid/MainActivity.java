package com.example.ayotajwid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

//    private StorageReference srBelajar, srQuis, srOptions, srExit;
    ImageButton menuBelajar, menuQuis, menuExit;
    Animation scaleUp, scaleDown;
    MediaPlayer media;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        menuBelajar = findViewById(R.id.btnBelajar);
        menuQuis = findViewById(R.id.btnQuis);
        menuExit = findViewById(R.id.btnExit);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        menuBelajar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(MainActivity.this, BelajarActivity.class);
                startActivity(intent);

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    menuBelajar.startAnimation(scaleUp);
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    menuBelajar.startAnimation(scaleDown);
                }

                return true;
            }
        });

        menuQuis.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(MainActivity.this, InstruksiActivity.class);
                startActivity(intent);

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    menuQuis.startAnimation(scaleUp);
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    menuQuis.startAnimation(scaleDown);
                }

                return true;
            }
        });

        menuExit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
//                finish();

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    menuExit.startAnimation(scaleUp);
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    menuExit.startAnimation(scaleDown);
                }

                return true;
            }
        });

//        srBelajar = FirebaseStorage.getInstance().getReference().child("images/btn_belajar.png");
//        srQuis = FirebaseStorage.getInstance().getReference().child("images/btn_quis.png");
//        srOptions = FirebaseStorage.getInstance().getReference().child("images/btn_options.png");
//        srExit = FirebaseStorage.getInstance().getReference().child("images/btn_exit.png");
//
//        try {
//            final File belajar = File.createTempFile("btn_belajar", "png");
//            final File quis = File.createTempFile("btn_quis", "png");
//            final File options = File.createTempFile("btn_options", "png");
//            final File exit = File.createTempFile("btn_exit", "png");
//
//            srBelajar.getFile(belajar).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                    Bitmap bitmap = BitmapFactory.decodeFile(belajar.getAbsolutePath());
//                    ((ImageButton) findViewById(R.id.btnBelajar)).setImageBitmap(bitmap);
//                }
//            });
//
//            srQuis.getFile(quis).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                    Bitmap bitmap = BitmapFactory.decodeFile(quis.getAbsolutePath());
//                    ((ImageButton) findViewById(R.id.btnQuis)).setImageBitmap(bitmap);
//                }
//            });
//
//            srOptions.getFile(options).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                    Bitmap bitmap = BitmapFactory.decodeFile(options.getAbsolutePath());
//                    ((ImageButton) findViewById(R.id.btnOptions)).setImageBitmap(bitmap);
//                }
//            });
//
//            srExit.getFile(exit).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                    Bitmap bitmap = BitmapFactory.decodeFile(exit.getAbsolutePath());
//                    ((ImageButton) findViewById(R.id.btnExit)).setImageBitmap(bitmap);
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}