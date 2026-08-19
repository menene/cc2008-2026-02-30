public class Localidad {
    private int idLocalidad;
    private String nombre;
    private double precio;
    private int capacidadMaxima;
    private int boletosVendidos;

    public Localidad(int idLocalidad, String nombre, double precio, int capacidadMaxima) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadMaxima = capacidadMaxima;
        this.boletosVendidos = 0;
    }

    public int getIdLocalidad() { return idLocalidad; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public int getBoletosDisponibles() {
        return capacidadMaxima - boletosVendidos;
    }

    public int getBoletosVendidos() { return boletosVendidos; }

    public boolean tieneEspacioSuficiente(int cantidadSolicitada) {
        return getBoletosDisponibles() >= cantidadSolicitada;
    }

    public boolean puedeVender(int cantidadSolicitada) {
        return tieneEspacioSuficiente(cantidadSolicitada);
    }

    public double calcularCosto(int cantidadBoletos) {
        return cantidadBoletos * precio;
    }

    public void venderBoletos(int cantidad) {
        if (!puedeVender(cantidad)) {
            throw new IllegalStateException("No hay espacio suficiente en la localidad.");
        }
        this.boletosVendidos += cantidad;
    }

    public double getRecaudacion() {
        return boletosVendidos * precio;
    }
}