public class Escenario {

    // Atributos
    private String codigoEscenario;
    private String nombre;
    private String ubicacion;
    private int capacidadMax;
    private boolean estado;

    // Constructor
    public Escenario(String codigoEscenario, String nombre, String ubicacion, int capacidadMax, boolean estado) {
        if (codigoEscenario.isEmpty()) {
            throw new IllegalArgumentException("El código del escenario no puede estar vacío.");
        }

        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del escenario no puede estar vacío."); 
        }

        if (ubicacion.isEmpty()) {
            throw new IllegalArgumentException("La ubicación del escenario no puede estar vacío."); 
        }

        validarCapacidadMax(capacidadMax);

        this.codigoEscenario = codigoEscenario;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMax = capacidadMax;
        this.estado = estado;
    }

    // Métodos
    public String getCodigoEscenario() {
        return codigoEscenario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setCapacidadMax(int max) {
        validarCapacidadMax(max);
        this.capacidadMax = max;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    private void validarCapacidadMax(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que 0 -_-");
        }
    }

    // Se sobreescribe toString para que devuleva los datos del escenario
    @Override
    public String toString() {
        return String.format("""
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
            Código: %s
            Nombre: %s
            Ubicación: %s
            Capacidad máxima: %d
            Estado: %s
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
            """,
            codigoEscenario,
            nombre,
            ubicacion,
            capacidadMax,
            estado ? "Ocupado" : "Libre"
        );
    }
}
