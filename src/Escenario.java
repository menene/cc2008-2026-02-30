public class Escenario {

    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String estado;

    public Escenario(String codigo, String nombre, String ubicacion, int capacidadMaxima, String estado) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código del escenario no puede estar vacío.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del escenario no puede estar vacío.");
        }
        if (ubicacion == null || ubicacion.isBlank()) {
            throw new IllegalArgumentException("La ubicación del escenario no puede estar vacía.");
        }
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que 0.");
        }
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado del escenario no puede estar vacío.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = estado;
    }

    public void validarCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que 0.");
        }
    }

    public void validarEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado del escenario no puede estar vacío.");
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Nombre: " + nombre
                + " | Ubicación: " + ubicacion
                + " | Capacidad máxima: " + capacidadMaxima
                + " | Estado: " + estado;
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

    public void setCapacidadMaxima(int capacidadMaxima) {
        validarCapacidadMaxima(capacidadMaxima);
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(String estado) {
        validarEstado(estado);
        this.estado = estado;
    }
}