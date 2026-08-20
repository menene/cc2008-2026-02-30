public class Atleta {

    private String nombre;
    private int numeroParticipante;
    private int edad;
    private double[] tiempos;
    private int cantidadIntentos;

    public Atleta (String nombre, int numeroParticipante, int edad){

        this.nombre = nombre;
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;
        this.tiempos = new double[10];
        this.cantidadIntentos = 0;
    }

    public boolean registrarTiempo(double tiempo){

        if(tiempo > 0 && cantidadIntentos < tiempos.length){

            tiempos[cantidadIntentos] = tiempo;
            cantidadIntentos++;

            return true;

        } else {

            return false;
        }
    }

    private boolean intentoValido(int numeroIntento){

        return numeroIntento > 0 && numeroIntento <= cantidadIntentos;
    }
    
    public double consultarTiempo(int numeroIntento){

        if(intentoValido(numeroIntento)){

            return tiempos[numeroIntento - 1];
        }

        return -1;
    }

    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo){

        if (intentoValido(numeroIntento) && nuevoTiempo > 0){

            tiempos[numeroIntento - 1] = nuevoTiempo;
            return true;
        }

        return false;
    }

    public double calcularPromedio(){

        if(cantidadIntentos == 0){

            return -1;
        }

        double suma = 0;

        for (int i = 0; i < cantidadIntentos; i++){
            suma += tiempos[i];
        }

        return suma / cantidadIntentos;

    }

    public double obtenerMejorTiempo(){

        if (cantidadIntentos == 0){
            return -1;
        }

        double mejorTiempo = tiempos[0];

        for (int i = 1; i < cantidadIntentos; i++){

            if(tiempos[i] < mejorTiempo){
                mejorTiempo = tiempos[i];
            }
        }

        return mejorTiempo;
    }
    
    public double obtenerMayorTiempo(){

        if (cantidadIntentos == 0){
            return -1;
        }

        double mayorTiempo = tiempos[0];

        for (int i = 1; i < cantidadIntentos; i++){

            if(tiempos[i] > mayorTiempo){
                mayorTiempo = tiempos[i];
            }
        }

        return mayorTiempo;

    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    public int obtenerIntentosDisponibles() {
        return tiempos.length - cantidadIntentos;
    }   

}