import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "entrenador")
public class Entrenador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrenador;
    private String nombre;
    private Date fechaNacimiento;
    private double salario;

    @OneToOne
    @JoinColumn(name = "idEquipo")
    private Equipo equipo;

    public Long getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}