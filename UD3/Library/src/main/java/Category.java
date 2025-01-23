public enum Category {
    NOVEL("Novel"),
    POETRY("Poetry"),
    ESSAY("Essay"),
    THEATER("Theater"),
    OTHERS("Others");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static Category fromString(String value) {
        for (Category category : Category.values()) {
            if (category.displayName.equalsIgnoreCase(value.trim())) {
                return category;
            }
        }
        throw new IllegalArgumentException("Not valid: " + value);
    }
}