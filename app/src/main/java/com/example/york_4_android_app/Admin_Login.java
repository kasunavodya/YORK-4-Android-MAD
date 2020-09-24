package com.example.york_4_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_Login extends AppCompatActivity {


    private Button Login;
    private  Button Sign_up;
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        email = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText)findViewById(R.id.editTextTextPassword2);
        Login =(Button) findViewById(R.id.button);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().length()== 0){
                        email.setError("Email is required!");
                }

                Intent intent = new Intent(Admin_Login.this,activity_admin.class);
                startActivity(intent);

                Toast.makeText(Admin_Login.this,"You have Successfully Logged in!",Toast.LENGTH_SHORT).show();
            }
        });

        Sign_up = (Button)findViewById(R.id.button11);
        Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Login.this,SignUp.class);
                startActivity(intent);
            }
        });

    }
}