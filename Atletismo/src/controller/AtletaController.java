package controller;
 
import model.Atleta;
 
public class AtletaController {
 
    private Atleta atleta;
 
    public void nuevoAtleta(String nombre, int numeroParticipante, int edad) {
        this.atleta = new Atleta(nombre, numeroParticipante, edad);
    }
 
    public boolean hayAtletaActivo() {
        return atleta != null;
    }
 
    public boolean registrarIntento(double tiempo) {
        return atleta.registrarTiempo(tiempo);
    }
 
    public double[] consultarTiempos() {
        return atleta.consultarTiempos();
    }
 
    public double consultarIntento(int numeroIntento) {
        return atleta.consultarIntento(numeroIntento);
    }
 
    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo) {
        return atleta.modificarTiempo(numeroIntento, nuevoTiempo);
    }
 
    public double obtenerPromedio() {
        return atleta.calcularPromedio();
    }
 
    public double obtenerMejorTiempo() {
        return atleta.obtenerMejorTiempo();
    }
 
    public double obtenerMayorTiempo() {
        return atleta.obtenerMayorTiempo();
    }
 
    public int obtenerIntentosDisponibles() {
        return atleta.obtenerIntentosDisponibles();
    }
 
    public int obtenerCantidadIntentos() {
        return atleta.getCantidadIntentos();
    }
 
    public String obtenerNombreAtleta() {
        return atleta.getNombre();
    }
 
    public int obtenerNumeroParticipante() {
        return atleta.getNumeroParticipante();
    }
 
    public int obtenerEdad() {
        return atleta.getEdad();
    }
}