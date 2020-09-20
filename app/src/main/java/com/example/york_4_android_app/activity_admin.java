package com.example.york_4_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class activity_admin extends AppCompatActivity {
    Database myDb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        myDb1 = new Database(this);

        final Button homeworkBtn = (Button) findViewById(R.id.button);
        homeworkBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(activity_admin.this, AddTimetable.class);
                activity_admin.this.startActivity(activityIntent);

            }
        });

    }
}