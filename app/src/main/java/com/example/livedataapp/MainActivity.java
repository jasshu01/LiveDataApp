package com.example.livedataapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView score;
    Button plus, minus;

    private MyScoreModel myScoreModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = findViewById(R.id.score);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);


        myScoreModel = new ViewModelProvider(this).get(MyScoreModel.class);

        myScoreModel.myScore.observe(this, new Observer<Integer>() {

            @Override
            public void onChanged(Integer integer) {

                if (integer % 5 == 0) {
                    Toast.makeText(MainActivity.this, "Score Reached multiple of 5", Toast.LENGTH_SHORT).show();
                }

                score.setText(String.valueOf(integer));
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myScoreModel.IncrementScore();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myScoreModel.DeccrementScore();
            }
        });


    }


}