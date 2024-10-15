package org.example;

public class ClasificacionDAOFactory {

    public static Dao<Clasificacion, String> getClasificacionDAO(String tipo) {
        if (tipo.equalsIgnoreCase("file")) {
            return ClasificacionJSONDAO.get();
        } else {
            return null;
        }
    }

}
