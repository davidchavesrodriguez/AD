package org.example;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Classification {
    private TeamDao teamDao;

    public Classification(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void addTeam(Team team) {
        teamDao.add(team);
    }

    public void removeTeam(Team team) {
        teamDao.remove(team);
    }

    public List<Team> getOrderedTeams() {
        List<Team> teams = teamDao.getAll();
        Collections.sort(teams);
        return teams;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Team team : getOrderedTeams()) {
            sb.append(team).append("\n");
        }
        return sb.toString();
    }

    public void saveClassification(String filename) throws IOException, IOException {
        teamDao.save(filename);
    }

    public void loadClassification(String filename) throws IOException, ClassNotFoundException {
        teamDao.load(filename);
    }
}
