package com.example.OEDR;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class login extends AppCompatActivity {
    EditText username,password;
    int i;
    ArrayList<String> users ;
    ArrayList<ArrayList<String>> table= new ArrayList<ArrayList<String>>() ;
    DatabaseReference reff;
    HashMap<String,Object> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_login);
        i=0;
        reff = FirebaseDatabase.getInstance().getReference().child("user");
        reff.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                 map =(HashMap<String,Object> )dataSnapshot.getValue();
                table.add(new ArrayList<String>(Arrays.asList(map.get("email").toString(),map.get("password").toString())));
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
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
        if (s1.compareTo(nullstring)!=0) {
            username.setBackgroundResource(R.drawable.default_edittext);
            flag = false;
            error1=findViewById(R.id.textView7);
            error1.setText("");
            if(Patterns.EMAIL_ADDRESS.matcher(s1).matches()){
                flag = false;
                username.setBackgroundResource(R.drawable.default_edittext);
            }
            else{
                flag = true;
                username.setBackgroundResource(R.drawable.warning_edittext);
                error1=findViewById(R.id.textView7);
                error1.setText("enter valid username");
            }
        }
        else {
            username.setBackgroundResource(R.drawable.warning_edittext);
            flag = true;
            error1 =findViewById(R.id.textView7);
            error1.setText("enter username");
        }

        if(s2.compareTo(nullstring)!=0 && flag==false && s2.length()>=6){

            flag=false;
            error2=findViewById(R.id.textView8);
            error2.setText("");
            password.setBackgroundResource(R.drawable.default_edittext);
        }
        else{
            flag=true;
            error2=findViewById(R.id.textView8);
            error2.setText("enter password");
            password.setBackgroundResource(R.drawable.warning_edittext);
        }
        if(flag==false) {
            boolean flag1=false;
            ArrayList<String> a1 =null;
            for (int i = 0; i < table.size(); i++) {
                a1 = table.get(i);
                Log.e(a1.get(0), "lkjh");
                Log.e(a1.get(1), "lkjh");
                //Log.e(s1, "lkjh");
               // Log.e(s2, "lkjh");
                if (a1.get(0).compareTo(s1)==0 && a1.get(1).compareTo(s2)==0) {
                        Intent intent = new Intent(login.this, home.class);
                        startActivity(intent);
                        flag1=true;
                        break;
                    }
                else{
                    flag=false;
                }

            }
            if(!flag1){
                    error2 = findViewById(R.id.textView8);
                    error2.setText("Invalid username/password");
            }

        }

    }
    public void register(View view){

        Intent intent = new Intent(login.this,signup.class);
        startActivity(intent);
    }
}
