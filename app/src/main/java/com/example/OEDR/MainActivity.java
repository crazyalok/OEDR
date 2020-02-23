package com.example.OEDR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.animate().alpha(0).setDuration(2400);

        new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    Intent intent = new Intent(MainActivity.this,loginsingup.class);
                    startActivity(intent);
                    finish();
                }

            },SPLASH_TIME_OUT);



    }
}
