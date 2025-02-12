package peliculas;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculapersonaxe")
public class PeliculaPersonaxe {

    @EmbeddedId
    private PeliculaPersonaxeId id;

    @ManyToOne
    @MapsId("idPelicula") // Mapea el campo idPelicula de la clave compuesta
    @JoinColumn(name = "idPelicula")
    private Pelicula pelicula;

    @ManyToOne
    @MapsId("idPersonaxe")
    @JoinColumn(name = "idPersonaxe")
    private Personaxe personaxe;

    @ManyToOne
    @MapsId("ocupacion")
    @JoinColumn(name = "ocupacion")
    private Ocupacion ocupacion;

    @Column(name = "personaxeInterpretado", length = 50)
    private String personaxeInterpretado;

    // Constructores
    public PeliculaPersonaxe() {
    }

    public PeliculaPersonaxe(Pelicula pelicula, Personaxe personaxe, Ocupacion ocupacion, String personaxeInterpretado) {
        this.pelicula = pelicula;
        this.personaxe = personaxe;
        this.ocupacion = ocupacion;
        this.personaxeInterpretado = personaxeInterpretado;
        this.id = new PeliculaPersonaxeId();
        this.id.setIdPelicula(pelicula.getIdPelicula());
        this.id.setIdPersonaxe(personaxe.getIdPersonaxe());
        this.id.setOcupacion(ocupacion.getOcupacion());
    }

    // Getters y setters
    public PeliculaPersonaxeId getId() {
        return id;
    }

    public void setId(PeliculaPersonaxeId id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Personaxe getPersonaxe() {
        return personaxe;
    }

    public void setPersonaxe(Personaxe personaxe) {
        this.personaxe = personaxe;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getPersonaxeInterpretado() {
        return personaxeInterpretado;
    }

    public void setPersonaxeInterpretado(String personaxeInterpretado) {
        this.personaxeInterpretado = personaxeInterpretado;
    }

    // Método toString
    @Override
    public String toString() {
        return "PeliculaPersonaxe{" +
                "pelicula=" + pelicula +
                ", personaxe=" + personaxe +
                ", ocupacion=" + ocupacion +
                ", personaxeInterpretado='" + personaxeInterpretado + '\'' +
                '}';
    }
}