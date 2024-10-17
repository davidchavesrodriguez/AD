package org.example;

public class QuestionTrueFalse extends Question {
    private boolean answer;

    public QuestionTrueFalse(String question, String type, String dificulty, Category category, boolean answer) {
        super(question, type, dificulty, category);
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
