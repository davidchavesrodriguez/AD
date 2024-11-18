package solution;

public class VariableFranxa {
    private static final int NO_DATA = -999;

    private VariableMeteo variableMeteo;
    private int valorManha;
    private int valorTarde;
    private int valorNoite;

    public VariableFranxa() {
        this.valorManha = NO_DATA;
        this.valorTarde = NO_DATA;
        this.valorNoite = NO_DATA;
    }

    public VariableFranxa(VariableMeteo variableMeteo, int valorManha, int valorTarde, int valorNoite) {
        this.variableMeteo = variableMeteo;
        this.valorManha = valorManha;
        this.valorTarde = valorTarde;
        this.valorNoite = valorNoite;
    }

    public VariableMeteo getVariableMeteo() {
        return variableMeteo;
    }

    public void setVariableMeteo(VariableMeteo variableMeteo) {
        this.variableMeteo = variableMeteo;
    }

    public int getValorManha() {
        return valorManha;
    }

    public void setValorManha(int valorManha) {
        this.valorManha = valorManha;
    }

    public int getValorTarde() {
        return valorTarde;
    }

    public void setValorTarde(int valorTarde) {
        this.valorTarde = valorTarde;
    }

    public int getValorNoite() {
        return valorNoite;
    }

    public void setValorNoite(int valorNoite) {
        this.valorNoite = valorNoite;
    }

    @Override
    public String toString() {
        return "VariableFranxa{" +
                "variableMeteo=" + variableMeteo +
                ", valorManha=" + valorManha +
                ", valorTarde=" + valorTarde +
                ", valorNoite=" + valorNoite +
                '}';
    }


//    public static void main(String[] args) {
//        VariableFranxa variable= new VariableFranxa();
//        System.out.println(variable);
//    }
}
