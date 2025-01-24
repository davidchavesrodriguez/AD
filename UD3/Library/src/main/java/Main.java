import jakarta.persistence.*;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Book book1 = new Book();
        book1.setIsbn("9783161484100");
        book1.setTitle("El Quijote");
        book1.setAuthor("Miguel de Cervantes");
        book1.setCategory(Category.NOVEL);
        book1.setPublicationDate(getCalendarDate(1605, Calendar.JANUARY, 16));
        book1.setAvailable(false);
        book1.setPublicationYear((short) 1605);
        em.persist(book1);

        Book book2 = new Book();
        book2.setIsbn("9780123456789");
        book2.setTitle("Cien Años de Soledad");
        book2.setAuthor("Gabriel García Márquez");
        book2.setCategory(Category.NOVEL);
        book2.setPublicationDate(getCalendarDate(1967, Calendar.MAY, 30));
        book2.setAvailable(true);
        book2.setPublicationYear((short) 1967);
        em.persist(book2);

        Book book3 = new Book();
        book3.setIsbn("9780061120084");
        book3.setTitle("1984");
        book3.setAuthor("George Orwell");
        book3.setCategory(Category.NOVEL);
        book3.setPublicationDate(getCalendarDate(1949, Calendar.JUNE, 8));
        book3.setAvailable(true);
        book3.setPublicationYear((short) 1949);
        em.persist(book3);

        Book book4 = new Book();
        book4.setIsbn("9780141187761");
        book4.setTitle("Crimen y Castigo");
        book4.setAuthor("Fyodor Dostoevsky");
        book4.setCategory(Category.NOVEL);
        book4.setPublicationDate(getCalendarDate(1866, Calendar.JANUARY, 1));
        book4.setAvailable(true);
        book4.setPublicationYear((short) 1866);
        em.persist(book4);

        Book book5 = new Book();
        book5.setIsbn("9780307277712");
        book5.setTitle("The Road");
        book5.setAuthor("Cormac McCarthy");
        book5.setCategory(Category.NOVEL);
        book5.setPublicationDate(getCalendarDate(2006, Calendar.SEPTEMBER, 26));
        book5.setAvailable(false);
        book5.setPublicationYear((short) 2006);
        em.persist(book5);

        Book book6 = new Book();
        book6.setIsbn("9780141187396");
        book6.setTitle("The Waste Land");
        book6.setAuthor("T.S. Eliot");
        book6.setCategory(Category.POETRY);
        book6.setPublicationDate(getCalendarDate(1922, Calendar.OCTOBER, 1));
        book6.setAvailable(true);
        book6.setPublicationYear((short) 1922);
        em.persist(book6);

        Book book7 = new Book();
        book7.setIsbn("9780140441046");
        book7.setTitle("Meditations");
        book7.setAuthor("Marcus Aurelius");
        book7.setCategory(Category.ESSAY);
        book7.setPublicationDate(getCalendarDate(180, Calendar.JANUARY, 1));
        book7.setAvailable(true);
        book7.setPublicationYear((short) 180);
        em.persist(book7);

        Book book8 = new Book();
        book8.setIsbn("9780140441268");
        book8.setTitle("Hamlet");
        book8.setAuthor("William Shakespeare");
        book8.setCategory(Category.THEATER);
        book8.setPublicationDate(getCalendarDate(1603, Calendar.JANUARY, 1));
        book8.setAvailable(true);
        book8.setPublicationYear((short) 1603);
        em.persist(book8);

        Book book9 = new Book();
        book9.setIsbn("9780385472579");
        book9.setTitle("The Alchemist");
        book9.setAuthor("Paulo Coelho");
        book9.setCategory(Category.NOVEL);
        book9.setPublicationDate(getCalendarDate(1988, Calendar.JANUARY, 1));
        book9.setAvailable(true);
        book9.setPublicationYear((short) 1988);
        em.persist(book9);

        Book book10 = new Book();
        book10.setIsbn("9781400033423");
        book10.setTitle("The Kite Runner");
        book10.setAuthor("Khaled Hosseini");
        book10.setCategory(Category.NOVEL);
        book10.setPublicationDate(getCalendarDate(2003, Calendar.MAY, 29));
        book10.setAvailable(true);
        book10.setPublicationYear((short) 2003);
        em.persist(book10);

        Book book11 = new Book();
        book11.setIsbn("9780307387893");
        book11.setTitle("The Hunger Games");
        book11.setAuthor("Suzanne Collins");
        book11.setCategory(Category.NOVEL);
        book11.setPublicationDate(getCalendarDate(2008, Calendar.SEPTEMBER, 14));
        book11.setAvailable(true);
        book11.setPublicationYear((short) 2008);
        em.persist(book11);

        Book book12 = new Book();
        book12.setIsbn("9780545010221");
        book12.setTitle("Harry Potter and the Deathly Hallows");
        book12.setAuthor("J.K. Rowling");
        book12.setCategory(Category.NOVEL);
        book12.setPublicationDate(getCalendarDate(2007, Calendar.JULY, 21));
        book12.setAvailable(false);
        book12.setPublicationYear((short) 2007);
        em.persist(book12);

        em.getTransaction().commit();

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