import java.util.Random;

public class Entrenador {

    // Atributos
    private String nombre;

    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;

    private boolean pokemon1Usado;
    private boolean pokemon2Usado;
    private boolean pokemon3Usado;
    private boolean pokemon4Usado;

    // Constructor
    public Entrenador(String nombre, Pokemon pokemon1, Pokemon pokemon2,
                      Pokemon pokemon3, Pokemon pokemon4) {

        this.nombre = nombre;

        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;

        this.pokemon1Usado = false;
        this.pokemon2Usado = false;
        this.pokemon3Usado = false;
        this.pokemon4Usado = false;
    }

    // Selecciona de manera aleatoria uno de los pokemones que el entrenador aun no ha usado
    public Pokemon seleccionarPokemon() {

        Random random = new Random();

        while (true) {

            int numero = random.nextInt(4) + 1;

            if (numero == 1 && !pokemon1Usado) {
                pokemon1Usado = true;
                return pokemon1;
            }

            if (numero == 2 && !pokemon2Usado) {
                pokemon2Usado = true;
                return pokemon2;
            }

            if (numero == 3 && !pokemon3Usado) {
                pokemon3Usado = true;
                return pokemon3;
            }

            if (numero == 4 && !pokemon4Usado) {
                pokemon4Usado = true;
                return pokemon4;
            }
        }
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public Pokemon getPokemon3() {
        return pokemon3;
    }

    public Pokemon getPokemon4() {
        return pokemon4;
    }
}