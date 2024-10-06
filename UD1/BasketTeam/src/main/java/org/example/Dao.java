package org.example;

import java.io.IOException;
import java.util.List;

public interface Dao<T> {
    void add(T t);
    void remove(T t);
    List<T> getAll();
    void save(String filename) throws IOException;
    void load(String filename) throws IOException, ClassNotFoundException;
}
