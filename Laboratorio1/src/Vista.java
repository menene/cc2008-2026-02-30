public class Vista {

    public void mostrarEntrenadores(Entrenador jugador1, Entrenador jugador2) {
        System.out.println("========================================");
        System.out.println("        LIGA ELEMENTAL - COMBATE");
        System.out.println("========================================");
        mostrarEntrenador(jugador1);
        mostrarEntrenador(jugador2);
    }

    private void mostrarEntrenador(Entrenador entrenador) {
        System.out.println("\nEntrenador: " + entrenador.getNombre());
        for (Pokemon p : entrenador.getPokemones()) {
            System.out.println("  - " + p.getNombre() + " | Tipo: " + p.getTipo()
                    + " | Ataque: " + p.getAtaque() + " | Defensa: " + p.getDefensa()
                    + " | Habilidad: " + p.getHabilidadEspecial().getNombre()
                    + " (" + p.getHabilidadEspecial().getProbabilidadActivacion() + "%)");
        }
    }

    public void mostrarInicioBatalla() {
        System.out.println("\n¡Comienza el combate!");
    }

    public void mostrarGanador(String mensaje) {
        System.out.println(mensaje);
    }
}