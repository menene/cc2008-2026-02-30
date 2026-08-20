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

    public boolean registrarTiempo(double tiempo) {
        if (tiempo <= 0 || cantidadIntentos >= tiempos.length) {
            return false;
        }

        tiempos[cantidadIntentos] = tiempo;
        cantidadIntentos++;

        return true;
    }

    public double obtenerTiempo(int indice) {
        if (indice < 0 || indice >= cantidadIntentos) {
            return -1; 
        }

        return tiempos[indice];
    }

    public boolean modificarTiempo(int indice, double nuevoTiempo) {
        if (indice <0 || indice >= cantidadIntentos || nuevoTiempo <= 0) {
            return false;
        }

        tiempos[indice] = nuevoTiempo;
        return true;
    }

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    public int getIntentosDisponibles() {
        return tiempos.length - cantidadIntentos;
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
}