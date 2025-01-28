import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class EquipoDAO {
    private EntityManager entityManager;

    // Constructor por defecto
    public EquipoDAO() {
    }

    // Constructor con EntityManager
    public EquipoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Método para añadir un equipo
    public void addEquipo(Equipo equipo){
        entityManager.getTransaction().begin();
        entityManager.persist(equipo);
        entityManager.getTransaction().commit();
    }

    // Método para encontrar un equipo por su ID
    public Equipo findEquipoById(Long id) {
        return entityManager.find(Equipo.class, id);
    }

    // Método para listar todos los equipos
    public List<Equipo> listEquipos() {
        return entityManager.createQuery("SELECT equipo FROM Equipo equipo", Equipo.class).getResultList();
    }

    public Equipo buscarEquipoPorId(Long id){
        return entityManager.find(Equipo.class, id);
    }

    public List<Equipo> listarEquipos(){
        return entityManager.createQuery("SELECT equipo FROM Equipo equipo", Equipo.class).getResultList();
    }

    public void close() {
    }
}
