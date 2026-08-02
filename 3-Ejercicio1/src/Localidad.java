public class Localidad {

    private static final int CAPACIDAD_POR_LOCALIDAD = 20;

    
    private int numero;
    private double precio;
    private int capacidad;
    private int vendidos;

    
    public Localidad(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = CAPACIDAD_POR_LOCALIDAD;
        this.vendidos = 0;
    }

    
    public boolean hayEspacio() {
        return vendidos < capacidad;
    }

    public int venderBoletos(int cantidad) {
        int cantidadVendida = Math.min(cantidad, disponibles());
        vendidos += cantidadVendida;
        return cantidadVendida;
    }

    public int disponibles() {
        return capacidad - vendidos;
    }

    public double dineroGenerado() {
        return vendidos * precio;
    }

    // getters
    public int getNumero() {
        return numero;
    }

    public double getPrecio() {
        return precio;
    }

    public int getVendidos() {
        return vendidos;
    }
}
