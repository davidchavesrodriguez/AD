import jakarta.persistence.EntityManager;
import java.util.List;

public class EquipoDAO {
    private EntityManager entityManager;

    public EquipoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void guardarEquipo(Equipo equipo){
        entityManager.getTransaction().begin();
        entityManager.persist(equipo);
        entityManager.getTransaction().commit();
    }

    public Equipo buscarEquipoPorId(Long id){
        return entityManager.find(Equipo.class, id);
    }

    public List<Equipo> listarEquipos(){
        return entityManager.createQuery("SELECT equipo FROM Equipo equipo", Equipo.class).getResultList();
    }
}
