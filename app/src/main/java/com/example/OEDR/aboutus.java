package com.example.OEDR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class aboutus extends AppCompatActivity {

    public void git26(View view){
        goToUrl("https://github.com/crazyalok");
    }
    public void git27(View view){
        goToUrl("https://github.com/aman5683");
    }
    public void linkedin26(View view){
        goToUrl("https://www.linkedin.com/in/alok-maurya-543581181/");
    }
    public void linkedin27(View view){
        goToUrl("https://www.linkedin.com/in/aman-ghatiya5683");
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_aboutus);

    }
}
