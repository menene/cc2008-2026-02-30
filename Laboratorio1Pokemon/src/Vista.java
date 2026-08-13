public class Vista{
    public void mostrarInicio(){
        System.out.println("------LIGA POKEMONNNN-------");
        System.out.println("Comienza la batalla Pokemon");
    }
    public void mostrarRonda(Pokemon atacante, Pokemon defensor, float ataqueTotal) {

        System.out.println("Atacante: " + atacante.getNombre());
        System.out.println("Defensor: " + defensor.getNombre());
        System.out.println("Ataque total: " + ataqueTotal);

        if (ataqueTotal > 0) {
            System.out.println("Gana el atacante");
        }
        else if (ataqueTotal < 0) {
            System.out.println("Gana el defensor");
        }
        else {
            System.out.println("Empate");
        }
    }
    public void determinarGanador(int victorias1, int victorias2) {

        System.out.println("\n--- RESULTADO FINAL ---");

        System.out.println("Victorias Jugador 1: " + victorias1);
        System.out.println("Victorias Jugador 2: " + victorias2);

        if (victorias1 > victorias2) {
            System.out.println("Gana el Jugador 1");
        }
        else if (victorias2 > victorias1) {
            System.out.println("Gana el Jugador 2");
        }
        else {
            System.out.println("La batalla termina en empate");
        }
    }
}