import entities.Estudiante;
import entities.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("El Padrino", (short) 1972);
        Pelicula pelicula2 = new Pelicula("El Padrino II", (short) 1974);
        Pelicula pelicula3 = new Pelicula("Blade Runner", (short) 1982);
        Pelicula pelicula4 = new Pelicula("Pulp Fiction", (short) 1994);
        Pelicula pelicula5 = new Pelicula("The Big Lebowski", (short) 1998);
        Pelicula pelicula6 = new Pelicula("Fight Club", (short) 1999);
        Pelicula pelicula7 = new Pelicula("A Clockwork Orange", (short) 1971);
        Pelicula pelicula8 = new Pelicula("The Shining", (short) 1980);
        Pelicula pelicula9 = new Pelicula("Donnie Darko", (short) 2001);


        LocalDate nacemento= LocalDate.of(1977, 7, 7);
        Estudiante estudiante= new Estudiante("Julio", "Acuña", nacemento, "O Pino");

        var entityManagerFactory= Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        // INSERT
        entityManager.getTransaction().begin();

        entityManager.persist(pelicula);
        entityManager.persist(pelicula2);
        entityManager.persist(pelicula3);
        entityManager.persist(pelicula4);
        entityManager.persist(pelicula5);
        entityManager.persist(pelicula6);
        entityManager.persist(pelicula7);
        entityManager.persist(pelicula8);
        entityManager.persist(pelicula9);

        entityManager.persist(estudiante);

        entityManager.getTransaction().commit();

        // SELECT
        Pelicula selectedPelicula = entityManager.find(Pelicula.class, 7L);
        System.out.println(selectedPelicula);

    }
}
