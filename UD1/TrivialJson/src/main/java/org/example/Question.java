package org.example;


public class Question {

    private String question;
    private String type;
    private String dificulty;
    private Category category;

    public Question(String question, String type, String dificulty, Category category) {
        this.question = question;
        this.type = type;
        this.dificulty = dificulty;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDificulty() {
        return dificulty;
    }

    public void setDificulty(String dificulty) {
        this.dificulty = dificulty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", type='" + type + '\'' +
                ", dificulty='" + dificulty + '\'' +
                ", category=" + category +
                '}';
    }
}
