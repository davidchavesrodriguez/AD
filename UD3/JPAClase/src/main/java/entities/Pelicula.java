package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id_pelicula", nullable = false, unique = true)
    private Long idPelicula;
    private String titulo;
    private Short ano;
    private transient LocalDate fechaEstreno;

    @ManyToOne
    @JoinColumn(name = "idDirector")

    private Director director;

    public Pelicula() {
    }

    public Pelicula(Long idPelicula, String titulo, Short ano) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.ano = ano;
    }

    public Pelicula(String titulo, Short ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return
                "[" + idPelicula + "]" + titulo + '\'' +
                "(" + ano + ')';
    }
}
