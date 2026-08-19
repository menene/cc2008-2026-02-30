public class Pokemon {

    private String nombre;
    private String tipo;
    private float ataque;
    private float defensa;
    private HabilidadEspecial habilidadE;

    public Pokemon(String nombre, String tipo, float ataque, float defensa, HabilidadEspecial habilidadE) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidadE = habilidadE;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public float getAtaque() {
        return ataque;
    }

    public float getDefensa() {
        return defensa;
    }

    public HabilidadEspecial getHabilidadE() {
        return habilidadE;
    }
}