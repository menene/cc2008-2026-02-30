import java.util.Arrays;
public class Atleta {
    private int noparticipante;
    private String Nombre;
    private int [] intentos;
    private int intentosHechos;

    public Atleta (int numero, String nombre, int longuitud){
        this.noparticipante = numero;
        this.Nombre = nombre;
        this.intentos = new int[longuitud];
    }

    public int [] VerArray(){
        int[] copia = Arrays.copyOf(intentos, intentos.length);
        return copia;
    }

    public String NombreAtleta (){
        return Nombre;
    }

    public int NumeroAtleta(){
        return noparticipante;
    }
    public int IntentosAtleta(){
        return intentosHechos;

    }


    // Y aqui las validaciones de la clase de utilidad Validaciones :v


    public int contadorDisponibles(){
        int intentosDisponibles = intentos.length-intentosHechos;
        return intentosDisponibles;
    }


    public boolean validacionRango(int indice){
        if (indice > 0 && indice < intentos.length){
            return true;
        }else{
            return false;
        }
    }

    public int Validacionindice(){
        for (int i =0; i < intentos.length; i++){
            if (intentos[i]==0) { 
                
                return i;
            }
        }
        return -1;
    }

    public boolean ValidacionTiempo(int t){
        if (t <= 0){
            return false;
        }else {
            return true;
        }
    }

    public boolean ValidacionDisponibilidad(){
        if (intentos ==null){
            return false;
        } 

        for (int i = 0; i < intentos.length; i++){
            if (intentos[i]==0){
                return true;                
            }            
        }
        return false;
                
    }
    // quizar ponerlas en controllador habria sido buena idea?
    public String EditarIntento(int indice, int nuevotiempo){
        String mensaje;
        if (ValidacionTiempo(nuevotiempo) && validacionRango(indice)) {
            intentos[indice]= nuevotiempo;
            mensaje= "Tiempo Editado con exito";
            return mensaje;
        }else {
            mensaje = "Tiempo o indice invalido";
            return mensaje;
        }
    }


    public String AgregarIntento(int nuevotiempo) {
        String mensaje;
        if (ValidacionTiempo(nuevotiempo) && ValidacionDisponibilidad()) {
            int indice = Validacionindice();
            intentosHechos ++;
            intentos[indice] = nuevotiempo;
            mensaje = "Tiempo registrado con exito";
            return mensaje;
        } else {
            mensaje = "Tiempo invalido o intentos completados";
            return mensaje;
        }
    }
}