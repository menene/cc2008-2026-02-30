import java.util.Random;
public class HabilidadEspecial{
    Random random = new Random();
    String nombre;
    byte probabilidadActivacion;

    public String getNombre(){
        return nombre;
    }
    public byte getProbabilidad(){
        return probabilidadActivacion;
    }

    public HabilidadEspecial(String nombre, byte probabilidad){
        this.nombre= nombre;
        this.probabilidadActivacion=probabilidad;
    }

    public boolean SeActiva(){ 
        int min = 0;
        int max = 99;
        byte numeroAleatorio =(byte)(random.nextInt(max - min + 1) + min);
        if (numeroAleatorio < probabilidadActivacion){
            return true;
        }else {
            return false;
        }
    }

    public byte Habilidad(byte movimiento){
        if (SeActiva()){
            int min = 1;
            int max = 25;
            byte numeroAleatorio =(byte)(random.nextInt(max - min + 1) + min);
            byte bonificacion =(byte) ((movimiento*numeroAleatorio)/100);
            return bonificacion;
        }else{
            return 0;
        }
    }
}