package com.example.york_4_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotesUpload extends AppCompatActivity {

    Database mydb1;
    EditText name, grade ;
    Button uploadPDF, delete_btn, view_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_upload);

        name =(EditText) findViewById(R.id.editTextTextPersonName2);
        grade=(EditText) findViewById(R.id.editTextNumber);
        delete_btn = (Button)findViewById(R.id.button6);
        view_btn= (Button)findViewById(R.id.button5);
        uploadPDF=(Button) findViewById(R.id.button7);
        uploadPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NotesView.class);
                startActivity(intent);
            }
        });
        AddData();
        DeleteData();
    }

    public void AddData(){
        uploadPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  boolean isInserted = mydb1.insertToNotes(name.getText().toString(), grade.getText().toString());

                if(isInserted == true)
                    Toast.makeText(NotesUpload.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(NotesUpload.this, "Data not Inserted!!", Toast.LENGTH_LONG).show();


            }
        }
        );
    }

    public void DeleteData (){

        delete_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Integer deletedRows = mydb1.deleteNote(name.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(NotesUpload.this, "Data Deleted Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(NotesUpload.this, "Data not Deleted!!", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(NotesUpload.this,AdminUpload.class);
                        startActivity(intent);
                    }
                }
        );

    }
}