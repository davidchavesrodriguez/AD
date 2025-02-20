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
            List<Pelicula> peliculas2 = em.createQuery(
                            "SELECT p FROM Pelicula p WHERE p.xenero = :xenero ORDER BY p.castelan", Pelicula.class)
                    .setParameter("xenero", Xenero.Animación)
                    .getResultList();

            for (Pelicula pelicula : peliculas2) {
                System.out.println(pelicula);
            }

            // 3. Obtener todas las ocupaciones que tienen más de 5 películas asociadas
//            List<Ocupacion> ocupacions = em.createQuery(
//                            "SELECT o FROM Ocupacion o WHERE SIZE(o.peliculaPersonaxes) > 5", Ocupacion.class)
//                    .getResultList();
//
//            for (Ocupacion ocupacion : ocupacions) {
//                System.out.println(ocupacion);
//            }

            // 4. Obtener todas las películas que tienen un país específico (por ejemplo, “España”)
            List<Pelicula> peliculas4 = em.createQuery("SELECT p FROM Pelicula p WHERE p.pais = :pais ORDER BY p.anoFin", Pelicula.class)
                    .setParameter("pais", new Pais("España"))
                    .getResultList();

            for (Pelicula pelicula : peliculas4) {
                System.out.println(pelicula);
            }

            // 5. Obtener todas las películas que tienen al menos un personaje interpretado por un actor de un país específico (por ejemplo, “Francia”).
            List<Pelicula> peliculas5 = em.createQuery(
                            "SELECT DISTINCT pp.pelicula " +
                                    "FROM PeliculaPersonaxe pp " +
                                    "JOIN pp.personaxe pe " +
                                    "WHERE pe.paisNacemento = :paisNacemento", Pelicula.class)
                    .setParameter("paisNacemento", "España")
                    .getResultList();

            for (Pelicula pelicula : peliculas5) {
                System.out.println(pelicula);
            }

            // 6. Obtener todas las películas que tienen música compuesta por un compositor específico (por ejemplo, “John Williams”).
            List<Pelicula> peliculas6 = em.createQuery(
                            "SELECT pp.pelicula " +
                                    "FROM PeliculaPersonaxe pp " +
                                    "WHERE pp.ocupacion.ocupacion= :ocupacion " +
                                    "AND pp.personaxe.nome= :nome", Pelicula.class)
                    .setParameter("nome", "Williams, John")
                    .setParameter("ocupacion", "Compositor de la banda original")
                    .getResultList();

            for (Pelicula pelicula : peliculas6) {
                System.out.println(pelicula);
            }

            // 7. Obtener todas las películas que tienen un personaje interpretado por un actor con un nombre específico (por ejemplo, “Tom Hanks”)
            List<Pelicula> peliculas7 = em.createQuery(
                    "SELECT pp.pelicula " +
                            "FROM PeliculaPersonaxe pp " +
                            "WHERE pp.ocupacion.ocupacion= :ocupacion " +
                            "AND pp.personaxe.nome= :nome", Pelicula.class
            ).setParameter("ocupacion", "Actor").setParameter("nome", "Hanks, Tom").getResultList();

            for (Pelicula pelicula : peliculas7) {
                System.out.println(pelicula);
            }

            // 8. Obtener todas las películas que tienen un género específico y que fueron producidas en un año específico (por ejemplo, “Acción” y 2005)
            List<Pelicula> peliculas8 = em.createQuery(
                            "SELECT p " +
                                    "FROM Pelicula p WHERE p.xenero = :xenero " +
                                    "AND p.anoFin = :anoFin", Pelicula.class
                    ).setParameter("xenero", Xenero.Comedia)
                    .setParameter("anoFin", 1999)
                    .getResultList();

            for (Pelicula pelicula : peliculas8) {
                System.out.println(pelicula);
            }

            // 9. Obtener todas las películas que tienen un personaje interpretado por un actor de un género específico (por ejemplo, “Mujer”).
            List<Pelicula> peliculas9 = em.createQuery(
                    "SELECT DISTINCT pp.pelicula " +
                            "FROM PeliculaPersonaxe pp " +
                            "WHERE pp.personaxe.sexo = :sexo", Pelicula.class
            ).setParameter("sexo", "mujer").getResultList();

            for (Pelicula pelicula : peliculas9) {
                System.out.println(pelicula);
            }

            // 10. Obtener todas las películas que tienen un personaje interpretado por un actor que nació en un país específico y que tienen una duración mayor a 100 minutos.
            List<Pelicula> peliculas10 = em.createQuery(
                            "SELECT DISTINCT pp.pelicula " +
                                    "FROM PeliculaPersonaxe pp " +
                                    "WHERE pp.personaxe.paisNacemento = :pais " +
                                    "AND pp.pelicula.duracion > :duracion", Pelicula.class
                    ).setParameter("pais", "España").setParameter("duracion", 100)
                    .getResultList();

            for (Pelicula pelicula : peliculas10) {
                System.out.println(pelicula);
            }


            // 11. Devolver todos los países que no tienen películas asociadas, puedes usar una consulta JPQL que utilice una subconsulta o un LEFT JOIN con una condición IS NULL.
            List<Pais> paisesSinPeliculas = em.createQuery(
                    "SELECT p FROM Pais p LEFT JOIN Pelicula pel ON p.pais = pel.pais.pais WHERE pel.idPelicula IS NULL",
                    Pais.class
            ).getResultList();


            for (Pais pelicula : paisesSinPeliculas) {
                System.out.println(pelicula);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
