package com.example.nosmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ranking extends AppCompatActivity {

    TextView tv_score;
    Button b_add, b_end;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);

        tv_score = findViewById(R.id.tv_score);
        b_add = findViewById(R.id.b_add);
        b_end = findViewById(R.id.b_end);

        tv_score.setText("SCORE: " + score);

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                tv_score.setText("SCORE: " + score);
            }
        });

        b_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("Last Score", score);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(),BestRanking.class);
                startActivity(intent);
                finish();

            }
        });
    }
}