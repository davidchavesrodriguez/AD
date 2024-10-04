package org.example;

import java.io.IOException;
import java.util.Scanner;

public class AppBasket {
    private static Classification classification = new Classification();
    private static final String FILE_NAME = "src/main/resources/classification.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("Basketball League Management Menu");
            System.out.println("1. Add team");
            System.out.println("2. Show classification");
            System.out.println("3. Save classification");
            System.out.println("4. Load classification");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    addTeam(sc);
                    break;
                case 2:
                    showClassification();
                    break;
                case 3:
                    saveClassification();
                    break;
                case 4:
                    loadClassification();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 5);
    }

    private static void addTeam(Scanner sc) {
        System.out.print("Enter team name: ");
        String name = sc.nextLine();
        System.out.print("Wins: ");
        int wins = sc.nextInt();
        System.out.print("Losses: ");
        int losses = sc.nextInt();
        System.out.print("Points For: ");
        int pointsFor = sc.nextInt();
        System.out.print("Points Against: ");
        int pointsAgainst = sc.nextInt();
        sc.nextLine();

        Team team = new Team(name, wins, losses, pointsFor, pointsAgainst);
        classification.addTeam(team);
    }

    private static void showClassification() {
        System.out.println("Current Classification:");
        System.out.println(classification);
    }

    private static void saveClassification() {
        try {
            Classification.saveClassification(classification, FILE_NAME);
            System.out.println("Classification saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving classification: " + e.getMessage());
        }
    }

    private static void loadClassification() {
        try {
            classification = Classification.loadClassification(FILE_NAME);
            System.out.println("Classification loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading classification: " + e.getMessage());
        }
    }
}
