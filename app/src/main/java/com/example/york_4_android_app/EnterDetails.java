package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EnterDetails extends AppCompatActivity {
    Database myDb1;
    EditText editId, editName, editGrade;
    RadioGroup radGp;
    RadioButton subject;
    Button BtnAddData;
    Button BtnViewAll;
    Button BtnUpdate;
    Button BtnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        myDb1 = new Database(this);

        editId = (EditText) findViewById(R.id.editTextTextPersonNameID);
        editName = (EditText) findViewById(R.id.editTextTextPersonNameID2);
        editGrade = (EditText) findViewById(R.id.editTextTextPersonNameID3);
        radGp = (RadioGroup) findViewById(R.id.radioGp);
        BtnAddData = (Button) findViewById(R.id.button2);
        BtnViewAll = (Button) findViewById(R.id.button9);
        BtnUpdate = (Button) findViewById(R.id.button3);
        BtnDelete = (Button) findViewById(R.id.button8);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();

        final ImageView nextBtn = (ImageView) findViewById(R.id.imageView3);
        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String id = editId.getText().toString();
                final String name = editName.getText().toString();

                Intent activityIntent = new Intent(EnterDetails.this, UploadHW.class);
                activityIntent.putExtra("editId", id);
                activityIntent.putExtra("editName", name);
                EnterDetails.this.startActivity(activityIntent);

            }
        });

    }

    public void DeleteData (){

        BtnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Integer deletedRows = myDb1.deleteData(editId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(EnterDetails.this, "Data Deleted Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(EnterDetails.this, "Data not Deleted!!", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

    public void UpdateData(){

        BtnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean  isUpdate = myDb1.updateData(editId.getText().toString(), editName.getText().toString(),
                                editGrade.getText().toString(), subject.getText().toString() );
                        if(isUpdate == true)
                            Toast.makeText(EnterDetails.this, "Data Updated Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(EnterDetails.this, "Data not Updated!!", Toast.LENGTH_LONG).show();
                    }
                }
        );


    }

    public void AddData(){
        BtnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int selected_id = radGp.getCheckedRadioButtonId();
                        subject = (RadioButton) findViewById(selected_id);

                        boolean isInserted = myDb1.insertData(editId.getText().toString(), editName.getText().toString(),
                                editGrade.getText().toString(), subject.getText().toString()
                        );
                        if(isInserted == true)
                            Toast.makeText(EnterDetails.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(EnterDetails.this, "Data not Inserted!!", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll(){

        BtnViewAll.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb1.getAllData();
                        if (res.getCount() == 0) {
                            //show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {

                            buffer.append("Student ID:" + res.getString(0) + "\n");
                            buffer.append("Student Name:" + res.getString(1) + "\n");
                            buffer.append("Student Grade:" + res.getString(2) + "\n");
                            buffer.append("Student Subject:" + res.getString(3) + "\n\n");

                        }

                        //show all data
                        showMessage("View Student Data", buffer.toString());
                    }
                }
        );

    }

    public void showMessage (String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setIcon(R.drawable.hogw);
        builder.setMessage(Message);
        builder.show();

    }

}
