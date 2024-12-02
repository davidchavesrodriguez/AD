import dao.BookDAO;
import models.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class MainBiblioteca {
    public static void main(String[] args) {
        // Obtener conexión
        try (Connection connection = BibliotecaConnectionManager.getConnection()) {
            BookDAO bookDAO = new BookDAO(connection);

            // Crear lista de libros
            List<Book> books = List.of(
                    new Book("9780307277672", "Cien años de soledad", "Gabriel García Márquez", (short) 1967, true, getPortadaBytes("covers/cien_anos.jpg")),
                    new Book("9780743273565", "Harry Potter y la piedra filosofal", "J.K. Rowling", (short) 1997, true, getPortadaBytes("covers/harry_potter.jpg")),
                    new Book("9780307959474", "The Sense of an Ending", "Julian Barnes", (short) 2011, true, getPortadaBytes("covers/sense_ending.jpg")),
                    new Book("9780307386672", "No Country for Old Men", "Cormac McCarthy", (short) 2005, true, getPortadaBytes("covers/no_country.jpg")),
                    new Book("9781400064168", "The Road", "Cormac McCarthy", (short) 2006, true, getPortadaBytes("covers/the_road.jpg"))
            );

            // Guardar libros en la base de datos
            for (Book book : books) {
                bookDAO.save(book);
                System.out.println("Libro guardado con ID: " + book.getIdBook());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para leer la portada desde un archivo
    private static byte[] getPortadaBytes(String filePath) {
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de portada: " + filePath, e);
        }
    }
}

