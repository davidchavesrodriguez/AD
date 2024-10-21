package org.example;

import java.util.Objects;

public final class Category {
    private static final String DEFAULT_CATEGORY = "General";
    private final String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
        this.name = "No category";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
