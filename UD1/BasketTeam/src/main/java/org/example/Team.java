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

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getPointsFor() {
        return pointsFor;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public int getPoints() {
        return wins * 2 + losses;
    }

    public int getGamesPlayed() {
        return wins + losses;
    }

    public int getPointDifference() {
        return pointsFor - pointsAgainst;
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
    public int compareTo(Team other) {
        int pointComparison = Integer.compare(other.getPoints(), this.getPoints());
        if (pointComparison == 0) {
            return Integer.compare(other.getPointDifference(), this.getPointDifference());
        }
        return pointComparison;
    }

    @Override
    public String toString() {
        return name + " - Points: " + getPoints() + ", Point Difference: " + getPointDifference();
    }
}
