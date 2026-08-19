public class Localidad {
    private int idLocalidad;
    private double precio;
    private int capacidad;
    private int vendidos;

    public Localidad(int idLocalidad, double precio, int capacidad) {
        this.idLocalidad = idLocalidad;
        this.precio = precio;
        this.capacidad = capacidad;
        this.vendidos = 0;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getVendidos() {
        return vendidos;
    }

    public int getDisponibles() {
        return capacidad - vendidos;
    }

    public boolean hayEspacio(int cantidad) {
        return getDisponibles() >= cantidad;
    }

    public int boletosVendibles(int cantidadDeseada) {
        if (cantidadDeseada <= getDisponibles()) {
            return cantidadDeseada;
        }

        return getDisponibles();
    }

    public void venderBoletos(int cantidad) {
        vendidos += cantidad;
    }

    public double reporteCaja() {
        return vendidos * precio;
    }
}
