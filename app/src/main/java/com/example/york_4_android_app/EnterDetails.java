package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class EnterDetails extends AppCompatActivity {
    Database myDb1;
    TextInputEditText editId, editName, editGrade;
    RadioGroup radGp;
    RadioButton subject;
    Button BtnAddData;
    Button BtnView;
    Button BtnUpdate;
    Button BtnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        myDb1 = new Database(this);

        editId = (TextInputEditText) findViewById(R.id.editTextTextPersonNameID);
        editName = (TextInputEditText) findViewById(R.id.editTextTextPersonNameID2);
        editGrade = (TextInputEditText) findViewById(R.id.editTextTextPersonNameID3);
        radGp = (RadioGroup) findViewById(R.id.radioGp);
        BtnAddData = (Button) findViewById(R.id.button2);
        BtnView = (Button) findViewById(R.id.button9);
        BtnUpdate = (Button) findViewById(R.id.button3);
        BtnDelete = (Button) findViewById(R.id.button8);
        AddData();
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

        BtnView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String id = editId.getText().toString();
                final String name = editName.getText().toString();
                final String grade = editGrade.getText().toString();
                final String sub = subject.getText().toString();

                Intent activityIntent = new Intent(EnterDetails.this, ViewStudentDetails.class);
                activityIntent.putExtra("editId", id);
                activityIntent.putExtra("editName", name);
                activityIntent.putExtra("editGrade", grade);
                activityIntent.putExtra("subject", sub);
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

                        if (editId.getText().toString().length() == 0) {
                            editId.setError("ID is required!") ;

                            editName.getText().toString().length();
                            editName.setError("Name is required!");

                            editGrade.getText().toString().length();
                            editGrade.setError("Grade is required!");

                        }else{

                            int selected_id = radGp.getCheckedRadioButtonId();
                            subject = (RadioButton) findViewById(selected_id);

                            boolean isInserted = myDb1.insertData(editId.getText().toString(), editName.getText().toString(),
                                    editGrade.getText().toString(), subject.getText().toString()

                            );
                            if (isInserted == true)
                                Toast.makeText(EnterDetails.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(EnterDetails.this, "Data not Inserted!!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

}