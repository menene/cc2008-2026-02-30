import java.util.Random;    
public class Entrenador {
    private String nombre;
    private Pokemon pokemon1, pokemon2, pokemon3, pokemon4;
    private int seleccionados;

    public Entrenador(String nombre, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4) {
        this.nombre = nombre;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
        this.seleccionados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon[] getPokemones() {
        return new Pokemon[]{pokemon1, pokemon2, pokemon3, pokemon4};
    }

    public Pokemon seleccion() {
        Random random = new Random();
        int numero = random.nextInt(4) + 1;
        Pokemon elegido = null;

        if (numero == 1 && pokemon1 != null) {

            elegido = pokemon1;
            pokemon1 = null;

        } else if (numero == 2 && pokemon2 != null) {

            elegido = pokemon2;
            pokemon2 = null;

        } else if (numero == 3 && pokemon3 != null) {

            elegido = pokemon3;
            pokemon3 = null;

        } else if (numero == 4 && pokemon4 != null) {

            elegido = pokemon4;
            pokemon4 = null;
        }

        if (elegido == null) {
            return seleccion();
        }
        return elegido;
    }
}