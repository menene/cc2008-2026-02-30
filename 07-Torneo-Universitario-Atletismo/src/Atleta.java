public class Atleta {

    private String nombre;
    private int numeroParticipante;
    private int edad;
    private double[] tiempos;
    private int cantidadIntentos;

    public Atleta(String nombre, int numeroParticipante, int edad) {
        this.nombre = nombre;
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;

        tiempos = new double[10];
        cantidadIntentos = 0;
    }

    public boolean registrarIntento(double tiempo) {

        if (tiempo <= 0) {
            return false;
        }

        if (cantidadIntentos >= 10) {
            return false;
        }

        tiempos[cantidadIntentos] = tiempo;
        cantidadIntentos++;

        return true;
    }

    public double consultarTiempo(int numeroIntento) {

        if (numeroIntento < 1 || numeroIntento > cantidadIntentos) {
            return -1;
        }

        return tiempos[numeroIntento - 1];
    }

    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo) {

        if (numeroIntento < 1 || numeroIntento > cantidadIntentos) {
            return false;
        }

        if (nuevoTiempo <= 0) {
            return false;
        }

        tiempos[numeroIntento - 1] = nuevoTiempo;

        return true;
    }

    public double calcularPromedio() {

        if (cantidadIntentos == 0) {
            return -1;
        }

        double suma = 0;

        for (int i = 0; i < cantidadIntentos; i++) {
            suma += tiempos[i];
        }

        return suma / cantidadIntentos;
    }

    public double obtenerMejorTiempo() {

        if (cantidadIntentos == 0) {
            return -1;
        }

        double mejorTiempo = tiempos[0];

        for (int i = 1; i < cantidadIntentos; i++) {
            if (tiempos[i] < mejorTiempo) {
                mejorTiempo = tiempos[i];
            }
        }

        return mejorTiempo;
    }

    public double obtenerMayorTiempo() {

        if (cantidadIntentos == 0) {
            return -1;
        }

        double mayorTiempo = tiempos[0];

        for (int i = 1; i < cantidadIntentos; i++) {
            if (tiempos[i] > mayorTiempo) {
                mayorTiempo = tiempos[i];
            }
        }

        return mayorTiempo;
    }

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    public int getIntentosDisponibles() {
        return 10 - cantidadIntentos;
    }
}