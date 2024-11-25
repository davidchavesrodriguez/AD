package models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Book {
    private Long idBook;
    private String isbn;
    private String titulo;
    private String autor;
    private Short anho;
    private Boolean disponible;
    private byte[] portada;
    private LocalDate dataPublicacion;


    public Book(String titulo, String autor, String isbn, Short anho) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        setAnho(anho);
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Short getAnho() {
        return anho;
    }

    public void setAnho(Short anho) {
        this.anho = anho;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public void setPortada(File f) {
        try {
            this.portada = Files.readAllBytes(f.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPortada(String f) {
        setPortada(new File(f));
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Image getImage() throws IOException {
        if (portada != null) {
            ByteArrayInputStream flujo = new ByteArrayInputStream(portada);
            return ImageIO.read(flujo);
        }
        return null;
    }

    public LocalDate getDataPublicacion() {
        return dataPublicacion;
    }

    public void setDataPublicacion(LocalDate dataPublicacion) {
        this.dataPublicacion = dataPublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(idBook, book.idBook) && Objects.equals(isbn, book.isbn)
                && Objects.equals(titulo, book.titulo) && Objects.equals(autor, book.autor)
                && Objects.equals(anho, book.anho) && Objects.equals(disponible, book.disponible)
                && Objects.deepEquals(portada, book.portada) && Objects.equals(dataPublicacion, book.dataPublicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBook, isbn, titulo, autor, anho, disponible, Arrays.hashCode(portada), dataPublicacion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Comprobamos cada campo y lo añadimos al StringBuilder
        sb.append(titulo != null ? titulo : "*")
                .append(", ")
                .append(autor != null ? autor : "*")
                .append(", ")
                .append(anho != null ? anho : "*")
                .append(", Publicado en: ")
                .append(dataPublicacion != null ? dataPublicacion : "*")
        ;

        // Si algún campo obligatorio está vacío, se añade un asterisco final
        if (titulo == null || autor == null || anho == null) {
            sb.append(" *");
        }

        return sb.toString();
    }

}
