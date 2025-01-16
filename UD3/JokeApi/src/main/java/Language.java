public enum Language {
    CS("cs"),
    DE("de"),
    EN("en"),
    ES("es"),
    FR("fr"),
    PT("pt");

    private final String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
