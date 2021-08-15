package com.example.math_quiz_practise;

import java.util.Random;

public class AdditionQuestion {

    private int firstNumber;
    private int secondNumber;
    private int answer;
    //4 possible choices for pickup
    private int [] answerArray; //to store the 4 answers to user to be pick from
    //which of the 4 position is correct(0 or 1 or 2 or 3)
    private int answerPosition; //number from 0-3
    //max value of first Number or SecondNumber ex number from 0-10
    private int upperLimit;
    //String output of the problem ex:- "6+5 =" (question Display format)
    private String questionPhrase;


    //generating a constructor to generate a new random questions which will take 2 random numbers
    // and add them togther and calculate the answer and also generate some false option
    public AdditionQuestion(int upperLimit){
        this.upperLimit = upperLimit;
        Random randomNumberMaker = new Random();
        //nextInt() is used to input an integer value from the user and assign it to the variable
        this.firstNumber = randomNumberMaker.nextInt(upperLimit);
        this.secondNumber = randomNumberMaker.nextInt(upperLimit);
        this.answer = this.firstNumber + this.secondNumber;
        // Question display format in the page
        this.questionPhrase = firstNumber + " + " + secondNumber + " = " + " ? ";

        // we have 4 option for generate an answer, so we generating 1 of the 4 to be answer
        this.answerPosition = randomNumberMaker.nextInt(4);
        // just initializing just for an array of random numbers
        this.answerArray =  new int[]{0,1,2,3};

        //re-calc those answers and providing the values for answers
        this.answerArray[0]= answer + 1;
        this.answerArray[1]= answer + 3;
        this.answerArray[2] = answer - 2;
        this.answerArray[3] = answer -5;

        //shuffle the 4 answer options
        this.answerArray = shuffleArray(this.answerArray);
        // after a shuffle, to place our correct answer in one of the 4 places
        answerArray[answerPosition] = answer;
    }

    //custom method for shuffleArray, where we use this to mix up our answers
    private int [] shuffleArray(int[] array){
        int index, temp;
        Random randomNumberGenerator = new Random();

        //for loop to run backward
        for (int i= array.length - 1; i>0; i--){
            //to take random position and swap with temperory numbers
            index = randomNumberGenerator.nextInt(i + 1);//nextInt() is used to input an integer value from the user and assign it to the variable
            temp = array[index];
            array[index]= array[i];
            array[i] = temp;
        }
        return array;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
