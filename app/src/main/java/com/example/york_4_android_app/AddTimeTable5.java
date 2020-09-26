package com.example.york_4_android_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTimeTable5 extends AppCompatActivity {

    Database myDb1;
    EditText editSub_Name , editStart_Time , editEnd_Time  , editLecture_Name , editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_time_table5 );

        myDb1 = new Database (this);

        editSub_Name = (EditText) findViewById( R.id.Sub_Name);
        editStart_Time = (EditText) findViewById( R.id.Start_Time );
        editEnd_Time = (EditText) findViewById( R.id.End_Time);
        editTextId = (EditText) findViewById( R.id.Sub_ID);
        editLecture_Name = (EditText) findViewById( R.id.Lec_Name);
        btnAddData = (Button) findViewById( R.id.button10 );
        btnviewAll = (Button) findViewById( R.id.button11 );
        btnviewUpdate = (Button ) findViewById( R.id.button13 );
        btnDelete = (Button ) findViewById( R.id.button14 );
        AddData1();
        viewAll();
        UpdateData1();
        DeleteData1();


    }
    public void DeleteData1(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = myDb1.deleteData1( editTextId.getText().toString() );
                        if(deletedRows > 0 )
                            Toast.makeText( AddTimeTable5.this,"Data Delete Succesfully" , Toast.LENGTH_LONG ) .show();
                        else
                            Toast.makeText( AddTimeTable5.this,"Data Delete not  Succesfully" , Toast.LENGTH_LONG ) .show();
                    }
                }
        );
    }

    public void UpdateData1() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = myDb1.updateData1( editTextId.getText().toString() , editSub_Name.getText().toString() ,
                                editStart_Time.getText().toString() ,  editEnd_Time.getText().toString()  ,
                                editLecture_Name.getText().toString() );
                        if (isUpdate == true)
                            Toast.makeText(AddTimeTable5.this,"Data Updated Succesfully" , Toast.LENGTH_LONG ) .show();
                        else
                            Toast.makeText(AddTimeTable5.this,"Data Update not  Succesfully" , Toast.LENGTH_LONG ) .show();
                    }
                }
        );
    }

    public void AddData1 () {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted =   myDb1.insertData1( editSub_Name.getText().toString(),
                                editStart_Time.getText().toString(),
                                editEnd_Time.getText().toString(),
                                editLecture_Name.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(AddTimeTable5.this,"Data Insert Succesfully" , Toast.LENGTH_LONG ) .show();
                        else
                            Toast.makeText( AddTimeTable5.this,"Data Insert is not Succesfully" , Toast.LENGTH_LONG ) .show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb1.getAllData1();
                        if(res.getCount() == 0 ){
                            //Show detail meaasge
                            showMessage( "Error" , "No data found" );
                            return;
                        }
                        StringBuffer buffer = new StringBuffer(  );
                        while (res.moveToNext()) {
                            buffer.append(  "ID : " +res.getString( 0 ) +"\n");
                            buffer.append(  "Sub_Name : " +res.getString( 1 ) +"\n");
                            buffer.append(  "Start_Time : " +res.getString( 2 ) +"\n");
                            buffer.append(  "End_Time : " +res.getString( 3 ) +"\n");
                            buffer.append(  "Lecture_Name : " +res.getString( 4 ) +"\n");


                        }
                        showMessage( "Data" , buffer.toString() );
                    }
                }
        );
    }

    public void showMessage (String title , String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setCancelable( true );
        builder.setTitle( title );
        builder.setMessage( Message );
        builder.show();
    }

}