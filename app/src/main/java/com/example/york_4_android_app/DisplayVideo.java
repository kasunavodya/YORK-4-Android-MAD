package com.example.york_4_android_app;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayVideo extends AppCompatActivity {

    WebView webView;
    TextView name_display, grade_display;
    String str,grd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_video);

        webView = (WebView)findViewById(R.id.webview1);
        webView.loadUrl("https://www.youtube.com/watch?v=4UVozY9dq58");

        name_display = (TextView)findViewById(R.id.nameDisplay);
        grade_display = (TextView)findViewById(R.id.gradeDisplay);

        str = getIntent().getExtras().getString("Values");
        name_display.setText(str);
        grd = getIntent().getExtras().getString("Grade");
        grade_display.setText(grd);
    }
}