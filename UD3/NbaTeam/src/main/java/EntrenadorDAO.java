import jakarta.persistence.EntityManager;
import java.util.List;

public class EntrenadorDAO {

    private EntityManager entityManager;
    public EntrenadorDAO() {
    }

    public EntrenadorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void guardarEntrenador(Entrenador entrenador) {
        entityManager.getTransaction().begin();
        entityManager.persist(entrenador);
        entityManager.getTransaction().commit();
    }

    public Entrenador buscarEntrenadorPorId(Long id) {
        return entityManager.find(Entrenador.class, id);
    }

    public List<Entrenador> listarEntrenadores() {
        return entityManager.createQuery("SELECT entrenador FROM Entrenador entrenador", Entrenador.class).getResultList();
    }

    public void close() {
    }
}