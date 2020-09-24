package com.example.york_4_android_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {
    Database myDb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        myDb1 = new Database(this);

        final Button StuBtn = (Button) findViewById(R.id.btn2);
        StuBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence message = "Welcome to Student panel";
                //Display string
                int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

                Intent activityIntent = new Intent(HomePage.this, activity_student.class);
                HomePage.this.startActivity(activityIntent);

            }
        });

        final Button AdminBtn = (Button) findViewById(R.id.btn);
        AdminBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence message = "Welcome to Admin panel";
                //Display string
                int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

                Intent activityIntent = new Intent(HomePage.this, Admin_Login.class);
                HomePage.this.startActivity(activityIntent);

            }
        });

    }
}