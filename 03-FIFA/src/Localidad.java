public class Localidad {

    // Atributos
    private int numeroLocalidad;
    private double precio;
    private int capacidadMaxima;
    private int ticketsVendidos;

    // Constructor
    public Localidad() {
    }

    // Getters
    public int getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getTicketsVendidos() {
        return ticketsVendidos;
    }

    // Setters
    public void setNumeroLocalidad(int numeroLocalidad) {
        this.numeroLocalidad = numeroLocalidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setTicketsVendidos(int ticketsVendidos) {
        this.ticketsVendidos = ticketsVendidos;
    }

    // Verifica si aún hay espacio disponible
    public boolean hayEspacioDisponible() {
        return ticketsVendidos < capacidadMaxima;
    }

    // Calcula los espacios disponibles
    public int espaciosDisponibles() {
        return capacidadMaxima - ticketsVendidos;
    }

}