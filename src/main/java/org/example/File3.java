package org.example;

import javax.swing.*;

public class File3 {
    public static void main(String[] args) {
        // Options for the dialog
        Object[] menuOptions = {"Create Folder", "List Folders", "Delete File or Folder", "Move File or Folder"};

        // Show the dialog with custom options
        int optionSelected = JOptionPane.showOptionDialog(
                null,
                "Please choose an option:", // Message to display
                "File Management", // Dialog title
                JOptionPane.DEFAULT_OPTION, // Option type, allows custom options
                JOptionPane.QUESTION_MESSAGE, // Message type
                null, // No custom icon
                menuOptions, // The custom options
                menuOptions[1] // Default selected option (Delete File or Folder)
        );

        // Output the result to the console for testing
        System.out.println("Option selected: " + menuOptions[optionSelected]);
    }
}
