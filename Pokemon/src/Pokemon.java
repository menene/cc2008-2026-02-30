public class Pokemon {
    private String nombre;
    private String Tipo; 
    private int ataque;
    private int defensa;
    private Habilidad habilidad;

    public Pokemon(String nombre, Habilidad habilidad, int ataque, int defensa, String tipo) {
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.ataque = ataque;
        this.defensa = defensa;
        this.Tipo = tipo;
    }

    public void mostrarHabilidad(String nombre, int potenciador) {
        System.out.println("Habilidad: " + nombre);
        System.out.println("Potenciador: " + potenciador + "%");
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return Tipo;
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

}