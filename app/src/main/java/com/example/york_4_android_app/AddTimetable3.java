package com.example.york_4_android_app;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddTimetable3 extends AppCompatActivity {
    Database myDb1;
    TextView editSub , editStart_time , editEnd_time , editVenue , editLecture_name , editTextId;
    Button btnAddData;
    Button btnviewUpdate;
    Button View;
    Button btnDelete;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_timetable3 );
        myDb1 = new Database (this);

        editSub = (TextView) findViewById( R.id.editTextTextPersonName);
        editStart_time = (TextView) findViewById( R.id.editTextTextPersonName2);
        editEnd_time = (TextView) findViewById( R.id.editTextTextPersonName3);
        editTextId = (TextView) findViewById( R.id.editTextTextPersonName6);
        editVenue = (TextView) findViewById( R.id.editTextTextPersonName4);
        editLecture_name = (TextView) findViewById( R.id.editTextTextPersonName5);
        btnAddData = (Button) findViewById( R.id.button_add );
        View = (Button) findViewById( R.id.button_viewAll );
        btnviewUpdate = (Button ) findViewById( R.id.button_update );
        btnDelete = (Button ) findViewById( R.id.button_delete );
        AddData();
        UpdateData();
        DeleteData();

        View.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String sub = editSub.getText().toString();
                final String start = editStart_time.getText().toString();
                final String end = editEnd_time.getText().toString();
                final String id = editTextId.getText().toString();
                final String venue = editVenue.getText().toString();
                final String lec = editLecture_name.getText().toString();

                Intent activityIntent = new Intent(AddTimetable3.this, ViewAdminWeekday.class);
                activityIntent.putExtra("editSub", sub);
                activityIntent.putExtra("editStart_time", start);
                activityIntent.putExtra("editEnd_time", end);
                activityIntent.putExtra("editTextId", id);
                activityIntent.putExtra("editVenue", venue);
                activityIntent.putExtra("editLecture_name", lec);
                AddTimetable3.this.startActivity(activityIntent);

            }
        });

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

}
