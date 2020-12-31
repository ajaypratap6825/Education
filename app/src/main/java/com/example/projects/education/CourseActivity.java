package com.example.projects.education;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Vector;

public class CourseActivity extends AppCompatActivity  {
    Toolbar toolbar;
    WebView video;
    Button play1, play2, play3, play4, play5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        toolbar = findViewById(R.id.toolbar);
        video = findViewById(R.id.video);
        play1 = findViewById(R.id.play1);
        play2 = findViewById(R.id.play2);
        play3 = findViewById(R.id.play3);
        play4 = findViewById(R.id.play4);
        play5 = findViewById(R.id.play5);

        video.getSettings().setJavaScriptEnabled(true);
        video.setWebChromeClient(new WebChromeClient() {});
        Vector<Videos> youtubeVideos = new Vector<>();

        setSupportActionBar(toolbar);
        toolbar.setTitle("Courses");
        toolbar.setBackgroundColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        youtubeVideos.add( new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" + ".youtube.com/embed/r59xYe3Vyks\" frameborder=\"0\" allowfullscreen></iframe>","1") );
        youtubeVideos.add( new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" + ".youtube.com/embed/gzlhm0jco0g\" frameborder=\"0\" allowfullscreen></iframe>","2") );
        youtubeVideos.add( new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" + ".youtube.com/embed/U8wrZRYAnmI\" frameborder=\"0\" allowfullscreen></iframe>","3") );
        youtubeVideos.add( new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" + ".youtube.com/embed/4ekASokneGU\" frameborder=\"0\" allowfullscreen></iframe>","4") );
        youtubeVideos.add( new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" + ".youtube.com/embed/qgMH6jOOFOE\" frameborder=\"0\" allowfullscreen></iframe>","5") );

        video.loadData(youtubeVideos.get(0).getUrl(),"text/html" , "utf-8");

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.loadData(youtubeVideos.get(0).getUrl(),"text/html" , "utf-8");
            }
        });

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.loadData(youtubeVideos.get(1).getUrl(),"text/html" , "utf-8");

            }
        });

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.loadData(youtubeVideos.get(2).getUrl(),"text/html" , "utf-8");

            }
        });

        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.loadData(youtubeVideos.get(3).getUrl(),"text/html" , "utf-8");

            }
        });

        play5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.loadData(youtubeVideos.get(4).getUrl(),"text/html" , "utf-8");

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
}