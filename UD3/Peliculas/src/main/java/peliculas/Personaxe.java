package peliculas;

import java.time.LocalDate;

public class Personaxe {
    private Long idPersonaxe;
    private String importancia;
    private String nome;
    private String nomeOrdenado;
    private String nomeOrixinal;
    private String sexo;
    private LocalDate dataNacemento;
    private String paisNacemento;
    private LocalDate dataDefuncion;
    private String cidadeDefuncion;
    private String estudio;
    private String bio;
    private String texto;
    private String textoFilmmografia;
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

    public String getTextoFilmmografia() {
        return textoFilmmografia;
    }

    public void setTextoFilmmografia(String textoFilmmografia) {
        this.textoFilmmografia = textoFilmmografia;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public Personaxe() {
    }

    public Personaxe(Long idPersonaxe, String importancia, String nome, String nomeOrdenado, String nomeOrixinal, String sexo, LocalDate dataNacemento, String paisNacemento, LocalDate dataDefuncion, String cidadeDefuncion, String estudio, String bio, String texto, String textoFilmmografia, String revisado) {
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
        this.textoFilmmografia = textoFilmmografia;
        this.revisado = revisado;
    }
}
