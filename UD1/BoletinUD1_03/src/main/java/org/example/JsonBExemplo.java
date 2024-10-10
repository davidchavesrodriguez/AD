package org.example;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.io.Serializable;

public class JsonBExemplo {

    public static void main(String[] args) {
        // Crear un objeto Java
        Persona persona = new Persona("Otto", 4, "Santiago de Compostela");

        // Crear un objeto Jsonb
        Jsonb jsonb = JsonbBuilder.create();

        // Convertir el objeto Java a JSON
        String strJson = jsonb.toJson(persona);

        // Imprimir la cadena JSON
        System.out.println("JSON Resultante (JSON-B):");
        System.out.println(strJson);
    }

    // Clase de ejemplo
    static class Persona implements Serializable {
        String nome;
        int idade;
        String cidade;

        public Persona(String nome, int idade, String cidade) {
            this.nome = nome;
            this.idade = idade;
            this.cidade = cidade;
        }
    }
}