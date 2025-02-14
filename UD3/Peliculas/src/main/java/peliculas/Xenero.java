package peliculas;

public enum Xenero {

    Acción_e_aventura("Acción y aventura"),
    Animación("Animación"),
    Ciencia_ficción("Ciencia ficción"),
    Comedia("Comedia"),
    Documental("Documental"),
    Drama("Drama"),
    Fantasía("Fantasía"),
    Histórico("Histórico"),
    Misterio("Misterio"),
    Musical("Musical"),
    Romántico("Romántico"),
    Suspense("Suspense"),
    Terror("Terror"),
    Guerra("Guerra"),
    Western("Western"),
    Aventura("Aventura"),
    Policial("Policial"),
    Vanguardia("Vanguardia"),
    ;

    private final String descricion;

    Xenero(String descricion) {
        this.descricion = descricion;
    }

    public String getDescricion() {
        return descricion;
    }

    public static Xenero fromString(String text) {
        for (Xenero xenero : Xenero.values()) {
            if (xenero.descricion.equalsIgnoreCase(text.trim())) {
                return xenero;
            }
        }
        throw new IllegalArgumentException("Xénero non válido: " + text);
    }

    @Override
    public String toString() {
        return descricion;
    }
}
