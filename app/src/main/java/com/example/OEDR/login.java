package com.example.OEDR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {
    public void login(View view){
        Intent intent = new Intent(login.this,home.class);
        startActivity(intent);
    }
    public void register(View view){
        Intent intent = new Intent(login.this,signup.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_login);
    }
}
