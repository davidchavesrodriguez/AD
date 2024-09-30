package org.example;

import java.io.*;

public class Flows2 {
    public static void main(String[] args) {
        Person julio = new Person("Julio", 22);
        Person aurora = new Person("Aurora", 35);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/students.dat"))) {
            oos.writeObject(julio);
            oos.writeObject(aurora);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/students.dat"))) {
            Person deserializedJulio = (Person) ois.readObject();
            Person deserializedAurora = (Person) ois.readObject();

            System.out.println("Deserialized objects:");
            System.out.println(deserializedJulio);
            System.out.println(deserializedAurora);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
