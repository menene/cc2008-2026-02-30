public class ControladorAtleta{

    // métodos

    // recibe el dato del controlador del torneo y verifica si el atleta aún tiene espacio en su lista de intentos, si si lo guarda en el siguiente espacio disponible
    public boolean registrarIntentos(int[] intentos, int intento){

        // recorrer la lista completa de intento inicializada con todos sus valores por predeterminado en 0 y agregar el intento el el primer 0 que encuentre
        for(int i = 0; i < intentos.length; i++){
            if(intentos[i] == 0){
                intentos[i] = intento;
                return true;
            }
        }
        return false;
    }

    // retorna la lista al controlador del Torneo con la lista de intentos que el atleta SI a realizado
    public int[] intentosRealizados(int[] intentos){
        
        // contar cuántos valores distintos de 0 hay
        int totalValidos = 0;
        for(int i = 0; i < intentos.length; i++){
            if(intentos[i] != 0){
                totalValidos++;
            }
        }

        // crear otra array con la cantidad especifica y agregarlos en orden a la nueva array
        int[] intentosValidos = new int[totalValidos];
        for(int j = 0; j < intentosValidos.length; j++){
            if(intentos[j] != 0){
                intentosValidos[j] = intentos[j];
            }
        }
        return intentosValidos;
    }

    // retorna el valor en segundos del tiempo correspondiente de al número de intento que se requiere consultar
    public int mostrarIntento(int[] intentos, int numeroIntentoConsultar){
        if(intentos[numeroIntentoConsultar - 1] == 0){
            return -1;
        }
        else{
            return intentos[numeroIntentoConsultar - 1];
        }
    }

    // recibe un número de intento a modificar y valida si este inteneto a sido registrado previamente, tambien recibe el nuevo tiempo, y se modifica solo si el intento se ha realizado previamente y guarda en el Atleta. 
    public void modificarIntento(int[] intentos, int numeroIntentoModificar, int nuevoTiempo){
        intentos[numeroIntentoModificar - 1] = nuevoTiempo;
    }

    // realiza el calculo del promedio de segundos de los intentos que YA ha realizado el atleta, no se cuentan los intentos no registrados
    public int calcularPromedo(int[] intentos){
        if(intentos.length == 0){
            return 0;
        }

        int sumaValores = 0;

        for(int i = 0; i < intentos.length; i++){
            sumaValores += intentos[i];
        }

        int promedio = sumaValores/intentos.length;
        return promedio;
    }

    // de los intentos registrados, retorna el MENOR tiempo en segundos entre todos los intentos registrados
    public int mejorTiempo(int[] intentos){
        if(intentos.length == 0){
            return 0;
        }
        else{
            int tiempo = intentos[0];
            
            for(int i = 1; i < intentos.length; i++){
                if(intentos[i] < tiempo){
                    tiempo = intentos[i];
                }
            }
            return tiempo;
        }

    }
    

    // de los intentos registrados, retorna el MAYOR tiempo en segundos entre todos los intentos registrados
    public int peorTiempo(int[] intentos){
        if(intentos.length == 0){
            return 0;
        }
        int tiempo = intentos[0];
        
        for(int i = 1; i < intentos.length; i++){
            if(intentos[i] > tiempo){
                tiempo = intentos[i];
            }
        }
        return tiempo;
    }

    // retorna como primer valor de array (indice 0) el número de intentos que ya ha registrado de intentos y como segundos valor (indice 1) el total de intentos que aún le quedan disponibles
    public int[] intentosDisponibles(int[] intentos){
        int[] intentosDisponibles = new int[2];
        int registrados = 0;
        int disponibles = 0;

        for( int i = 0; i < intentos.length; i++ ){
            if(intentos[i] != 0){
                registrados++;
            }
            else{
                disponibles++;
            }
        }
        intentosDisponibles[0] = registrados;
        intentosDisponibles[1] = disponibles;
        return intentosDisponibles;
    }

}