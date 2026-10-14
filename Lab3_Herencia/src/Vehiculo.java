/* Clase del vehiculo. Decide si puede transportar un envio y si esta libre para un despacho. */
public class Vehiculo {

    private String placa;
    private double capacidadMaxima;
    private boolean refrigerado;
    private Despacho despachoActual;

    /* Constructor. Revisa la placa y la capacidad. Todo vehiculo nuevo empieza libre */
    public Vehiculo(String placa, double capacidadMaxima, boolean refrigerado) {
        if (placa == null || placa.trim().length() == 0) {
            throw new IllegalArgumentException("La placa no puede quedar vacia");
        }

        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad maxima debe ser mayor que 0");
        }

        this.placa = placa.trim().toUpperCase();
        this.capacidadMaxima = capacidadMaxima;
        this.refrigerado = refrigerado;
        this.despachoActual = null;
    }

    public String getPlaca() {
        return placa;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    /* Dice si el vehiculo no tiene ningun despacho sin cerrar */
    public boolean estaLibre() {
        if (despachoActual == null) {
            return true;
        }

        return false;
    }

    /* Si el envio pide refrigeracion el vehiculo tiene que ser refrigerado. No pregunta la categoria */
    public boolean puedeTransportar(Envio envio) {
        if (envio.requiereRefrigeracion() == true && refrigerado == false) {
            return false;
        }

        return true;
    }

    /* Guarda el despacho que va a hacer el vehiculo. Solo puede tener uno sin cerrar */
    public void ocupar(Despacho despacho) {
        if (despacho == null) {
            throw new IllegalArgumentException("No hay despacho que asignar al vehiculo");
        }

        if (estaLibre() == false) {
            throw new IllegalStateException("El vehiculo " + placa + " ya tiene el despacho #" + despachoActual.getNumero() + " sin cerrar");
        }

        despachoActual = despacho;
    }

    /* Deja el vehiculo libre cuando su despacho se cierra */
    public void liberar() {
        despachoActual = null;
    }

    /* Junta la placa, la capacidad, si es refrigerado y si esta libre */
    @Override
    public String toString() {
        String textoRefrigerado = "no";

        if (refrigerado == true) {
            textoRefrigerado = "si";
        }

        String disponibilidad = "libre";

        if (estaLibre() == false) {
            disponibilidad = "con el despacho #" + despachoActual.getNumero();
        }

        return "Vehiculo " + placa
                + " | Capacidad: " + String.format("%.2f", capacidadMaxima) + " kg"
                + " | Refrigerado: " + textoRefrigerado
                + " | Estado: " + disponibilidad;
    }
}
