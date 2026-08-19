package pokemonbattle;

public class Pokemon {

    private String nombre;
    private TipoPokemon tipo;
    private double ataque;
    private double defensa;
    private HabilidadEspecial habilidad;
    private boolean haPeleado;

    public Pokemon(String nombre, TipoPokemon tipo, double ataque, double defensa, HabilidadEspecial habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.haPeleado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public double getAtaque() {
        return ataque;
    }

    public double getDefensa() {
        return defensa;
    }

    public HabilidadEspecial getHabilidad() {
        return habilidad;
    }

    public boolean haPeleado() {
        return haPeleado;
    }

    public void marcarComoUsado() {
        this.haPeleado = true;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ", ATQ:" + ataque + ", DEF:" + defensa + ")";
    }
}
