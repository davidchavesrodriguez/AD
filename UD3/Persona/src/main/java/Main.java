import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("personaPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persona persona = new Persona("Carlos", "Pérez",
                LocalDate.of(1995, 6, 15), Sexo.HOME,
                EstadoCivil.SOLTEIRO, new byte[]{});
        em.persist(persona);

        Persona julio= new Persona("Julio", "Acuña",
                LocalDate.of(2002, 4, 19), Sexo.HOME,
                EstadoCivil.CASADO, new byte[]{});
        em.persist(julio);

        Persona silvia= new Persona("Silvia", "Plath",
                LocalDate.of(1932, 10, 27), Sexo.MULLER,
                EstadoCivil.VIUVO, new byte[]{});
        em.persist(silvia);

        em.getTransaction().commit();

//        Persona recuperada = em.find(Persona.class, persona.getIdPersona());
//        System.out.println("Nome Apelidos: " + recuperada.getNomeApelidos());
//        System.out.println("Idade: " + recuperada.getIdade());
    }
}
