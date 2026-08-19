public class Pokemon {

    // Atributos
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidad;//tomo un objeto de mi otra clase: habilidad

    // Constructor
    public Pokemon(String nombre, String tipo, int ataque, int defensa,
                   HabilidadEspecial habilidad) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public HabilidadEspecial getHabilidad() {
        return habilidad;
    }
}
