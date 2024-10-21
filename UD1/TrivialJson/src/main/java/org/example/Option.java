package org.example;

public final class Option {
    private String statement;
    private boolean isTrue;

    // Constructor vacío
    public Option() {
    }

    // Constructor con solo 'statement'
    public Option(final String statement) {
        this.statement = statement;
        this.isTrue = false;
    }

    // Constructor con 'statement' y 'isTrue'
    public Option(final String statement, final boolean isTrue) {
        this.statement = statement;
        this.isTrue = isTrue;
    }

    // Métodos getter y setter
    public String getStatement() {
        return statement;
    }

    public void setStatement(final String statement) {
        this.statement = statement;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(final boolean isTrue) {
        this.isTrue = isTrue;
    }

    // Método toString()
    @Override
    public String toString() {
        return statement + (isTrue ? "[*]" : "");
    }
}
