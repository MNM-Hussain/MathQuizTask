package com.example.math_quiz_practise;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainSubtraction extends AppCompatActivity {

    Button btn_start, btn_answer0, btn_answer1, btn_answer2, btn_answer3;
    TextView tv_score, tv_questions, tv_timer, tv_bottommessage;
    ProgressBar prog_timer;

    //importing the GameADD Class
    GameSUB gameSUB = new GameSUB();
    //initializing the variable
    int SecondsRemaining = 60;

    //setting COuntdownTimer object to set remaining time
    CountDownTimer timer = new CountDownTimer(60000,1000) {
        @Override
        //method to run  after one seconds
        public void onTick(long l) {
            SecondsRemaining--;
            tv_timer.setText(Integer.toString(SecondsRemaining) + " Sec");
            prog_timer.setProgress(60 - SecondsRemaining);
        }

        @Override
        //method to be run after every 60 seconds
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            //to view the total Score of the user once the game over
            tv_bottommessage.setText("Time is Up!!! " + gameSUB.getNumberCorrect() + "/" + (gameSUB.getTotalQuestions() - 1));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btn_start = findViewById(R.id.btn_start);
        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);

        tv_score = findViewById(R.id.tv_score);
        tv_bottommessage = findViewById(R.id.tv_bottommessage);
        tv_questions = findViewById(R.id.questions);
        tv_timer = findViewById(R.id.tv_timer);
        prog_timer = findViewById(R.id.prog_timer);

        //setting initial text for each of the textviews
        tv_timer.setText("0 sec");
        tv_questions.setText("");
        tv_bottommessage.setText("Press Go");
        tv_score.setText("0");
        prog_timer.setProgress(0);

        nextTurn();
        timer.start();

        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button is child class of view class
                Button buttonClicked = (Button) view;// type casting is done "(Button) view" since its inherited
                //converted to integer and char sequence is converted to String
                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());
                gameSUB.checkAnswer(answerSelected);
                //converted the integer into Strings
                tv_score.setText(Integer.toString(gameSUB.getScore())); //to update the scores
                //to move on with next set of questions, nextTurn method called here
                nextTurn();

            }
        };

        //setting all btns
        // btn_start.setOnClickListener(startButtonClickListener);
        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);
    }

    private void nextTurn() {
        //create a  new Question
        gameSUB.makeNewQuestion();
        int[] answer = gameSUB.getCurrentQuestion().getAnswerArray();

        // set the QUESTION in the UI
        tv_questions.setText(gameSUB.getCurrentQuestion().getQuestionPhrase());

        //set text on answer buttons && here converting to String if not it can be crash because answer is in Int but setText only takes String
        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        //enable answer buttons
        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        //setting bottom message
        tv_bottommessage.setText(gameSUB.getNumberCorrect() + "/" + (gameSUB.getTotalQuestions() - 1)); //-1 because totalQuestions value comes when question appear

     }
    }