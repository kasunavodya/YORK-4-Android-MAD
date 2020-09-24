package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewStudentDetails extends AppCompatActivity {
    Database myDb1;
    TextView editId, editName, editGrade, subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_details);

        myDb1 = new Database(this);

        editId = (TextView) findViewById(R.id.textViewIDLabel);
        editName = (TextView) findViewById(R.id.textViewIDLabel2);
        editGrade = (TextView) findViewById(R.id.textViewIDLabel3);
        subject = (TextView) findViewById(R.id.textViewIDLabel4);

        final String id = getIntent().getStringExtra("editId");
        final String name = getIntent().getStringExtra("editName");
        final String grade = getIntent().getStringExtra("editGrade");
        final String sub = getIntent().getStringExtra("subject");

        editId.setText(id);
        editName.setText(name);
        editGrade.setText(grade);
        subject.setText(sub);

    }

}