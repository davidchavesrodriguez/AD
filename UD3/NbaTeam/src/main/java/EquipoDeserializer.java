import com.google.gson.*;

import java.lang.reflect.Type;

public class EquipoDeserializer implements JsonDeserializer<Equipo> {

    @Override
    public Equipo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        Equipo equipo = new Equipo();
        equipo.setNombre(jsonObject.get("name").getAsString());
        equipo.setCiudad(jsonObject.get("city").getAsString());
        equipo.setNombreCompleto(jsonObject.get("full_name").getAsString());
        equipo.setAbreviatura(jsonObject.get("abbreviation").getAsString());

        String conference = jsonObject.get("conference").getAsString();
        equipo.setConferencia(Conferencia.valueOf(conference.equals("East") ? "ESTE" : "OESTE"));

        String division = jsonObject.get("division").getAsString();
        equipo.setDivision(Division.valueOf(division.toUpperCase()));

        return equipo;
    }
}