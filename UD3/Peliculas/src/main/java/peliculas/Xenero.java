package peliculas;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Xenero {

    Acción_e_aventura("Acción e aventura"),
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
    Terror("Terror");

    private final String descricion;

    Xenero(String descricion) {
        this.descricion = descricion;
    }

    public String getDescricion() {
        return descricion;
    }

    public static Xenero fromString(String text) {
        for (Xenero xenero : Xenero.values()) {
            if (xenero.descricion.equalsIgnoreCase(text)) {
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