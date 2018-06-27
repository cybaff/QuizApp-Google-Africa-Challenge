package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float correctAnswers = 0;
    float totalQuestions = 8;
    boolean qOneAnswered = false;
    boolean qTwoAnswered = false;
    boolean qThreeAnswered = false;
    boolean qFourAnswered = false;
    boolean qSixAnswered = false;
    boolean qSevenAnswered = false;
    boolean qEightAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //code for question one
    public void questionOneAnswered(View v) {
        if (v.getId() == R.id.q_one_a) {
            correctAnswers += 1;
        } else {
            if (qOneAnswered) {
                correctAnswers -= 1;
            }
        }
        qOneAnswered = true;
    }

    //code for question two
    public void questionTwoAnswered(View v) {
        if (v.getId() == R.id.q_two_a) {
            correctAnswers += 1;
        } else {
            if (qTwoAnswered) {
                correctAnswers -= 1;
            }
        }
        qTwoAnswered = true;
    }

    //code for question three
    public void questionThreeAnswered(View v) {
        if (v.getId() == R.id.q_three_d) {
            correctAnswers += 1;
        } else {
            if (qThreeAnswered) {
                correctAnswers -= 1;
            }
        }
        qThreeAnswered = true;
    }

    //code for question four
    public void questionFourAnswered(View v) {
        if (v.getId() == R.id.q_four_b) {
            correctAnswers += 1;
        } else {
            if (qFourAnswered) {
                correctAnswers -= 1;
            }
        }
        qFourAnswered = true;
    }

    //code for question six
    public void questionSixAnswered(View v) {
        if (v.getId() == R.id.q_six_c) {
            correctAnswers += 1;
        } else {
            if (qSixAnswered) {
                correctAnswers -= 1;
            }
        }
        qSixAnswered = true;
    }

    //code for question seven
    public void questionSevenAnswered(View v) {
        if (v.getId() == R.id.q_seven_c) {
            correctAnswers += 1;
        } else {
            if (qSevenAnswered) {
                correctAnswers -= 1;
            }
        }
        qSevenAnswered = true;
    }

    //code for question eight
    public void questionEightAnswered(View v) {
        switch (v.getId()) {
            case R.id.q_eight_a:
                correctAnswers += 0.0;
                break;
            case R.id.q_eight_b:
                correctAnswers += 0.5;
                break;
            case R.id.q_eight_c:
                correctAnswers += 0.0;
                break;
            case R.id.q_eight_d:
                correctAnswers += 0.5;
                break;
            default:
                if (qEightAnswered) {
                    correctAnswers -= 1;
                }
                break;
        }
        qEightAnswered = true;
    }

        private void uncheckAllChildren (ViewGroup vg){
            for (int i = 0; i < vg.getChildCount(); i++) {
                View v = vg.getChildAt(i);
                if (v instanceof CheckBox) {
                    ((CheckBox) v).setChecked(false);
                }
            }
        }
        //code for question five
        public void submitAnswersTapped (View v){
            EditText qFive = (EditText) findViewById(R.id.q_five_answer);
            if (qFive.getText().toString().equalsIgnoreCase("12")) {
                correctAnswers += 1;
            }

            displayScore();

        }

        //code to display message
        private void displayScore () {
            Log.v("Correct Answers", Float.toString(correctAnswers));
            float score = correctAnswers / totalQuestions * 100;
            score = Math.round(score);
            Log.v("Score: ", Float.toString(score * 100) + "%");
            String scoreMessage = "Score: " + score + "%";
            Toast.makeText(MainActivity.this, scoreMessage, Toast.LENGTH_LONG).show();
            resetQuiz();
        }

        //code for resetting radio buttons and checkbox
        private void resetQuiz() {
            RadioGroup one = (RadioGroup) findViewById(R.id.q_one_group);
            one.clearCheck();

            RadioGroup two = (RadioGroup) findViewById(R.id.q_two_group);
            two.clearCheck();

            RadioGroup three = (RadioGroup) findViewById(R.id.q_three_group);
            three.clearCheck();

            RadioGroup four = (RadioGroup) findViewById(R.id.q_four_group);
            four.clearCheck();

            RadioGroup six = (RadioGroup) findViewById(R.id.q_six_group);
            six.clearCheck();

            RadioGroup seven = (RadioGroup) findViewById(R.id.q_seven_group);
            seven.clearCheck();

            LinearLayout checkboxes = (LinearLayout) findViewById(R.id.checkbox_question);
            uncheckAllChildren(checkboxes);

            correctAnswers = 0;
            qOneAnswered = false;
            qTwoAnswered = false;
            qThreeAnswered = false;
            qFourAnswered = false;
            qSixAnswered = false;
            qSevenAnswered = false;
            qEightAnswered = false;
        }

    }
