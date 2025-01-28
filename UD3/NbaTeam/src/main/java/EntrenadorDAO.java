import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntrenadorDAO {
    private EntityManager em;

    public EntrenadorDAO(EntityManager em) {
        this.em = em;
    }

    public void addEntrenador(Entrenador entrenador) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(entrenador);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

    public Entrenador getEntrenadorById(Long id) {
        return em.find(Entrenador.class, id);
    }
}