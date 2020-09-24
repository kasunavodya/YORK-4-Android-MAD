package com.example.york_4_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VideoUploading extends AppCompatActivity {
    Database mydb1;
    private Button btnUpload,btnView,btnDelete;
    private EditText name,grade;
    String str1;
        Integer grd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_uploading);

        name = (EditText)findViewById(R.id.lectureName);
        grade = (EditText)findViewById(R.id.grade);
        btnView = (Button)findViewById(R.id.btnView);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnUpload = (Button)findViewById(R.id.btnUpload);

        AddData();
        DeleteData();


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnUpload) {
                    Intent intent = new Intent(VideoUploading.this, DisplayVideo.class);
                    str1 = name.getText().toString();
                    grd = Integer.parseInt(grade.getText().toString());
                    intent.putExtra("Values", str1);
                    intent.putExtra("Grade", grd);

                    startActivity(intent);
                    finish();
                }
            }

        });
    }


    public void AddData(){
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoUploading.this,DisplayVideo.class);
                startActivity(intent);
                boolean isInserted = mydb1.insertToNotes(name.getText().toString(), grade.getText().toString());
                if(isInserted == true)
                    Toast.makeText(VideoUploading.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(VideoUploading.this, "Data not Inserted!!", Toast.LENGTH_LONG).show();
            }
        }
        );
    }

    public void DeleteData (){

        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = mydb1.deleteNote(name.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(VideoUploading.this, "Data Deleted Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(VideoUploading.this, "Data not Deleted!!", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}