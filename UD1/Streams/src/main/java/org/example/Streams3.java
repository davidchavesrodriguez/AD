package org.example;

import javax.swing.*;
import java.io.*;
import java.util.Collection;

public class Flows3 {
    private static final String SERIALIZATION_FILE = "src/main/resources/studentsCollection.dat";

    public static void main(String[] args) {
        PersonCollection collection = loadCollection();

        while (true) {
            String[] options = {"Add student", "View student list", "View specific student", "Exit"};
            int selection = JOptionPane.showOptionDialog(
                    null,
                    "Select an option:",
                    "Student Management",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (selection) {
                case 0:
                    addStudent(collection);
                    break;
                case 1:
                    viewStudentList(collection);
                    break;
                case 2:
                    viewSpecificStudent(collection);
                    break;
                case 3:
                    saveCollection(collection);
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent(PersonCollection collection) {
        String name = JOptionPane.showInputDialog("Enter the student's name:");
        String ageStr = JOptionPane.showInputDialog("Enter the student's age:");
        try {
            int age = Integer.parseInt(ageStr);
            collection.addPerson(new Person(name, age));
            JOptionPane.showMessageDialog(null, "Student added successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid age. Please enter a number.");
        }
    }

    private static void viewStudentList(PersonCollection collection) {
        StringBuilder list = new StringBuilder("Student list:\n");
        for (Person p : collection.getPersonList()) {
            list.append(p.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, list.toString());
    }

    private static void viewSpecificStudent(PersonCollection collection) {
        String indexStr = JOptionPane.showInputDialog("Enter the number of the student you want to view:");
        try {
            int index = Integer.parseInt(indexStr) - 1;
            Person student = collection.getPerson(index);
            if (student != null) {
                JOptionPane.showMessageDialog(null, student.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Student not found.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number. Please enter a number.");
        }
    }

    private static PersonCollection loadCollection() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIALIZATION_FILE))) {
            try {
                return (PersonCollection) ois.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            return new PersonCollection();
        }
    }

    private static void saveCollection(PersonCollection collection) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZATION_FILE))) {
            oos.writeObject(collection);
            JOptionPane.showMessageDialog(null, "Collection saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving the collection: " + e.getMessage());
        }
    }
}