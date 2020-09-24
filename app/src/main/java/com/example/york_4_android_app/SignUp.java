package com.example.york_4_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    Database mydb1;
    private EditText name, email, password;
    private Button  delete,sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        name = (EditText)findViewById(R.id.editTextTextPersonName3);
        email =(EditText)findViewById(R.id.editTextTextPersonName4);
        password = (EditText)findViewById(R.id.editTextTextPassword);

        delete = (Button) findViewById(R.id.button9);

        sign_up =(Button) findViewById(R.id.button10);
        AddData();
        DeleteData();

    }

    public void AddData(){
        sign_up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(SignUp.this,AdminHome.class);
                        startActivity(intent);

                        boolean isInserted = mydb1.insertDataAdmin(name.getText().toString(),
                                email.getText().toString(), password.getText().toString()
                        );

                        if(isInserted == true)
                            Toast.makeText(SignUp.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SignUp.this, "Data not Inserted!!", Toast.LENGTH_LONG).show();


                    }
                }
        );
    }

    public void DeleteData (){

        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Integer deletedRows = mydb1.deleteDataAdmin(name.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(SignUp.this, "Data Deleted Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SignUp.this, "Data not Deleted!!", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}