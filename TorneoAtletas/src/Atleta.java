public class Atleta{

    // atributos

    String nombre;
    int noParticipante;
    int edad;
    int[] intentos = new int[10];


    // métodos

    // crea un atleta con sus datos iniciales
    public Atleta(String nombre, int noParticipante, int edad){
        this.nombre = nombre;
        this.noParticipante = noParticipante;
        this.edad = edad;
    }

    // retorna el nombre del comprador
    public String getNombre(){
        return nombre;
    }
    
    // retorna los intentos que ha realizado el atleta
    public int[] getIntentos(){
        return intentos;
    }
    
    // permite realizar cambios a la lista de intentos que se han realizado
    public void setIntentos(int[] intentos){
        this.intentos = intentos;
    }


}