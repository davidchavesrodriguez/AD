package org.example;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.swing.JFileChooser;

public class File1 {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser("/media/a22davidcr/a22davidcr_documentos");
        int returnValue = fc.showOpenDialog((Component) null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            if (selectedFile.exists()) {
                printFileDetails(selectedFile);
            } else {
                handleFileCreation(selectedFile);
            }
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void printFileDetails(File f) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Path: ").append(f.getAbsolutePath()).append("\n")
                .append("Name: ").append(f.getName()).append("\n")
                .append("Size: ").append(f.length()).append(" bytes").append("\n")
                .append("Last mod: ").append(new Date(f.lastModified())).append("\n")
                .append("Is it a directory? ").append(f.isDirectory() ? "It is a directory." : "It is NOT a directory.");
        System.out.println(strBuilder);
    }

    private static void handleFileCreation(File f) {
        System.out.println("The selected file does not exist.");
        try {
            if (f.createNewFile()) {
                System.out.println("New file created: " + f.getAbsolutePath());
            } else {
                System.out.println("Failed to create the file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }
}
