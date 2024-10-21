package org.example;

public enum QuestionType {
    MULTIANSWER("multianswer"), TRUEFALSE("truefalse");
    private final String questionType;

    QuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getType() {
        return questionType;
    }
}
