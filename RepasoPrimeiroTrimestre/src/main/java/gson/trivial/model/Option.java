package gson.trivial.model;

public class Option {
    private String statement;
    private boolean rightAnswer;

    public Option() {
    }

    public Option(String statement) {
        this.statement = statement;
        this.rightAnswer = false;
    }

    public Option(String statement, boolean rightAnswer) {
        this.statement = statement;
        this.rightAnswer = rightAnswer;
    }


    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        StringBuilder sc = new StringBuilder();
        sc.append(statement);
        if (rightAnswer) {
            sc.append("[*]");
        }
        return sc.toString();
    }
}
