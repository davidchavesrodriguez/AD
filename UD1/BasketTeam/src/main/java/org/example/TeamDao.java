package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TeamDao implements Dao<Team, String> {
    private Path path;

    public TeamDao(Path path) {
        this.path = path;
    }

    @Override
    public Team get(String id) throws IOException {
        List<Team> teams = getAll();
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(id)) {
                return team;
            }
        }
        return null;
    }

    @Override
    public List<Team> getAll() throws IOException {
        if (!Files.exists(path)) {
            return List.of();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
                return (List<Team>) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return List.of();
            }
        }
    }


    @Override
    public boolean save(Team obxecto) throws IOException {
        List<Team> teams = getAll();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oos.writeObject(teams);
        }
        return true;
    }

    @Override
    public void delete(Team obx) {

    }

    @Override
    public void update(Team obx) {

    }
}

