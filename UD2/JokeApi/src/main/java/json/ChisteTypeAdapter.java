package json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import entities.Chiste;
import entities.Flag;

import java.io.IOException;

public class ChisteTypeAdapter extends TypeAdapter<Chiste> {

    @Override
    public void write(JsonWriter out, Chiste chiste) throws IOException {
        // Escribir el objeto Chiste como JSON
        out.beginObject();
        out.name("id").value(chiste.getId());
        out.name("category").value(chiste.getCategoriaString());
        out.name("lang").value(chiste.getLenguajeString());
        out.name("type").value(chiste.getTipoString());
        out.name("setup").value(chiste.getChiste());
        if (chiste.getRespuesta() != null && !chiste.getRespuesta().isEmpty()) {
            out.name("delivery").value(chiste.getRespuesta());
        }

        // Serializar las banderas
        out.name("flags");
        out.beginObject();
        for (Flag flag : Flag.values()) {
            out.name(flag.getNombre()).value(chiste.containsFlag(flag));
        }
        out.endObject();

        out.endObject();
    }

    @Override
    public Chiste read(JsonReader in) throws IOException {
        // Leer el JSON y convertirlo en un objeto Chiste
        Chiste chiste = new Chiste();

        in.beginObject();
        while (in.hasNext()) {
            String name = in.nextName();

            switch (name) {
                case "id":
                    chiste.setId(in.nextInt());
                    break;

                case "category":
                    chiste.setCategoria(in.nextString());
                    break;

                case "lang":
                    chiste.setLenguaje(in.nextString());
                    break;

                case "type":
                    chiste.setTipo(in.nextString());
                    break;

                case "setup":
                    chiste.setChiste(in.nextString());
                    break;

                case "delivery":
                    if (in.peek() != JsonToken.NULL) {
                        chiste.setRespuesta(in.nextString());
                    } else {
                        in.nextNull();
                    }
                    break;

                case "flags":
                    in.beginObject();
                    while (in.hasNext()) {
                        String flagName = in.nextName();
                        boolean value = in.nextBoolean();
                        if (value) {
                            Flag flag = Flag.getFlag(flagName);
                            if (flag != null) {
                                chiste.addFlag(flag);
                            }
                        }
                    }
                    in.endObject();
                    break;

                default:
                    in.skipValue(); // Ignorar campos desconocidos
            }
        }
        in.endObject();

        return chiste;
    }
}
