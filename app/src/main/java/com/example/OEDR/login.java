package com.example.OEDR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {
    EditText username,password;
    public void login(View view){
        user user1;
        DatabaseReference reff;
        boolean flag=true;
        String nullstring="";
        TextView error1,error2;
        password = findViewById(R.id.editText7);
        username = findViewById(R.id.editText);
        String s1,s2;
        s1=username.getText().toString();
        s2=password.getText().toString();
        if (s1.compareTo(nullstring)==0){
            flag=true;
            error1=findViewById(R.id.textView7);
            error1.setText("enter username");

        }
        else{
            flag=false;
            error1=findViewById(R.id.textView7);
            error1.setText("");
        }
        if(s2.compareTo(nullstring)==0){
            flag=true;
            error2=findViewById(R.id.textView8);
            error2.setText("enter password");
        }
        else{
            flag=false;
            error2=findViewById(R.id.textView8);
            error2.setText("");
        }
        if (flag==false){
            Intent intent = new Intent(login.this,home.class);
            startActivity(intent);
        }
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
