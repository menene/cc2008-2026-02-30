package modelo;

// Guarda los datos de un Pokemon que se trajeron de la PokeAPI.
public class Pokemon {

    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidad;
    private boolean yaPeleo;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, HabilidadEspecial habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        // Al inicio ningun Pokemon ha peleado.
        this.yaPeleo = false;
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

    public HabilidadEspecial getHabilidad() {
        return habilidad;
    }

    public boolean getYaPeleo() {
        return yaPeleo;
    }

    // Marca al Pokemon para que ya no lo puedan escoger en otra ronda.
    public void marcarComoPeleado() {
        this.yaPeleo = true;
    }

    // Suma al ataque el porcentaje de la habilidad. Ejemplo: 40 con 20% da 48.
    public int calcularAtaqueEfectivo(int porcentaje) {
        int extra = (int) (ataque * porcentaje / 100.0);
        return ataque + extra;
    }

    // Suma a la defensa el porcentaje de la habilidad, igual que el ataque.
    public int calcularDefensaEfectiva(int porcentaje) {
        int extra = (int) (defensa * porcentaje / 100.0);
        return defensa + extra;
    }
}
