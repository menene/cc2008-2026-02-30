import java.util.Random;
public class Habilidadespecial {
    private String nombreHabilidad;
    private int probabilidadAct;

    public Habilidadespecial (String nombreHabilidad, int probabilidadAct){
        this.nombreHabilidad = nombreHabilidad;
        this.probabilidadAct = probabilidadAct;

    }

    public boolean activarHabilidad(){
        Random random = new Random();
        int numero = random.nextInt(101);

        if (numero <= probabilidadAct){
            return true;
        } else {
            return false;
        }
    }

    public int generarPotenciador(){
        Random random = new Random();
        int potenciador = random.nextInt(26);

        return potenciador;

    }

    public String getNombreHabilidad() {
    return nombreHabilidad;
    }

    public int getProbabilidadAct() {
        return probabilidadAct;
    }

}