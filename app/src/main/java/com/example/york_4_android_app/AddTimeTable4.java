package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddTimeTable4 extends AppCompatActivity implements View.OnClickListener{

    Button bt8,bt9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_time_table4 );

        bt8 = (Button) findViewById(R.id.button8);
        bt8.setOnClickListener(this);

        bt9 = (Button) findViewById(R.id.button9);
        bt9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent (AddTimeTable4.this,AddTimeTable5.class);
        startActivity( intent );
    }

}
