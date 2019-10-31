package com.example.intentlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class TargetActivity extends AppCompatActivity implements View.OnClickListener{
    public TextView message;
    public TextView questionNumber;
    public TextView question;
    public Button buttonOption1;
    public Button buttonOption2;
    public Button buttonOption3;
    public Button buttonOption4;
    private int score;
    public Quiz quiz;
    public static final String TAG = "TargetActivity";
    public static final String EXTRA_SCORE="score";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        wireWidgets();
        setListeners();
        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.question);
        String jsonString = readTextFile(XmlFileInputStream);
        Log.d(TAG, "onCreate: " + jsonString);

        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Question[] questions =  gson.fromJson(jsonString, Question[].class);
        // convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
        quiz = new Quiz(questionList);
        // verify that it read everything properly
        //receive intent
        Intent lastIntent = getIntent();
        //open extras
        String username = lastIntent.getStringExtra(MainActivity.EXTRA_USERNAME);
        //set the text view to username
        //nullcheck is good

        question.setVisibility(View.VISIBLE);
        questionNumber.setVisibility(View.VISIBLE);
        refreshDisplay();


    }

    private void setListeners() {
        buttonOption1.setOnClickListener(this);
        buttonOption2.setOnClickListener(this);
        buttonOption3.setOnClickListener(this);
        buttonOption4.setOnClickListener(this);
    }

    public void refreshDisplay() {
        if (quiz.getProblemNumber() >= quiz.questionAmount()){
            Intent scoreIntent = new Intent(TargetActivity.this, Score.class);
            scoreIntent.putExtra(EXTRA_SCORE,score);
            startActivity(scoreIntent);
            fileList();
        }
        buttonOption1.setVisibility(View.GONE);
        buttonOption2.setVisibility(View.GONE);
        buttonOption3.setVisibility(View.GONE);
        buttonOption4.setVisibility(View.GONE);
        question.setText(quiz.getQuestionString());
        questionNumber.setText(""+(quiz.getProblemNumber()+1)+"");
        if (quiz.isTrueFalse()){
            buttonOption1.setText("True");
            buttonOption2.setText("False");
            buttonOption1.setVisibility(View.VISIBLE);
            buttonOption2.setVisibility(View.VISIBLE);
        }
        else {
            buttonOption1.setText(quiz.getOption1());
            buttonOption2.setText(quiz.getOption2());
            buttonOption3.setText(quiz.getOption3());
            buttonOption4.setText(quiz.getOption4());
            buttonOption1.setVisibility(View.VISIBLE);
            buttonOption2.setVisibility(View.VISIBLE);
            buttonOption3.setVisibility(View.VISIBLE);
            buttonOption4.setVisibility(View.VISIBLE);
        }
    }

    private void delay(int i) {
        try {Thread.sleep(i);}
        catch (InterruptedException e)
        {e.printStackTrace();}
    }
    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }

    private void wireWidgets() {

        question = findViewById(R.id.textView_target_question);
        questionNumber = findViewById(R.id.textView_target_questionNumber);
        buttonOption1 = findViewById(R.id.button_target_option1);
        buttonOption2 = findViewById(R.id.button_target_option2);
        buttonOption3 = findViewById(R.id.button_target_option3);
        buttonOption4 = findViewById(R.id.button_target_option4);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_target_option1: {
                if (quiz.isCorrect(quiz.getOption1())){
                    score++;
                    Toast.makeText(this,"correct",Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(this,"incorrect",Toast.LENGTH_SHORT);

                }
                quiz.nextQuestion();
                refreshDisplay();
            }
            break;
            case R.id.button_target_option2: {
                if (quiz.isCorrect(quiz.getOption2())){
                    score++;
                    Toast.makeText(this,"correct",Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(this,"incorrect",Toast.LENGTH_SHORT);

                }
                quiz.nextQuestion();
                refreshDisplay();
            }
            break;
            case R.id.button_target_option3: {
                if (quiz.isCorrect(quiz.getOption3())){
                    score++;
                    Toast.makeText(this,"correct",Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(this,"incorrect",Toast.LENGTH_SHORT);

                }
                quiz.nextQuestion();
                refreshDisplay();
            }
            break;
            case R.id.button_target_option4: {
                if (quiz.isCorrect(quiz.getOption4())){
                    score++;
                    Toast.makeText(this,"correct",Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(this,"incorrect",Toast.LENGTH_SHORT);

                }
                quiz.nextQuestion();
                refreshDisplay();
            }
        }
    }
}
