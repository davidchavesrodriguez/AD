import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idPersona;

    @Column(name = "nome_apelidos", nullable = false)
    private String nomeApelidos;

    @Transient
    private String nome;

    @Transient
    private String apelidos;

    @Column(name = "idade", nullable = false)
    private int idade;

    @Transient
    private LocalDate dataNacemento;

    @Convert(converter = SexoConverter.class)
    @Column(name = "sexo", nullable = false, length = 1)
    private Sexo sexo;

    @Convert(converter = EstadoCivilConverter.class)
    @Column(name = "estado_civil", nullable = false)
    private EstadoCivil estadoCivil;

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    public Persona() {
    }

    public Persona(String nome, String apelidos, LocalDate dataNacemento,
                   Sexo sexo, EstadoCivil estadoCivil, byte[] foto) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.dataNacemento = dataNacemento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.foto = foto;
    }

//    public Persona(String nomeApelidos, String nome, String apelidos, int idade,
//                   LocalDate dataNacemento, Sexo sexo, byte[] foto,
//                   EstadoCivil estadoCivil) {
//        this.nomeApelidos = nomeApelidos;
//        this.nome = nome;
//        this.apelidos = apelidos;
//        this.idade = idade;
//        this.dataNacemento = dataNacemento;
//        this.sexo = sexo;
//        this.foto = foto;
//        this.estadoCivil = estadoCivil;
//    }

    // Getters and Setters
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNomeApelidos() {
        return nomeApelidos;
    }

    public void setNomeApelidos(String nomeApelidos) {
        this.nomeApelidos = nomeApelidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(LocalDate dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        String[] palabras = str.toLowerCase().split(" ");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : palabras) {
            resultado.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1)).append(" ");
        }
        return resultado.toString().trim();
    }

    @PrePersist
    @PreUpdate
    private void syncToDatabaseFields() {
        if (nome != null && apelidos != null) {
            this.nomeApelidos = capitalize(apelidos) + ", " + capitalize(nome);
        }
        if (dataNacemento != null) {
            this.idade = Period.between(dataNacemento, LocalDate.now()).getYears();
        }
    }

    @PostLoad
    private void syncFromDatabaseFields() {
        if (nomeApelidos != null && nomeApelidos.contains(", ")) {
            String[] partes = nomeApelidos.split(", ");
            this.apelidos = partes[0].trim();
            this.nome = partes[1].trim();
        }
        this.dataNacemento = LocalDate.now().minusYears(idade);
    }


}
