public class Festival {

    private String nombreFestival;
    private String codigoFestival;
    private String nombreCoordinador;

    // Constructor 
    public Festival(String nombreFestival, String codigoFestival, String nombreCoordinador) {
        if (nombreFestival.isEmpty()) {
            throw new IllegalArgumentException("El nombre del festival no puede estar vacío :/"); // Se conservó el lanzamiento de excepciones para proteger al objeto.
        }

        if (codigoFestival.isEmpty()) {
            throw new IllegalArgumentException("El código del festival no puede estar vacío UwU");
        }
        
        if (nombreCoordinador.isEmpty()) {
            throw new IllegalArgumentException("El nombre del coordinador no puede estar vacío :c");
        }

        this.nombreFestival = nombreFestival;
        this.codigoFestival = codigoFestival;
        this.nombreCoordinador = nombreCoordinador;
    }

    @Override 
    public String toString() {
        return String.format(
            """
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
            Festival: %s
            Código: %s
            Coordinador: %s
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
            """,
        nombreFestival,
        codigoFestival,
        nombreCoordinador);
    }
}
