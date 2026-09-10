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
        setCapacidadMaxima(capacidadMaxima);
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                "La capacidad máxima debe ser mayor que 0."
            );
        }
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
