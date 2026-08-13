public class Entrenador {
    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;

    public Entrenador() {
    }

    public Entrenador(String nombre, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4) {
        this.nombre = nombre;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public Pokemon getPokemon3() {
        return pokemon3;
    }

    public void setPokemon3(Pokemon pokemon3) {
        this.pokemon3 = pokemon3;
    }

    public Pokemon getPokemon4() {
        return pokemon4;
    }

    public void setPokemon4(Pokemon pokemon4) {
        this.pokemon4 = pokemon4;
    }
}