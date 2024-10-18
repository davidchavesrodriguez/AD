package org.example;

import java.util.List;

public class Question {

    private QuestionType questionType;
    private Difficulty difficulty;
    private Category category;
    private String question;
    private String rightAnswer;
    private List<String> wrongAnswers;

    // Constructor
    public Question() {
    }

    public Question(String question, QuestionType questionType, Difficulty difficulty, Category category) {
        this.question = question;
        this.questionType = questionType;
        this.difficulty = difficulty;
        this.category = category;
    }

    // Getters y Setters
    public String getRightAnswer() {
        return rightAnswer;
    }

    public Question setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
        return this;
    }

    public List<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public Question setWrongAnswers(List<String> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public Question setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
        return this;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Question setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Question setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Question addWrong(String wrongAnswer) {
        if (wrongAnswer != null) {
            wrongAnswers.add(wrongAnswer);
        }
        return this;
    }

    // Método toString
    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", type='" + questionType + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", category=" + category +
                '}';
    }

}
