package org.example;

import java.io.*;

public class Person implements Serializable {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person: " + name + " (" + age + ')';
    }
}