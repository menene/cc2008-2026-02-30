public class Atleta {
    private String nombreAtleta;
    private int numeroParticipante;
    private int edad;
    private int intentos;
    private int maxIntentos;
    private Tiempo[] tiempos;

    public Atleta(String nombreAtleta, int numeroParticipante, int edad) {
        this. nombreAtleta = nombreAtleta;
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;
        //iniciamos en 0 
        this.intentos = 0;
        //los intentos maximos que puede tener
        this.maxIntentos = 10;
        //el arreglo de tiempos y tiene 10 intentos maximos, que se define arriba
        this.tiempos = new Tiempo[maxIntentos];

    }

    public boolean registrarTiempo(double segundos) {
        if (segundos <= 0) {
            return false;
        } 
        if (intentos < maxIntentos) {
            tiempos[intentos] = new Tiempo(segundos);   
            intentos++;
            return true;          
        }
        return false;
    }

    public Tiempo consultarIntento(int numeroIntento) {
        if (!esIntentoValido(numeroIntento)) {
            return null;
        }
        return tiempos[numeroIntento - 1];
    }

    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo) {
        if (!esIntentoValido(numeroIntento) || nuevoTiempo <= 0) {
            return false;
        }
        tiempos[numeroIntento - 1].setSegundos(nuevoTiempo);
        return true;
    }

    public double calcularPromedio() {
        if (intentos == 0) {
            return 0;
        }
        double total = 0;
        for (int indice = 0; indice < intentos; indice++) {
            total += tiempos[indice].getSegundos();
        }
        return total / intentos;
    }

    public Tiempo obtenerMejorTiempo() {
        return obtenerTiempoExtremo(true);
    }

    public Tiempo obtenerMayorTiempo() {
        return obtenerTiempoExtremo(false);
    }

    public int getIntentos() {
        return intentos;
    }

    public int getIntentosDisponibles() {
        return maxIntentos - intentos;
    }

    public String getNombreAtleta() {
        return nombreAtleta;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    private boolean esIntentoValido(int numeroIntento) {
        return numeroIntento >= 1 && numeroIntento <= intentos;
    }

    private Tiempo obtenerTiempoExtremo(boolean menor) {
        if (intentos == 0) {
            return null;
        }
        Tiempo extremo = tiempos[0];
        for (int indice = 1; indice < intentos; indice++) {
            double tiempoActual = tiempos[indice].getSegundos();
            double tiempoExtremo = extremo.getSegundos();
            if ((menor && tiempoActual < tiempoExtremo)
                    || (!menor && tiempoActual > tiempoExtremo)) {
                extremo = tiempos[indice];
            }
        }
        return extremo;
    }

}