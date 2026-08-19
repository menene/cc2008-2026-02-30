import java.util.ArrayList;

public class Pokemon {

    // Atributos de un Pokémon
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private String habilidad;
    private int probabilidadHabilidad;

    // Constructor
    public Pokemon(String nombre, String tipo, int ataque, int defensa,
                   String habilidad, int probabilidadHabilidad) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.probabilidadHabilidad = probabilidadHabilidad;
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

    public String getHabilidad() {
        return habilidad;
    }

    public int getProbabilidadHabilidad() {
        return probabilidadHabilidad;
    }

    
    public static ArrayList<Pokemon> crearPokemones() {

        ArrayList<Pokemon> pokemones = new ArrayList<>();

        
        // Pokémon de fuego
        

        pokemones.add(new Pokemon(
                "Charmander", "Fuego", 52, 43,
                "Llama Final", 30));

        pokemones.add(new Pokemon(
                "Charmeleon", "Fuego", 64, 58,
                "Llama Final", 34));

        pokemones.add(new Pokemon(
                "Charizard", "Fuego", 84, 78,
                "Llama Final", 20));

        pokemones.add(new Pokemon(
                "Vulpix", "Fuego", 41, 40,
                "Llama Final", 10));

        pokemones.add(new Pokemon(
                "Ninetales", "Fuego", 76, 75,
                "Llama Final", 39));

        pokemones.add(new Pokemon(
                "Growlithe", "Fuego", 70, 45,
                "Llama Final", 40));

        pokemones.add(new Pokemon(
                "Arcanine", "Fuego", 110, 80,
                "Llama Final", 60));

        pokemones.add(new Pokemon(
                "Ponyta", "Fuego", 85, 55,
                "Llama Final", 50));

        pokemones.add(new Pokemon(
                "Rapidash", "Fuego", 100, 70,
                "Llama Final", 90));

        pokemones.add(new Pokemon(
                "Magmar", "Fuego", 95, 57,
                "Llama Final", 15));

        pokemones.add(new Pokemon(
                "Flareon", "Fuego", 130, 60,
                "Llama Final", 35));

        pokemones.add(new Pokemon(
                "Moltres", "Fuego", 100, 90,
                "Llama Final", 67));


        // Pokémon de agua

        pokemones.add(new Pokemon(
                "Squirtle", "Agua", 48, 65,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Wartortle", "Agua", 63, 80,
                "Inundación devastadora", 67));

        pokemones.add(new Pokemon(
                "Blastoise", "Agua", 83, 100,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Psyduck", "Agua", 52, 48,
                "Inundación devastadora", 99));

        pokemones.add(new Pokemon(
                "Golduck", "Agua", 82, 78,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Poliwag", "Agua", 50, 40,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Poliwhirl", "Agua", 65, 65,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Poliwrath", "Agua", 85, 95,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Tentacool", "Agua", 40, 100,
                "Inundación devastadora", 29));

        pokemones.add(new Pokemon(
                "Tentacruel", "Agua", 80, 65,
                "Inundación devastadora", 41));

        pokemones.add(new Pokemon(
                "Slowpoke", "Agua", 65, 65,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Slowbro", "Agua", 75, 110,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Seel", "Agua", 45, 55,
                "Inundación devastadora", 01));

        pokemones.add(new Pokemon(
                "Dewgong", "Agua", 70, 80,
                "Inundación devastadora", 49));

        pokemones.add(new Pokemon(
                "Shellder", "Agua", 65, 100,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Cloyster", "Agua", 95, 180,
                "Inundación devastadora", 23));

        pokemones.add(new Pokemon(
                "Krabby", "Agua", 105, 90,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Kingler", "Agua", 130, 115,
                "Inundación devastadora", 17));

        pokemones.add(new Pokemon(
                "Horsea", "Agua", 40, 70,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Seadra", "Agua", 65, 95,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Seaking", "Agua", 92, 65,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Staryu", "Agua", 45, 55,
                "Inundación devastadora", 76));

        pokemones.add(new Pokemon(
                "Starmie", "Agua", 75, 85,
                "Inundación devastadora", 40));

        pokemones.add(new Pokemon(
                "Vaporeon", "Agua", 65, 60,
                "Inundación devastadora", 80));

        pokemones.add(new Pokemon(
                "Lapras", "Agua", 85, 80,
                "Inundación devastadora", 07));

        pokemones.add(new Pokemon(
                "Gyarados", "Agua", 125, 79,
                "Inundación devastadora", 40));


        // Pokémon de planta

        pokemones.add(new Pokemon(
                "Bulbasaur", "Planta", 49, 49,
                "Escudo Natural", 67));

        pokemones.add(new Pokemon(
                "Ivysaur", "Planta", 62, 63,
                "Escudo Natural", 40));

        pokemones.add(new Pokemon(
                "Venusaur", "Planta", 82, 83,
                "Escudo Natural", 20));

        pokemones.add(new Pokemon(
                "Oddish", "Planta", 50, 55,
                "Escudo Natural", 50));

        pokemones.add(new Pokemon(
                "Gloom", "Planta", 65, 70,
                "Escudo Natural", 40));

        pokemones.add(new Pokemon(
                "Vileplume", "Planta", 80, 85,
                "Escudo Natural", 40));

        pokemones.add(new Pokemon(
                "Bellsprout", "Planta", 75, 35,
                "Escudo Natural", 45));

        pokemones.add(new Pokemon(
                "Weepinbell", "Planta", 90, 50,
                "Escudo Natural", 30));

        pokemones.add(new Pokemon(
                "Victreebel", "Planta", 105, 65,
                "Escudo Natural", 10));


        // Pokémon de eléctrico

        pokemones.add(new Pokemon(
                "Pikachu", "Electrico", 55, 40,
                "Impacto Relampago", 25));

        pokemones.add(new Pokemon(
                "Raichu", "Electrico", 90, 55,
                "Impacto Relampago", 20));


        return pokemones;
    }
}