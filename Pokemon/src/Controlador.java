import java.util.ArrayList;
import java.util.Random;

public class Controlador {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Vista vista;
    private Batalla batalla;

    private ArrayList<Pokemon> pokemones;
    private Random random;


    public Controlador() {

        vista = new Vista();
        batalla = new Batalla();

        pokemones = Pokemon.crearPokemones();

        random = new Random();
    }


    public void iniciar() {

        entrenador1 = nuevoEntrenador("Entrenador 1");
        entrenador2 = nuevoEntrenador("Entrenador 2");


        vista.mostrarMenuPokemon(pokemones);


        asignarPokemones(entrenador1);
        asignarPokemones(entrenador2);


        vista.mostrarEntrenador(entrenador1);
        vista.mostrarEntrenador(entrenador2);


        vista.mostrarInicioBatalla(
                entrenador1,
                entrenador2);


        batalla.iniciarBatalla(
                entrenador1,
                entrenador2);


        vista.mostrarMarcador(
                entrenador1,
                batalla.getVictoriasEntrenador1(),
                entrenador2,
                batalla.getVictoriasEntrenador2());


        vista.mostrarBatalla(
                batalla.getGanador_perdedor());
    }


    public Entrenador nuevoEntrenador(String nombre) {

        return new Entrenador(nombre);
    }


    private void asignarPokemones(
            Entrenador entrenador) {

        while (entrenador
                .getEleccion_pokemon()
                .size() < 4) {

            int posicion =
                    random.nextInt(pokemones.size());

            Pokemon pokemon =
                    pokemones.get(posicion);

            entrenador.agregarPokemon(pokemon);
        }
    }
}