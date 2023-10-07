package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Weight, HeightFt, HeightIn;
        AppCompatButton CalcBtn;
        TextView Result, Bmi;
        LinearLayout llBg;

        Weight = findViewById(R.id.weight);
        HeightFt = findViewById(R.id.HeightFt);
        HeightIn = findViewById(R.id.HeightIn);
        CalcBtn = findViewById(R.id.CalcBtn);
        Result = findViewById(R.id.Result);
        llBg = findViewById(R.id.llBg);
        Bmi = findViewById(R.id.Bmi);

        CalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double wt = Integer.parseInt(Weight.getText().toString());
                double ft = Integer.parseInt(HeightFt.getText().toString());
                double in = Integer.parseInt(HeightIn.getText().toString());

                double totalIn = ft * 12 + in;
                double cm = totalIn * 2.53;
                double m = cm / 100;

                double bmi = wt / (m * m);

                Bmi.setText("BMI: "+ String.format("%.2f",bmi));

                if (bmi > 25) {
                    Result.setText("You're Overweight!!");
                    llBg.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.Over));
                } else if (bmi > 18 && bmi < 25) {
                    Result.setText("You're Healthy!!");
                    llBg.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.Healthy));
                } else {
                    Result.setText("You're Underweight!!");
                    llBg.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.Under));
                }
            }
        }
        );


    }
}