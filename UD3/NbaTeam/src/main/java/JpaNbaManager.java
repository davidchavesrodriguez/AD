import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaNbaManager {

    private EntityManagerFactory emf;
    private EntityManager em;

    public JpaNbaManager() {
        emf = Persistence.createEntityManagerFactory("nbaPU");
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

    public void addEquipo(Equipo equipo) {
        EquipoDAO equipoDAO = new EquipoDAO(em);
        equipoDAO.addEquipo(equipo);
    }

    public void addEntrenador(Entrenador entrenador) {
        EntrenadorDAO entrenadorDAO = new EntrenadorDAO(em);
        entrenadorDAO.addEntrenador(entrenador);
    }

    public void asignarEntrenadorAEquipo(Long equipoId, Long entrenadorId) {
        Equipo equipo = em.find(Equipo.class, equipoId);
        Entrenador entrenador = em.find(Entrenador.class, entrenadorId);
        if (equipo != null && entrenador != null) {
            equipo.setEntrenador(entrenador);
            entrenador.setEquipo(equipo);
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.merge(equipo);
                em.merge(entrenador);
                transaction.commit();
            } catch (RuntimeException e) {
                if (transaction.isActive()) transaction.rollback();
                throw e;
            }
        }
    }

    public void mostrarDatosEquipoYEntrenador(Long equipoId) {
        Equipo equipo = em.find(Equipo.class, equipoId);
        if (equipo != null) {
            System.out.println("Equipo: " + equipo.getNombreCompleto());
            if (equipo.getEntrenador() != null) {
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());
            }
        }
    }
}
