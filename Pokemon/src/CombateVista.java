public class CombateVista {
    public void mostrarDetallesRonda(int numRond, Pokemon at, Pokemon def) {
        System.out.println("=========================================");
        System.out.println("RONDA " + numRond);
        System.out.println("ATACA: " + at.getNombre() + " (" + at.getTipo() + ")");
        System.out.println("DEFIENDE: " + def.getNombre() + " (" + def.getTipo() + ")");
    }

    public void mostrarHabilidad(String nombrePoke, String nombreHabilidad, boolean act, double porc) {
        if (act) {
            System.out.println("! " + nombrePoke + " ha activado su habilidad especial [" + nombreHabilidad + "], ganando " + String.format("%.2f", porc) + " puntos extra!");
        }
    }

    public void mostrarResultado(double ataqueTotal, String msg) {
        System.out.println("Diferencia de daño (Ataque Total): " + String.format("%.2f", ataqueTotal));
        System.out.println(msg);
        System.out.println("=========================================\n");
    }

    public void mostrarGanadorFinal(int victoriasJ1, int victoriasJ2) {
        System.out.println("******** RESULTADO DEL TORNEO ********");
        System.out.println("Entrenador 1: " + victoriasJ1 + " victorias");
        System.out.println("Entrenador 2: " + victoriasJ2 + " victorias");
        
        if (victoriasJ1 > victoriasJ2) {
            System.out.println("¡EL ENTRENADOR 1 ES EL CAMPEÓN!");
        } else if (victoriasJ2 > victoriasJ1) {
            System.out.println("¡EL ENTRENADOR 2 ES EL CAMPEÓN!");
        } else {
            System.out.println("¡EL TORNEO TERMINA EN EMPATE!");
        }
    }
}