public class Vista {

    //constructor vista
    public Vista() {

    }


    //mostrar el inicio del combate
    public void mostrarInicioCombate(String entrenador1, String entrenador2) {

        System.out.println("Combate Pokemon");
        System.out.println(entrenador1 + " VS " + entrenador2);
        System.out.println();
    }


    //mostrar la ronda y los pokemon que participan
    public void mostrarRonda(int numeroRonda, String atacante, String defensor) {

        System.out.println("Ronda " + numeroRonda);
        System.out.println("Pokemon atacante: " + atacante);
        System.out.println("Pokemon defensor: " + defensor);
        System.out.println();
    }


    //mostrar si se activo o no la habilidad
    public void mostrarHabilidad(String pokemon, String habilidad, boolean activada, int potenciador) {

        System.out.println("Habilidad de " + pokemon + ": " + habilidad);

        //si la habilidad se activo
        if (activada) {
            System.out.println("La habilidad se activo");
            System.out.println("Potenciador: " + potenciador + "%");
        }

        //si no se activo
        else {
            System.out.println("La habilidad no se activo");
        }

        System.out.println();
    }


    //mostrar resultado de la ronda
    public void mostrarResultadoRonda(String resultado) {

        System.out.println(resultado);
        System.out.println();
    }


    //mostrar resultado final
    public void mostrarResultadoFinal(String resultado) {

        System.out.println(resultado);
    }
}