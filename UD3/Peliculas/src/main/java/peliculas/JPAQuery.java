package peliculas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import peliculas.Pelicula;

public class JPAQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("peliculasPU");
        EntityManager em = emf.createEntityManager();

        try {
            // 1. Listar as de duración superior a 120 minutos, ordenadas por duración
            List<Pelicula> peliculas = em.createQuery(
                            "SELECT p FROM Pelicula p WHERE p.duracion > 120 ORDER BY p.duracion ASC ", Pelicula.class)
                    .getResultList();

            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }

            // 2. Listar as dun género determinado, neste caso "Animación", ordenadas por título
            List<Pelicula> peliculas2= em.createQuery(
                    "SELECT p FROM Pelicula p WHERE p.xenero = 'Animacion' ORDER BY p.castelan", Pelicula.class)
                    .getResultList();

            for (Pelicula pelicula : peliculas2){
                System.out.println(pelicula);
            }

            // 3. Obtener todas las ocupaciones que tienen más de 5 películas asociadas

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
