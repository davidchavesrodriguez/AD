package peliculas;

/**
 * B/N
 * B/N e Color
 * Color
 */
public enum Cor {
    BN("B/N"),
    BN_Y_COLOR("B/N e Color"),
    COLOR("Color");

    private final String nome;

    Cor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
