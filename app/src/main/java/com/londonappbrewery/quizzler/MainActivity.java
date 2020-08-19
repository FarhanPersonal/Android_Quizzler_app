package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * This is the main file for Java code
 * @author Farhan Rahman
 * @version 08/16/2020_01
 */
public class MainActivity extends Activity {

    //region Fields
    private Button _trueButton;
    private Button _falseButton;
    private TextView _questionTextView;
    private int _questionIndex;
    private Question[] _questionBank;

    private TextView _scoreTextView;
    private int _score;
    private ProgressBar _progressBar;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        if(savedInstanceState != null) {
            _score = savedInstanceState.getInt("ScoreKey");
            _questionIndex = savedInstanceState.getInt("IndexKey");

            Log.d("Rotated", "score = " + _score);
        }

        else {
            _score = 0;
            _questionIndex = 1;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _questionBank = Question.getQuestionBank();
        _scoreTextView = this.findViewById(R.id.score);
        _trueButton = findViewById(R.id.true_button);
        _falseButton = findViewById(R.id.false_button);
        _questionTextView = findViewById(R.id.question_text_view);
        _progressBar = this.findViewById(R.id.progress_bar);

        updateScore();

    }

    /**
     * FR: Event-handler function or call-back function for the True button
     * @param view
     */
    public void OnClick_btn_True(View view) {
        showMessage(getString(R.string.true_button));
        checkAnswer(true);

//        askNextRandomQuestion();
        askQuestion();
    }

    /**
     * FR: Event-handler function or call-back function for the False button
     * @param view
     */
    public void OnClick_btn_False(View view) {
        showMessage(this.getString(R.string.false_button));
        checkAnswer(false);

//        askNextRandomQuestion();
        askQuestion();
    }

    private void checkAnswer(boolean answer) {
        if (this._questionBank[this._questionIndex].getAnswer() == answer) {
            showMessage(this.getString(R.string.correct_toast));
            _score++;
            updateScore();
            _progressBar.incrementProgressBy(1);
        }
        else {showMessage(this.getString(R.string.incorrect_toast));
            _progressBar.incrementProgressBy(1);}
    }

    private void updateScore() {
        _scoreTextView.setText("Score " + _score + "/" + _questionBank.length );
    }

    private void askNextRandomQuestion() {
        Random random = new Random();
        this._questionIndex = random.nextInt(13);

        String question = (String) this.getText(_questionBank[this._questionIndex].getId());
        _questionTextView.setText(question);
    }

    private void askQuestion() {
        if(this._questionIndex == _questionBank.length){
            this._questionIndex = 0;
        }

        String question = (String) this.getText(_questionBank[this._questionIndex].getId());
        _questionTextView.setText(question);
        this._questionIndex++;
    }

    private void showMessage(String message) {
        Toast toast = new Toast(this.getApplicationContext());
        toast = Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("ScoreKey", _score);
        outState.putInt("IndexKey", _questionIndex);
    }
}
