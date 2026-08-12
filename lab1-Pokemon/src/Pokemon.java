public class Pokemon {
    // Atributos
    private String nombre;
    private int tipo;
    private int ataque;
    private int defensa;
    private boolean usado;
    private HabilidadEspecial habilidadEspecial;

    // Método constructor
    public Pokemon(String nombre, int tipo, int ataque, int defensa, HabilidadEspecial habilidadEspecial) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidadEspecial = habilidadEspecial;
        this.usado = false;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public int getTipo() {
        return this.tipo;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int defensa() {
        return this.defensa;
    }

    public boolean estaUsado() {
        return this.usado;
    }

    public void marcarComoUsado() {
        this.usado = true;
    }

    public HabilidadEspecial getHabilidadEspecial() {
        return this.habilidadEspecial;
    }
}