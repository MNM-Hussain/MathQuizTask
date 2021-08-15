package com.example.math_quiz_practise;
import java.util.ArrayList;
import java.util.List;

public class GameADD {
    //to have list of questions
    private List<AdditionQuestion> questions;
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestions;
    private int score;
    // to track the current question is displayed
    private AdditionQuestion currentQuestion;

    //constructor
    public GameADD(){
        numberCorrect=0;
        numberIncorrect=0;
        totalQuestions=0;
        score=0;
        //setting a current question(i.e a new question and setted a range of 10)
        currentQuestion = new AdditionQuestion(10);
        questions = new ArrayList<AdditionQuestion>();
    }

    //create a function/method
    public void makeNewQuestion(){
        //generate a new question and assigning to current question
        currentQuestion = new AdditionQuestion(totalQuestions * 2 + 5); //increases the difficulty level
        totalQuestions++;
        //adding the current question for the questions list
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

    //Getters and Setters
    public List<AdditionQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<AdditionQuestion> questions) {
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

    public AdditionQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(AdditionQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
