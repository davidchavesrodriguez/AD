package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RAF4 {
    public static void main(String[] args) {
        try {
            File testFile = new File("/home/sanclemente.local/a22davidcr/Escritorio/AD/RandomAccessFile/src/main/java/org/example/test.txt");
            if (!testFile.exists()) {
                testFile.createNewFile();
                System.out.println("File created");
            }
            RandomAccessFile raf = new RandomAccessFile(testFile, "rw");
            System.out.println("What message do you want to leave?");
            Scanner scanner = new Scanner(System.in);
            raf.setLength(0);
            raf.writeUTF(scanner.nextLine());
            raf.seek(0);
            System.out.println("test.txt reads: " + raf.readUTF());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
