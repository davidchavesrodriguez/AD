package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Flows4 {
    public static void main(String[] args) throws URISyntaxException {
        try {
            URI uri = new URI("https://www.rcdeportivo.es/gl");

            try (InputStream inputStream = uri.toURL().openStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);) {
                while (inputStreamReader.read() != -1) {
                    System.out.println(inputStreamReader.read());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (URISyntaxException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
