package org.example;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Flows4 {
    public static void main(String[] args) {
        try {
            System.out.println("Which page do you want to download?");
            Scanner sc = new Scanner(System.in);
            URI uri = new URI(sc.nextLine());

            try (InputStream inputStream = uri.toURL().openStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/page.txt");
                 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream)) {

                int ch;
                while ((ch = inputStreamReader.read()) != -1) {
                    outputStreamWriter.write(ch);
                }

                System.out.println("Page downloaded and saved successfully!");

            } catch (IOException e) {
                throw new RuntimeException("An error occurred during download or file writing", e);
            }

        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid URI", e);
        }
    }
}
