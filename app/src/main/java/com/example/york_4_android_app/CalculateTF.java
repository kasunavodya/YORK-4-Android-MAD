package com.example.york_4_android_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateTF extends AppCompatActivity {
    Button add;
    TextView answer;

    CheckBox checkBox1, checkBox2;
    private int RegularFee = 30000;
    private int LibraryFee = 2000;
    private int ShuttleFee = 5000;
    private int Sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_t_f);

        add = findViewById(R.id.btn);
        checkBox1 = findViewById(R.id.chb1);
        checkBox1 = findViewById(R.id.chb2);
        answer = findViewById(R.id.result);
    }

    public void ClickMe(View v) {
        if(checkBox1.isChecked() == true){


            add.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Sum = RegularFee + LibraryFee;
                    answer.setText("Rs. "+ String.valueOf(Sum));
                }
            });
        }

        else if(checkBox1.isChecked() == true) {

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Sum = RegularFee + ShuttleFee;
                    answer.setText("Rs. " + String.valueOf(Sum));
                }
            });
        }

        else if(checkBox1.isChecked() == true && checkBox2.isChecked() == true){

            add.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Sum = RegularFee + LibraryFee + ShuttleFee;
                    answer.setText("Rs. "+ String.valueOf(Sum));
                }
            });
        }
        else {
            answer.setText("Rs. "+ String.valueOf(RegularFee));
        }
    }
}