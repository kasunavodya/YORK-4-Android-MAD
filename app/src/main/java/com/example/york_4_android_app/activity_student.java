package com.example.york_4_android_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_student extends AppCompatActivity {
    Database myDb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        myDb1 = new Database(this);

        final Button homeworkBtn = (Button) findViewById(R.id.btn2);
        homeworkBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(activity_student.this, MainActivity.class);
                activity_student.this.startActivity(activityIntent);

            }
        });

        final Button RegBtn = (Button) findViewById(R.id.btn1);
        RegBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(activity_student.this, MainTermRegister.class);
                activity_student.this.startActivity(activityIntent);

            }
        });

    }

}