package com.example.york_4_android_app;


import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class activity_admin extends AppCompatActivity {
    Database myDb1;
    TextView ViewAdmin,ViewAdmin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        myDb1 = new Database(this);

        final Button homeworkBtn = (Button) findViewById(R.id.button);
        ViewAdmin = (TextView) findViewById(R.id.studentDetailsShow);
        ViewAdmin1 = (TextView) findViewById(R.id.studentDetailsShow2);
        viewAll();
        viewUploadImage();

        homeworkBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(activity_admin.this, AddTimetable.class);
                activity_admin.this.startActivity(activityIntent);

            }
        });

    }

    public void viewAll(){

        ViewAdmin.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb1.getAllData();
                        if (res.getCount() == 0) {
                            //show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {

                            buffer.append("Student ID:" + res.getString(0) + "\n");
                            buffer.append("Student Name:" + res.getString(1) + "\n");
                            buffer.append("Student Grade:" + res.getString(2) + "\n");
                            buffer.append("Student Subject:" + res.getString(3) + "\n\n");

                        }

                        //show all data
                        showMessage("View Student Data", buffer.toString());
                    }
                }
        );

    }

    public void showMessage (String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setIcon(R.drawable.hogw);
        builder.setMessage(Message);
        builder.show();

    }

    public void viewUploadImage(){

        ViewAdmin1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb1.getImageData();
                        if (res.getCount() == 0) {
                            //show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {

                            buffer.append("ID: " + res.getString(0) + "\n");
                            buffer.append("Title: " + res.getString(1) + "\n");
                            buffer.append("Image: " + res.getBlob(2) + "\n\n");


                        }

                        //show all data
                        showImgMessage("View Homework Data", buffer.toString());
                    }
                }
        );

    }

    public void showImgMessage(String title, String Message){

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setIcon(R.drawable.hogw);
        builder.setMessage(Message);
        builder.show();

    }


}