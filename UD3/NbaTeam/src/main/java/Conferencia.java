public enum Conferencia {
    ESTE("East"), OESTE("West");

    private String nombre;

    Conferencia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Conferencia fromString(String nombre){
        for (Conferencia conferencia : Conferencia.values()){
            if (conferencia.nombre.equalsIgnoreCase(nombre)){
                return conferencia;
            }
        }
        throw new IllegalArgumentException("Confrencia no válida: " + nombre);
    }
}
