import java.util.Scanner;

public class Vista {
    private Scanner sc;

    public Vista() {
        sc = new Scanner(System.in);
    }

    public void mostrarInicio() {
        System.out.println("==========================");
        System.out.println("     LIGA ELEMENTAL");
        System.out.println("==========================");
    }

    public String pedirNombreJugador(int numeroJugador) {
        System.out.print("Ingrese el nombre del Jugador "
                + numeroJugador + ": ");

        return sc.nextLine();
    }

    public void pausar() {
        System.out.println();
        System.out.println("Presiona Enter para comenzar la batalla...");
        sc.nextLine();
    }

    public int pedirPokemon(String nombreJugador, int numeroPokemon) {
        System.out.println();
        System.out.println(nombreJugador + ", selecciona tu Pokémon " + numeroPokemon + " de 4:");

        System.out.println("Opción: ");
        int opcion = sc.nextInt();

        sc.nextLine();
        return opcion;
    }

    public void mostrarPokemonDisponibles(Pokemon p1, Pokemon p2, Pokemon p3, Pokemon p4, Pokemon p5, Pokemon p6,
            Pokemon p7, Pokemon p8) {
        System.out.println();
        System.out.println("POKÉMON DISPONIBLES");
        System.out.println("===================");

        mostrarPokemon(1, p1);
        mostrarPokemon(2, p2);
        mostrarPokemon(3, p3);
        mostrarPokemon(4, p4);
        mostrarPokemon(5, p5);
        mostrarPokemon(6, p6);
        mostrarPokemon(7, p7);
        mostrarPokemon(8, p8);
    }

    private void mostrarPokemon(int numero, Pokemon pokemon) {
        if (!pokemon.getAsignado()) {
            System.out.println(numero + ". " + pokemon.getNombre() + " - " + pokemon.getTipo());
        }
    }

    public void mostrarErrorSeleccion() {
        System.out.println();
        System.out.println("Selección inválida. Por favor, elige un Pokémon disponible.");
    }

    public void mostrarEquipo(Jugador jugador) {
        System.out.println();
        System.out.println("Equipo de " + jugador.getNombre());
        System.out.println("===================");

        System.out.println("1. " + jugador.getP1().getNombre() + " - " + jugador.getP1().getTipo());
        System.out.println("2. " + jugador.getP2().getNombre() + " - " + jugador.getP2().getTipo());
        System.out.println("3. " + jugador.getP3().getNombre() + " - " + jugador.getP3().getTipo());
        System.out.println("4. " + jugador.getP4().getNombre() + " - " + jugador.getP4().getTipo());
    }

    public void mostrarRonda(int ronda, String resultado) {
        System.out.println();
        System.out.println("===================");
        System.out.println("Ronda " + ronda);
        System.out.println("===================");

        System.out.println(resultado);
    }

    public void mostrarResultadoFinal(String resultado) {
        System.out.println();
        System.out.println("==========================");
        System.out.println("     RESULTADO FINAL");
        System.out.println("==========================");

        System.out.println(resultado);
    }
}