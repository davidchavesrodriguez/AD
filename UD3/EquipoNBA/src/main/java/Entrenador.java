import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrenador;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Long salario;

    @OneToOne
    @JoinColumn(name = "idEquipo", nullable = true)
    private Equipo equipo;

    public Entrenador() {
    }

    public Entrenador(Long identrenador, String nombre, Equipo equipo, LocalDate fechaNacimiento, Long salario) {
        idEntrenador = identrenador;
        this.nombre = nombre;
        this.equipo = equipo;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
    }
}



