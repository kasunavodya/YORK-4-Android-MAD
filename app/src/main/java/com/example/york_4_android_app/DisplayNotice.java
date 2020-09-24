package com.example.york_4_android_app;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayNotice extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_notice);

        imageView = (ImageView)findViewById(R.id.imageViewDisplayed);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int resId = bundle.getInt("resId");
            imageView.setImageResource(resId);
        }
    }
}