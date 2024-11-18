package solution;

public enum VariableMeteo {
    CIELO("ceo"),
    LLUVIA("pchoiva"),
    TEMPERATURA_MAXIMA("tmaxFranxa"),
    TEMPERATURA_MINIMA("tminFranxa"),
    VIENTO("vento");

    private String nomeVariableMeteo;

    VariableMeteo(String nomeVariableMeteo) {
        this.nomeVariableMeteo = nomeVariableMeteo;
    }

    public String getNomeVariableMeteo() {
        return nomeVariableMeteo;
    }

    @Override
    public String toString() {
        return "VariableMeteo{" +
                "nomeVariableMeteo='" + nomeVariableMeteo + '\'' +
                '}';
    }

    // Método para convertir texto plano a valores da Enum
    public static VariableMeteo fromString(String nomeVariable){
        for (VariableMeteo var : VariableMeteo.values()){
            if (var.nomeVariableMeteo.equalsIgnoreCase(nomeVariable)){
                return var;
            }
        }
        throw new IllegalArgumentException("Non hai variable para: " + nomeVariable);
    }
}

