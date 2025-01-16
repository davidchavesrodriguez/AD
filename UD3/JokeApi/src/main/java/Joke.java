import jakarta.persistence.*;

import java.util.List;

@Entity
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private JokeType jokeType;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "flags", joinColumns = @JoinColumn(name = "joke_id"))
    @Column(name = "flag")
    @Enumerated(EnumType.STRING)
    private final List<Flag> flags;

    private String jokeText;
    private String answer;

    @Enumerated(EnumType.STRING)
    private Language language;

    public Joke() {
        this.flags = null;
    }

    public Joke(List<Flag> flags) {
        this.flags = flags;
    }

    public Joke(List<Flag> flags, Language language, String answer, String jokeText, JokeType jokeType, Category category, int id) {
        this.flags = flags;
        this.language = language;
        this.answer = answer;
        this.jokeText = jokeText;
        this.jokeType = jokeType;
        this.category = category;
        this.id = id;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public JokeType getJokeType() {
        return jokeType;
    }

    public void setJokeType(JokeType jokeType) {
        this.jokeType = jokeType;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public String getJokeText() {
        return jokeText;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
