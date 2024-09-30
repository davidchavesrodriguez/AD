package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// EX 8
public class Documento {
    private File arquivo;

    public Documento(String nomeArquivo) {
        this.arquivo = new File(nomeArquivo);
    }

    public Documento(File arquivo) {
        this.arquivo = arquivo;
    }

    public boolean exists() {
        return arquivo != null && arquivo.exists();
    }

    public String readFile() throws IOException {
        if (exists()) {
            StringBuilder sb = new StringBuilder();
            try (FileReader fr = new FileReader(arquivo)) {
                int c;
                while ((c = fr.read()) != -1) {
                    sb.append((char) c);
                }
            }
            return sb.toString();
        } else {
            throw new FileNotFoundException("Non existe o arquivo");
        }
    }

    public String readFileNIO() throws IOException {
        if (!exists()) {
            throw new FileNotFoundException("Non existe o arquivo");
        }
        return Files.readString(arquivo.toPath());
    }

    public boolean writeFromString(String write){

    }

}
