package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonCollection implements Serializable {
    private ArrayList<Person> personList;

    public PersonCollection() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public Person getPerson(int index) {
        if (index >= 0 && index < personList.size()) {
            return personList.get(index);
        }
        return null;
    }
}
