package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddTimetable2 extends AppCompatActivity {

    Database myDb1;
    Button bt3, bt4, bt5, bt6, bt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_timetable2 );
        myDb1 = new Database( this );

        bt3 = (Button) findViewById( R.id.btone3 );
        bt4 = (Button) findViewById( R.id.btone4 );
        bt5 = (Button) findViewById( R.id.btone5 );
        bt6 = (Button) findViewById( R.id.btone6 );
        bt7 = (Button) findViewById( R.id.btone7 );

        bt3.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AddTimetable2.this, AddTimetable3.class );
                AddTimetable2.this.startActivity( intent );
            }
        } );

        bt4.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AddTimetable2.this, AddTimetable3.class );
                AddTimetable2.this.startActivity( intent );
            }
        } );

        bt5.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AddTimetable2.this, AddTimetable3.class );
                AddTimetable2.this.startActivity( intent );
            }
        } );

        bt6.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AddTimetable2.this, AddTimetable3.class );
                AddTimetable2.this.startActivity( intent );
            }
        } );

        bt7.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AddTimetable2.this, AddTimetable3.class );
                AddTimetable2.this.startActivity( intent );
            }
        } );

    }
}