public class Pokemon {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private boolean haPeleado;
    private boolean asignado;
    private Habilidad habilidad;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, Habilidad habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;

        haPeleado = false;
        asignado = false;
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

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public boolean haPeleado() {
        return haPeleado;
    }

    public void setHaPeleado(boolean haPeleado) {
        this.haPeleado = haPeleado;
    }

    public boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
}
