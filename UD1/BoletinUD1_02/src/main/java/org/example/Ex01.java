package org.example;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) throws IOException {
//    a) Escribe un programa Java que compruebe si una ruta de archivo es absoluta o
//  relativa y si existe.
/*        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a path to scan: ");
        Path path = Paths.get(scanner.nextLine());

        if (path.isAbsolute()) {
            System.out.println("It is an absolute path.");
        } else {
            System.out.println("It is a relative path.");
        }

        if (Files.exists(path)) {
            System.out.println("The path exists.");
        } else {
            System.out.println("The path does not exist.");
        }*/


//    b) Escribe un programa Java que copie un archivo en otro, sustituyéndolo si existe, y
//  lo mueva un archivo de una ubicación en otra, empleando Files.
/*
        System.out.println("Which file do you want to copy?");
        Path sourceFile = Paths.get(scanner.nextLine());

        System.out.println("Where do you want to copy it?");
        Path targetFile = Paths.get(scanner.nextLine() + "/" + sourceFile.getFileName());
        System.out.println(targetFile);
        Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
*/


//    c) Crea un programa Java que recoja una ruta de archivo como entrada del usuario
//  (con JFileChooser) y muestre el nombre del archivo y su extensión en una ventana
//  emergente (JOptionPane). Crea un Path y recupera la posición a partir del nombre
//  del archivo (emplea el método lastIndexOf).

        JFileChooser jFileChooser= new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("/home/sanclemente.local/a22davidcr/Escritorio/AD/UD1/BoletinUD1_02"));
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.showOpenDialog(null);

        JOptionPane jOptionPane= new JOptionPane();
        jOptionPane.setMessage(jFileChooser.getSelectedFile());
        jOptionPane.setVisible(true);
    }
}
