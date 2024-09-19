package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class personCollection implements Serializable {
    ArrayList<Person> personArrayList= new ArrayList<Person>();

    public personCollection(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }
}
