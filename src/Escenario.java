public class Escenario {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String estado;

    public Escenario(String codigo, String nombre, String ubicacion,
                     int capacidadMaxima, String estado) {
        validarTexto(codigo, "código");
        validarTexto(nombre, "nombre");
        validarTexto(ubicacion, "ubicación");
        validarCapacidad(capacidadMaxima);
        validarTexto(estado, "estado");

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

    public void setCapacidadMaxima(int capacidadMaxima) {
        validarCapacidad(capacidadMaxima);
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(String estado) {
        validarTexto(estado, "estado");
        this.estado = estado.trim();
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Nombre: " + nombre
                + " | Ubicación: " + ubicacion
                + " | Capacidad máxima: " + capacidadMaxima
                + " | Estado: " + estado;
    }

    private void validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El " + campo + " del escenario no puede estar vacío.");
        }
    }

    private void validarCapacidad(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que 0.");
        }
    }
}
