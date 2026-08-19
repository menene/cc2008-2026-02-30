public class ControladorCombate {
    private Entrenador jugador1;
    private Entrenador jugador2;
    private CombateVista vista;
    private Ronda ronda1, ronda2, ronda3, ronda4;

    public ControladorCombate(Entrenador jugador1, Entrenador jugador2, CombateVista vista) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.vista = vista;
    }

    public void iniciarCombate() {
        ronda1 = new Ronda();
        ronda2 = new Ronda();
        ronda3 = new Ronda();
        ronda4 = new Ronda();

        // Ejecutar las 4 rondas
        ejecutarYRegistrarRonda(ronda1, 1);
        prepararNuevaRonda();
        ejecutarYRegistrarRonda(ronda2, 2);
        prepararNuevaRonda();
        ejecutarYRegistrarRonda(ronda3, 3);
        prepararNuevaRonda();
        ejecutarYRegistrarRonda(ronda4, 4);

        // Contar victorias
        int victoriasJ1 = 0;
        int victoriasJ2 = 0;

        if (ronda1.getGanador() == jugador1) victoriasJ1++; else if (ronda1.getGanador() == jugador2) victoriasJ2++;
        if (ronda2.getGanador() == jugador1) victoriasJ1++; else if (ronda2.getGanador() == jugador2) victoriasJ2++;
        if (ronda3.getGanador() == jugador1) victoriasJ1++; else if (ronda3.getGanador() == jugador2) victoriasJ2++;
        if (ronda4.getGanador() == jugador1) victoriasJ1++; else if (ronda4.getGanador() == jugador2) victoriasJ2++;

        vista.mostrarGanadorFinal(victoriasJ1, victoriasJ2);
    }

    private void prepararNuevaRonda() {
        jugador1.cambiarRol();
        jugador2.cambiarRol();
    }

    private double calcularMultiplicador(Tipo atacante, Tipo defensor) {
        if (atacante == Tipo.FUEGO && defensor == Tipo.PLANTA) return 20.0;
        if (atacante == Tipo.FUEGO && defensor == Tipo.AGUA) return -10.0;
        if (atacante == Tipo.AGUA && defensor == Tipo.FUEGO) return 20.0;
        if (atacante == Tipo.AGUA && defensor == Tipo.PLANTA) return -10.0;
        if (atacante == Tipo.PLANTA && defensor == Tipo.AGUA) return 20.0;
        if (atacante == Tipo.PLANTA && defensor == Tipo.FUEGO) return -10.0;
        if (atacante == Tipo.ELECTRICO && defensor == Tipo.AGUA) return 20.0;
        
        return 0.0;
    }

    private void ejecutarYRegistrarRonda(Ronda ronda, int numRonda) {
        ronda.setEntrenador1(jugador1);
        ronda.setEntrenador2(jugador2);

        Entrenador ataca = jugador1.getRol() ? jugador1 : jugador2;
        Entrenador defiende = jugador1.getRol() ? jugador2 : jugador1;

        Pokemon pokeAtacante = ataca.obtenerPokemonAleatorio();
        Pokemon pokeDefensor = defiende.obtenerPokemonAleatorio();

        pokeAtacante.marcarComoPeleado();
        pokeDefensor.marcarComoPeleado();

        vista.mostrarDetallesRonda(numRonda, pokeAtacante, pokeDefensor);

        // Lógica de cálculo de ataque
        double dañoAtaque = pokeAtacante.getAtaque();
        boolean habAtaca = pokeAtacante.getHabilidad().calcularSiSeActiva();
        if (habAtaca) {
            double extra = pokeAtacante.getHabilidad().calcularPotenciador()*dañoAtaque;
            dañoAtaque += extra;
            vista.mostrarHabilidad(pokeAtacante.getNombre(), pokeAtacante.getHabilidad().getNombre(), true, extra);
        }
        dañoAtaque += calcularMultiplicador(pokeAtacante.getTipo(), pokeDefensor.getTipo());

        // Lógica de cálculo de defensa
        double defensa = pokeDefensor.getDefensa();
        boolean habDefiende = pokeDefensor.getHabilidad().calcularSiSeActiva();
        if (habDefiende) {
            double extra = pokeDefensor.getHabilidad().calcularPotenciador()*defensa;
            defensa += extra;
            vista.mostrarHabilidad(pokeDefensor.getNombre(), pokeDefensor.getHabilidad().getNombre(), true, extra);
        }

        // Resolución
        double ataqueTotal = dañoAtaque - defensa;
        ronda.setAtaqueTotal(ataqueTotal);

        if (ataqueTotal > 0) {
            ronda.setGanador(ataca);
            vista.mostrarResultado(ataqueTotal, "Ganador de la ronda: Entrenador que atacó.");
        } else if (ataqueTotal < 0) {
            ronda.setGanador(defiende);
            vista.mostrarResultado(ataqueTotal, "Ganador de la ronda: Entrenador que defendió.");
        } else {
            ronda.setGanador(null);
            vista.mostrarResultado(ataqueTotal, "La ronda terminó en EMPATE.");
        }
    }
}