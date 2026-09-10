public class Escenario {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String estado;

    public Escenario(String codigo, String nombre, String ubicacion,
            int capacidadMaxima, String estado) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El codigo del escenario no puede estar vacio.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del escenario no puede estar vacio.");
        }
        if (ubicacion == null || ubicacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La ubicacion del escenario no puede estar vacia.");
        }
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado del escenario no puede estar vacio.");
        }
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad maxima debe ser mayor que 0.");
        }

        this.codigo = codigo.trim();
        this.nombre = nombre.trim();
        this.ubicacion = ubicacion.trim();
        this.capacidadMaxima = capacidadMaxima;
        this.estado = estado.trim();
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

    public void setCapacidadMaxima(int nuevaCapacidad) {
        if (nuevaCapacidad <= 0) {
            throw new IllegalArgumentException("La capacidad maxima debe ser mayor que 0.");
        }
        capacidadMaxima = nuevaCapacidad;
    }

    public void setEstado(String nuevoEstado) {
        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado del escenario no puede estar vacio.");
        }
        estado = nuevoEstado.trim();
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + "\nNombre: " + nombre
                + "\nUbicacion: " + ubicacion
                + "\nCapacidad maxima: " + capacidadMaxima
                + "\nEstado: " + estado;
    }
}
