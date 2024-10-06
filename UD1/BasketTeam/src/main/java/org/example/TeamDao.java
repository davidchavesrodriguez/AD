package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDao implements Dao<Team> {
    private List<Team> teams;

    public TeamDao() {
        teams = new ArrayList<>();
    }

    @Override
    public void add(Team team) {
        if (!teams.contains(team)) {
            teams.add(team);
        }
    }

    @Override
    public void remove(Team team) {
        teams.remove(team);
    }

    @Override
    public List<Team> getAll() {
        return new ArrayList<>(teams);
    }

    @Override
    public void save(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(teams);
        }
    }

    @Override
    public void load(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            teams = (List<Team>) ois.readObject();
        }
    }
}
