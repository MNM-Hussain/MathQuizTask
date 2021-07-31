package com.example.math_quiz_practise;

import java.util.ArrayList;
import java.util.List;

public class GameSUB {
    private List<SubtractionQuestion> questions;
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestions;
    private int score;
    private SubtractionQuestion currentQuestion;

    //constructor
    public GameSUB(){
        numberCorrect=0;
        numberIncorrect=0;
        totalQuestions=0;
        score=0;
        currentQuestion = new SubtractionQuestion(10);
        questions = new ArrayList<SubtractionQuestion>();
    }

    //create a function
    public void makeNewQuestion(){
        //generate a new question and assigning to current question
        currentQuestion = new SubtractionQuestion(totalQuestions * 2 + 7); //increases the difficulty level
        totalQuestions++;
        questions.add(currentQuestion);
    }
    //checking whether the submitted answer is correct or wrong
    public boolean checkAnswer(int submittedAnswer){
        boolean isCorrect;
        if (currentQuestion.getAnswer() == submittedAnswer){
            numberCorrect++;
            isCorrect = true;
        }else {
            numberIncorrect++;
            isCorrect = false;
        }
        score = numberCorrect * 10 - numberIncorrect * 10;
        return isCorrect;
    }

    //Getters And Setters
    public List<SubtractionQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<SubtractionQuestion> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public SubtractionQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(SubtractionQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
