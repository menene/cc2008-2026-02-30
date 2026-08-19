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

    public String getNombre() {
        return nombre;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public int getEdad() {
        return edad;
    }


    public boolean registrarTiempo(double tiempo) {
        if (tiempo <= 0) {
            return false;
        }
        if (cantidadIntentos >= MAX_INTENTOS) {
            return false;
        }
        tiempos[cantidadIntentos] = tiempo;
        cantidadIntentos++;
        return true;
    }


    public double consultarTiempo(int numeroIntento) {
        if (!intentoValido(numeroIntento)) {
            return -1;
        }
        return tiempos[numeroIntento - 1];
    }


    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo) {
        if (nuevoTiempo <= 0) {
            return false;
        }
        if (!intentoValido(numeroIntento)) {
            return false;
        }
        tiempos[numeroIntento - 1] = nuevoTiempo;
        return true;
    }


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

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    public int getIntentosDisponibles() {
        return MAX_INTENTOS - cantidadIntentos;
    }

    public double[] getTiempos() {
        return tiempos;
    }


    private boolean intentoValido(int numeroIntento) {
        return numeroIntento >= 1 && numeroIntento <= cantidadIntentos;
    }
}
