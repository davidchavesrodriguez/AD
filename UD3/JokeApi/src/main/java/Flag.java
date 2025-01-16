public enum Flag {
    EXPLICIT("Explicit"),
    NSFW("NSFW"),
    RELIGIOUS("Religious"),
    POLITICAL("Political"),
    RACIST("Racist"),
    SEXIST("Sexist");

    private final String value;

    Flag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
