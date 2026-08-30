public class Atleta {
    private String nombre; 
    private int numeroParticipante; 
    private int edad; 
    private int[] intentos; 
    private int cantidadIntentos; 



    public Atleta (String nombre, int numeroParticipante, int edad){
        this.nombre = nombre; 
        this.numeroParticipante = numeroParticipante; 
        this.edad = edad; 
        cantidadIntentos = 0;
        intentos = new int[10];
    }

    public String getNombre() {
        return nombre; 
    }    

    public int getNumeroParticipante(){
        return numeroParticipante; 
    }

//retornar el arreglo, hicimos el cambio porque al recibirlo como parametro no funcionó como esperabamos (ya actualizado en el analisis y uml) 
    public int[] getIntentos() {
        return intentos; 
    }
    
    

    public int getCantidadIntentos() {
        return cantidadIntentos;  
    }

    public int getIntento( int numeroIntento) {
        if (numeroIntento > 0 && numeroIntento <= cantidadIntentos){
            return intentos[numeroIntento - 1];
        } return 0;
        
    }

    public int intentosRestantes(){
        return 10 - cantidadIntentos; 

    }
    
    public int intentosRealizados(){
        return cantidadIntentos;
    }

    public int mejorTiempo() {
        if (cantidadIntentos == 0){
            return 0; 
        }
        int mejorRegistrado = intentos[0]; 
        for (int i = 0; i < cantidadIntentos; i++) {
            if (intentos [i] < mejorRegistrado){
                mejorRegistrado = intentos[i];
             
            }
            
        } return mejorRegistrado;
    }

    public int peorTiempo() {
        if (cantidadIntentos == 0){
            return 0; 
        }
        int peorRegistrado = intentos[0]; 
        for (int i = 0; i < cantidadIntentos; i++) {
            if (intentos [i] > peorRegistrado){
                peorRegistrado = intentos[i];
             
            }
            
        } return peorRegistrado;
    }

    public int promedioIntentos() {
        if (cantidadIntentos == 0){
            return 0; 
        }
        int suma = 0; 
        for (int i = 0; i < cantidadIntentos; i++) {
            suma += intentos[i]; 
        }
        int promedio = suma/cantidadIntentos;
        return promedio; 
    
    }

    public boolean modificarIntento(int numeroIntento, int tiempoNuevo){
        if (numeroIntento <= cantidadIntentos && numeroIntento > 0) {
            if (tiempoNuevo > 0) {
                intentos[numeroIntento -1] = tiempoNuevo; 
                return true; 

            }return false;
        }return false; 

    }

    public boolean agregarIntento(int tiempo){
        if (tiempo > 0) {
            if (cantidadIntentos < 10){ 
                intentos[cantidadIntentos] = tiempo; 
                cantidadIntentos += 1; 
                return true; 
            } 



        }return false; 
    }    

}
    
    