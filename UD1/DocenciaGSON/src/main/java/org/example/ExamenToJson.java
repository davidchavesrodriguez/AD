package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ExamenToJson {
    public static void main(String[] args) {
        try {
            // Create Gson instance with pretty printing and date format yyyy-MM-dd HH:mm
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .setDateFormat("yyyy-MM-dd HH:mm")
                    .create();

            // List of 20th-century female poets
            List<String> participants = Arrays.asList(
                    "Gabriela Mistral", "Sylvia Plath", "Alejandra Pizarnik", "Emily Dickinson", "Anne Sexton");

            // Create a specific date using LocalDateTime and convert to Date
            Date specificDate = Date.from(
                    LocalDateTime.of(2024, 11, 12, 9, 45)
                            .atZone(ZoneId.systemDefault())
                            .toInstant());

            // Create Examen object
            Examen exam = new Examen("Acceso a Datos", specificDate, participants);

            // Convert the Examen object to JSON
            String json = gson.toJson(exam);

            // Save the JSON to a file called accesoADatos.json
            Path path = Paths.get("src/main/resources/accesoADatos.json");
            Files.write(path, json.getBytes());

            // Display the content of the JSON file on the screen
            System.out.println("Content of the saved JSON file:");
            System.out.println(new String(Files.readAllBytes(path)));

            // Retrieve the file and store it in a new Java object
            String jsonFromFile = new String(Files.readAllBytes(path));

            // Deserialize directly into the Examen class
            Examen newExam = gson.fromJson(jsonFromFile, Examen.class);

            // Display the new Java object retrieved from the JSON file
            System.out.println("\nNew Examen object retrieved from the file:");
            System.out.println(newExam);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
