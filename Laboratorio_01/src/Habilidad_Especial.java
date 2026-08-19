import java.util.Random;
public class Habilidad_Especial{
    private String nombre_habilidad;
    private int porcentaje_habilidad;
    public Habilidad_Especial(String nombre, int porcentaje){
        this.nombre_habilidad = nombre;
        this.porcentaje_habilidad = porcentaje;
    }
    public String getNombre(){
        return nombre_habilidad;
    }
    public int getPorcentaje(){
        return porcentaje_habilidad;
    }
    public boolean activar_Habilidad(){
        Random random = new Random();
        int numero = random.nextInt(101);
        return numero <= porcentaje_habilidad;
    }
    public int generar_Potenciador(){
        Random random = new Random();
        return random.nextInt(26);
    }

}