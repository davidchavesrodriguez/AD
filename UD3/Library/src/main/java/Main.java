import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();

        // Crear y persistir libros
        em.getTransaction().begin();

        Book book1 = new Book();
        book1.setIsbn("9783161484100");
        book1.setTitle("El Quijote");
        book1.setAuthor("Miguel de Cervantes");
        book1.setCategory(Category.NOVEL);
        book1.setPublicationDate(getCalendarDate(1605, Calendar.JANUARY, 16));
        em.persist(book1);

        Book book2 = new Book();
        book2.setIsbn("9780123456789");
        book2.setTitle("Cien Años de Soledad");
        book2.setAuthor("Gabriel García Márquez");
        book2.setCategory(Category.NOVEL);
        book2.setPublicationDate(getCalendarDate(1967, Calendar.MAY, 30));
        em.persist(book2);

        em.getTransaction().commit();

        // Recuperar y mostrar libros
        List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        for (Book book : books) {
            System.out.println("ID: " + book.getIdBook());
            System.out.println("Título: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthor());
            System.out.println("Categoría: " + book.getCategory());
            System.out.println("Fecha de publicación: " + book.getPublicationDate().getTime());
            System.out.println("Días desde publicación: " + book.getDaysSincePublication());
            System.out.println("ISBN-13: " + book.getIsbn());
            System.out.println("ISBN-10: " + book.getIsbn10());
            System.out.println("--------------------------------");
        }

        em.close();
        emf.close();
    }

    private static Calendar getCalendarDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar;
    }
}
