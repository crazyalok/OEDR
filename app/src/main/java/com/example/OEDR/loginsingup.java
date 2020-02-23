package com.example.OEDR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class loginsingup extends AppCompatActivity {
    public void login(View view){
        Intent intent = new Intent(loginsingup.this,login.class);
        startActivity(intent);
    }
    public void signup(View view){
        Intent intent = new Intent(loginsingup.this,signup.class);
        startActivity(intent);
    }
public void about(View view){
    Intent intent = new Intent(loginsingup.this,aboutus.class);
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
        setContentView(R.layout.activity_loginsingup);
    }
}
