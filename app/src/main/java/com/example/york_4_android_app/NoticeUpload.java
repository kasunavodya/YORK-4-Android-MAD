package com.example.york_4_android_app;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeUpload extends AppCompatActivity {

    public static final int CAMERA_REQUEST_CODE = 102;
    private ImageView imageView;
    private Button camera , gallery,sendImage;
    public static final int CAMERA_PERM_CODE = 101;
    String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_upload);

        imageView = (ImageView) findViewById(R.id.displayImageView);
        camera = (Button) findViewById(R.id.cameraBtn);
        gallery = (Button) findViewById(R.id.galleryBtn);
        sendImage = (Button) findViewById(R.id.sendImagebtn);

        //send an image to display image page
        sendImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoticeUpload.this,DisplayNotice.class);
                intent.putExtra("resId",R.id.imageView);
                startActivity(intent);
            }
        });

        //take picture from camera
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                askPermission();
                Toast.makeText(NoticeUpload.this,"Take a picture",Toast.LENGTH_SHORT).show();

            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NoticeUpload.this,"Pick an image from gallery",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void askPermission() {

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA},CAMERA_PERM_CODE);
        }
        else{
            dispatchTakePictureIntent();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      if(requestCode == CAMERA_PERM_CODE){
          if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
              dispatchTakePictureIntent();
          }else{
              Toast.makeText(NoticeUpload.this,"Camera Permission is required!",Toast.LENGTH_SHORT).show();
          }
      }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
          if(requestCode == Activity.RESULT_OK){
              File f = new File(currentPhotoPath);
              imageView.setImageURI(Uri.fromFile(f));
          }

        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }



    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent,CAMERA_REQUEST_CODE );
            }
        }
    }


}