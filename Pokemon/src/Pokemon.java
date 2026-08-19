public class Pokemon {
    private String nombre;
    private Tipo tipo;
    private double ataque;
    private double defensa;
    private HabilidadEspecial habilidad;
    private boolean yaPeleo;

    public Pokemon(String nombre, Tipo tipo, double ataque, double defensa, HabilidadEspecial habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.yaPeleo = false; // Por defecto no ha peleado al crearse
    }

    public void marcarComoPeleado() {
        this.yaPeleo = true;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }
    public double getAtaque() { return ataque; }
    public void setAtaque(double ataque) { this.ataque = ataque; }
    public double getDefensa() { return defensa; }
    public void setDefensa(double defensa) { this.defensa = defensa; }
    public HabilidadEspecial getHabilidad() { return habilidad; }
    public void setHabilidad(HabilidadEspecial habilidad) { this.habilidad = habilidad; }
    public boolean isYaPeleo() { return yaPeleo; }
    public void setYaPeleo(boolean yaPeleo) { this.yaPeleo = yaPeleo; }
}