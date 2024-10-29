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
        Direccion direccionMadrid= new Direccion("Madrid", "Zoo Nacional");
        GsonBuilder gsonBuilder= new GsonBuilder();
        Gson gson= gsonBuilder.setPrettyPrinting()
                .registerTypeAdapter(Direccion.class, (JsonSerializer<Direccion>) (o, type, jsonSerializationContext) -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("address", o.getCalle()+ ", " + o.getCiudad());
                    return jsonObject;
                })
                .registerTypeAdapter(Direccion.class, (JsonDeserializer<Direccion>) (jsonElement, type, jsonDeserializationContext) -> {
                    JsonObject jsonObject= jsonElement.getAsJsonObject();
                    String address= jsonObject.get("address").getAsString();
                    String[] partes= address.split(", ");
                    return new Direccion(partes[1], partes[0]);
                })
                .create();

        // Serializar
        String json = gson.toJson(direccion);
        String jsonMadrid= gson.toJson(direccionMadrid);
        System.out.println("--------------------------------");
        System.out.println("Serialized JSON: " + json);
        System.out.println("--------------------------------");
        System.out.println("Serialized Madrid: " + jsonMadrid);

        // Deserializar
        Direccion direccionDeserializada = gson.fromJson(json, Direccion.class);
        Direccion direccionMadridDeserializada= gson.fromJson(jsonMadrid, Direccion.class);
        System.out.println("--------------------------------");
        System.out.println("Deserialized Object: " + direccionDeserializada);
        System.out.println("--------------------------------");
        System.out.println("Deserialized Madrid: " + direccionMadridDeserializada);
        System.out.println("--------------------------------");

    }
}
