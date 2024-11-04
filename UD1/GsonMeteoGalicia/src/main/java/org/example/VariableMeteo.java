package org.example;

import java.util.Objects;

public enum VariableMeteo {
    CEO("ceo"), CHUVIA("pchoiva"), TEMPERATURA_MAXIMA("tmaxFranxa"),
    TEMPERATURA_MINIMA("tminFranxa"), VENTO("vento");

    private String nome;

    VariableMeteo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static VariableMeteo getVariableMeteo(String nome) {
        for (VariableMeteo v : VariableMeteo.values()) {
            if (nome.equalsIgnoreCase(v.getNome()))
                return v;
        }
        return null;
    }
}
