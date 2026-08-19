import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();

        //lista de pokemones que usare
        pokemones.add(new Pokemon("Charizard","Fuego",60,45, new Habilidadespecial("Llama final", 30)));
        pokemones.add(new Pokemon("Vulpix","Fuego",42,38, new Habilidadespecial("Llama final", 30)));
        pokemones.add(new Pokemon("Growlithe","Fuego",55,40, new Habilidadespecial("Llama final", 30)));
        pokemones.add(new Pokemon("Psyduck","Agua",42,40, new Habilidadespecial("Escudo Natural", 40)));
        pokemones.add(new Pokemon ("Poliwag","Agua",38,42,new Habilidadespecial("Escudo Natural", 40)));
        pokemones.add(new Pokemon ("Staryu","Agua", 48,45, new Habilidadespecial("Escudo Natural", 40)));
        pokemones.add(new Pokemon("Oddish","Planta",40,42,new Habilidadespecial("Escudo Natural", 40)));
        pokemones.add(new Pokemon("Bellsprout","Planta",48,35,new Habilidadespecial("Escudo Natural", 40)));
        pokemones.add(new Pokemon("Exeggcute","Planta",42,50,new Habilidadespecial("Escudo Natural", 40)));
        pokemones.add(new Pokemon("Raichu","Electrico",58,40, new Habilidadespecial("Impacto Relampago", 20)));
        pokemones.add(new Pokemon("Magnemite","Electrico",45,55,new Habilidadespecial("Impacto Relampago", 20)));
        pokemones.add(new Pokemon("Voltorb","Electrico",45,42,new Habilidadespecial("Impacto Relampago", 20)));

        Entrenador jugador1 = new Entrenador("Jugador 1");
        Entrenador jugador2 = new Entrenador("Jugador 2");

        jugador1.seleccionarEquipo(pokemones);
        jugador2.seleccionarEquipo(pokemones);

        System.out.println("Equipo 1: ");
        for (Pokemon pokemon : jugador1.getEquipo()){
            System.out.println(pokemon.getNombre());

        }

        System.out.println("\nEquipo 2: ");

        for (Pokemon pokemon : jugador2.getEquipo()){
            System.out.println(pokemon.getNombre());
        }
        Batalla batalla = new Batalla(jugador1, jugador2);

        batalla.iniciarBatalla();

        Vista vista =new Vista();
        vista.determinarGanador(batalla.getVictorias1(),batalla.getVictorias2());

    }
    
}