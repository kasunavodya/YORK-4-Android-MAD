package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Database myDb1;

    private static ImageView imgView;
    private static TextView link;

    private int current_image_index;
    int[] images = {R.drawable.h5,R.drawable.h2,R.drawable.qq};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb1 = new Database(this);
        LinkClick();

        final FloatingActionButton nextBtn = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(MainActivity.this, EnterDetails.class);
                MainActivity.this.startActivity(activityIntent);

            }
        });
    }

    public void LinkClick(){
        imgView = (ImageView) findViewById(R.id.imageView2);
        link = (TextView) findViewById(R.id.textVw1);
        link.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        current_image_index++;
                        current_image_index = current_image_index % images.length;
                        imgView.setImageResource(images[current_image_index]);
                    }
                }
        );
    }

}
