package peliculas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Personaxe")
public class Personaxe {
    @Id
    @Column(name = "idPersonaxe")
    private Long idPersonaxe;

    @Column(length = 16)
    private String importancia;

    @Column(length = 125)
    private String nome;

    @Column(name = "nomeOrdenado", length = 125)
    private String nomeOrdenado;

    @Column(name = "nomeOrixinal", length = 125)
    private String nomeOrixinal;

    @Column(length = 6)
    private String sexo;

    @Column(name = "dataNacemento")
    private LocalDate dataNacemento;

    @Column(name = "paisNacemento", length = 125)
    private String paisNacemento;

    @Column(name = "dataDefuncion")
    private LocalDate dataDefuncion;

    @Column(name = "cidadeDefuncion", length = 125)
    private String cidadeDefuncion;

    @Column(length = 1)
    private String estudio;

    @Column(length = 1)
    private String bio;

    @Column(columnDefinition = "LONGTEXT")
    private String texto;

    @Column(name = "textoFilmografia", columnDefinition = "LONGTEXT")
    private String textoFilmografia;

    @Column(length = 10)
    private String revisado;

    public Long getIdPersonaxe() {
        return idPersonaxe;
    }

    public void setIdPersonaxe(Long idPersonaxe) {
        this.idPersonaxe = idPersonaxe;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeOrdenado() {
        return nomeOrdenado;
    }

    public void setNomeOrdenado(String nomeOrdenado) {
        this.nomeOrdenado = nomeOrdenado;
    }

    public String getNomeOrixinal() {
        return nomeOrixinal;
    }

    public void setNomeOrixinal(String nomeOrixinal) {
        this.nomeOrixinal = nomeOrixinal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(LocalDate dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public String getPaisNacemento() {
        return paisNacemento;
    }

    public void setPaisNacemento(String paisNacemento) {
        this.paisNacemento = paisNacemento;
    }

    public LocalDate getDataDefuncion() {
        return dataDefuncion;
    }

    public void setDataDefuncion(LocalDate dataDefuncion) {
        this.dataDefuncion = dataDefuncion;
    }

    public String getCidadeDefuncion() {
        return cidadeDefuncion;
    }

    public void setCidadeDefuncion(String cidadeDefuncion) {
        this.cidadeDefuncion = cidadeDefuncion;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoFilmografia() {
        return textoFilmografia;
    }

    public void setTextoFilmografia(String textoFilmografia) {
        this.textoFilmografia = textoFilmografia;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public Personaxe() {
    }

    public Personaxe(Long idPersonaxe, String importancia, String nome, String nomeOrdenado, String nomeOrixinal, String sexo, LocalDate dataNacemento, String paisNacemento, LocalDate dataDefuncion, String cidadeDefuncion, String estudio, String bio, String texto, String textoFilmografia, String revisado) {
        this.idPersonaxe = idPersonaxe;
        this.importancia = importancia;
        this.nome = nome;
        this.nomeOrdenado = nomeOrdenado;
        this.nomeOrixinal = nomeOrixinal;
        this.sexo = sexo;
        this.dataNacemento = dataNacemento;
        this.paisNacemento = paisNacemento;
        this.dataDefuncion = dataDefuncion;
        this.cidadeDefuncion = cidadeDefuncion;
        this.estudio = estudio;
        this.bio = bio;
        this.texto = texto;
        this.textoFilmografia = textoFilmografia;
        this.revisado = revisado;
    }

    @Override
    public String toString() {
        return "Personaxe{" +
                "idPersonaxe=" + idPersonaxe +
                ", importancia='" + importancia + '\'' +
                ", nome='" + nome + '\'' +
                ", nomeOrdenado='" + nomeOrdenado + '\'' +
                ", nomeOrixinal='" + nomeOrixinal + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dataNacemento=" + dataNacemento +
                ", paisNacemento='" + paisNacemento + '\'' +
                ", dataDefuncion=" + dataDefuncion +
                ", cidadeDefuncion='" + cidadeDefuncion + '\'' +
                ", estudio='" + estudio + '\'' +
                ", bio='" + bio + '\'' +
                ", texto='" + texto + '\'' +
                ", textoFilmografia='" + textoFilmografia + '\'' +
                ", revisado='" + revisado + '\'' +
                '}';
    }
}
