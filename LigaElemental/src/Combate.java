public class Combate {

    private Entrenador jugador1;
    private Entrenador jugador2;
    private int numeroRondas;
    private ResultadoRonda[] resultados;

    public Combate(Entrenador jugador1, Entrenador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.numeroRondas = 4; // el combate siempre consta de 4 rondas
        this.resultados = new ResultadoRonda[numeroRondas];
    }

    //Inicia las 4 rondas del combate
    public void jugarBatalla() {
        for (int i = 0; i < numeroRondas; i++) {
            int numeroRonda = i + 1;

            Entrenador atacante = (numeroRonda % 2 != 0) ? jugador1 : jugador2;
            Entrenador defensor = (numeroRonda % 2 != 0) ? jugador2 : jugador1;

            resultados[i] = jugarRonda(numeroRonda, atacante, defensor);
        }
    }

    // Realiza: 
    // selección de Pokemon,
    // sorteo de habilidades, aplicacion del potenciador
    // y cálculo del resultado final de la ronda.
    public ResultadoRonda jugarRonda(int numeroRonda, Entrenador atacante, Entrenador defensor) {
        Pokemon pokemonAtacante = atacante.seleccionarPokemonAleatorio();
        Pokemon pokemonDefensor = defensor.seleccionarPokemonAleatorio();

        double ataqueEfectivo = pokemonAtacante.getAtaque();
        double defensaEfectiva = pokemonDefensor.getDefensa();

        // Sorteo de habilidad del atacante
        if (pokemonAtacante.getHabilidad().intentarActivacion()) {
            int porcentaje = pokemonAtacante.getHabilidad().calcularMagnitud();
            ataqueEfectivo += pokemonAtacante.getAtaque() * (porcentaje / 100.0);
        }


        // Sorteo de habilidad del defensor
        if (pokemonDefensor.getHabilidad().intentarActivacion()) {
            int porcentaje = pokemonDefensor.getHabilidad().calcularMagnitud();
            defensaEfectiva += pokemonDefensor.getDefensa() * (porcentaje / 100.0);
        }

        int bonoTipo = calcularBonoTipo(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());

        ResultadoRonda resultado = new ResultadoRonda(numeroRonda, pokemonAtacante, pokemonDefensor, ataqueEfectivo, defensaEfectiva, bonoTipo);
        resultado.calcularResultado();

        //Pokemones como ya utilizados en el combate
        pokemonAtacante.setHaPeleado(true);
        pokemonDefensor.setHaPeleado(true);

        return resultado;
    }

    //Devuelve el bono o penalizacion de la efectividad
    public int calcularBonoTipo(String tipoAtacante, String tipoDefensor) {
        if (tipoAtacante.equals(tipoDefensor)) {
            return 0;
        }

        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Planta")) return 20;
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Agua")) return -10;

        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Fuego")) return 20;
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Planta")) return -10;

        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Agua")) return 20;
        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Fuego")) return -10;

        if (tipoAtacante.equals("Electrico") && tipoDefensor.equals("Agua")) return 20;

        return 0;
    }


    public String determinarGanadorBatalla() {
        int puntosJugador1 = 0;
        int puntosJugador2 = 0;

        for (int i = 0; i < numeroRondas; i++) {
            int numeroRonda = i + 1;
            Entrenador atacante = (numeroRonda % 2 != 0) ? jugador1 : jugador2;
            Entrenador defensor = (numeroRonda % 2 != 0) ? jugador2 : jugador1;

            String ganadorRonda = resultados[i].getGanadorRonda();
            if (ganadorRonda.equals("Atacante")) {
                if (atacante == jugador1) puntosJugador1++; else puntosJugador2++;
            } else if (ganadorRonda.equals("Defensor")) {
                if (defensor == jugador1) puntosJugador1++; else puntosJugador2++;
            }
        }

        if (puntosJugador1 > puntosJugador2) return jugador1.getNombre();
        if (puntosJugador2 > puntosJugador1) return jugador2.getNombre();
        return "Empate";
    }

    // Getters adicionales. Imprime el detalle del combate
    public ResultadoRonda[] getResultados() {
        return resultados;
    }

    public Entrenador getJugador1() {
        return jugador1;
    }

    public Entrenador getJugador2() {
        return jugador2;
    }
}