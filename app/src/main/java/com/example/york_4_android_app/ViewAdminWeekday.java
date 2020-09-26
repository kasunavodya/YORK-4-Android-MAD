package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewAdminWeekday extends AppCompatActivity {
    Database myDb1;
    TextView editSub , editStart_time , editEnd_time , editVenue , editLecture_name , editTextId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_admin_weekday);
        myDb1 = new Database(this);

        editSub = (TextView) findViewById( R.id.textViewIDLabel);
        editStart_time = (TextView) findViewById( R.id.textViewNameLabel);
        editEnd_time = (TextView) findViewById( R.id.textViewTitleLabel);
        editTextId = (TextView) findViewById( R.id.textViewImageLabel);
        editVenue = (TextView) findViewById( R.id.textViewImageLabel2);
        editLecture_name = (TextView) findViewById( R.id.textViewImageLabel3);

        final String sub = getIntent().getStringExtra("editSub");
        final String start = getIntent().getStringExtra("editStart_time");
        final String end = getIntent().getStringExtra("editEnd_time");
        final String id = getIntent().getStringExtra("editTextId");
        final String venue = getIntent().getStringExtra("editVenue");
        final String lec = getIntent().getStringExtra("editLecture_name");

        editSub.setText(sub);
        editStart_time.setText(start);
        editEnd_time.setText(end);
        editTextId.setText(id);
        editVenue.setText(venue);
        editLecture_name.setText(lec);

    }

}