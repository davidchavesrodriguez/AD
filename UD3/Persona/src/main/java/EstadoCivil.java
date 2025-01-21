public enum EstadoCivil {
    SOLTEIRO, CASADO, DIVORCIADO, VIUVO;

    @Override
    public String toString() {
        switch (this) {
            case SOLTEIRO: return "Solteiro/a";
            case CASADO: return "Casado/a";
            case DIVORCIADO: return "Divorciado/a";
            case VIUVO: return "Viúvo/a";
            default: throw new IllegalArgumentException("Estado civil desconocido");
        }
    }
}
