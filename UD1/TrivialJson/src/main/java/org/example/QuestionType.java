package org.example;

public enum QuestionType {
    MULTIANSWER("multianswer"), TRUEFALSE("truefalse");
    private final String questionType;

    QuestionType(String type) {
        this.questionType = type;
    }

    public String getType() {
        return this.questionType;
    }
}
