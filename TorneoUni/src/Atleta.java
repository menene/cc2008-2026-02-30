public class Atleta {

    private String nombre;
    private int numeroParticipante;
    private int edad;

    // Arreglo fijo de 10 posiciones para los tiempos del atleta
    private double[] tiempos;
    // Cuántas de esas posiciones ya están ocupadas
    private int intentosRegistrados;

    public Atleta(String nombre, int numeroParticipante, int edad) {
        this.nombre = nombre;
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;
        this.tiempos = new double[10];
        this.intentosRegistrados = 0;
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

    public int getIntentosRegistrados() {
        return intentosRegistrados;
    }

    // Intenta guardar un nuevo tiempo en la siguiente posición libre
    public boolean registrarTiempo(double tiempo) {
        if (tiempo > 0 && intentosRegistrados < tiempos.length) {
            tiempos[intentosRegistrados] = tiempo;
            intentosRegistrados++;
            return true;
        }
        return false;
    }

    // Modifica un intento ya registrado
    public boolean modificarTiempo(int numIntento, double nuevoTiempo){
        int indice = numIntento - 1;
        if (nuevoTiempo > 0 && indice >= 0 && indice < intentosRegistrados) {
            tiempos[indice] = nuevoTiempo;
            return true;
        }
        return false;
    }

    //Retorna el tiempo de un intento
    public double consultarTiempo(int numIntento) {
        int indice = numIntento - 1;
        if (indice >= 0 && indice < intentosRegistrados) {
            return tiempos[indice];
        }
        return -1;
    }

    //Devuelve solo las posiciones del arreglo con tiempos reales
    public double[] consultarTiempos() {
        double[] registrados = new double[intentosRegistrados];
        for (int i = 0; i < intentosRegistrados; i++) {
            registrados[i] = tiempos[i];
        }
        return registrados;
    }

    // Promedio solo de los tiempos que existen
    public double calcularPromedio() {
        if (intentosRegistrados == 0) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < intentosRegistrados; i++) {
            suma += tiempos[i];
        }
        return suma / intentosRegistrados;
    }

    //el tiempo más bajo
    public double obtenerMejorTiempo() {
        if (intentosRegistrados == 0) {
            return 0;
        }
        double mejor = tiempos[0];
        for (int i = 1; i < intentosRegistrados; i++) {
            if (tiempos[i] < mejor) {
                mejor = tiempos[i];
            }
        }
        return mejor;
    }

    // El peor tiempo registrado
    public double obtenerPeorTiempo() {
        if (intentosRegistrados == 0) {
            return 0;
        }
        double peor = tiempos[0];
        for (int i = 1; i < intentosRegistrados; i++) {
            if (tiempos[i] > peor) {
                peor = tiempos[i];
            }
        }
        return peor;
    }

    // Espacios libres de los 10 permitidos
    public int espaciosDisponibles() {
        return tiempos.length - intentosRegistrados;
    }
}