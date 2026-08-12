public class Pokemon {
    private String nombre;
    private String tipo;
    private double ataque;
    private double defensa;
    private HabilidadesEspeciales habilidadEspecial;

    public Pokemon(String nombre, String tipo, double ataque, double defensa,
                   HabilidadesEspeciales habilidadEspecial) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getAtaque() {
        return ataque;
    }

    public double getDefensa() {
        return defensa;
    }

    public HabilidadesEspeciales getHabilidadEspecial() {
        return habilidadEspecial;
    }
}