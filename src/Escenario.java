public class Escenario {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String estado;

    public Escenario(String codigo, String nombre, String ubicacion,
                     int capacidadMaxima, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        actualizarDatos(capacidadMaxima, estado);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public String getEstado() {
        return estado;
    }

    public void actualizarDatos(int capacidadMaxima, String estado) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                "La capacidad debe ser mayor que 0."
            );
        }

        this.capacidadMaxima = capacidadMaxima;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
            + " | Nombre: " + nombre
            + " | Ubicacion: " + ubicacion
            + " | Capacidad: " + capacidadMaxima
            + " | Estado: " + estado;
    }
}