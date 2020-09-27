package com.example.york_4_android_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateTF extends AppCompatActivity {
    Button add, clear;
    TextView answer;
    CheckBox checkBox1, checkBox2, checkBox3;

    int results;
    int x = 30000;
    int y = 2000;
    int z = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_t_f);

        add = findViewById(R.id.btn);
        clear = findViewById(R.id.clearBtn);
        checkBox1 = findViewById(R.id.ChkBx1);
        checkBox2 = findViewById(R.id.chb1);
        checkBox3 = findViewById(R.id.chb2);
        answer = findViewById(R.id.result);
    }

    public void ClickMe(View v) {

        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                if (checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()) {
                    results = x;
                    answer.setText("Rs: " + results);
                }

                else if (checkBox2.isChecked() && !checkBox1.isChecked() && !checkBox3.isChecked()) {
                    results = y;
                    answer.setText("Rs: " + results);
                }

                else if (checkBox3.isChecked() && !checkBox1.isChecked() && !checkBox2.isChecked()) {
                    results = z;
                    answer.setText("Rs: " + results);
                }

                else if (checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked()) {
                    results = x + y;
                    answer.setText("Rs: " + results);
                }

                else if (checkBox1.isChecked() && checkBox3.isChecked() && !checkBox2.isChecked()) {
                    results = x + z;
                    answer.setText("Rs: " + results);
                }

                else if (checkBox2.isChecked() && checkBox3.isChecked() && !checkBox1.isChecked()) {
                    results = y + z;
                    answer.setText("Rs: " + results);
                }

                else if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()) {
                    results = x + y + z;
                    answer.setText("Rs: " + results);
                }

                else {
                    results = 0;
                    answer.setText("Rs: " + results);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                answer.setText("");
            }
        });

    }
}