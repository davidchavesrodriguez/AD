package local.sanclemente.ad.exame.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import local.sanclemente.ad.exame.model.Genero;
import local.sanclemente.ad.exame.model.Imagen;
import local.sanclemente.ad.exame.model.Juego;
import local.sanclemente.ad.exame.model.Plataforma;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JuegoTypeAdapter extends TypeAdapter<Juego> {

    @Override
    public void write(JsonWriter out, Juego juego) throws IOException {
        out.beginObject();
        out.name("id").value(juego.getIdJuego());
        out.name("title").value(juego.getTitulo());
        out.name("thumbnail").value(juego.getMiniatura());
        out.name("short_description").value(juego.getDescripcionCorta());
        out.name("description").value(juego.getDescripcion());
        out.name("game_url").value(juego.getUrl());
        out.name("developer").value(juego.getDesarrollador());
        out.name("publisher").value(juego.getEditor());
        out.name("release_date").value(juego.getFecha().toString());
        out.name("genre").value(juego.getGenero().getNombre());
        out.name("platform").value(juego.getPlataforma().getNombre());

        out.name("screenshots").beginArray();
        for (Imagen img : juego.getImagenes()) {
            out.beginObject();
            out.name("image").value(img.getUrl());
            out.endObject();
        }
        out.endArray();

        out.endObject();
    }

    @Override
    public Juego read(JsonReader reader) throws IOException {
        Juego juego = new Juego();
        List<Imagen> imagenes = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "id":
                    juego.setIdJuego(reader.nextInt());
                    break;
                case "title":
                    juego.setTitulo(reader.nextString());
                    break;
                case "thumbnail":
                    juego.setMiniatura(reader.nextString());
                    break;
                case "short_description":
                    juego.setDescripcionCorta(reader.nextString());
                    break;
                case "description":
                    juego.setDescripcion(reader.nextString());
                    break;
                case "game_url":
                    juego.setUrl(reader.nextString());
                    break;
                case "developer":
                    juego.setDesarrollador(reader.nextString());
                    break;
                case "publisher":
                    juego.setEditor(reader.nextString());
                    break;
                case "release_date":
                    juego.setFecha(LocalDate.parse(reader.nextString(), formatter));
                    break;
                case "genre":
                    juego.setGenero(new Genero(reader.nextString()));
                    break;
                case "platform":
                    juego.setPlataforma(new Plataforma(reader.nextString()));
                    break;
                case "screenshots":
                    reader.beginArray();
                    while (reader.hasNext()) {
                        reader.beginObject();
                        while (reader.hasNext()) {
                            if (reader.nextName().equals("image")) {
                                imagenes.add(new Imagen(reader.nextString()));
                            } else {
                                reader.skipValue();
                            }
                        }
                        reader.endObject();
                    }
                    reader.endArray();
                    break;
                default:
                    reader.skipValue();
            }
        }
        reader.endObject();
        juego.setImagenes(imagenes);
        return juego;
    }
}
