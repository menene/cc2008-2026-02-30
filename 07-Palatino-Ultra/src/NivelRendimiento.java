public enum NivelRendimiento {
    EXCELENTE("Excelente"),
    BUENO("Bueno"),
    REGULAR("Regular"),
    BAJO("Bajo");

    private final String etiqueta;

    NivelRendimiento(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public static NivelRendimiento clasificar(double efectividad) {
        if (efectividad >= 50) {
            return EXCELENTE;
        }
        if (efectividad >= 30) {
            return BUENO;
        }
        if (efectividad >= 15) {
            return REGULAR;
        }
        return BAJO;
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}
