package org.example;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostalCodeTypeAdapter extends TypeAdapter<PostalCode> {
    @Override
    public void write(JsonWriter jsonWriter, PostalCode postalCode) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("post code").value(postalCode.getPostalCode());
        jsonWriter.name("country").value(postalCode.getCountry());
        jsonWriter.name("country abbreviation").value(postalCode.getCountryAbbreviation());

        jsonWriter.name("places");
        jsonWriter.beginArray();
        for (Place place : postalCode.getPlaces()) {
            jsonWriter.beginObject();
            jsonWriter.name("place name").value(place.getPlaceName());
            jsonWriter.name("latitude").value(String.valueOf(place.getLatitude()));
            jsonWriter.name("longitude").value(String.valueOf(place.getLongitude()));

            jsonWriter.name("state").value(place.getState());
            jsonWriter.name("state abbreviation").value(place.getStateAbbreviation());
            jsonWriter.endObject();
        }
        jsonWriter.endArray();
        jsonWriter.endObject();
    }


    @Override
    public PostalCode read(JsonReader jsonReader) throws IOException {
        String postalCode = null;
        String country = null;
        String countryAbbreviation = null;
        List<Place> places = new ArrayList<>();

        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();
            switch (name) {
                case "post code" -> postalCode = jsonReader.nextString();
                case "country" -> country = jsonReader.nextString();
                case "country abbreviation" -> countryAbbreviation = jsonReader.nextString();
                case "places" -> {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        places.add(readPlace(jsonReader));
                    }
                    jsonReader.endArray();
                }
            }
        }
        jsonReader.endObject();

        return new PostalCode(postalCode, country, countryAbbreviation, places);
    }

    private Place readPlace(JsonReader jsonReader) throws IOException {
        String placeName = null;
        double latitude = 0;
        double longitude = 0;
        String state = null;
        String stateAbbreviation = null;

        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String field = jsonReader.nextName();
            switch (field) {
                case "place name" -> placeName = jsonReader.nextString();
                case "latitude" -> latitude = Double.parseDouble(jsonReader.nextString());
                case "longitude" -> longitude = Double.parseDouble(jsonReader.nextString());
                case "state" -> state = jsonReader.nextString();
                case "state abbreviation" -> stateAbbreviation = jsonReader.nextString();
            }
        }
        jsonReader.endObject();

        return new Place(placeName, latitude, longitude, state, stateAbbreviation);
    }

}