public class Escenario {
    private int id;
    private String nombre;
    private String ubicacion;
    private int maxAsistente;
    private String estado;

    public Escenario(int id, String nombre, String ubicacion, int maxAsistente, String estado) {
        if (maxAsistente <= 0) {
            throw new IllegalArgumentException("La capacidad máxima de asistentes debe ser mayor que 0.");
        }
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.maxAsistente = maxAsistente;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public int getMaxAsistente() { return maxAsistente; }
    public String getEstado() { return estado; }

    public void setMaxAsistente(int maxAsistente) { 
        if (maxAsistente <= 0) throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        this.maxAsistente = maxAsistente; 
    }
    
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Escenario [Código: " + id + " | Nombre: " + nombre + 
               " | Ubicación: " + ubicacion + " | Capacidad: " + maxAsistente + " | Estado: " + estado + "]";
    }
}