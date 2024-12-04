import dao.BookDao;
import models.Book;

import java.sql.Connection;
import java.sql.SQLException;

public class MainBiblioteca {
    public static void main(String[] args) throws SQLException {
        // Obtener la instancia Singleton
        BibliotecaConnectionManager connectionManager = BibliotecaConnectionManager.getInstance();

        // Obtener la conexión desde el Singleton
        Connection connection = connectionManager.getConnection();

        // Mostrar información de la conexión
        System.out.println("Conexión establecida: " + connection);

        BookDao bookDao = new BookDao(connection);

        // Mostrar libro con x id
        // System.out.println(bookDao.get(1));

        // Mostrar todos los libros
        // bookDao.getAll().forEach(System.out::println);

        // Insertar un libro
        // bookDao.save(new Book("0-6836-1607-2", "Como aprobar Pokemon", "David Chaves", (short) 2002, true));

        // Modificar un libro
        // bookDao.update(new Book(11L, "0-6836-1607-2", "Como aprobar Java", "Julio Aller", (short) 2002, true));

        // Eliminar un libro
        // bookDao.delete(new Book(11L, "0-6836-1607-2", "Como aprobar Java", "Julio Aller", (short) 2002, true));

        // Eliminar un libro con x id
        // bookDao.deleteById(10);

        // Mostrar todos os ID
        // bookDao.getAllIds().forEach(System.out::println);


        // Cerrar la conexión al finalizar
        connectionManager.closeConnection();
    }
}
