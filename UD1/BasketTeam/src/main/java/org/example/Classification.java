package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Classification implements Serializable {
    private ArrayList<Team> teams;

    public Classification() {
        this.teams = new ArrayList<>();
    }

    public Classification(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void removeTeam(Team team) {
        teams.remove(team);
    }

    public static Classification loadClassification(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Classification) ois.readObject();
        }
    }

    public static void saveClassification(Classification classification, String file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(classification);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(teams);
        for (Team team : teams) {
            sb.append(team.toString()).append("\n");
        }
        return sb.toString();
    }
}
