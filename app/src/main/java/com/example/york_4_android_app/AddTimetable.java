package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddTimetable extends AppCompatActivity {

    Database myDb1;
    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_timetable );
        myDb1 = new Database( this );

        bt1 = (Button) findViewById( R.id.btone );
        bt2 = (Button) findViewById( R.id.btone2 );

        bt1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AddTimetable.this, AddTimetable2.class );
                AddTimetable.this.startActivity( intent );

            }

        } );

        bt2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent( AddTimetable.this, AddTimetable3.class );
                AddTimetable.this.startActivity( intent1 );
            }


        } );

    }
}