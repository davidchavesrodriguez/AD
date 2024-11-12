package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConcellosAdapter extends TypeAdapter<List<Concello>> {

    @Override
    public void write(JsonWriter writer, List<Concello> concellos) throws IOException {

    }

    @Override
    public List<Concello> read(JsonReader reader) throws IOException {
        List<Concello> concellos = new ArrayList<>();
        if (reader.peek() == JsonToken.BEGIN_ARRAY) {
            reader.beginArray();
            while (reader.hasNext()) {
                concellos.add(getConcello(reader));
            }

            reader.endArray();
        }
        return concellos;
    }

    private Concello getConcello(JsonReader reader) throws IOException {
        String nomeConcello = null;
        Integer idConcello = null;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "nombre":
                    nomeConcello = reader.nextString();
                    break;
                case "id":
                    if (reader.peek() != JsonToken.NULL) {
                        idConcello = reader.nextInt();
                    } else {
                        reader.skipValue();
                    }
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }

        reader.endObject();
        return new Concello(nomeConcello, idConcello);
    }

    public static void main(String[] args) throws IOException {
        Type tipo = new TypeToken<List<Concello>>() {}.getType();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(tipo, new ConcellosAdapter())
                .create();

        List<Concello> concellos = gson.fromJson(Files.newBufferedReader(Paths.get("src/main/resources/concellos.json")), tipo);
        concellos.forEach(System.out::println);
    }
}
