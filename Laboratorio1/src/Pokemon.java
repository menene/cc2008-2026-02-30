public class Pokemon {

    private String nombre;
    private String tipo;
    private double ataque;
    private double defensa;
    private HabilidadEspecial habilidadEspecial;
    private boolean haPeleado;

    public Pokemon() {
    }

    public Pokemon(String nombre, String tipo, double ataque, double defensa, HabilidadEspecial habilidadEspecial) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidadEspecial = habilidadEspecial;
        this.haPeleado = false;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setHabilidadEspecial(HabilidadEspecial habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public HabilidadEspecial getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHaPeleado(boolean haPeleado) {
        this.haPeleado = haPeleado;
    }

    public boolean getHaPeleado() {
        return haPeleado;
    }
}