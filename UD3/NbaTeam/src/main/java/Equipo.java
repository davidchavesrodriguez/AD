import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "equipo", uniqueConstraints = {
        @UniqueConstraint(columnNames = "idEquipo"),
        @UniqueConstraint(columnNames = "abreviatura")
})
public class Equipo implements Serializable {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;
    private String nombre;
    private String ciudad;
    @Enumerated(EnumType.STRING)
    private Conferencia conferencia;
    @Enumerated(EnumType.STRING)
    private Division division;
    private String nombreCompleto;
    private String abreviatura;

    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    private Entrenador entrenador;

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }


}
