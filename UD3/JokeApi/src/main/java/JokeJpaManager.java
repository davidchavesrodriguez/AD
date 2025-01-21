
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;


public class JokeJpaManager {

    public static final String BIBLIOTECA_H2 = "jokeH2";
    public static final String BIBLIOTECA_POSTGRES = "jokePostgres";


    private static final Map<String, EntityManagerFactory> instancies = new HashMap<>();

    private JokeJpaManager() {
    }

    private static boolean isEntityManagerFactoryClosed(String unidadPersistencia) {
        return !instancies.containsKey(unidadPersistencia) || instancies.get(unidadPersistencia) == null ||
                !instancies.get(unidadPersistencia).isOpen();
    }

    public static EntityManagerFactory getEntityManagerFactory(String unidadPersistencia) {
        if (isEntityManagerFactoryClosed(unidadPersistencia)) {
            synchronized (JokeJpaManager.class) {
                if (isEntityManagerFactoryClosed(unidadPersistencia)) {
                    try {
                        instancies.put(unidadPersistencia, Persistence.createEntityManagerFactory(unidadPersistencia));
                    } catch (Exception e) {
                        LOG.error("Erro ó crear a unidade de persistencia " + unidadPersistencia +
                                ": " + e.getMessage());
                    }
                }
            }
        }
        return instancies.get(unidadPersistencia);
    }


    public static EntityManager getEntityManager(String persistenceUnitName) {
        return getEntityManagerFactory(persistenceUnitName).createEntityManager();
    }


    public static void close(String persistenceUnitName) {
        if (instancies.containsKey(persistenceUnitName)) {
            instancies.get(persistenceUnitName).close();
            instancies.remove(persistenceUnitName);
        }
    }

}