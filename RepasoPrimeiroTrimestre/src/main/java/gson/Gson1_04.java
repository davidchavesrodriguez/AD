package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static java.lang.System.out;

public class Gson1_04 {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Deserializes a String
        String name= gson.fromJson("\"Silvia Plath\"", String.class);
        out.println(name);

        // Serializes an int
        gson.toJson(256, out);
        out.println();

        // Serialization
        gson.toJson("<html>", out);
        out.println();

        // Gson with no scaping
        gson = new GsonBuilder().disableHtmlEscaping().create();
        gson.toJson("<html>", out);
        out.println();
    }
}
