package org.example;

public class ClasificacionDAOFactory {

    public static Dao<Clasificacion, String> getClasificacionDAO(String tipo) {
        if (tipo.equalsIgnoreCase("file")) {
            System.out.println();
            return new ClasificacionJSONDAO(); // Devuelve una nueva instancia
        } else {
            return null;
        }
    }
}
