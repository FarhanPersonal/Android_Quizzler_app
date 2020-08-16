package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * This is the main file for Java code
 * @author Farhan Rahman
 * @version 08/16/2020_01
 */
public class MainActivity extends Activity {

    // TODO: Declare constants here

    // TODO: Declare member variables here:
    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionText;
    int mQuestionIndex;

    // TODO: Uncomment to create question bank
    private Question[] mQuestionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton =   findViewById(R.id.true_button);
        mFalseButton =   findViewById(R.id.false_button);
        mQuestionText = findViewById(R.id.question_text_view);

        mQuestionBank = Question.getQuestionBank();
        askNextRandomQuestion();
    }



    /**
     * FR: Event-handler function or call-back function for the True button
     * @param view
     */
    public void OnClick_btn_True(View view) {
        showMessage("You answered true");
        checkAnswer(true);

        askNextRandomQuestion();

    }
    /**
     * FR: Event-handler function or call-back function for the False button
     * @param view
     */
    public void OnClick_btn_False(View view) {
        showMessage("You answered false");
        checkAnswer(false);

        askNextRandomQuestion();
    }

    private void checkAnswer(boolean answer) {
        if (this.mQuestionBank[this.mQuestionIndex].getAnswer() == answer) {showMessage("You are right");}
        else {showMessage("You are wrong");}
    }

    private void askNextRandomQuestion() {
        Random random = new Random();
        this.mQuestionIndex = random.nextInt(13);

        String question = (String) this.getText(mQuestionBank[this.mQuestionIndex].getId());
        mQuestionText.setText(question);
    }

    private void showMessage(String message) {
        Toast toast = new Toast(this.getApplicationContext());
        toast = Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }
}
