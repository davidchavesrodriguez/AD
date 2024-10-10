package org.example;

import java.io.StringWriter;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;
import java.io.StringWriter;

public class JsonPExemplo {

    public static void main(String[] args) {
        // Crear un objeto JSON usando JSON-P
        JsonObject objetoJson = Json.createObjectBuilder()
                .add("name", "David")
                .add("age", 22)
                .add("country", "Galiza")
                .build();

        // Convertir el objeto JSON a una cadena
        StringWriter stringWriter = new StringWriter();
        try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
            jsonWriter.writeObject(objetoJson);
        }

        // Imprimir la cadena JSON
        String strJson = stringWriter.toString();
        System.out.println("JSON Resultante (JSON-P):");
        System.out.println(strJson);
    }
}