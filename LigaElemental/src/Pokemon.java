public class Pokemon {

    private String nombre;
    private String tipo; // Fuego, Agua, Planta o Electrico
    private int ataque;
    private int defensa;
    private Habilidad habilidad;
    private boolean haPeleado; // controla que no participe en mas de una ronda

    public Pokemon(String nombre, String tipo, int ataque, int defensa, Habilidad habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.haPeleado = false; // al inicar ningun Pokemon ha peleado todavia
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

    public boolean isHaPeleado() {
        return haPeleado;
    }

    public void setHaPeleado(boolean haPeleado) {
        this.haPeleado = haPeleado;
    }
}