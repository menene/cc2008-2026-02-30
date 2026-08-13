public class VistaCombate {
    public void mostrarInicioCombate() {
        System.out.println("\n====== INICIO DEL COMBATE ======");
    }

    public void mostrarInicioRonda(int numeroRonda, String  nombreAtacante, String nombreDefensor) {
        System.out.println("\n====== RONDA " + numeroRonda + " ======");
        System.out.println("Atacante: " + nombreAtacante);
        System.out.println("Defensor: " + nombreDefensor);
    }

    public void mostrarPokemonSeleccionado(String rol, Pokemon pokemon) {
        System.out.println(rol + ": " + pokemon.getNombrePokemon() + " [" + pokemon.getTipoPokemon() + "]");
    }

    public void mostrarHabilidad(Pokemon pokemon, boolean activada, int potenciador) {
        if(activada) {
            System.out.println(
                "La habilidad " + pokemon.getHabilidadEspecial().getNombreHabilidad() 
                + " de " + pokemon.getNombrePokemon() 
                + " se activó con un potenciador de " + potenciador + "%."
            );
        } else { 
            System.out.println(
                "La habilidad " + pokemon.getHabilidadEspecial().getNombreHabilidad()
                + " de " + pokemon.getNombrePokemon() + " no se activó."
            );
        }
    }

    public void mostrarResultadoRonda(String resultado) {
        System.out.println("Resultado de la ronda: " + resultado);
    }

    public void mostrarResultadoFinal(String resultado) {
        System.out.println("\n====== RESULTADO FINAL ======");
        System.out.println(resultado);
    }
}