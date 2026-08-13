public class Pokemon {

    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private Habilidadespecial Habilidadespecial;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, Habilidadespecial Habilidadespecial) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.Habilidadespecial = Habilidadespecial;

    }

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
    public Habilidadespecial getHabilidadEspecial() {
        return Habilidadespecial;
    }



}