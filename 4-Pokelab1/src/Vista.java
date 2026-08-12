/**
 * Se encarga unicamente de mostrar por consola la informacion de la batalla.
 * No contiene logica de calculo.
 */
public class Vista {

    public void mostrarInicio() {
        System.out.println("BATALLA POKEMON");
    }

    public void mostrarRonda(int ronda) {
        System.out.println();
        System.out.println("RONDA " + ronda);
    }

    public void mostrarEnfrentamiento(Pokemon atacante, Pokemon defensor) {
        System.out.println(atacante.getNombre() + " (" + atacante.getTipo() + ") ataca a "
                + defensor.getNombre() + " (" + defensor.getTipo() + ")");
    }

    public void mostrarHabilidad(Pokemon pokemon, boolean activada, int potenciador) {
        if (activada) {
            System.out.println("     La habilidad " + pokemon.getHabilidad().getNombre()
                    + " de " + pokemon.getNombre() + " se activo (+" + potenciador + "%)");
        } else {
            System.out.println("     La habilidad " + pokemon.getHabilidad().getNombre()
                    + " de " + pokemon.getNombre() + " no se activo");
        }
    }

    public void mostrarResultadoRonda(String resultado) {
        System.out.println(resultado);
    }

    public void mostrarResultadoFinal(String resultado) {
        System.out.println();
        System.out.println(resultado);
    }
}
