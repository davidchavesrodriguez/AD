package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PostalCodeDeserializer implements JsonDeserializer<PostalCode> {
    @Override
    public PostalCode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        // Convertimos a obxecto JSON
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Extraemos os atributos do JSON
        String postalCode = jsonObject.get("postalCode").getAsString();
        String country = jsonObject.get("country").getAsString();
        String countryAbbreviation = jsonObject.get("countryAbbreviation").getAsString();

        // Extraemos a lista tamén
        JsonArray placesArray = jsonObject.getAsJsonArray("places");
        List<Place> places = new ArrayList<>();

        for (JsonElement placeElement : placesArray) {
            Place place = jsonDeserializationContext.deserialize(placeElement, Place.class);
            places.add(place);
        }
        return new PostalCode(postalCode, country, countryAbbreviation, places);
    }

}
