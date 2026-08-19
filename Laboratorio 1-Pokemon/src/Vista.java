public class Vista {

    public void mostrarInicioBatalla() {
        System.out.println("================================");
        System.out.println("          LIGA INDIGO");
        System.out.println("================================");
        System.out.println("A BATALLAR");
        System.out.println();
    }

    public void mostrarRonda(int ronda) {
        System.out.println("--------------------------------");
        System.out.println("RONDA " + ronda);
        System.out.println("--------------------------------");
    }

    public void mostrarRoles(Entrenador atacante, Entrenador defensor) {
        System.out.println(
            "Atacante: " + atacante.getNombre()
        );

        System.out.println(
            "Defensor: " + defensor.getNombre()
        );

        System.out.println();
    }

    public void mostrarResultadoRonda(String resultado) {
        System.out.println(
            "Resultado de la ronda: " + resultado
        );

        System.out.println();
    }

    public void mostrarMarcador(
            int victoriasEntrenador1,
            int victoriasEntrenador2) {

        System.out.println(
            "Marcador: "
            + victoriasEntrenador1
            + " - "
            + victoriasEntrenador2
        );

        System.out.println();
    }

    public void mostrarResultadoFinal(String resultado) {

        System.out.println("================================");
        System.out.println("       RESULTADO FINAL");
        System.out.println("================================");

        if (resultado.equals("Empate")) {
            System.out.println(
                "La batalla termino en empate."
            );
        } else {
            System.out.println(
                "Ganador: " + resultado
            );
        }
    }
}