import java.util.Scanner;

public class VistaCombate {
    public Scanner sc;

    // Constructor de la clase que crea una instancia 
    public VistaCombate() {
        sc = new Scanner(System.in);
    }

    // Método para pedir el nombre de los jugadores. 
    public String pedirNombreJugador(int numeroJugador) {
        System.out.print("Ingrese nombre del jugador " + numeroJugador + ": ");
        return sc.nextLine();
    }

    // Método para mostrar el título
    public void mostrarInicioCombate(String nombreJugador1,String pokemon1, String pokemon2, String pokemon3, String pokemon4, 
        String nombreJugador2, String pokemon5, String pokemon6, String pokemon7, String pokemon8) {

        String mensaje = String.format(
            """
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                    LIGA ELEMENTAL
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

            Jugador: %s
            Equipo:
            - %s
            - %s
            - %s
            - %s

                            VS

            Jugador: %s
            Equipo:
            - %s
            - %s
            - %s
            - %s
            """,
            nombreJugador1, pokemon1, pokemon2, pokemon3, pokemon4,
            nombreJugador2, pokemon5, pokemon6, pokemon7, pokemon8
        );
        System.out.println(mensaje);
    }

    // Método para mostrar la información de las rondas.
    public void mostrarRonda(int numeroRonda, String atacante, String defensor, String jugadorAtacante, String jugadorDefensor) {
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("Ronda " + numeroRonda);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println(jugadorAtacante + " - Pokemon atacante: " + atacante);
        System.out.println(jugadorDefensor + " - Pokemon defensor: " + defensor);
    }

    // Método para mostrar los resultados de la ronda
    public void mostrarResultadoRonda(int ataque, int defensa, int diferencia, int bono, String ganador) {
        System.out.println("Ataque final: " + ataque);
        System.out.println("Defensa final: " + defensa);
        System.out.println("Bono Elemental: " + bono);
        System.out.println("Diferencia: " + diferencia);

        if (ganador == null) {
            System.out.println("Resultado: Empate");
        } else {
            System.out.println("Ganador: " + ganador);
        }
        System.out.println();
    }

    // Método para mostrar ganador del combate
    public void mostrarGanadorCombate(String ganador) {
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("GANADOR DEL COMBATE :)");
        System.out.println(ganador);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
    }

    // Método para mostrar que el combate terminó en empate
    public void mostrarEmpate() {
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("EL COMBATE TERMINÓ EN EMPATE :)");
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
    }  
}