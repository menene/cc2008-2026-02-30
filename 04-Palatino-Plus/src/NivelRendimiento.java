// Enum que clasifica el rendimiento de un equipo segun su porcentaje
// de efectividad (goles anotados sobre tiros a gol).
public enum NivelRendimiento {
    EXCELENTE("Excelente"),
    BUENO("Bueno"),
    REGULAR("Regular"),
    BAJO("Bajo");

    private final String etiqueta;

    NivelRendimiento(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    // A partir de un porcentaje de efectividad devuelve el nivel correspondiente.
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
