import java.util.Random;
public class HabilidadEsp {
    private String nombreHab; 
    private int probabilidadActivacion; 

    //CONSTRUCTOR
    public HabilidadEsp(String nombreHab, int probabilidadActivacion) {
        this.nombreHab = nombreHab; 
        this.probabilidadActivacion = probabilidadActivacion; 
    }
    //GETTER
    public String getNombreHab() {
         return nombreHab; 
    }
    // PARTE QUE REALIZA EL SOTERO DE 0 A 100 Y VERIFICA QUE
    // ESTÉ DENTRO DEL RANGO PARA ACTIVAR EL POTENCIADOR.
    public int sorteoHabilidad() {
        Random random = new Random(); 
        int numeroHabilidad = random.nextInt(101);
        if (numeroHabilidad <= probabilidadActivacion) {
            return potenciador(); 
        } else {
            return 0; 
        }
    }

    //Establecer el potenciador que se le dará al pokemon
    public int potenciador(){
        Random random = new Random(); 
        int totalPotencia = random.nextInt(26);
        return totalPotencia; 
    }
    
}


    