public enum Division {
    ATLANTICO("Atlantic"),
    CENTRAL("Central"),
    SURESTE("Southeast"),
    NOROESTE("Northwest"),
    PACIFICO("Pacific"),
    SUROESTE("Southwest");

    private String nombre;

    Division(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Division fromString(String nombre){
        for (Division division : Division.values()){
            if (division.nombre.equalsIgnoreCase(nombre)){
                return division;
            }
        }
        throw new IllegalArgumentException("División no válida: " + nombre);
    }
}
