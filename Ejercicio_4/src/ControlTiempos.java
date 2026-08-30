public class ControlTiempos{
    private double[] tiempos;
    private int cantidadIntentos;
    private static final int Max_Intentos = 10;
    public ControlTiempos(){
        tiempos = new double[Max_Intentos];
        cantidadIntentos = 0;
    }
    public boolean registrarIntento(double tiempo){
        if (tiempo > 0 && cantidadIntentos < Max_Intentos){
            tiempos[cantidadIntentos] = tiempo;
            cantidadIntentos++;
            return true;
        } else {
            return false;
        }
    }
    public double obtenerTiempo(int numeroIntento){
        if (numeroIntento >= 1 && numeroIntento <= cantidadIntentos){
            return tiempos[numeroIntento -1];
        } else {
            return -1;
        }
    }
    public boolean modificarTiempo(int numeroIntento, double nuevoTiempo){
        if (numeroIntento >=1 && numeroIntento <= cantidadIntentos && nuevoTiempo > 0){
            tiempos[numeroIntento-1] = nuevoTiempo;
            return true;
        }
        else {
            return false;
        }
    }
    public double calcularPromedio(){
        if (cantidadIntentos==0){
            return 0;
        }
        else{
            double acumulador = 0;
            for (int i=0; i<cantidadIntentos; i++){
                acumulador+=tiempos[i];
            }
            return acumulador/cantidadIntentos;
        }
    }
    public double obtenerMayorTiempo(){
        if (cantidadIntentos==0){
            return 0;
        } else {
            double mayorTiempo = tiempos[0];
            for (int i=0; i<cantidadIntentos; i++){
                if (mayorTiempo<tiempos[i]){
                    mayorTiempo= tiempos[i];
                }
            }
            return mayorTiempo;
        }
    }
    public double obtenerMejorTiempo(){
        if (cantidadIntentos==0){
            return 0;
        } else {
            double mejorTiempo = tiempos[0];
            for (int i=0; i<cantidadIntentos; i++){
                if (mejorTiempo>tiempos[i]){
                    mejorTiempo= tiempos[i];
                }
            }
            return mejorTiempo;
        }
    }
    public int getCantidadIntentos(){
        return cantidadIntentos;
    }
    public int obtenerIntentosDisponibles(){
        return Max_Intentos - cantidadIntentos;
    }
}