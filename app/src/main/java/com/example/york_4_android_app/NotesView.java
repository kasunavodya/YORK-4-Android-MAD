package com.example.york_4_android_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class NotesView extends AppCompatActivity {

  PDFView pdfView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);
        pdfView =(PDFView)findViewById(R.id.pdfviewer);
        pdfView.fromAsset("grade9.pdf").load();


    }


}