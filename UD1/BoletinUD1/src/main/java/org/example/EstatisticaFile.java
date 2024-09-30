package org.example;

import java.io.*;
import java.util.Date;

// EX 6<z
public class EstatisticaFile {
    private File arquivo;
    private int linhas;
    private int letras;
    private int espazos;

    public EstatisticaFile(String nomeArquivo) {
        this.arquivo = new File(nomeArquivo);
        this.linhas = 0;
        this.letras = 0;
        this.espazos = 0;
        calcularEstatisticas();
    }

    public File getArquivo() {
        return arquivo;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getLetras() {
        return letras;
    }

    public int getEspazos() {
        return espazos;
    }

    public boolean existe() {
        return arquivo.exists();
    }

    public Date ultimaModificacion() {
        return new Date(arquivo.lastModified());
    }

    public String getRuta() {
        return arquivo.getPath();
    }

    private void calcularEstatisticas() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                linhas++;

                for (char c : linha.toCharArray()) {
                    if (Character.isLetter(c)) {
                        letras++;
                    } else if (Character.isSpaceChar(c)) {
                        espazos++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error lendo o arquivo: " + e.getMessage());
        }
    }

    public long getLongitud() {
        return arquivo.length();
    }

    public void mostrarEstadisticas() {
        System.out.println("Ruta: " + getRuta());
        System.out.println("Número de liñas: " + getLinhas());
        System.out.println("Número de letras: " + getLetras());
        System.out.println("Número de espazos: " + getEspazos());
        System.out.println("Última modificación: " + ultimaModificacion());
        System.out.println("Lonxitude do arquivo: " + getLongitud() + " bytes");
    }

    public static void main(String[] args) {
        EstatisticaFile estatisticas = new EstatisticaFile("src/main/resources/ex6.txt");

        if (estatisticas.existe()) {
            estatisticas.mostrarEstadisticas();
        } else {
            System.out.println("Non existe o arquivo");
        }
    }
}
