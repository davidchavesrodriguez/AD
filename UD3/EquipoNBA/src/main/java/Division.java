public enum Division {
    ATLANTICO("ATLANTIC"),
    CENTRAL("CENTRAL"),
    SURESTE("SOUTHEAST"),
    NOROESTE("NORTHWEST"),
    PACIFICO("PACIFIC"),
    SUROESTE("SOUTHWEST");

    private final String valor;

    Division(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
