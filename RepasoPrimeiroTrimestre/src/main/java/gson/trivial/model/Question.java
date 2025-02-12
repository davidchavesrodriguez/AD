package gson.trivial.model;

import java.io.Serializable;
import java.util.Objects;

public class Question implements Comparable<Question>, Serializable {

    // Enums
    public enum QuestionType {
        BOOLEAN("True/False"), MULTIPLE("Multiple choice");

        private final String questionType;

        QuestionType(String questionType) {
            this.questionType = questionType;
        }

        public String getQuestionType() {
            return questionType;
        }
    }

    public enum Dificulty {
        EASY("Easy"), MEDIUM("Medium"), HARD("Hard");

        private final String dificulty;

        Dificulty(String dificulty) {
            this.dificulty = dificulty;
        }

        public String getDificulty() {
            return dificulty;
        }
    }

    private Long questionId;
    private Category category;
    private String questionText;
    private QuestionType questionType;
    private Dificulty dificulty;

    public Question() {
    }

    public Question(String questionText) {
        this.questionText = questionText;
    }

    // Getters y setters
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Dificulty getDificulty() {
        return dificulty;
    }

    public void setDificulty(Dificulty dificulty) {
        this.dificulty = dificulty;
    }

    // Método compareTo
    @Override
    public int compareTo(Question other) {
        int comparation = this.questionText.compareTo(other.questionText);
        if (comparation != 0) return comparation;

        comparation = this.questionType.compareTo(other.questionType);
        if (comparation != 0) return comparation;

        comparation = this.dificulty.compareTo(other.dificulty);
        if (comparation != 0) return comparation;

        return this.category.compareTo(other.category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(questionId, question1.questionId) &&
                Objects.equals(category, question1.category) &&
                Objects.equals(questionText, question1.questionText) &&
                questionType == question1.questionType &&
                dificulty == question1.dificulty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, category, questionText, questionType, dificulty);
    }

    @Override
    public String toString() {
        return (questionId != null ? questionId + ". " : "") +
                questionText.substring(0, 1).toUpperCase() + questionText.substring(1);
    }
}