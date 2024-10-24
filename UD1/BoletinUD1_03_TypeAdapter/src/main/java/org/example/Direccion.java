package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

public class Direccion {
    private String ciudad;
    private String calle;

    public Direccion() {
    }

    public Direccion(String ciudad, String calle) {
        this.ciudad = ciudad;
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "ciudad='" + ciudad + '\'' +
                ", calle='" + calle + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Direccion direccion= new Direccion("Boiro", "Rua Principal");
        GsonBuilder gsonBuilder= new GsonBuilder();
        Gson gson= gsonBuilder.setPrettyPrinting()
                .registerTypeAdapter(Direccion.class, new JsonSerializer() {
                    @Override
                    public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
                        return null;
                    }
                })
                .create();

        String json= gson.toJson(direccion);
        System.out.println(json);

        Direccion direccionDeserializada= gson.fromJson(json, Direccion.class);
        System.out.println(direccionDeserializada);
    }
}
