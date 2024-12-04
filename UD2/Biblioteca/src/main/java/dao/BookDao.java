package dao;

import models.Book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements DAO<Book> {

    private final Connection connection;

    public BookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Book get(long id) throws SQLException {
        String query = "SELECT * FROM Book WHERE idBook= ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Book book = new Book();
                    book.setIdBook(resultSet.getLong("idBook"));
                    book.setIsbn(resultSet.getString("isbn"));
                    book.setTitulo(resultSet.getString("titulo"));
                    book.setAutor(resultSet.getString("autor"));
                    book.setAnho(resultSet.getShort("anho"));
                    book.setDisponible(resultSet.getBoolean("disponible"));
                    book.setPortada(resultSet.getBytes("portada"));
                    book.setDataPublicacion(resultSet.getDate("dataPublicacion").toLocalDate());
                    return book;
                }
            }
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        String query = "SELECT * FROM Book";
        List<Book> bookList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setIdBook(resultSet.getLong("idBook"));
                    book.setIsbn(resultSet.getString("isbn"));
                    book.setTitulo(resultSet.getString("titulo"));
                    book.setAutor(resultSet.getString("autor"));
                    book.setAnho(resultSet.getShort("anho"));
                    book.setDisponible(resultSet.getBoolean("disponible"));
                    book.setPortada(resultSet.getBytes("portada"));
                    bookList.add(book);
                }
                return bookList;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Book book) throws SQLException {
        String query = "INSERT INTO Book (isbn, titulo, autor, anho, disponible) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getAutor());
            preparedStatement.setString(3, book.getAutor());
            preparedStatement.setShort(4, book.getAnho());
            preparedStatement.setBoolean(5, book.getDisponible());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Libro " + book.getTitulo() + " gardado na base de datos");
            } else {
                System.out.println("Algo saleu mal");
            }
        }
    }

    @Override
    public void update(Book book) throws SQLException {
        String query = "UPDATE Book SET isbn=?, titulo=?, autor=?, anho=?, disponible=? WHERE idBook=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getTitulo());
            preparedStatement.setString(3, book.getAutor());
            preparedStatement.setShort(4, book.getAnho());
            preparedStatement.setBoolean(5, book.getDisponible());
            preparedStatement.setLong(6, book.getIdBook());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Libro cambiado na base de datos");
            } else {
                System.out.println("Non se encontrou o libro");
            }
        }
    }

    @Override
    public void delete(Book book) throws SQLException {
        String query = "DELETE FROM Book WHERE idBook= ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, book.getIdBook());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Libro borradísimo");
            } else {
                System.out.println("Non se borrou nada");
            }
        }
    }

    @Override
    public boolean deleteById(long id) {
        String query = "DELETE FROM Book WHERE idBook= ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Libro borradísimo");
                return true;
            } else {
                System.out.println("Non se borrou nada");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Integer> getAllIds() throws SQLException {
        String query = "SELECT idBook from Book";
        List<Integer> idList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    idList.add((int) resultSet.getLong("idBook"));
                }
            }
        }
        return idList;
    }

    @Override
    public void updateLOB(Book book, String f) throws SQLException {
        String query = "UPDATE Book SET portada= ? WHERE idBook= ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             FileInputStream fileInputStream = new FileInputStream(f)) {

            preparedStatement.setBinaryStream(1, fileInputStream, fileInputStream.available());
            preparedStatement.setLong(2, book.getIdBook());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("A portada do libro " + book.getTitulo() + " cambiouse");
            } else {
                System.out.println("Non hai ese libro");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateLOBById(long id, String f) throws SQLException {
        String query = "UPDATE Book SET portada = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             FileInputStream fileInputStream = new FileInputStream(f)) {

            preparedStatement.setBinaryStream(1, fileInputStream, fileInputStream.available());
            preparedStatement.setLong(2, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("A portada do libro con id " + id + " cambiouse");
            } else {
                System.out.println("Non hai ese libro");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteAll() throws SQLException {
        String query = "DELETE FROM Book";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Libros borrados (" + affectedRows + ")");
            }
        }
    }
}