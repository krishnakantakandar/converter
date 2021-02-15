package com.example.lenovo.anyconverter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2ActivityFlash extends AppCompatActivity {
private ImageView imageView;
private static int SPLASH=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_flash);
        getSupportActionBar().hide();
        imageView=findViewById(R.id.imageView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent= new Intent(Main2ActivityFlash.this,MainActivity.class);
                startActivity(homeintent);
                finish();
            }
        },SPLASH);
    }
}
