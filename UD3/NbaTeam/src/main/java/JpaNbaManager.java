import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaNbaManager {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EquipoDAO equipoDAO;
    private EntrenadorDAO entrenadorDAO;

    public JpaNbaManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("nbaPU");
        entityManager = entityManagerFactory.createEntityManager();
        equipoDAO = new EquipoDAO(entityManager);
        entrenadorDAO = new EntrenadorDAO(entityManager);
    }

    public void cerrar() {
        entityManager.close();
        entityManagerFactory.close();
    }

    // Métodos para añadir equipos, entrenadores, asignar relaciones, etc.
}