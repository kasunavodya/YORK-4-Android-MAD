package com.example.york_4_android_app;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class activity_student extends AppCompatActivity {
    Database myDb1;
    TextView btnviewAll, stuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        myDb1 = new Database(this);
        btnviewAll = (TextView) findViewById( R.id.admDetailsShow );
        stuView = (TextView) findViewById( R.id.admDetailsShow2 );
        viewAll();
        viewStuAll();

        final Button homeworkBtn = (Button) findViewById(R.id.btn2);
        homeworkBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(activity_student.this, MainActivity.class);
                activity_student.this.startActivity(activityIntent);

            }
        });

        final Button RegisterBtn = (Button) findViewById(R.id.btn1);
        RegisterBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(activity_student.this, MainTermRegister.class);
                activity_student.this.startActivity(activityIntent);

            }
        });

    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb1.getAllTimetableData();
                        if(res.getCount() == 0 ){
                            //Show detail meaasge
                            showMessage( "Error" , "No data found" );
                            return;
                        }
                        StringBuffer buffer = new StringBuffer(  );
                        while (res.moveToNext()) {
                            buffer.append(  "ID : " +res.getString( 0 ) +"\n");
                            buffer.append(  "sub_name : " +res.getString( 1 ) +"\n");
                            buffer.append(  "start_time : " +res.getString( 2 ) +"\n");
                            buffer.append(  "end_time : " +res.getString( 3 ) +"\n");
                            buffer.append(  "venue : " +res.getString( 4 ) +"\n");
                            buffer.append(  "lecture_name: " +res.getString( 5 ) +"\n\n");

                        }
                        showMessage( "Weekday Timetable" , buffer.toString() );
                    }
                }
        );
    }
    public void showMessage (String title , String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setCancelable( true );
        builder.setTitle( title );
        builder.setMessage( Message );
        builder.show();
    }

    public void viewStuAll() {
        stuView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb1.getAllData1();
                        if(res.getCount() == 0 ){
                            //Show detail meaasge
                            showMessage( "Error" , "No data found" );
                            return;
                        }
                        StringBuffer buffer = new StringBuffer(  );
                        while (res.moveToNext()) {
                            buffer.append(  "ID : " +res.getString( 0 ) +"\n");
                            buffer.append(  "Sub_Name : " +res.getString( 1 ) +"\n");
                            buffer.append(  "Start_Time : " +res.getString( 2 ) +"\n");
                            buffer.append(  "End_Time : " +res.getString( 3 ) +"\n");
                            buffer.append(  "Lecture_Name : " +res.getString( 4 ) +"\n\n");

                        }
                        showStuMessage( "Weekend Timetable" , buffer.toString() );
                    }
                }
        );
    }

    public void showStuMessage (String title , String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setCancelable( true );
        builder.setTitle( title );
        builder.setMessage( Message );
        builder.show();
    }

}