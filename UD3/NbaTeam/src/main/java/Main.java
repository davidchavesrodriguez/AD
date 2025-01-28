import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    // Método main para probar la funcionalidad
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nbaPU");
        EntityManager em = emf.createEntityManager();

        EquipoDAO equipoDAO = new EquipoDAO(em);

        // Crear un nuevo equipo
        Equipo equipo = new Equipo();
        equipo.setIdEquipo(1L);
        equipo.setNombre("Lakers");
        equipo.setCiudad("Los Angeles");
        equipo.setConferencia(Conferencia.OESTE);
        equipo.setDivision(Division.PACIFICO);
        equipo.setNombreCompleto("Los Angeles Lakers");
        equipo.setAbreviatura("LAL");

        // Añadir el equipo a la base de datos
        equipoDAO.addEquipo(equipo);

        // Cerrar el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
    }
}
