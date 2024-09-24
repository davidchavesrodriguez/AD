package org.example;

import java.io.*;

public class EstatisticaFile {
    private File file;
    private int lines;
    private int letters;
    private int whitespaces;

    public EstatisticaFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getLetters() {
        return letters;
    }

    public void setLetters(int letters) {
        this.letters = letters;
    }

    public int getWhitespaces() {
        return whitespaces;
    }

    public void setWhitespaces(int whitespaces) {
        this.whitespaces = whitespaces;
    }

    public boolean exists() {
        return file.exists();
    }

    public long lastModified() {
        return file.lastModified();
    }

    public String getPath() {
        return file.getPath();
    }

    public void calculateStats() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String lineCounter;
            while ((lineCounter= bufferedReader.readLine())!=null){
                lines++; // count lines
            }
            while ()
        } catch (
                IOException e) {
            throw new

                    RuntimeException(e);
        }
    }
}
