package com.example.intentlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class TargetActivity extends AppCompatActivity {
    public TextView message;
    public TextView questionNumber;
    public TextView question;
    public Button option1;
    public Button option2;
    public Button option3;
    public Button option4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        wireWidgets();

        //receive intent
        Intent lastIntent = getIntent();
        //open extras
        String username = lastIntent.getStringExtra(MainActivity.EXTRA_USERNAME);
        String password = lastIntent.getStringExtra(MainActivity.EXTRA_PASSWORD);
        //set the text view to username
        //nullcheck is good
        message.setText("Welcome " + username + " with password [REDACTED]. Login is complete/r The test will begin shortly");

        message.setText("Good Luck");
    }
    private void delay(int i) {
        try {Thread.sleep(i);}
        catch (InterruptedException e)
        {e.printStackTrace();}
    }

    private void wireWidgets() {

        message = findViewById(R.id.textView_target_messageInitial);
        question = findViewById(R.id.textView_target_question);
        questionNumber = findViewById(R.id.textView_target_questionNumber);
        option1 = findViewById(R.id.button_target_option1);
        option2 = findViewById(R.id.button_target_option2);
        option3 = findViewById(R.id.button_target_option3);
        option4 = findViewById(R.id.button_target_option4);
    }
    // create a gson object
    Gson gson = new Gson();
    // read your json file into an array of questions
    Question[] questions =  gson.fromJson(jsonString, Question[].class);
    // convert your array to a list using the Arrays utility class
    List<Question> questionList = Arrays.asList(questions);
    // verify that it read everything properly
    Log.d(TAG, "onCreate: " + questionList.toString());

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_target_option1: {

            }
            break;
        }
        switch(view.getId()) {
            case R.id.button_target_option2 : {

            }
            break;
        }
        switch(view.getId()) {
            case R.id.button_target_option3: {

            }
            break;
        }
        switch(view.getId()) {
            case R.id.button_target_option4: {

            }
            break;
        }
    }

}
