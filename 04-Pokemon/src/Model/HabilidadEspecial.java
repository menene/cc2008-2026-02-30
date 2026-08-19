package Model;

import java.util.Random;

public class HabilidadEspecial {

    private String nombreHabilidad;
    private int probabilidadActivacion;

    public HabilidadEspecial(String nombreHabilidad, int probabilidadActivacion) {
        this.nombreHabilidad = nombreHabilidad;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }

    public boolean intentarActivacion() {
        Random random = new Random();
        int numero = random.nextInt(101);

        return numero <= probabilidadActivacion;
    }

    public int generarPotenciador() {
        Random random = new Random();
        return random.nextInt(26);
    }
}