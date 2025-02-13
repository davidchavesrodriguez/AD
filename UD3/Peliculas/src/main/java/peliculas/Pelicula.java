package peliculas;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "pelicula", schema = "peliculas")
public class Pelicula {
    @Id
    @Column(name = "idPelicula")
    private Long idPelicula;

    @Column(length = 50)
    private String musica;

    @Column(length = 125)
    private String orixinal;

    @Column(length = 125)
    private String ingles;

    @Column(length = 125)
    private String castelan;

    @Convert(converter = XeneroConverter.class)
    @Column(name = "xenero", length = 50)
    private Xenero xenero;

    private Short anoFin;

    @ManyToOne
    @JoinColumn(name = "pais")
    private Pais pais;

    private Short duracion;

    @Column(length = 12)
    private Cor cor;

    @Column(length = 6)
    private String son;

    @Column(columnDefinition = "LONGTEXT")
    private String texto;

    @Lob
    private byte[] poster;

    @Column(length = 10)
    private String revisado;

    @Embedded
    private DetallePelicula detalle; // Campos opcionales embebidos

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PeliculaPersonaxe> participantes;

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getOrixinal() {
        return orixinal;
    }

    public void setOrixinal(String orixinal) {
        this.orixinal = orixinal;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getCastelan() {
        return castelan;
    }

    public void setCastelan(String castelan) {
        this.castelan = castelan;
    }

    public Xenero getXenero() {
        return xenero;
    }

    public void setXenero(Xenero xenero) {
        this.xenero = xenero;
    }

    public Short getAnoFin() {
        return anoFin;
    }

    public void setAnoFin(Short anoFin) {
        this.anoFin = anoFin;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }


    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public Pelicula() {
    }

    public Pelicula(Long idPelicula, String musica, String orixinal, String ingles, String castelan, Xenero xenero, Short anoFin, Pais pais, Short duracion, Cor cor, String son, String texto, byte[] poster, String revisado) {
        this.idPelicula = idPelicula;
        this.musica = musica;
        this.orixinal = orixinal;
        this.ingles = ingles;
        this.castelan = castelan;
        this.xenero = xenero;
        this.anoFin = anoFin;
        this.pais = pais;
        this.duracion = duracion;
        this.cor = cor;
        this.son = son;
        this.texto = texto;
        this.poster = poster;
        this.revisado = revisado;
    }
}
