package org.example;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Examen {

    private String subject;
    private LocalDateTime date;
    private List<String> students;

    // default constructor
    public Examen() {
    }

    // constructor
    public Examen(String subject, LocalDateTime date, List<String> students) {
        this.subject = subject;
        this.date = date;
        this.students = students;
    }

    // Getters y setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "subject='" + subject + '\'' +
                ", date=" + date +
                ", students=" + students +
                '}';
    }

    public static void main(String[] args) {
        // create object
        LocalDateTime examDate = LocalDateTime.of(2024, Month.NOVEMBER, 12, 10, 0);
        List<String> students = Arrays.asList(
                "Rosalía de Castro",
                "Concepción Arenal (Conchi)",
                "Emilia Pardo Bazán",
                "Sofía Casanova",
                "Pepa Calo"
        );
        Examen exam = new Examen("Acceso a Datos", examDate, students);

        // serializate json object and save
        try (Jsonb jsonb = JsonbBuilder.create()) {
            String json = jsonb.toJson(exam);
            Path filePath = Paths.get("src/main/resources/accesoADatos.json");
            Files.write(filePath, json.getBytes());
            System.out.println("JSON saved");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // read Json
        try {
            Path filePath = Paths.get("src/main/resources/accesoADatos.json");
            String content = Files.readString(filePath);
            System.out.println("JSON data:");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // deserializate and create Java object
        try (Jsonb jsonb = JsonbBuilder.create()) {
            Path filePath = Paths.get("src/main/resources/accesoADatos.json");
            String jsonContent = Files.readString(filePath);
            Examen deserializedExam = jsonb.fromJson(jsonContent, Examen.class);
            System.out.println("deserialized object:");
            System.out.println(deserializedExam);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
