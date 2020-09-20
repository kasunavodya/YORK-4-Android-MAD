package com.example.york_4_android_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTimetable3 extends AppCompatActivity {
    Database myDb1;
    EditText editSub , editStart_time , editEnd_time , editVenue , editLecture_name , editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_timetable3 );
        myDb1 = new Database (this);

        editSub = (EditText) findViewById( R.id.editTextTextPersonName);
        editStart_time = (EditText) findViewById( R.id.editTextTextPersonName2);
        editEnd_time = (EditText) findViewById( R.id.editTextTextPersonName3);
        editTextId = (EditText) findViewById( R.id.editTextTextPersonName6);
        editVenue = (EditText) findViewById( R.id.editTextTextPersonName4);
        editLecture_name = (EditText) findViewById( R.id.editTextTextPersonName5);
        btnAddData = (Button) findViewById( R.id.button_add );
        btnviewAll = (Button) findViewById( R.id.button_viewAll );
        btnviewUpdate = (Button ) findViewById( R.id.button_update );
        btnDelete = (Button ) findViewById( R.id.button_delete );
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = myDb1.deleteTimetableData( editTextId.getText().toString() );
                        if(deletedRows > 0 )
                            Toast.makeText( AddTimetable3.this,"Data Delete Succesfully" , Toast.LENGTH_LONG ) .show();
                        else
                            Toast.makeText( AddTimetable3.this,"Data Delete not  Succesfully" , Toast.LENGTH_LONG ) .show();
                    }
                }
        );
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = myDb1.updateTimetableData( editTextId.getText().toString() , editSub.getText().toString() ,
                                editStart_time.getText().toString() ,  editEnd_time.getText().toString() , editVenue.getText().toString() ,
                                editLecture_name.getText().toString() );
                        if (isUpdate == true)
                            Toast.makeText( AddTimetable3.this,"Data Updated Succesfully" , Toast.LENGTH_LONG ) .show();
                        else
                            Toast.makeText( AddTimetable3.this,"Data Update not  Succesfully" , Toast.LENGTH_LONG ) .show();
                    }
                }
        );
    }

    public void AddData () {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted =   myDb1.insertTimetableData( editSub.getText().toString(),
                                editStart_time.getText().toString(),
                                editEnd_time.getText().toString(),
                                editVenue.getText().toString(),
                                editLecture_name.getText().toString());
                        if(isInserted == true)
                            Toast.makeText( AddTimetable3.this,"Data Insert Succesfully" , Toast.LENGTH_LONG ) .show();
                        else
                            Toast.makeText( AddTimetable3.this,"Data Insert is not Succesfully" , Toast.LENGTH_LONG ) .show();
                    }
                }
        );
    }
    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb1.getAllTimetableData();
                        if(res.getCount() == 0 ){
                            //Show detail meaasge
                            showMessage( "Error" , "No data found" );
                            return;
                        }
                        StringBuffer buffer = new StringBuffer(  );
                        while (res.moveToNext()) {
                            buffer.append(  "ID : " +res.getString( 0 ) +"\n");
                            buffer.append(  "sub_name : " +res.getString( 1 ) +"\n");
                            buffer.append(  "start_time : " +res.getString( 2 ) +"\n");
                            buffer.append(  "end_time : " +res.getString( 3 ) +"\n");
                            buffer.append(  "venue : " +res.getString( 4 ) +"\n");
                            buffer.append(  "lecture_name: " +res.getString( 5 ) +"\n\n");

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