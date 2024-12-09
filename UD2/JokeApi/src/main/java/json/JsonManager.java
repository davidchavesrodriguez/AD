package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonManager {
    private static JsonManager instance;
    private Gson gson;

    private JsonManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public static JsonManager getInstance() {
        if (instance == null) {
            synchronized (JsonManager.class) {
                if (instance == null) {
                    instance = new JsonManager();
                }
            }
        }
        return instance;
    }
}
