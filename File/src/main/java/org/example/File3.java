package org.example;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class File3 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Please, choose an option: " + "\n")
                .append("1- Create directory" + "\n")
                .append("2- List all files" + "\n")
                .append("3- Delete directory" + "\n")
                .append("4- Move/rename directory" + "\n")
                .append("5- Cancel" + "\n");
        System.out.println(stringBuilder.toString());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Waiting for input...");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Option chosen: " + choice);

        switch (choice) {
            case 1:
                createDirectory();
                break;
            case 2:
                listFiles();
                break;
            case 3:
                deleteDirectory();
                break;
            case 4:
                moveOrRenameDirectory();
                break;
            case 5:
                System.out.println("Operation canceled.");
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    public static void createDirectory() {
        JFileChooser jfilechooser = new JFileChooser();
        jfilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfilechooser.setDialogTitle("Select location to create a new directory");

        int returnValue = jfilechooser.showDialog(null, "Select Directory");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = jfilechooser.getSelectedFile();
            System.out.println("Enter the name of the new directory:");
            Scanner scanner = new Scanner(System.in);
            String newDirectoryName = scanner.nextLine();

            File newDirectory = new File(selectedDirectory, newDirectoryName);
            if (newDirectory.mkdirs()) {
                System.out.println("Directory created successfully: " + newDirectory.getPath());
            } else {
                System.out.println("Failed to create directory.");
            }
        } else {
            System.out.println("No directory selected.");
        }
    }

    public static void listFiles() {
        JFileChooser jfilechooser = new JFileChooser();
        jfilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfilechooser.setDialogTitle("Select a directory to list files");

        int returnValue = jfilechooser.showDialog(null, "Select Directory");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = jfilechooser.getSelectedFile();
            File[] files = selectedDirectory.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("No directory selected.");
        }
    }

    public static void deleteDirectory() {
        JFileChooser jfilechooser = new JFileChooser();
        jfilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfilechooser.setDialogTitle("Select a directory to delete");

        int returnValue = jfilechooser.showDialog(null, "Select Directory");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = jfilechooser.getSelectedFile();
            if (selectedDirectory.exists() && selectedDirectory.isDirectory()) {
                if (deleteDirectoryRecursively(selectedDirectory)) {
                    System.out.println("Directory deleted successfully.");
                } else {
                    System.out.println("Failed to delete directory.");
                }
            } else {
                System.out.println("Invalid directory path.");
            }
        } else {
            System.out.println("No directory selected.");
        }
    }

    public static boolean deleteDirectoryRecursively(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDirectoryRecursively(file);
                }
            }
        }
        return directory.delete();
    }

    public static void moveOrRenameDirectory() {
        JFileChooser jfilechooser = new JFileChooser();
        jfilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfilechooser.setDialogTitle("Select a directory to move/rename");

        int returnValue = jfilechooser.showDialog(null, "Select Directory");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = jfilechooser.getSelectedFile();
            if (selectedDirectory.exists() && selectedDirectory.isDirectory()) {
                System.out.println("Enter the new path or new name for the directory:");
                Scanner scanner = new Scanner(System.in);
                String newDirectoryPath = scanner.nextLine();
                File newDirectory = new File(newDirectoryPath);

                if (newDirectory.exists()) {
                    System.out.println("A directory with that name already exists.");
                } else if (selectedDirectory.renameTo(newDirectory)) {
                    System.out.println("Directory moved/renamed successfully.");
                } else {
                    System.out.println("Failed to move/rename directory.");
                }
            } else {
                System.out.println("Invalid directory path.");
            }
        } else {
            System.out.println("No directory selected.");
        }
    }
}
