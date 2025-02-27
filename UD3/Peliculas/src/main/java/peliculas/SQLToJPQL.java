package peliculas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.NoResultException;

import java.util.List;

public class SQLToJPQL {
    public static void main(String[] args) {
        // Crear la fábrica y el manager de entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("peliculasPU");

        try (emf; EntityManager em = emf.createEntityManager()) {
            System.out.println("1- Muestra la película solicitando el id:");
            int identificador = 140;

            try {
                // Consulta de película por ID, utilizando el DTO para devolver solo los campos necesarios
                Pelicula pelicula = em.createQuery(
                                "SELECT new peliculas.Pelicula(p.castelan, p.orixinal, p.anoFin, " +
                                        "CASE WHEN p.poster IS NOT NULL THEN true ELSE false END) " +
                                        "FROM Pelicula p WHERE p.idPelicula = :identificador",
                                Pelicula.class
                        )
                        .setParameter("identificador", identificador)
                        .getSingleResult();

                System.out.println(pelicula);
            } catch (NoResultException e) {
                System.out.println("No se encontró ninguna película con el ID: " + identificador);
            }

            // Consulta de películas con o sin personajes
            System.out.println("2- Muestra las películas que tienen algún personaje (IS NOT EMPTY) o no tienen personajes (IS EMPTY)");

            List<Pelicula> peliculasConPersonajes = em.createQuery("SELECT p FROM Pelicula p WHERE p.participantes IS NOT EMPTY", Pelicula.class).getResultList();
            List<Pelicula> peliculasSinPersonajes = em.createQuery("SELECT p FROM Pelicula p WHERE p.participantes IS EMPTY", Pelicula.class).getResultList();

            // Mostrar las películas con personajes
            for (Pelicula pelicula : peliculasConPersonajes) {
                System.out.println("CON personajes: " + pelicula);
            }

            // Mostrar las películas sin personajes
            for (Pelicula pelicula : peliculasSinPersonajes) {
                System.out.println("SIN personajes: " + pelicula);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
