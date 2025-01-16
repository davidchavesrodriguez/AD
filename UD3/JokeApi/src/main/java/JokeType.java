public enum JokeType {
    SINGLE("Single"),
    TWOPART("Twopart");

    private final String value;

    JokeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
