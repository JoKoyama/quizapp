package com.example.intentlearning;

import android.util.Log;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Question {
    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private boolean isTrueFalse;
    private int questionNumber;

    public Question(List<Question> questionList){
        this.question = question.getQuestion(questionList.get(questionNumber));
        this.answer = answer;
        if (!option1.equals("n")){
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.option4 = option4;
            isTrueFalse = false;
        }
        else{
            isTrueFalse = true;
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public boolean isTrueFalse() {
        return isTrueFalse;
    }

    public void setTrueFalse(boolean trueFalse) {
        isTrueFalse = trueFalse;
    }
}
