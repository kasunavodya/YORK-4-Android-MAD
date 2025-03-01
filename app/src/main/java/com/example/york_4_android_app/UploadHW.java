package com.example.york_4_android_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class UploadHW extends AppCompatActivity {
    Database myDb1;
    ImageView imageView;
    Integer REQUEST_CAMERA = 1, SELECT_FILE = 0;
    TextInputEditText Title;
    Button UploadBtn, ViewBtn, DeleteBtn, UpdateBtn;
    TextView editId, editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_h_w);
        myDb1 = new Database(this);

        imageView = (ImageView) findViewById(R.id.imageView);
        editId = (TextView) findViewById(R.id.textViewID);
        editName = (TextView) findViewById(R.id.textViewStName);
        Title = (TextInputEditText) findViewById(R.id.autoCompleteTextView);
        UploadBtn = (Button) findViewById(R.id.buttonHW2);
        DeleteBtn = (Button) findViewById(R.id.button8);
        UpdateBtn = (Button) findViewById(R.id.button3);
        ViewBtn = (Button) findViewById(R.id.buttonHW);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        final String id = getIntent().getStringExtra("editId");
        final String name = getIntent().getStringExtra("editName");

        editId.setText(id);
        editName.setText(name);
        AddData1();
        UpdateData();
        DeleteImgData();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });

        final ImageView previousBtn = (ImageView) findViewById(R.id.imageView3);
        previousBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(UploadHW.this, EnterDetails.class);
                UploadHW.this.startActivity(activityIntent);

            }
        });

        final TextView nextBtn = (TextView) findViewById(R.id.textVw1);
        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String id = editId.getText().toString();
                final String name = editName.getText().toString();

                Intent activityIntent = new Intent(UploadHW.this, ErrorHW.class);
                activityIntent.putExtra("editId", id);
                activityIntent.putExtra("editName", name);
                UploadHW.this.startActivity(activityIntent);

            }
        });

        ViewBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String id = editId.getText().toString();
                final String name = editName.getText().toString();
                final String title = Title.getText().toString();

                Intent activityIntent = new Intent(UploadHW.this, ViewUploadDetails.class);
                activityIntent.putExtra("editId", id);
                activityIntent.putExtra("editName", name);
                activityIntent.putExtra("Title", title);
                UploadHW.this.startActivity(activityIntent);

            }
        });

    }

    private void SelectImage(){
        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(UploadHW.this);
        builder.setTitle("Add Homework Image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);

                }else if(items[i].equals("Gallery")){

                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, "Select File"), SELECT_FILE);

                }else if (items[i].equals("Cancel")){
                    dialogInterface.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode== Activity.RESULT_OK){

            if(requestCode==REQUEST_CAMERA){

                Bundle bundle = data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                imageView.setImageBitmap(bmp);

            }else if(requestCode==SELECT_FILE){

                Uri selectedImageUri = data.getData();
                imageView.setImageURI(selectedImageUri);

            }
        }

    }

    public void AddData1(){
        UploadBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (Title.getText().toString().length() == 0) {
                            Title.setError("Title is required!");

                        } else {

                            boolean isInserted = myDb1.insertDetails(editId.getText().toString(), Title.getText().toString(), imageView);
                            if (isInserted == true)
                                Toast.makeText(UploadHW.this, "Uploaded Successfully", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(UploadHW.this, "Uploaded not successfully!!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void DeleteImgData(){

        DeleteBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Integer deletedRows = myDb1.deleteImgData(editId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(UploadHW.this, "Image Data Deleted Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(UploadHW.this, "Image Data not Deleted!!", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

    public void UpdateData(){

        UpdateBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean  isUpdate = myDb1.updateImgData(editId.getText().toString(), Title.getText().toString(),
                                imageView);
                        if(isUpdate == true)
                            Toast.makeText(UploadHW.this, "Data Updated Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(UploadHW.this, "Data not Updated!!", Toast.LENGTH_LONG).show();
                    }
                }
        );


    }

}