package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class AppPrediccion {
    public static final String URL_STRING = "https://servizos.meteogalicia.gal/mgrss/predicion/" +
            "jsonPredConcellos.action?idConc=15078&request_locale=gl";

    public static void main(String[] args) {
        try {
            URI uri = new URI(URL_STRING);
            URL url = uri.toURL();
            URLConnection connection = url.openConnection();

            try (InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

                // Configura Gson con el adaptador PrediccionAdapter
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Prediccion.class, new PredicionAdapter())
                        .create();

                // Deserializa el JSON en un objeto Prediccion
                Prediccion prediccion = gson.fromJson(bufferedReader, Prediccion.class);

                // Ejemplo de cómo mostrar los datos deserializados
                System.out.println("Concello: " + prediccion.getConcello().getNomeConcello());
                System.out.println("ID Concello: " + prediccion.getConcello().getIdConcello());

                // Mostrar predicciones diarias
                for (PrediccionDia dia : prediccion.getListaPredDiaConcello()) {
                    System.out.println("Fecha: " + dia.getDataPredicion());
                    System.out.println("Temperatura Máxima: " + dia.getTemperaturaMaxima());
                    System.out.println("Temperatura Mínima: " + dia.getTemperaturaMinima());
                    System.out.println("-----");
                }

            }
        } catch (URISyntaxException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
