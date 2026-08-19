package pokemonbattle;

import java.util.Random;


public class HabilidadEspecial {

    private String nombre;
    private int probabilidadActivacion;
    private static final Random RANDOM = new Random();

    public HabilidadEspecial(String nombre, int probabilidadActivacion) {
        this.nombre = nombre;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }

   
    public boolean intentarActivacion() {
        int sorteo = RANDOM.nextInt(101); // 0 a 100 inclusive
        return sorteo <= probabilidadActivacion;
    }

    
    public int generarPotenciador() {
        return RANDOM.nextInt(26); // 0 a 25 inclusive
    }
}
