public class Localidad {
    private int numeroLocalidad;
    private double precio;
    private int capacidad;
    private int boletosVendidos;

    public Localidad(
            int numeroLocalidad,
            double precio,
            int capacidad
    ) {
        this.numeroLocalidad = numeroLocalidad;
        this.precio = precio;
        this.capacidad = capacidad;
        this.boletosVendidos = 0;
    }

    public int getDisponibles() {
        return capacidad - boletosVendidos;
    }

    public void venderBoletos(int cantidad) {
        if (cantidad > 0 && cantidad <= getDisponibles()) {
            boletosVendidos += cantidad;
        }
    }

    public int getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }
}