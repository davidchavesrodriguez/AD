package gson.trivial.model;

import java.util.Objects;

public class Category implements Comparable<Category> {
    private String name;
    private static final String DEFAULT_CATEGORY = "General";

    public Category() {
        this.name = "No Category";
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Category other) {
        if (this.name == null && other.name == null) {
            return 0;
        } else if (this.name == null) {
            return -1;
        } else if (other.name == null) {
            return 1;
        }
        return this.name.compareTo(other.name);
    }
}
