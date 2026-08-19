public class Pokemon {

    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidadEspecial;
    private boolean usado;

    public Pokemon(String nombre, String tipo, int ataque, int defensa,
                   HabilidadEspecial habilidadEspecial) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidadEspecial = habilidadEspecial;
        this.usado = false;
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

    public HabilidadEspecial getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public boolean estaUsado() {
        return usado;
    }

    public void marcarComoUsado() {
        usado = true;
    }

    public double calcularAtaqueEfectivo(int potenciador) {

        return ataque + (ataque * potenciador / 100.0);
    }

    public double calcularDefensaEfectiva(int potenciador) {

        return defensa + (defensa * potenciador / 100.0);
    }
}