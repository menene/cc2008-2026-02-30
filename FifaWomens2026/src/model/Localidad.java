package model;

/* Clase de la localidad. Tiene 20 boletos y hace las validaciones de venta. */
public class Localidad {

    private int identificadorLocalidad;
    private double precioBoleto;
    private int boletosVendidos;
    private double dineroRecaudado;
    private final int CAPACIDAD_TOTAL = 20;

    /* Constructor. Recibe el numero de la localidad y su precio */
    public Localidad(int identificadorLocalidad, double precioBoleto) {
        this.identificadorLocalidad = identificadorLocalidad;
        this.precioBoleto = precioBoleto;
        boletosVendidos = 0;
        dineroRecaudado = 0.0;
    }

    /* Validacion 1. Dice si todavia queda espacio */
    public boolean validarEspacio() {
        if (boletosVendidos < CAPACIDAD_TOTAL) {
            return true;
        }
        return false;
    }

    /* Validacion 2. Dice cuantos boletos si se pueden vender */
    public int validarDisponibilidad(int boletosDeseados) {
        int espaciosLibres = CAPACIDAD_TOTAL - boletosVendidos;
        if (boletosDeseados <= espaciosLibres) {
            return boletosDeseados;
        }
        return espaciosLibres;
    }

    /* Validacion 3. Dice si el precio cabe en el presupuesto */
    public boolean validarPrecio(double presupuestoMaximo) {
        if (precioBoleto <= presupuestoMaximo) {
            return true;
        }
        return false;
    }

    /* Vende los boletos y devuelve cuanto se cobro */
    public double venderBoletos(int cantidadBoletos) {
        double montoCobrado = cantidadBoletos * precioBoleto;
        boletosVendidos = boletosVendidos + cantidadBoletos;
        dineroRecaudado = dineroRecaudado + montoCobrado;
        return montoCobrado;
    }

    public int getIdentificadorLocalidad() {
        return identificadorLocalidad;
    }

    public double getPrecioBoleto() {
        return precioBoleto;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public double getDineroRecaudado() {
        return dineroRecaudado;
    }

    public int getBoletosDisponibles() {
        return CAPACIDAD_TOTAL - boletosVendidos;
    }

    public int getCapacidadTotal() {
        return CAPACIDAD_TOTAL;
    }
}
