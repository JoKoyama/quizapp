package com.example.intentlearning;

import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int problemNumber=0;

    public Quiz(List<Question> questionList) {
        this.questions = questionList;
    }


    public void nextQuestion(){
        problemNumber+=1;
    }

    public int questionAmount(){
        return questions.size();
    }

    public boolean isCorrect(String answer){
        if (answer.equals(questions.get(problemNumber).getAnswer())){
            return true;
        }
        else{return false;}
    }
    public boolean isTrueFalse(){
        return questions.get(problemNumber).isTrueFalse();
    }

    public String getQuestionString() {
        return questions.get(problemNumber).getQuestion();
    }

    public String getOption1()
    {
        return questions.get(problemNumber).getOption1();
    }

    public String getOption2()
    {
        return questions.get(problemNumber).getOption2();
    }

    public String getOption3()
    {
        return questions.get(problemNumber).getOption3();
    }

    public String getOption4()
    {
        return questions.get(problemNumber).getOption4();
    }

    public int getProblemNumber() {
        return problemNumber;
    }

    public void setProblemNumber(int problemNumber) {
        this.problemNumber = problemNumber;
    }


}
