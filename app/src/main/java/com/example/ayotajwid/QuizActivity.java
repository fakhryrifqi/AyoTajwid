package com.example.ayotajwid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question, timer;
    private Button ops1, ops2, ops3, ops4;
    private List<Question> listQuiz;
    private int number;
    private CountDownTimer countDown;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        question = findViewById(R.id.question);
        timer = findViewById(R.id.countDown);

        ops1 = findViewById(R.id.option1);
        ops2 = findViewById(R.id.option2);
        ops3 = findViewById(R.id.option3);
        ops4 = findViewById(R.id.option4);

        ops1.setOnClickListener(this);
        ops2.setOnClickListener(this);
        ops3.setOnClickListener(this);
        ops4.setOnClickListener(this);

        //call list question
        getQuestionList();

        //starting score
        score = 0;
    }

    private void getQuestionList(){
        //list quiz
        listQuiz = new ArrayList<>();

        listQuiz.add(new Question("Question 1", "A", "B", "C", "D", 2));
        listQuiz.add(new Question("Question 2", "B", "C", "D", "A", 2));
        listQuiz.add(new Question("Question 3", "C", "D", "A", "B", 2));
        listQuiz.add(new Question("Question 4", "D", "A", "B", "C", 2));
        listQuiz.add(new Question("Question 5", "D", "A", "C", "B", 2));
        listQuiz.add(new Question("Question 6", "C", "B", "D", "A", 2));
        listQuiz.add(new Question("Question 7", "B", "C", "A", "D", 2));
        listQuiz.add(new Question("Question 8", "A", "D", "B", "C", 2));
        listQuiz.add(new Question("Question 9", "C", "B", "D", "A", 2));
        listQuiz.add(new Question("Question 10", "B", "A", "C", "D", 2));

        //call method set question
        setQuestion();
    }

    private void setQuestion(){
        //set timer
        timer.setText(String.valueOf(10));

        //set question + choice
        question.setText(listQuiz.get(0).getQuestion());
        ops1.setText(listQuiz.get(0).getOptionA());
        ops2.setText(listQuiz.get(0).getOptionB());
        ops3.setText(listQuiz.get(0).getOptionC());
        ops4.setText(listQuiz.get(0).getOptionD());

        //call method start timer
        startTimer();

        //index of questions
        number = 0;
    }

    private void startTimer(){
        //setting count down
        countDown = new CountDownTimer(12000, 1000) {
            @Override
            public void onTick(long l) {
                if(l < 10000){
                    timer.setText(String.valueOf(l / 1000));
                }
            }

            @Override
            public void onFinish() {
                nextQuiz();
            }
        };

        countDown.start();
    }

    @Override
    public void onClick(View view) {

        //change choice
        int selectedOption = 0;

        switch (view.getId()){
            case R.id.option1:
                selectedOption = 1;
                break;
            case R.id.option2:
                selectedOption = 2;
                break;
            case R.id.option3:
                selectedOption = 3;
                break;
            case R.id.option4:
                selectedOption = 4;
                break;
            default:
        }

        //count down end
        countDown.cancel();

        //call method checking answer
        checkAnswer(selectedOption, view);

    }

    private void checkAnswer(int selectedOption, View view){
        if(selectedOption == listQuiz.get(number).getAnswer()){
            //change color right answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

            //increment score
            score++;
        }
        else {
            //change color wrong answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));

            switch (listQuiz.get(number).getAnswer()){
                case 1:
                    ops1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    ops2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    ops3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    ops4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }

        //handling delay any question
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //call method next quiz
                nextQuiz();
            }
        }, 2000);


    }

    private void nextQuiz(){
        if(number < listQuiz.size() - 1){

            //question increment
            number++;

            playAnim(question, 0, 0);
            playAnim(ops1, 0, 1);
            playAnim(ops2, 0, 2);
            playAnim(ops3, 0, 3);
            playAnim(ops4, 0, 4);

            //set timer any question
            timer.setText(String.valueOf(10));
            startTimer();
        }
        else {
            //get score
            Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
            intent.putExtra("SCORE", String.valueOf(score * 10));
            startActivity(intent);
            QuizActivity.this.finish();
        }
    }

    private void playAnim(View v, int value, int num){
        v.animate()
                .alpha(value)
                .scaleX(value)
                .scaleY(value)
                .setDuration(500)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        //get question + choice
                        if(value == 0){
                            switch (num){
                                case 0:
                                    ((TextView) v).setText(listQuiz.get(number).getQuestion());
                                    break;
                                case 1:
                                    ((Button) v).setText(listQuiz.get(number).getOptionA());
                                    break;
                                case 2:
                                    ((Button) v).setText(listQuiz.get(number).getOptionB());
                                    break;
                                case 3:
                                    ((Button) v).setText(listQuiz.get(number).getOptionC());
                                    break;
                                case 4:
                                    ((Button) v).setText(listQuiz.get(number).getOptionD());
                                    break;
                            }

                            //reset color btn
                            if(num != 0){
                                ((Button) v).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFF9900")));
                            }

                            //call method animation
                            playAnim(v, 1, num);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
    }
}