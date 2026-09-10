public class Escenario {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidad;
    private String estado;

    public Escenario(String cod, String nom, String ubi, int cap, String est) {
        this.codigo = cod;
        this.nombre = nom;
        this.ubicacion = ubi;
        this.capacidad = cap;
        this.estado = est;
    }

    public String getEscenario(int indice) {
        return ("Escenario " + indice + "\n -> codigo: " + codigo + "\n Nombre: "
                + nombre + "\n -> Ubicacion: " + ubicacion + "\n -> Capacidad: " + capacidad +
                "\n -> Estado: " + estado);
    }

    public String getCodigo() {
        return (this.codigo);
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

    public int getCapacidad() {
        return (this.capacidad);
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad maxima debe ser mayor que 0.");
        }
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return (this.estado);
    }

    public void setEstado(String est) {
        this.estado = est;
    }

}