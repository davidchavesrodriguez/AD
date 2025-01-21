import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lobsPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Crear un documento de prueba
            Documento doc = new Documento();
            doc.setId(1L);
            doc.setContenido("Contenido del documento largo...");
            doc.setImagen(new byte[]{1, 2, 3, 4, 5});

            em.persist(doc);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
