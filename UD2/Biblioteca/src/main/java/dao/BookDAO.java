package dao;

import models.Book;
import org.h2.command.query.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book> {
    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Book get(long id) {
        String query = "SELECT * FROM Book WHERE idBook = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToBook(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener el libro con ID " + id, e);
        }
        return null;
    }

    private Book mapResultSetToBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setIdBook(resultSet.getLong("idBook"));
        book.setTitulo(resultSet.getString("titulo"));
        book.setAutor(resultSet.getString("autor"));
        book.setAnho(resultSet.getShort("anho"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setDisponible(resultSet.getBoolean("disponible"));
        book.setPortada(resultSet.getBytes("portada"));
        return book;
    }

    @Override
    public List<Book> getAll() {
        String query = "SELECT * FROM Book";
        List<Book> books = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                books.add(mapResultSetToBook(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener todos los libros", e);
        }
        return books;
    }


    @Override
    public void save(Book book) {
        String query = "INSERT INTO Book (titulo, autor, anho, isbn, disponible, portada) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, book.getTitulo());
            preparedStatement.setString(2, book.getAutor());
            preparedStatement.setShort(3, book.getAnho());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setBoolean(5, book.getDisponible());
            preparedStatement.setBytes(6, book.getPortada());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    book.setIdBook(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el libro", e);
        }
    }

    @Override
    public void update(Book book) {
        String query = "UPDATE Book SET titulo = ?, autor = ?, anho = ?, isbn = ?, disponible = ?, portada = ? WHERE idBook = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, book.getTitulo());
            preparedStatement.setString(2, book.getAutor());
            preparedStatement.setShort(3, book.getAnho());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setBoolean(5, book.getDisponible());
            preparedStatement.setBytes(6, book.getPortada());
            preparedStatement.setLong(7, book.getIdBook());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el libro", e);
        }
    }

    @Override
    public void delete(Book book) {
        deleteById(book.getIdBook());
    }

    @Override
    public boolean deleteById(long id) {
        String query = "DELETE FROM Book WHERE idBook = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el libro con ID " + id, e);
        }
    }

    @Override
    public List<Integer> getAllIds() {
        String query = "SELECT idBook FROM Book";
        List<Integer> ids = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ids.add(resultSet.getInt("idBook"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener los IDs de los libros", e);
        }
        return ids;
    }


    @Override
    public void updateLOB(Book book, String filePath) {
        updateLOBById(book.getIdBook(), filePath);
    }

    @Override
    public void updateLOBById(long id, String filePath) {
        String query = "UPDATE Book SET portada = ? WHERE idBook = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             FileInputStream fis = new FileInputStream(filePath)) {
            preparedStatement.setBinaryStream(1, fis, fis.available());
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Error al actualizar LOB del libro con ID " + id, e);
        }
    }

    @Override
    public void deleteAll() {
        String query = "DELETE FROM Book";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar todos los libros", e);
        }
    }
}
