import java.util.Random;

public class Pockemon{

    // atributos

    String nombre;
    String tipo;
    int ataque;
    int defensa;
    String nombreHabilidad;
    int probabilidadActivacion;
    boolean haPeleado;
    Random random = new Random();


    // métodos

    // Crea un pokemon con sus datos iniciales
    public Pockemon(String nombre, String tipo, int ataque, int defensa, String nombreHabilidad, int probabilidadActivacion){
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nombreHabilidad = nombreHabilidad;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    // Genera un numero al azar entre cero y cien y lo compara contra la probabilidad de activacion, para saber si la habilidad se activa
    public boolean intentarActivarHabilidad(){
        int requisitoActivacion = random.nextInt(100 + 1);
        return requisitoActivacion <= probabilidadActivacion;

    }

    //Genera un número al azar entre cero y veinticinco, que es el porcentaje de bono que da la habilidad al activarse
    public int generarPotenciador(){
        int potenciador = random.nextInt(25 + 1);
        return potenciador;
    }

    // getters de los datos de la clase Pockemon
    
    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public int getAtaque(){
        return ataque;
    }

    public int getDefensa(){
        return defensa;
    }

    public String getNombreHabilidad(){
        return nombreHabilidad;
    }

    public int getProbabilidadActivacion(){
        return probabilidadActivacion;
    }

    public boolean getHaPeleado(){
        return haPeleado;
    }

    // setters de los datos de la clase Pockemon

    public void setHaPeleado(boolean haPeleado){
        this.haPeleado = haPeleado;
    }


}
