package com.example.OEDR;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Patterns;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    DatabaseReference reff;
    user user1;
    boolean flag=false;
    TextView error4;
    public void register(View view ) {
    EditText fname, lname, email, password, cpassword;
    fname = findViewById(R.id.editText2);
    lname = findViewById(R.id.editText3);
    email = findViewById(R.id.editText4);
    password = findViewById(R.id.editText5);
    cpassword = findViewById(R.id.editText6);
    reff = FirebaseDatabase.getInstance().getReference().child("User");
    String s2, s3, s4, s5, s6;
    // s2=fname.toString().trim();
    s2 = fname.getText().toString();
    String nullstring = "";
    s3 = lname.getText().toString().trim();
    s4 = email.getText().toString().trim();
    s5 = password.getText().toString().trim();
    s6 = cpassword.getText().toString().trim();
    String c;

    if (s2.compareTo(nullstring)!=0) {
        fname.setBackgroundResource(R.drawable.default_edittext);
        flag = false;
        TextView error2 =findViewById(R.id.error2);
        error2.setText("");
    } else {
        fname.setBackgroundResource(R.drawable.warning_edittext);
        flag = true;
        c="enter a valid name";
        TextView error2 =findViewById(R.id.error2);
        error2.setText(c);
    }
    if (s3.compareTo(nullstring)!=0) {
        lname.setBackgroundResource(R.drawable.default_edittext);
        flag = false;
        TextView error3 =findViewById(R.id.error3);
        error3.setText("");
    } else {
        lname.setBackgroundResource(R.drawable.warning_edittext);
        flag = true;
        c="enter a valid name";
        TextView error3 =findViewById(R.id.error3);
        error3.setText(c);
    }
    if (s4.compareTo(nullstring)!=0) {
        email.setBackgroundResource(R.drawable.default_edittext);
        flag = false;
        c="";
        error4 =findViewById(R.id.error4);
        error4.setText(c);
        if(Patterns.EMAIL_ADDRESS.matcher(s4).matches()){
            flag = false;
            email.setBackgroundResource(R.drawable.default_edittext);

        }
        else{
            flag = true;
            email.setBackgroundResource(R.drawable.warning_edittext);
            c="enter a valid email address";
            error4 =findViewById(R.id.error4);
            error4.setText(c);

        }
    } else {
        email.setBackgroundResource(R.drawable.warning_edittext);
        flag = true;
        c="enter email address";
        error4 =findViewById(R.id.error4);
        error4.setText(c);
    }
    if (s5.compareTo(nullstring)!=0) {
        password.setBackgroundResource(R.drawable.default_edittext);
        flag = false;
        c="";
        TextView error5 =findViewById(R.id.error5);
        error5.setText(c);
    } else {
        password.setBackgroundResource(R.drawable.warning_edittext);
        flag = true;
        c="enter a valid password";
        TextView error6 =findViewById(R.id.error5);
        error6.setText(c);
    }
    if (s6.compareTo(nullstring)!=0) {
        cpassword.setBackgroundResource(R.drawable.default_edittext);
        flag = false;
        c="";
        TextView error6 =findViewById(R.id.error6);
        error6.setText(c);
    } else {
        cpassword.setBackgroundResource(R.drawable.warning_edittext);
        flag = true;
        c="enter a valid password";
        TextView error6 =findViewById(R.id.error6);
        error6.setText(c);
    }
    if(s5.compareTo(s6)==0 && s5.length() > 6){
        flag = false;
        cpassword.setBackgroundResource(R.drawable.default_edittext);
        password.setBackgroundResource(R.drawable.default_edittext);
        c="";
        TextView error6 =findViewById(R.id.error6);
        error6.setText(c);
    }
    else
    {
        password.setBackgroundResource(R.drawable.warning_edittext);
        cpassword.setBackgroundResource(R.drawable.warning_edittext);
        flag = true;
        c="enter a valid password";
        TextView error6 =findViewById(R.id.error6);
        error6.setText(c);
    }
    if (flag == false) {
        user1 = new user();
        user1.setFname(s2);
        user1.setLname(s3);
        user1.setEmail(s4);
        user1.setPassword(s5);
        user1.setCpassword(s6);
        reff.push().setValue(user1);
        Toast.makeText(signup.this,s2,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(signup.this, login.class);
        startActivity(intent);
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_signup);
    }
}
