public class Atleta {
    //cantidad maxima de intentos permitidos para cada atleta
    private static int MAX_INTENTOS = 10;

    //atributos con la informacion personal del atleta
    private String nombre;
    private int numeroParticipante;
    private int edad;

    //arreglo que almacena los tiempos y contador de posiciones utilizadas
    private double[] tiempos;
    private int intentosRegistrados;

    //constructor que inicializa al atleta sin intentos registrados
    public Atleta(String nombre, int numeroParticipante, int edad) {
        this.nombre = nombre;
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;
        this.tiempos = new double[MAX_INTENTOS];
        this.intentosRegistrados = 0;
    }

    //metodos para consultar los datos personales del atleta
    public String getNombre() {
        return nombre;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public int getEdad() {
        return edad;
    }

    //registra el tiempo en la siguiente posicion disponible del arreglo
    public boolean registrarIntento(double tiempo) {
        //no se aceptan tiempos invalidos ni mas de 10 intentos
        if (!esTiempoValido(tiempo) || intentosRegistrados >= MAX_INTENTOS) {
            return false;
        }

        //el contador funciona como indice de la siguiente posicion disponible
        tiempos[intentosRegistrados] = tiempo;
        intentosRegistrados++;
        return true;
    }

    //devuelve una copia que contiene solamente los tiempos registrados
    public double[] obtenerTiemposRegistrados() {
        double[] tiemposRegistrados = new double[intentosRegistrados];

        //se copia el arreglo para evitar que otras clases modifiquen el original
        for (int i = 0; i < intentosRegistrados; i++) {
            tiemposRegistrados[i] = tiempos[i];
        }

        return tiemposRegistrados;
    }

    //obtiene el tiempo de un intento usando numeros del 1 al 10
    public double getTiempo(int numeroIntento) {
        if (!esIntentoRegistrado(numeroIntento)) {
            return -1;
        }

        //se resta 1 porque los indices de los arreglos comienzan en 0
        return tiempos[numeroIntento - 1];
    }

    //modifica unicamente intentos registrados y con un tiempo valido
    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo) {
        if (!esIntentoRegistrado(numeroIntento) || !esTiempoValido(nuevoTiempo)) {
            return false;
        }

        tiempos[numeroIntento - 1] = nuevoTiempo;
        return true;
    }

    //calcula el promedio usando solo las posiciones registradas
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

    //busca el tiempo menor porque representa el mejor resultado
    public double obtenerMejorTiempo() {
        if (intentosRegistrados == 0) {
            return 0;
        }

        double mejorTiempo = tiempos[0];
        for (int i = 1; i < intentosRegistrados; i++) {
            if (tiempos[i] < mejorTiempo) {
                mejorTiempo = tiempos[i];
            }
        }

        return mejorTiempo;
    }

    //busca el tiempo mas alto entre los intentos registrados
    public double obtenerMayorTiempo() {
        if (intentosRegistrados == 0) {
            return 0;
        }

        double mayorTiempo = tiempos[0];
        for (int i = 1; i < intentosRegistrados; i++) {
            if (tiempos[i] > mayorTiempo) {
                mayorTiempo = tiempos[i];
            }
        }

        return mayorTiempo;
    }

    //devuelve la cantidad de intentos que ya se realizaron
    public int getIntentosRegistrados() {
        return intentosRegistrados;
    }

    //calcula cuantos espacios quedan disponibles en el arreglo
    public int obtenerIntentosDisponibles() {
        return MAX_INTENTOS - intentosRegistrados;
    }

    //verifica que el numero corresponda a un intento ya registrado
    private boolean esIntentoRegistrado(int numeroIntento) {
        return numeroIntento >= 1 && numeroIntento <= intentosRegistrados;
    }

    //rechaza valores menores o iguales a 0, infinitos y NaN
    private boolean esTiempoValido(double tiempo) {
        return Double.isFinite(tiempo) && tiempo > 0;
    }
}