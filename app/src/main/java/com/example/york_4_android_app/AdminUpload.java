package com.example.york_4_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminUpload extends AppCompatActivity {

   private Button btn_note, btn_notice, btn_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_upload);

        //Note uploading
        btn_note = (Button) findViewById(R.id.button2);
        btn_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminUpload.this,NotesUpload.class);
                startActivity(intent);
            }
        });

        //Announcement Uploading
     btn_notice = (Button) findViewById(R.id.button3);
        btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminUpload.this,NoticeUpload.class);
                startActivity(intent);
            }
        });


        //Video Uploading
      btn_video =(Button) findViewById(R.id.button4);
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminUpload.this,VideoUploading.class);
                startActivity(intent);
            }
        });
    }
}