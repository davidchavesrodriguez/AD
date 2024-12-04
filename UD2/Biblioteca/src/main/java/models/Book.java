package models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Book implements Serializable {
    private Long idBook;
    private String isbn;
    private String titulo;
    private String autor;
    private Short anho;
    private Boolean disponible;
    private byte[] portada;
    private LocalDate dataPublicacion;

    public Book() {
    }

    public Book(String isbn, String titulo, String autor, Short anho, Boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anho = anho;
        this.disponible = disponible;
    }

    public Book(String titulo, String autor, String isbn, Short anho) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        setAnho(anho);
    }

    public Book(Long idBook, String isbn, String titulo, String autor, Short anho, Boolean disponible) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anho = anho;
        this.disponible = disponible;
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

    // Añadir portada desde archivo
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
            ImageIO.read(flujo);
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
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(titulo != null ? titulo : "*")
                .append(", ")
                .append(autor != null ? autor : "*")
                .append(", ")
                .append(anho != null ? anho : "*")
                .append(", Publicado en: ")
                .append(dataPublicacion != null ? dataPublicacion : "*")
        ;

        if (titulo == null || autor == null || anho == null) {
            sb.append(" *");
        }

        return sb.toString();
    }

}
