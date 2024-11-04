package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        VariableFranxa vf = new VariableFranxa("tmaxFranxa");
        vf.setManha(19);
        vf.setNoite(17);
        vf.setTarde(21);

        System.out.println(vf);
        System.out.println(gson.toJson(vf));

    }
}
