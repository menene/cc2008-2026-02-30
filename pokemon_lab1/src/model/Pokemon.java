package model;

public class Pokemon {

    public enum TipoPokemon {
        FUEGO, AGUA, PLANTA, ELECTRICO
    }

    private String nombre;
    private TipoPokemon tipo;
    private int ataque;
    private int defensa;
    private String nombreHabilidad;
    private int probabilidadActivacion;
    private boolean haPeleado;


    public Pokemon(String nombre, TipoPokemon tipo, int ataque, int defensa, String nombreHabilidad, int probabilidadActivacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nombreHabilidad = nombreHabilidad;
        this.probabilidadActivacion = probabilidadActivacion;
        this.haPeleado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }

    public boolean isHaPeleado() {
        return haPeleado;
    }

    public void setHaPeleado(boolean haPeleado) {
        this.haPeleado = haPeleado;
    }

    public int intentarActivarHabilidad() {
        int probabilidad = (int) (Math.random() * 101);
        if (probabilidad <= probabilidadActivacion) {
            return (int) (Math.random() * 26);
        }
        return 0;
    }

}