public enum Conferencia {
    ESTE("EAST"),
    OESTE("WEST");

    private final String valor;

    Conferencia(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}