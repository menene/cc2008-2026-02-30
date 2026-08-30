public class Atleta {

    private String nombre;
    private int numParticipante;
    private int edad;
    private double[] tiempos;
    private int cantidadIntentos;
    private int intentosRestantes;

    public Atleta(String nombre, int numParticipante, int edad) {
        this.nombre = nombre;
        this.numParticipante = numParticipante;
        this.edad = edad;
        tiempos = new double[10];
        cantidadIntentos = 0;
        intentosRestantes = 10;
    }

    public boolean registrarTiempo(double tiempo) {

        if (tiempo <= 0) {
            return false;
        }

        if (cantidadIntentos >= tiempos.length) {
            return false;
        }

        tiempos[cantidadIntentos] = tiempo;
        cantidadIntentos++;
        intentosRestantes--;
        return true;
    }

    public double getTiempo(int numIntento) {
        if (numIntento < 1 || numIntento > cantidadIntentos) {
            return -1;
        }

        return tiempos[numIntento - 1];
    }

    public boolean modificarTiempo(int numIntento, double nuevoTiempo) {
        if (nuevoTiempo <= 0) {
            return false;
        }

        if (numIntento < 1 || numIntento > cantidadIntentos) {
            return false;
        }

        tiempos[numIntento - 1] = nuevoTiempo;
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

    public void mostrarTiempos() {

        if (cantidadIntentos == 0) {
            System.out.println("No hay tiempos registrados.");
            return;
        }

        for (int i = 0; i < cantidadIntentos; i++) {
            System.out.println(
                    "Intento " + (i + 1) + ": "
                    + tiempos[i] + " segundos"
            );
        }
    }

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumParticipante() {
        return numParticipante;
    }

    public int getEdad() {
        return edad;
    }
}