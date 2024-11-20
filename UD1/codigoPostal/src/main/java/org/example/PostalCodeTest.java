package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PostalCodeTest {
    public static void main(String[] args) {
        // JSON de ejemplo
        String jsonExample = """
        {
          "post code": "15930",
          "country": "Spain",
          "country abbreviation": "ES",
          "places": [
            {
              "place name": "Boiro (Boiro)",
              "longitude": "-8.9",
              "state": "Galicia",
              "state abbreviation": "GA",
              "latitude": "42.65"
            },
            {
              "place name": "Vimiliro (Boiro)",
              "longitude": "-8.9",
              "state": "Galicia",
              "state abbreviation": "GA",
              "latitude": "42.65"
            }
          ]
        }
        """;

        // Configurar Gson con el TypeAdapter
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(PostalCode.class, new PostalCodeTypeAdapter())
                .setPrettyPrinting() // Para una salida bonita del JSON
                .create();

        // Paso 1: Deserialización
        System.out.println("### Deserialización ###");
        PostalCode deserializedPostalCode = gson.fromJson(jsonExample, PostalCode.class);
        System.out.println("Objeto deserializado:");
        System.out.println(deserializedPostalCode);

        // Paso 2: Serialización
        System.out.println("\n### Serialización ###");
        String serializedJson = gson.toJson(deserializedPostalCode);
        System.out.println(serializedJson);

        // Paso 3: Validación
        System.out.println("\n### Validación ###");
        if (jsonExample.replaceAll("\\s+", "").equals(serializedJson.replaceAll("\\s+", ""))) {
            System.out.println("¡La deserialización y serialización coinciden! 🎉");
        } else {
            System.out.println("La deserialización y serialización no coinciden... 😢");
        }
    }
}
