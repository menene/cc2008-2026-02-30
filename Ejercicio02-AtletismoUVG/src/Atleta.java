public class Atleta {

    private String nombreAtleta;
    private int numeroParticipante;
    private int edad;
    private int cantidadIntentos;
    private double[] tiempos;

    public Atleta(String nombreAtleta, int numeroParticipante, int edad) {
        this.nombreAtleta = nombreAtleta;
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;
        this.cantidadIntentos = 0;
        this.tiempos = new double[10];
    }

    public boolean registrarTiempo(double tiempo) {
        if (!validarMayorCero(tiempo)) {
            return false;
        }
        if (cantidadIntentos >= tiempos.length) {
            return false;
        }
        tiempos[cantidadIntentos] = tiempo;
        cantidadIntentos++;
        return true;
    }

    public double consultarTiempo(int numeroIntento) {
        int indice = numeroIntento - 1;
        if (indice < 0 || indice >= cantidadIntentos) {
            return -1;
        }
        return tiempos[indice];
    }

    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo) {
        int indice = numeroIntento - 1;
        if (indice < 0 || indice >= cantidadIntentos) {
            return false;
        }
        if (!validarMayorCero(nuevoTiempo)) {
            return false;
        }
        tiempos[indice] = nuevoTiempo;
        return true;
    }

    public double calcularPromedio() {
        if (cantidadIntentos == 0) {
            return 0.0;
        }

        double suma = 0.0;
        for (int i = 0; i < cantidadIntentos; i++) {
            suma += tiempos[i];
        }
        return suma / cantidadIntentos;
    }

    public double obtenerMejorTiempo() {
        if (cantidadIntentos == 0) {
            return 0.0;
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
            return 0.0;
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
        return tiempos.length - cantidadIntentos;
    }

    public String getNombreAtleta() {
        return nombreAtleta;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public int getEdad() {
        return edad;
    }

    public boolean validarMayorCero(double tiempo) {
        return tiempo > 0;
    }
}