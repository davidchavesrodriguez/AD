package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;
    private String nome;
    private String apelidos;
    private LocalDate fechaNacemento;
    private String direccion;

    public Estudiante() {
    }

    public Estudiante(Long idEstudiante, String nome, String apelidos, LocalDate fechaNacemento, String direccion) {
        this.idEstudiante = idEstudiante;
        this.nome = nome;
        this.apelidos = apelidos;
        this.fechaNacemento = fechaNacemento;
        this.direccion = direccion;
    }

    public Estudiante(String nome, String apelidos, LocalDate fechaNacemento, String direccion) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.fechaNacemento = fechaNacemento;
        this.direccion = direccion;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public LocalDate getFechaNacemento() {
        return fechaNacemento;
    }

    public void setFechaNacemento(LocalDate fechaNacemento) {
        this.fechaNacemento = fechaNacemento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", nome='" + nome + '\'' +
                ", apelidos='" + apelidos + '\'' +
                ", fechaNacemento=" + fechaNacemento +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
