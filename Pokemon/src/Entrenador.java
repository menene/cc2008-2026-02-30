public class Entrenador {

    // Atributos
    private String nombre;
    private Pokemon[] pokemones;

    // Constructor
    public Entrenador(String nombre, Pokemon[] pokemones) {
        this.nombre = nombre;
        this.pokemones = pokemones;
    }
    

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Pokemon[] getPokemones() {
        return pokemones;
    }
}
