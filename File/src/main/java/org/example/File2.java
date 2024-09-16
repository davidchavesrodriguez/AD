package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class File2 {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser("/media/a22davidcr/a22davidcr_documentos");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fc.showOpenDialog((Component) null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fc.getSelectedFile();
            File[] fileList = selectedDirectory.listFiles();

            if (fileList != null) {
                System.out.println("Files in the selected directory:");
//                System.out.println(Arrays.toString(fileList));
                int totalSize= 0;
                for (int i = 0; i < fileList.length; i++) {
                    System.out.println(fileList[i]);

                }
            } else {
                System.out.println("The selected directory is empty or could not be read.");
            }
        } else {
            System.out.println("No directory selected.");
        }
    }
}
