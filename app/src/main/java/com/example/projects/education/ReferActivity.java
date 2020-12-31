package com.example.projects.education;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReferActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button facebook, whatsapp, twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer);

        toolbar = findViewById(R.id.toolbar);
        facebook = findViewById(R.id.facebook);
        whatsapp = findViewById(R.id.whatsapp);
        twitter = findViewById(R.id.twitter);

        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        toolbar.setBackgroundColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm=getPackageManager();
                try {
                    PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if(isPackageInstalled("com.whatsapp",pm)){
                    String link = ""; // here we can add link or anything we want to send
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, link);
                    sendIntent.setType("text/plain");
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(Intent.createChooser(sendIntent,"Share with"));
                }else{
                    Toast.makeText(ReferActivity.this, "Please install app before inviting friends.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm=getPackageManager();
                try {
                    PackageInfo info = pm.getPackageInfo("com.facebook.katana", PackageManager.GET_META_DATA);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if(isPackageInstalled("com.facebook.katana",pm)){
                    String link = ""; // here we can add link or anything we want to send
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, link);
                    sendIntent.setType("text/plain");
                    sendIntent.setPackage("com.facebook.katana");
                    startActivity(Intent.createChooser(sendIntent,"Share with"));
                } else{
                    Toast.makeText(ReferActivity.this, "Please install app before inviting friends.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm = getPackageManager();
                try {
                    PackageInfo info = pm.getPackageInfo("com.twitter.android", PackageManager.GET_META_DATA);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if(isPackageInstalled("com.twitter.android",pm)){

                    String link = ""; // here we can add link or anything we want to send
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, link);
                    sendIntent.setType("text/plain");

                    sendIntent.setPackage("com.twitter.android");
                    startActivity(Intent.createChooser(sendIntent,"Share with"));

                } else{
                    Toast.makeText(ReferActivity.this, "Please install app before inviting friends.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}