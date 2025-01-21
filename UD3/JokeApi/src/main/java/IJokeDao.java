import java.io.Writer;

public interface IJokeDAO {

    public String getRandomJokeAsString();

    public String getJokeAsString(String categoria, String[] tipo, String[] banderas);

    public String getJokeAsString(String categoria, String[] tipo, String[] banderas, String idioma);

    public Joke getRandomJoke();

    public Joke getJoke(String categoria, String[] tipo, String[] banderas);

    public Joke getJoke(String categoria, String[] tipo, String[] banderas, String idioma);

    public Joke getJokeById(int id);


    public void saveJokeAsJson(Joke chiste, Writer writer);

}