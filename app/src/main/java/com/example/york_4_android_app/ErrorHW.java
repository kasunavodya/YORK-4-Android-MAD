package com.example.york_4_android_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class ErrorHW extends AppCompatActivity {
    Database myDb1;
    TextInputEditText ErrorText;
    Button submitBtn;
    TextView editId, editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_h_w);
        myDb1 = new Database(this);

        final ImageView previousBtn = (ImageView) findViewById(R.id.imageView3);
        editId = (TextView) findViewById(R.id.textViewID);
        editName = (TextView) findViewById(R.id.textViewStName);
        ErrorText = (TextInputEditText) findViewById(R.id.TextInputType);
        submitBtn = (Button) findViewById(R.id.buttonError);

        final String id = getIntent().getStringExtra("editId");
        final String name = getIntent().getStringExtra("editName");

        editId.setText(id);
        editName.setText(name);
        AddData2();

        previousBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(ErrorHW.this, UploadHW.class);
                ErrorHW.this.startActivity(activityIntent);

            }
        });

    }

    public void AddData2(){
        submitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isInserted = myDb1.insertErrorDetails(editId.getText().toString(), Objects.requireNonNull(ErrorText.getText()).toString());
                        if(isInserted == true)
                            Toast.makeText(ErrorHW.this, "Submit", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(ErrorHW.this, "Not Submit!!", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}