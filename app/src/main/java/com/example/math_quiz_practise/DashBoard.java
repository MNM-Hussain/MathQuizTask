package com.example.math_quiz_practise;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashBoard extends AppCompatActivity {

    private Button AddBtn, SubBtn, MulBtn, DivBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //Setting the Dashboard Buttons
       AddBtn = findViewById(R.id.button);
       SubBtn = findViewById(R.id.button2);
       MulBtn = findViewById(R.id.button3);
       DivBtn = findViewById(R.id.button4);

       //to navigate to Addition Quiz
       AddBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(DashBoard.this, MainAddition.class);
               startActivity(intent);
           }
       });

       //to navigate Subtraction Quiz
        SubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoard.this,MainSubtraction.class);
                startActivity(intent);
            }
        });

        //navigate to Multiplication Quiz
        MulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DashBoard.this,MainMultiplication.class);
                startActivity(intent);
            }
        });

        //navigate to Division Quiz
        DivBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoard.this,MainDivision.class);
                startActivity(intent);
            }
        });
    }
}