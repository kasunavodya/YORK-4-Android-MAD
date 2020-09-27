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

public class AddSlip extends AppCompatActivity {
    Database myDb1;
    ImageView imageView;
    Integer REQUEST_CAMERA = 1, SELECT_FILE = 0;
    Button UploadBtn1, DeleteBtn1;
    TextView editId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_slip);
        myDb1 = new Database(this);

        imageView = (ImageView) findViewById(R.id.imageView);
        editId = (TextView) findViewById(R.id.textViewID);
        UploadBtn1 = (Button) findViewById(R.id.buttonslip);
        DeleteBtn1 = (Button) findViewById(R.id.buttondelete);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        AddDataSlip();
        DeleteImgDataSlip();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage1();
            }
        });

    }

    private void SelectImage1(){
        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(AddSlip.this);
        builder.setTitle("Add Slip");
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

    public void AddDataSlip(){
        UploadBtn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isInserted = myDb1.insertDetailsSlip(editId.getText().toString(), imageView);
                        if (isInserted == true)
                            Toast.makeText(AddSlip.this, "Uploaded Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddSlip.this, "Uploaded not successfully!!", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteImgDataSlip(){

        DeleteBtn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Integer deletedRows = myDb1.deleteSlipImgData(editId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(AddSlip.this, "Data Deleted Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddSlip.this, "Data not Deleted!!", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

}