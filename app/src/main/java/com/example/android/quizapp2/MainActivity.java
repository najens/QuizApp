package com.example.android.quizapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *  Method for calculating the score.
     */
    public void showResults (View view) {

        /* initial score */
        int score = 0;

        /* calculates score from RadioButton questions */
        RadioButton rb_answer = (RadioButton) findViewById(R.id.rb_answer1);
        if (rb_answer.isChecked()){score = score+1;}
            else {score = score+0;}
        rb_answer = (RadioButton) findViewById(R.id.rb_answer2);
        if (rb_answer.isChecked()){score = score+1;}
            else {score = score+0;}
        rb_answer = (RadioButton) findViewById(R.id.rb_answer3);
        if (rb_answer.isChecked()){score = score+1;}
            else {score = score+0;}

        /* calculates score from EditText questions */
        EditText et_answer = (EditText) findViewById(R.id.et_4);
        String st_answer = et_answer.getText().toString();
        if (getString(R.string.a4).equalsIgnoreCase(st_answer)){score = score +1;}
            else {score = score+0;}
        et_answer = (EditText) findViewById(R.id.et_5);
        st_answer = et_answer.getText().toString();
        if (getString(R.string.a5).equalsIgnoreCase(st_answer)){score = score +1;}
            else {score = score+0;}
        et_answer = (EditText) findViewById(R.id.et_6);
        st_answer = et_answer.getText().toString();
        if (getString(R.string.a6).equalsIgnoreCase(st_answer)){score = score +1;}
            else {score = score+0;}

        /* calculates score from CheckBox questions */
        CheckBox ans7a = (CheckBox) findViewById(R.id.cb_7a);
        CheckBox ans7b = (CheckBox) findViewById(R.id.cb_7b);
        CheckBox ans7c = (CheckBox) findViewById(R.id.cb_7c);
        CheckBox ans7d = (CheckBox) findViewById(R.id.cb_7d);
        boolean cb_answer = (ans7a.isChecked() && ans7b.isChecked() && !ans7c.isChecked() && ans7d.isChecked());
        if (cb_answer) {score = score +1;}
            else {score = score+0;}
        CheckBox ans8a = (CheckBox) findViewById(R.id.cb_8a);
        CheckBox ans8b = (CheckBox) findViewById(R.id.cb_8b);
        CheckBox ans8c = (CheckBox) findViewById(R.id.cb_8c);
        CheckBox ans8d = (CheckBox) findViewById(R.id.cb_8d);
        cb_answer = (ans8a.isChecked() && !ans8b.isChecked() && ans8c.isChecked() && !ans8d.isChecked());
        if (cb_answer) {score = score +1;}
            else {score = score+0;}
        CheckBox ans9a = (CheckBox) findViewById(R.id.cb_9a);
        CheckBox ans9b = (CheckBox) findViewById(R.id.cb_9b);
        CheckBox ans9c = (CheckBox) findViewById(R.id.cb_9c);
        CheckBox ans9d = (CheckBox) findViewById(R.id.cb_9d);
        cb_answer = (ans9a.isChecked() && ans9b.isChecked() && ans9c.isChecked() && ans9d.isChecked());
        if (cb_answer) {score = score +1;}
            else {score = score+0;}

        /* display score */
        displayScore (score);
    }

    /**
     *  Method displaying score on the screen.
     */
    private void displayScore (int finalScore) {
        Toast scoreMessage = Toast.makeText(this,finalScore + getString(R.string.resultToast),Toast.LENGTH_LONG);
        scoreMessage.show();
    }

    /**
     *  Method show the correct answers.
     */
    public void correctAnswers (View vew) {

        /* This part scrolls the screen back to the top. */
        ScrollView scrollToTop = (ScrollView) findViewById(R.id.quiz_sv);
        scrollToTop.fullScroll(ScrollView.FOCUS_UP);

        /* This sets the RadioButtons to the correct answers. */
        RadioGroup choiceRG = (RadioGroup) findViewById(R.id.rg_1);
        choiceRG.check(R.id.rb_answer1);
        choiceRG = (RadioGroup) findViewById(R.id.rg_2);
        choiceRG.check(R.id.rb_answer2);
        choiceRG = (RadioGroup) findViewById(R.id.rg_3);
        choiceRG.check(R.id.rb_answer3);

        /* This sets the EditText to the correct answers. */
        String st_answer = getString(R.string.a4);
        EditText et_answer = (EditText) findViewById(R.id.et_4);
        et_answer.setText(st_answer);
        st_answer = getString(R.string.a5);
        et_answer = (EditText) findViewById(R.id.et_5);
        et_answer.setText(st_answer);
        st_answer = getString(R.string.a6);
        et_answer = (EditText) findViewById(R.id.et_6);
        et_answer.setText(st_answer);

        /* This sets the CheckBoxes to the correct answers. */
        CheckBox choiceCB = (CheckBox) findViewById(R.id.cb_7a);
        choiceCB.setChecked(true);
        choiceCB = (CheckBox) findViewById(R.id.cb_7b);
        choiceCB.setChecked(true);
        choiceCB = (CheckBox) findViewById(R.id.cb_7c);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_7d);
        choiceCB.setChecked(true);
        choiceCB = (CheckBox) findViewById(R.id.cb_8a);
        choiceCB.setChecked(true);
        choiceCB = (CheckBox) findViewById(R.id.cb_8b);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_8c);
        choiceCB.setChecked(true);
        choiceCB = (CheckBox) findViewById(R.id.cb_8d);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_9a);
        choiceCB.setChecked(true);
        choiceCB = (CheckBox) findViewById(R.id.cb_9b);
        choiceCB.setChecked(true);
        choiceCB = (CheckBox) findViewById(R.id.cb_9c);
        choiceCB.setChecked(true);
        choiceCB = (CheckBox) findViewById(R.id.cb_9d);
        choiceCB.setChecked(true);

        /* informative toast */
        Toast infoMessage = Toast.makeText(this,getString(R.string.answerToast),Toast.LENGTH_LONG);
        infoMessage.show();
    }

    /**
     *  Method resets the test.
     */
    public void resetTest (View view) {
        /* This part scrolls the screen back to the top. */
        ScrollView scrollToTop = (ScrollView) findViewById(R.id.quiz_sv);
        scrollToTop.fullScroll(ScrollView.FOCUS_UP);

        /* This clears the RadioGroup answers. */
        RadioGroup choiceRG = (RadioGroup) findViewById(R.id.rg_1);
        choiceRG.clearCheck();
        choiceRG = (RadioGroup) findViewById(R.id.rg_2);
        choiceRG.clearCheck();
        choiceRG = (RadioGroup) findViewById(R.id.rg_3);
        choiceRG.clearCheck();

        /* This clears the EditText answers. */
        String clearAnswer ="";
        EditText et_answer = (EditText) findViewById(R.id.et_4);
        et_answer.setText(clearAnswer);
        clearAnswer ="";
        et_answer = (EditText) findViewById(R.id.et_5);
        et_answer.setText(clearAnswer);
        clearAnswer ="";
        et_answer = (EditText) findViewById(R.id.et_6);
        et_answer.setText(clearAnswer);

        /* This clears the CheckBox answers. */
        CheckBox choiceCB = (CheckBox) findViewById(R.id.cb_7a);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_7b);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_7c);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_7d);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_8a);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_8b);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_8c);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_8d);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_9a);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_9b);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_9c);
        choiceCB.setChecked(false);
        choiceCB = (CheckBox) findViewById(R.id.cb_9d);
        choiceCB.setChecked(false);

        /* informative toast */
        Toast resetMessage = Toast.makeText(this,getString(R.string.resetToast),Toast.LENGTH_LONG);
        resetMessage.show();
    }
}

