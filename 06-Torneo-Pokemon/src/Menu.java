public class Menu {

    public void mostrarResultadoRonda(Ronda ronda) {
        System.out.println(ronda);
    }

    public void mostrarResultadoFinal(String ganador) {

        System.out.println();
        System.out.println("Resultado Final");

        if (ganador.equals("EMPATE")) {
            System.out.println("La batalla terminó en empate.");
        } else {
            System.out.println("Ganador: " + ganador);
        }
    }
}