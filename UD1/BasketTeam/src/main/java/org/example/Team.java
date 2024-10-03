package org.example;

import java.io.Serializable;

public class Team implements Comparable<Team>, Serializable {
    private String name;
    private int wins;
    private int losses;
    private int pointsFor;
    private int pointsAgainst;

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, int wins, int losses, int pointsFor, int pointsAgainst) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.pointsFor = pointsFor;
        this.pointsAgainst = pointsAgainst;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPointsFor() {
        return pointsFor;
    }

    public void setPointsFor(int pointsFor) {
        this.pointsFor = pointsFor;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public void setPointsAgainst(int pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }

    // Derived methods
    public int getPoints() {
        return wins * 2;
    }

    public int getGamesPlayed() {
        return wins + losses;
    }

    public int getPointDifference() {
        return pointsFor - pointsAgainst;
    }

    @Override
    public int compareTo(Team otherTeam) {
        if (this.getPoints() == otherTeam.getPoints()) {
            return Integer.compare(otherTeam.getPointDifference(), this.getPointDifference());
        }
        return Integer.compare(otherTeam.getPoints(), this.getPoints());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Team team = (Team) obj;
        return name.equalsIgnoreCase(team.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return name + " - Points: " + getPoints() + ", GP: " + getGamesPlayed() +
                ", PF: " + pointsFor + ", PA: " + pointsAgainst + ", Diff: " + getPointDifference();
    }
}
