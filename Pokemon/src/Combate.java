import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combate {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int victoriasEntrenador1;
    private int victoriasEntrenador2;

    public Combate(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.victoriasEntrenador1 = 0;
        this.victoriasEntrenador2 = 0;
    }

    public void iniciarCombate() {

        List<Pokemon> disponibles1 = new ArrayList<>(entrenador1.getPokemones());
        List<Pokemon> disponibles2 = new ArrayList<>(entrenador2.getPokemones());

        boolean entrenador1Ataca = true;

        for (int ronda = 1; ronda <= 4; ronda++) {

            Entrenador atacante;
            Entrenador defensor;
            List<Pokemon> pokemonesAtacante;
            List<Pokemon> pokemonesDefensor;

            if (entrenador1Ataca) {
                atacante = entrenador1;
                defensor = entrenador2;
                pokemonesAtacante = disponibles1;
                pokemonesDefensor = disponibles2;
            } else {
                atacante = entrenador2;
                defensor = entrenador1;
                pokemonesAtacante = disponibles2;
                pokemonesDefensor = disponibles1;
            }

            Pokemon pokemonAtacante = seleccionarPokemon(pokemonesAtacante);
            Pokemon pokemonDefensor = seleccionarPokemon(pokemonesDefensor);

            double ataqueEfectivo = pokemonAtacante.getAtaque();
            double defensaEfectiva = pokemonDefensor.getDefensa();

            if (pokemonAtacante.getHabilidadEspecial().seActiva()) {
                double potenciador =
                        pokemonAtacante.getHabilidadEspecial().generarPotenciador();

                ataqueEfectivo += ataqueEfectivo * (potenciador / 100);
            }

            if (pokemonDefensor.getHabilidadEspecial().seActiva()) {
                double potenciador =
                        pokemonDefensor.getHabilidadEspecial().generarPotenciador();

                defensaEfectiva += defensaEfectiva * (potenciador / 100);
            }

            double bonoTipo = calcularBonoTipo(
                    pokemonAtacante.getTipo(),
                    pokemonDefensor.getTipo()
            );

            double ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;

            System.out.println("\nRonda " + ronda);
            System.out.println(
                    pokemonAtacante.getNombre() + " ataca a "
                    + pokemonDefensor.getNombre()
            );

            if (ataqueTotal > 0) {
                System.out.println("Gano esta ronda: " + atacante.getNombre());

                if (atacante == entrenador1) {
                    victoriasEntrenador1++;
                } else {
                    victoriasEntrenador2++;
                }

            } else if (ataqueTotal < 0) {
                System.out.println("Gano esta ronda: " + defensor.getNombre());

                if (defensor == entrenador1) {
                    victoriasEntrenador1++;
                } else {
                    victoriasEntrenador2++;
                }

            } else {
                System.out.println("Empate");
            }

            entrenador1Ataca = !entrenador1Ataca;
        }

        mostrarResultado();
    }

    private Pokemon seleccionarPokemon(List<Pokemon> disponibles) {

        Random random = new Random();

        int posicion = random.nextInt(disponibles.size());

        return disponibles.remove(posicion);
    }

    private double calcularBonoTipo(String tipoAtacante, String tipoDefensor) {

        if (tipoAtacante.equals("Fuego")
                && tipoDefensor.equals("Planta")) {
            return 20;
        }

        if (tipoAtacante.equals("Planta")
                && tipoDefensor.equals("Fuego")) {
            return -10;
        }

        if (tipoAtacante.equals("Agua")
                && tipoDefensor.equals("Fuego")) {
            return 20;
        }

        if (tipoAtacante.equals("Fuego")
                && tipoDefensor.equals("Agua")) {
            return -10;
        }

        if (tipoAtacante.equals("Planta")
                && tipoDefensor.equals("Agua")) {
            return 20;
        }

        if (tipoAtacante.equals("Agua")
                && tipoDefensor.equals("Planta")) {
            return -10;
        }

        if (tipoAtacante.equals("Eléctrico")
                && tipoDefensor.equals("Agua")) {
            return 20;
        }

        return 0;
    }

    private void mostrarResultado() {

        System.out.println("RESULTADO");

        System.out.println(
                entrenador1.getNombre() + ": "
                + victoriasEntrenador1 + " victorias"
        );

        System.out.println(
                entrenador2.getNombre() + ": "
                + victoriasEntrenador2 + " victorias"
        );

        if (victoriasEntrenador1 > victoriasEntrenador2) {
            System.out.println(
                    "Ganador: " + entrenador1.getNombre()
            );

        } else if (victoriasEntrenador2 > victoriasEntrenador1) {
            System.out.println(
                    "Ganador: " + entrenador2.getNombre()
            );

        } else {
            System.out.println("Es un empate.");
        }
    }
}