public class Pokemon {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private Habilidad habilidad;
    private boolean usado;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, Habilidad habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.usado = false;
    }

    public String GetNombre() {
        return this.nombre;
    }

    public String GetTipo() {
        return this.tipo;
    }

    public int GetAtaque() {
        return this.ataque;
    }

    public int GetDefensa() {
        return this.defensa;
    }

    public Habilidad GetHabilidad() {
        return this.habilidad;
    }

    public boolean GetUsado() {
        return this.usado;
    }

    public void SetUsado() {
        this.usado = true;
    }
}