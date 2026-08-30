package modelo;

import java.util.Random;

// Guarda la habilidad especial de un Pokemon: su nombre y su probabilidad de activarse.
public class HabilidadEspecial {

    private String nombre;
    private int probabilidadActivacion;

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

    // Tira un numero de 0 a 100 y dice si la habilidad se activa en esta ronda.
    public boolean intentarActivar(Random aleatorio) {
        int numero = aleatorio.nextInt(101);
        return numero <= probabilidadActivacion;
    }

    // Devuelve el porcentaje del potenciador, que va de 0 a 25.
    public int calcularPotenciador(Random aleatorio) {
        return aleatorio.nextInt(26);
    }
}
