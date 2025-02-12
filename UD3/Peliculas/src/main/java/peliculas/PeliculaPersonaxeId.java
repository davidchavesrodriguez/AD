package peliculas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PeliculaPersonaxeId implements Serializable {

    @Column(name = "idPelicula")
    private Long idPelicula;

    @Column(name = "idPersonaxe")
    private Long idPersonaxe;

    @Column(name = "ocupacion", length = 50)
    private String ocupacion;

    // Getters y setters
    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Long getIdPersonaxe() {
        return idPersonaxe;
    }

    public void setIdPersonaxe(Long idPersonaxe) {
        this.idPersonaxe = idPersonaxe;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaPersonaxeId that = (PeliculaPersonaxeId) o;
        return Objects.equals(idPelicula, that.idPelicula) &&
                Objects.equals(idPersonaxe, that.idPersonaxe) &&
                Objects.equals(ocupacion, that.ocupacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, idPersonaxe, ocupacion);
    }
}