import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EquipoDAO {
    private EntityManager em;

    public EquipoDAO(EntityManager em) {
        this.em = em;
    }

    public void addEquipo(Equipo equipo) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(equipo);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

    public Equipo getEquipoById(Long id) {
        return em.find(Equipo.class, id);
    }
}