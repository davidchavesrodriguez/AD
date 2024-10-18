package org.example;

public class QuestionTrueFalse extends Question {
    private boolean answer;

    public QuestionTrueFalse(String question, QuestionType questionType, Difficulty difficulty, Category category, boolean answer) {
        super(question, questionType, difficulty, category);
        this.answer = answer;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionTrueFalse{" +
                "answer=" + answer +
                '}';
    }
}
