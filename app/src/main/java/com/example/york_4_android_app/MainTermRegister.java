package com.example.york_4_android_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.google.android.material.textfield.TextInputEditText;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTermRegister extends AppCompatActivity {
    public static final int CAMERA_PERMISSION_CODE = 101;
    public static final int CAMERA_REQUEST = 102;
    Database myDb1;
    Button RegBtnAddData, ResetBtn;
    ImageButton camera;
    TextInputEditText name, id;
    TextView UploadHereBtn;
    private String Sid;
    String currentPhotoPath;
    private String nameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_term_register);

        myDb1 = new Database(this);
        final TextView LinkBtn = (TextView) findViewById(R.id.txtV3);
        final TextView LinkBtn1 = (TextView) findViewById(R.id.txtV8);
        RegBtnAddData = (Button) findViewById(R.id.button3);
        ResetBtn = findViewById(R.id.button);
        camera = (ImageButton)findViewById(R.id.cameraBtn);
        name = (TextInputEditText) findViewById(R.id.nameTxt);
        id = (TextInputEditText) findViewById(R.id.Sid);

        //take a picture from camera
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermission();
                Toast.makeText(MainTermRegister.this, "Take a picture", Toast.LENGTH_SHORT).show();
            }
        });
        AddRegData();

        LinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(MainTermRegister.this, CalculateTF.class);
                MainTermRegister.this.startActivity(activityIntent);

            }
        });

        LinkBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(MainTermRegister.this, AddSlip.class);
                MainTermRegister.this.startActivity(activityIntent);

            }
        });

        ResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                id.setText("");

            }
        });

    }

    private void askPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
        }else{
            dispatchTakePictureIntent();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                dispatchTakePictureIntent();
            }else{
                Toast.makeText(MainTermRegister.this,"Camera Permission is required!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void AddRegData(){
        RegBtnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isInserted = myDb1.insertRegData(id.getText().toString(), name.getText().toString()
                        );
                        if(isInserted == true)
                            Toast.makeText(MainTermRegister.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainTermRegister.this, "Registered UnSuccessfully", Toast.LENGTH_LONG).show();
                    }
                }
        );
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
                startActivityForResult(takePictureIntent,CAMERA_REQUEST);
            }
        }
    }

    private void displayForSid(String i) {
        displayForNameTxt(nameTxt);
    }
    private void displayForNameTxt(String i) {
        displayForNameTxt(Sid);
    }
}
