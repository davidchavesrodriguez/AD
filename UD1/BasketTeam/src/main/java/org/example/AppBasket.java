package org.example;

import java.io.IOException;
import java.util.Scanner;

public class AppBasket {
    private static TeamDao teamDao = new TeamDao();
    private static Classification classification = new Classification(teamDao);
    private static final String FILENAME = "classification.dat";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("a. Add Team");
            System.out.println("b. Show Classification");
            System.out.println("c. Save Classification");
            System.out.println("d. Load Classification");
            System.out.println("e. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "a":
                    addTeam();
                    break;
                case "b":
                    showClassification();
                    break;
                case "c":
                    saveClassification();
                    break;
                case "d":
                    loadClassification();
                    break;
                case "e":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void addTeam() {
        System.out.print("Enter team name: ");
        String name = scanner.nextLine();
        System.out.print("Enter wins: ");
        int wins = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter losses: ");
        int losses = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter points for: ");
        int pointsFor = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter points against: ");
        int pointsAgainst = Integer.parseInt(scanner.nextLine());

        Team team = new Team(name, wins, losses, pointsFor, pointsAgainst);
        classification.addTeam(team);
    }

    private static void showClassification() {
        System.out.println(classification);
    }

    private static void saveClassification() {
        try {
            classification.saveClassification(FILENAME);
            System.out.println("Classification saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving classification: " + e.getMessage());
        }
    }

    private static void loadClassification() {
        try {
            classification.loadClassification(FILENAME);
            System.out.println("Classification loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading classification: " + e.getMessage());
        }
    }
}
