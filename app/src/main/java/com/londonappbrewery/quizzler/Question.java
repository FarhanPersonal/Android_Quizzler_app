package com.londonappbrewery.quizzler;

public class Question {

    private int id;
    private boolean answer;

    public Question(int id, boolean answer) {
        this.id = id;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public static Question[] getQuestionBank(){

        Question[] questions = new Question[] {
                new Question(R.string.question_1, true),
                new Question(R.string.question_2, true),
                new Question(R.string.question_3, true),
                new Question(R.string.question_4, true),
                new Question(R.string.question_5, true),
                new Question(R.string.question_6, false),
                new Question(R.string.question_7, true),
                new Question(R.string.question_8, false),
                new Question(R.string.question_9, true),
                new Question(R.string.question_10, true),
                new Question(R.string.question_11, false),
                new Question(R.string.question_12, false),
                new Question(R.string.question_13,true)
        };

        return questions;
    }
}
