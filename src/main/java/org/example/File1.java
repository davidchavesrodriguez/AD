package org.example;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

public class File1 {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser("/media/a22davidcr/a22davidcr_documentos");

        int returnValue = fc.showOpenDialog((Component) null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();

            if (f.exists()) {
                System.out.println("Path: " + f.getAbsolutePath());
                System.out.println("Name: " + f.getName());
                System.out.println("Size: " + f.length() + " bytes");
                System.out.println("Last Mod: " + f.lastModified());
                System.out.println("Is a directory? " + f.isDirectory());
            } else {
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
        } else {
            System.out.println("No file selected.");
        }
    }
}
