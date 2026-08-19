public class Localidad {
    private int idLocalidad;
    private double precio;
    private int capacidadMaxima;
    private int boletosVendidos;

    public Localidad(int idLocalidad, double precio, int capacidadMaxima) {
        this.idLocalidad = idLocalidad;
        this.precio = precio;
        this.capacidadMaxima = capacidadMaxima;
        this.boletosVendidos = 0;
    }

    public boolean hayEspacio(int cantidad) {
        return getDisponibles() > 0;
    }

    public int venderBoletos(int cantidad) {
        int disponibles = getDisponibles();
        int aVender;

        if (cantidad <= disponibles) {
            aVender = cantidad;
        } else {
            aVender = disponibles;
        }

        boletosVendidos = boletosVendidos + aVender;
        return aVender;
    }

    public int getDisponibles() {
        return capacidadMaxima - boletosVendidos;
    }

    public double calcularIngreso() {
        return precio * boletosVendidos;
    }

    public double getPrecio() {
        return precio;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }
}
