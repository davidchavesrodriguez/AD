package peliculas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocupacion")
public class Ocupacion {
    @Id
    @Column(name = "ocupacion", length = 50)
    private String ocupacion;

    @Column(name = "orde", nullable = false)
    private Integer orde;

    public Ocupacion() {
    }

    public Ocupacion(String ocupacion, Integer orde) {
        this.ocupacion = ocupacion;
        this.orde = orde;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getOrde() {
        return orde;
    }

    public void setOrde(Integer orde) {
        this.orde = orde;
    }

    @Override
    public String toString() {
        return "[" + ocupacion + "] (" + orde + ')';
    }
}