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

    // Constructor para asignar la descripción
    Xenero(String descricion) {
        this.descricion = descricion;
    }

    // Método para obtener la descripción
    public String getDescricion() {
        return descricion;
    }

    // Método para convertir un valor de la base de datos a la enumeración
    public static Xenero fromString(String text) {
        for (Xenero xenero : Xenero.values()) {
            if (xenero.descricion.equalsIgnoreCase(text)) {
                return xenero;
            }
        }
        throw new IllegalArgumentException("Xénero non válido: " + text);
    }

    // Método toString para representación en texto
    @Override
    public String toString() {
        return descricion;
    }
}