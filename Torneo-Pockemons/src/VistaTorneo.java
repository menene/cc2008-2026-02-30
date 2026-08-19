public class VistaTorneo{

    // métodos

    
    // Imprime en pantalla los datos de un pokemon, recibidos ya como valores sueltos
    public void mostrarPockemon(String nombre, String tipo, int ataque, int defensa, String nombreHabilidad, int probabilidadActivacion){
        // los debe obtener del controlador
        System.out.println("Pokemon: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Habilidad: " + nombreHabilidad + " (" + probabilidadActivacion + "% de activacion)");
        System.out.println();
    }

    // Imprime en pantalla el detalle completo de una ronda, recibidos ya como valores sueltos
    public void mostrarResultado(int numeroRonda, String nombreJugadorAtacante, String nombreJugadorDefensor, String nombrePokemonAtacante, String nombrePokemonDefensor, int ataqueEfectivo, int defensaEfectiva, int bonoTipo, int ataqueTotal, String ganadorRonda){
        // los debe obtener del controlador
        System.out.println("Ronda " + numeroRonda);
        System.out.println(nombreJugadorAtacante + " ataca con " + nombrePokemonAtacante);
        System.out.println(nombreJugadorDefensor + " defiende con " + nombrePokemonDefensor);
        System.out.println("Ataque efectivo: " + ataqueEfectivo);
        System.out.println("Defensa efectiva: " + defensaEfectiva);
        System.out.println("Bono de tipo: " + bonoTipo);
        System.out.println("Ataque total: " + ataqueTotal);
        System.out.println("Ganador de la ronda: " + ganadorRonda);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    // Imprime en pantalla el marcador final y el campeon del combate, recibidos ya como valores sueltos
    public void mostrarResultado(String nombreJugador1, int rondasGanadasJugador1, String nombreJugador2, int rondasGanadasJugador2, String ganadorTorneo){
        // los debe obtener del controlador
        System.out.println("Resultado Final");
        System.out.println(nombreJugador1 + ": " + rondasGanadasJugador1 + " rondas ganadas");
        System.out.println(nombreJugador2 + ": " + rondasGanadasJugador2 + " rondas ganadas");
        System.out.println("Campeon del combate: " + ganadorTorneo);
    }


}
