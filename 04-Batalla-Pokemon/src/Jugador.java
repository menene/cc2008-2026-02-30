import java.util.Random;

public class Jugador {

    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private int rondasGanadas;

    // Constructor
    public Jugador(String nombre, int equipo) {

        this.nombre = nombre;
        this.rondasGanadas = 0;

        // Equipo 1
        if (equipo == 1) {

            pokemon1 = new Pokemon(
                    "Charmander",
                    "Fuego",
                    50,
                    35,
                    new HabilidadEspecial("Llama Final", 30)
            );

            pokemon2 = new Pokemon(
                    "Squirtle",
                    "Agua",
                    40,
                    50,
                    new HabilidadEspecial("Escudo Natural", 40)
            );

            pokemon3 = new Pokemon(
                    "Pikachu",
                    "Electrico",
                    55,
                    35,
                    new HabilidadEspecial("Impacto Relampago", 20)
            );

            pokemon4 = new Pokemon(
                    "Bulbasaur",
                    "Planta",
                    45,
                    45,
                    new HabilidadEspecial("Energia Natural", 35)
            );

        // Equipo 2
        } else {

            pokemon1 = new Pokemon(
                    "Vulpix",
                    "Fuego",
                    45,
                    40,
                    new HabilidadEspecial("Llama Poderosa", 30)
            );

            pokemon2 = new Pokemon(
                    "Psyduck",
                    "Agua",
                    45,
                    45,
                    new HabilidadEspecial("Defensa Acuatica", 40)
            );

            pokemon3 = new Pokemon(
                    "Magnemite",
                    "Electrico",
                    50,
                    40,
                    new HabilidadEspecial("Rayo Electrico", 20)
            );

            pokemon4 = new Pokemon(
                    "Oddish",
                    "Planta",
                    40,
                    50,
                    new HabilidadEspecial("Poder Natural", 35)
            );
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public void setRondasGanadas(int rondasGanadas) {
        this.rondasGanadas = rondasGanadas;
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

    public Pokemon seleccionarPokemon() {

        Random random = new Random();

        Pokemon seleccionado = null;

        while (seleccionado == null) {

            int numero = random.nextInt(4) + 1;

            if (numero == 1 && !pokemon1.getAgotado()) {
                seleccionado = pokemon1;

            } else if (numero == 2 && !pokemon2.getAgotado()) {
                seleccionado = pokemon2;

            } else if (numero == 3 && !pokemon3.getAgotado()) {
                seleccionado = pokemon3;

            } else if (numero == 4 && !pokemon4.getAgotado()) {
                seleccionado = pokemon4;
            }
        }

        seleccionado.setAgotado(true);

        return seleccionado;
    }
}