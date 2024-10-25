package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PersonaSerializerDeserializer implements JsonSerializer<Persona>, JsonDeserializer<Persona> {
    public static void main(String[] args) {
        Persona persona = new Persona("Pepe", 24);
        persona.setDireccion(new Direccion("Boiro", "Cabo de Crus"));

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting()
                .registerTypeAdapter(Persona.class, new PersonaSerializerDeserializer());
        Gson gson = gsonBuilder.create();

        String json = gson.toJson(persona);
        System.out.println("JSON serializado: " + json);

        System.out.println("---------------");

        Persona personaDeserializada = gson.fromJson(json, Persona.class);
        System.out.println("Persona deserializada: " + personaDeserializada);
    }

    @Override
    public Persona deserialize(JsonElement jsonElement,
                               Type type,
                               JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String nombre = jsonObject.get("name").getAsString();
        int edad = jsonObject.get("age").getAsInt();
        return new Persona(nombre, edad);
    }

    @Override
    public JsonElement serialize(Persona persona,
                                 Type type,
                                 JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", persona.getNombre());
        jsonObject.addProperty("age", persona.getEdad());
        jsonObject.addProperty("address", persona.getCalle() + ", " + persona.getCidade());
        return jsonObject;
    }
}
