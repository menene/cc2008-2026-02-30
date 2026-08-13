public class Vista {
    public Vista() {
    }

    public void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
    }
    
    public void mostrarEquipo(Entrenador entrenador) {
        System.out.println("\nEquipo de " + entrenador.getNombre() + ":");

        for (Pokemon pokemon : entrenador.getPokemones()) {
            System.out.println( "- " + pokemon.getNombre() + " | Tipo: " + pokemon.getTipo() + " | Ataque: " + pokemon.getAtaque() 
                + " | Defensa: " + pokemon.getDefensa() + " | Habilidad: " + pokemon.getHabilidadE().getNombre() 
                + " | Probabilidad: " + pokemon.getHabilidadE().getProbabilidad() + "%");
        }
    }

    public void mostrarResultadosRonda(String resultadoRonda) {
        System.out.println(resultadoRonda);
    }

    public void mostrarResultadoFinal(String resultadoFinal) {
        System.out.println("\n========== RESULTADO FINAL ==========");
        System.out.println(resultadoFinal);
    }
}

// decidi ya no poner el scanner (ya que, iba a hacer que los jugadores ingresaran su nombre),
// sin embargo, lo deje solo con jugador 1 y jugador 2.