package com.example.intentlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    private TextView scoreString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        wireWidgets();
        Intent lastIntent = getIntent();
        Integer score = lastIntent.getIntExtra(TargetActivity.EXTRA_SCORE,0);
        scoreString.setText("Your score is "+score+" out of 10");

    }

    private void wireWidgets() {
        scoreString=findViewById(R.id.textView_score_scoreBoard);

    }
}
