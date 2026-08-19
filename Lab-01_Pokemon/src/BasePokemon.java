import java.util.Random;

public class BasePokemon {

    private Pokemon[] pokemones;
    public BasePokemon(){

        pokemones = new Pokemon[12];

        pokemones[0] = new Pokemon(
        "Charmander", "Fuego", 52, 43,
        new HabilidadEspecial("Llama Final", 30));

        pokemones[1] = new Pokemon(
        "Vulpix", "Fuego", 41, 40,
        new HabilidadEspecial("Fuego Veloz", 35));

        pokemones[2] = new Pokemon(
        "Growlithe", "Fuego", 70, 45,
        new HabilidadEspecial("Colmillo Ardiente", 25));

        pokemones[3] = new Pokemon(
        "Squirtle", "Agua", 48, 65,
        new HabilidadEspecial("Escudo Acuatico", 40));

        pokemones[4] = new Pokemon(
        "Psyduck", "Agua", 52, 48,
        new HabilidadEspecial("Oleada Mental", 30));

        pokemones[5] = new Pokemon(
        "Poliwag", "Agua", 50, 40,
        new HabilidadEspecial("Torrente", 35));

        pokemones[6] = new Pokemon(
        "Bulbasaur", "Planta", 49, 49,
        new HabilidadEspecial("Escudo Natural", 45));

        pokemones[7] = new Pokemon(
        "Oddish", "Planta", 50, 55,
        new HabilidadEspecial("Raiz Protectora", 35));

        pokemones[8] = new Pokemon(
        "Bellsprout", "Planta", 75, 35,
        new HabilidadEspecial("Latigo Verde", 25));

        pokemones[9] = new Pokemon(
        "Pikachu", "Electrico", 55, 40,
        new HabilidadEspecial("Impacto Relampago", 30));

        pokemones[10] = new Pokemon(
        "Magnemite", "Electrico", 35, 70,
        new HabilidadEspecial("Campo Magnetico", 35));

        pokemones[11] = new Pokemon(
        "Voltorb", "Electrico", 30, 50,
        new HabilidadEspecial("Sobrecarga", 25));

    }
    
    public Pokemon[] seleccionarPokemones(){

        Pokemon[] seleccionados = new Pokemon[8];
        boolean[] usados = new boolean[12];
        Random random = new Random();

        for (int i = 0; i < seleccionados.length; i++){

            int posicion = random.nextInt(12);

            if(!usados[posicion]){

                seleccionados[i] = pokemones[posicion];
                usados[posicion] = true;
            } else {

                i--;
            }
        }
        
        return seleccionados;
    }
}