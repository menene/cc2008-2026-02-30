package model;
 
import java.util.Arrays;
 
public class Atleta {

    private static final int MAX_INTENTOS = 10;

    private String nombre;
    private int numeroParticipante;
    private int edad;

    private double[] tiempos;

    private int cantidadIntentos;

    public Atleta(String nombre, int numeroParticipante, int edad) {
        this.nombre = nombre;
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;
        this.tiempos = new double[MAX_INTENTOS];
        this.cantidadIntentos = 0;
    }

    public boolean registrarTiempo(double tiempo) {
        if (tiempo <= 0) {
            return false;
        }
        if (!haySpacioDisponible()) {
            return false;
        }
        tiempos[cantidadIntentos] = tiempo;
        cantidadIntentos++;
        return true;
    }
 
    public double[] consultarTiempos() {
        return Arrays.copyOf(tiempos, cantidadIntentos);
    }
 
    public double consultarIntento(int numeroIntento) {
        validarNumeroIntentoExistente(numeroIntento);
        return tiempos[numeroIntento - 1];
    }
 
    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo) {
        if (nuevoTiempo <= 0) {
            return false;
        }
        if (numeroIntento < 1 || numeroIntento > cantidadIntentos) {
            return false;
        }
        tiempos[numeroIntento - 1] = nuevoTiempo;
        return true;
    }
 
    public double calcularPromedio() {
        validarHayIntentosRegistrados();
        double suma = 0;
        for (int i = 0; i < cantidadIntentos; i++) {
            suma += tiempos[i];
        }
        return suma / cantidadIntentos;
    }
 
    public double obtenerMejorTiempo() {
        validarHayIntentosRegistrados();
        double mejor = tiempos[0];
        for (int i = 1; i < cantidadIntentos; i++) {
            if (tiempos[i] < mejor) {
                mejor = tiempos[i];
            }
        }
        return mejor;
    }

    public double obtenerMayorTiempo() {
        validarHayIntentosRegistrados();
        double mayor = tiempos[0];
        for (int i = 1; i < cantidadIntentos; i++) {
            if (tiempos[i] > mayor) {
                mayor = tiempos[i];
            }
        }
        return mayor;
    }
 
    public int obtenerIntentosDisponibles() {
        return MAX_INTENTOS - cantidadIntentos;
    }
 
    public int getCantidadIntentos() {
        return cantidadIntentos;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public int getNumeroParticipante() {
        return numeroParticipante;
    }
 
    public int getEdad() {
        return edad;
    }

    private boolean haySpacioDisponible() {
        return cantidadIntentos < MAX_INTENTOS;
    }
 
    private void validarHayIntentosRegistrados() {
        if (cantidadIntentos == 0) {
            throw new IllegalStateException("El atleta todavía no tiene intentos registrados.");
        }
    }
 
    private void validarNumeroIntentoExistente(int numeroIntento) {
        if (numeroIntento < 1 || numeroIntento > cantidadIntentos) {
            throw new IllegalArgumentException("El intento " + numeroIntento + " no ha sido registrado.");
        }
    }
}