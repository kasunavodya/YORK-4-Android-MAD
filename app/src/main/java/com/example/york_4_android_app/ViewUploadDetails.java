package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class ViewUploadDetails extends AppCompatActivity {
    Database myDb1;
    TextView editId, editName, Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_upload_details);

        myDb1 = new Database(this);

        editId = (TextView) findViewById(R.id.textViewIDLabel);
        editName = (TextView) findViewById(R.id.textViewIDLabel2);
        Title = (TextView) findViewById(R.id.textViewIDLabel3);
        //image = (TextView) findViewById(R.id.textViewIDLabel4);

        final String id = getIntent().getStringExtra("editId");
        final String name = getIntent().getStringExtra("editName");
        final String title = getIntent().getStringExtra("Title");
        //final String image = getIntent().getStringExtra("radioGp");

        editId.setText(id);
        editName.setText(name);
        Title.setText(title);
        //image.setText(image);


    }
}