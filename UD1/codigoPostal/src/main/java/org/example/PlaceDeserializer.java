package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PlaceDeserializer implements JsonDeserializer<Place> {
    @Override
    public Place deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String placeName = jsonObject.get("place name").getAsString();
        double latitude = jsonObject.get("latitude").getAsDouble();
        double longitude = jsonObject.get("longitude").getAsDouble();
        String state = jsonObject.get("state").getAsString();
        String stateAbbreviation = jsonObject.get("state abbreviation").getAsString();

        return new Place(placeName, latitude, longitude, state, stateAbbreviation);
    }
}
