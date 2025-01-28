import jakarta.persistence.*;

import java.awt.*;
import java.util.Objects;

@Entity
public class Equipo{
    @Id
    private Long idEquipo;

    @Column(unique = true)
    private String abreviatura;

    private String nombre;
    private String ciudad;
    private String nombreCompleto;

    @Enumerated(EnumType.STRING)
    private Conferencia conferencia;

    @Enumerated(EnumType.STRING)
    private Division division;

    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Entrenador entrenador;

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(idEquipo, equipo.idEquipo) && Objects.equals(abreviatura, equipo.abreviatura) && Objects.equals(nombre, equipo.nombre) && Objects.equals(ciudad, equipo.ciudad) && Objects.equals(nombreCompleto, equipo.nombreCompleto) && conferencia == equipo.conferencia && division == equipo.division && Objects.equals(entrenador, equipo.entrenador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipo, abreviatura, nombre, ciudad, nombreCompleto, conferencia, division, entrenador);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo=" + idEquipo +
                ", abreviatura='" + abreviatura + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", conferencia=" + conferencia +
                ", division=" + division +
                ", entrenador=" + entrenador +
                '}';
    }
}