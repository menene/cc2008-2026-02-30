/**
 * Clase ControlTiempos
 * Administra el arreglo de tiempos registrados por el atleta activo
 * durante sus diferentes intentos en el torneo.
 */
public class ControlTiempos {

    private double[] tiempos;
    private int cantidadIntentos;
    private static final int MAX_INTENTOS = 10;

    /**
     * Crea el arreglo de tiempos e inicializa el control de intentos registrados.
     */
    public ControlTiempos() {
        tiempos = new double[MAX_INTENTOS];
        cantidadIntentos = 0;
    }

    /**
     * Valida y almacena un nuevo tiempo en la siguiente posición disponible del arreglo.
     * Devuelve si fue posible realizar el registro.
     */
    public boolean registrarTiempo(double tiempo) {
        if (tiempo > 0 && hayEspacioDisponible()) {
            tiempos[cantidadIntentos] = tiempo;
            cantidadIntentos++;
            return true;
        }
        return false;
    }

    /**
     * Devuelve el tiempo correspondiente a un intento previamente registrado.
     * numeroIntento se recibe en base 1 (intento 1, intento 2, ...).
     * Si el intento no existe todavía, devuelve -1.
     */
    public double consultarTiempo(int numeroIntento) {
        int indice = numeroIntento - 1;
        if (indice >= 0 && indice < cantidadIntentos) {
            return tiempos[indice];
        }
        return -1;
    }

    /**
     * Modifica el tiempo de un intento registrado si el intento y el nuevo tiempo son válidos.
     */
    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo) {
        int indice = numeroIntento - 1;
        if (indice >= 0 && indice < cantidadIntentos && nuevoTiempo > 0) {
            tiempos[indice] = nuevoTiempo;
            return true;
        }
        return false;
    }

    /**
     * Devuelve el arreglo que contiene los tiempos para permitir consultar los intentos registrados.
     */
    public double[] getTiempos() {
        return tiempos;
    }

    /**
     * Calcula y devuelve el promedio utilizando únicamente los tiempos registrados.
     */
    public double calcularPromedio() {
        if (cantidadIntentos == 0) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < cantidadIntentos; i++) {
            suma += tiempos[i];
        }
        return suma / cantidadIntentos;
    }

    /**
     * Busca y devuelve el menor tiempo registrado, ya que representa el mejor resultado.
     */
    public double obtenerMejorTiempo() {
        if (cantidadIntentos == 0) {
            return -1;
        }
        double mejor = tiempos[0];
        for (int i = 1; i < cantidadIntentos; i++) {
            if (tiempos[i] < mejor) {
                mejor = tiempos[i];
            }
        }
        return mejor;
    }

    /**
     * Busca y devuelve el tiempo más alto registrado por el atleta.
     */
    public double obtenerMayorTiempo() {
        if (cantidadIntentos == 0) {
            return -1;
        }
        double mayor = tiempos[0];
        for (int i = 1; i < cantidadIntentos; i++) {
            if (tiempos[i] > mayor) {
                mayor = tiempos[i];
            }
        }
        return mayor;
    }

    /**
     * Devuelve la cantidad de intentos que han sido registrados.
     */
    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    /**
     * Devuelve cuántos intentos quedan disponibles de los 10 permitidos.
     */
    public int getIntentosDisponibles() {
        return MAX_INTENTOS - cantidadIntentos;
    }

    /**
     * Indica si todavía existe una posición disponible para almacenar otro tiempo.
     */
    public boolean hayEspacioDisponible() {
        return cantidadIntentos < MAX_INTENTOS;
    }
}