public class Batalla {

    private Entrenador jugador1;
    private Entrenador jugador2;
    private int rondaActual;
    private boolean jugador1Ataca;

    public Batalla(Entrenador jugador1, Entrenador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.rondaActual = 1;
        this.jugador1Ataca = true;
    }

    public void setJugador1(Entrenador jugador1) {
        this.jugador1 = jugador1;
    }

    public Entrenador getJugador1() {
        return jugador1;
    }

    public void setJugador2(Entrenador jugador2) {
        this.jugador2 = jugador2;
    }

    public Entrenador getJugador2() {
        return jugador2;
    }

    public int getRondaActual() {
        return rondaActual;
    }

    public boolean getJugador1Ataca() {
        return jugador1Ataca;
    }

   
    public void iniciarBatalla() {
        for (rondaActual = 1; rondaActual <= 4; rondaActual++) {
            if (jugador1Ataca) {
                ejecutarRonda(jugador1, jugador2);
            } else {
                ejecutarRonda(jugador2, jugador1);
            }
            jugador1Ataca = !jugador1Ataca;
        }
        mostrarGanador();
    }


    public void ejecutarRonda(Entrenador atacante, Entrenador defensor) {
        Pokemon pokemonAtacante = atacante.seleccionarPokemon();
        Pokemon pokemonDefensor = defensor.seleccionarPokemon();

        System.out.println("\n--- Ronda " + rondaActual + " ---");
        System.out.println(atacante.getNombre() + " ataca con " + pokemonAtacante.getNombre()
                + " (" + pokemonAtacante.getTipo() + ")");
        System.out.println(defensor.getNombre() + " defiende con " + pokemonDefensor.getNombre()
                + " (" + pokemonDefensor.getTipo() + ")");

        int potenciadorAtaque = 0;
        if (pokemonAtacante.getHabilidadEspecial().intentarActivacion()) {
            potenciadorAtaque = pokemonAtacante.getHabilidadEspecial().generarPotenciador();
            System.out.println(pokemonAtacante.getNombre() + " activo su habilidad "
                    + pokemonAtacante.getHabilidadEspecial().getNombre()
                    + " (+" + potenciadorAtaque + "% ataque)");
        }

        int potenciadorDefensa = 0;
        if (pokemonDefensor.getHabilidadEspecial().intentarActivacion()) {
            potenciadorDefensa = pokemonDefensor.getHabilidadEspecial().generarPotenciador();
            System.out.println(pokemonDefensor.getNombre() + " activo su habilidad "
                    + pokemonDefensor.getHabilidadEspecial().getNombre()
                    + " (+" + potenciadorDefensa + "% defensa)");
        }

        double ataqueEfectivo = calcularEstadisticaEfectiva(pokemonAtacante.getAtaque(), potenciadorAtaque);
        double defensaEfectiva = calcularEstadisticaEfectiva(pokemonDefensor.getDefensa(), potenciadorDefensa);

        int bonoTipo = calcularEfectividadTipo(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());

        int resultado = calcularResultadoRonda(ataqueEfectivo, defensaEfectiva, bonoTipo);

        System.out.println("Ataque efectivo: " + ataqueEfectivo + " | Defensa efectiva: " + defensaEfectiva
                + " | Bono de tipo: " + bonoTipo);

        if (resultado > 0) {
            atacante.incrementarRondasGanadas();
            System.out.println("Gana la ronda: " + atacante.getNombre());
        } else if (resultado < 0) {
            defensor.incrementarRondasGanadas();
            System.out.println("Gana la ronda: " + defensor.getNombre());
        } else {
            System.out.println("La ronda termino en empate");
        }
    }

   
    public int calcularEfectividadTipo(String tipoAtacante, String tipoDefensor) {
        if (tipoAtacante.equalsIgnoreCase(tipoDefensor)) {
            return 0;
        }

        switch (tipoAtacante.toLowerCase()) {
            case "fuego":
                if (tipoDefensor.equalsIgnoreCase("Agua")) return -10;
                if (tipoDefensor.equalsIgnoreCase("Planta")) return 20;
                return 0;
            case "agua":
                if (tipoDefensor.equalsIgnoreCase("Fuego")) return 20;
                if (tipoDefensor.equalsIgnoreCase("Planta")) return -10;
                return 0;
            case "planta":
                if (tipoDefensor.equalsIgnoreCase("Fuego")) return -10;
                if (tipoDefensor.equalsIgnoreCase("Agua")) return 20;
                return 0;
            case "electrico":
            case "eléctrico":
                if (tipoDefensor.equalsIgnoreCase("Agua")) return 20;
                return 0;
            default:
                return 0;
        }
    }

    public double calcularEstadisticaEfectiva(double estadistica, int potenciador) {
        return estadistica + (estadistica * potenciador / 100.0);
    }

   
    public int calcularResultadoRonda(double ataqueEfectivo, double defensaEfectiva, int bonoTipo) {
        double ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;

        if (ataqueTotal > 0) {
            return 1;
        } else if (ataqueTotal < 0) {
            return -1;
        } else {
            return 0;
        }
    }


    public void mostrarGanador() {
        System.out.println("\n--- Resultado final ---");
        System.out.println(jugador1.getNombre() + ": " + jugador1.getRondasGanadas() + " rondas ganadas");
        System.out.println(jugador2.getNombre() + ": " + jugador2.getRondasGanadas() + " rondas ganadas");

        if (jugador1.getRondasGanadas() > jugador2.getRondasGanadas()) {
            System.out.println("¡" + jugador1.getNombre() + " gana la batalla!");
        } else if (jugador2.getRondasGanadas() > jugador1.getRondasGanadas()) {
            System.out.println("¡" + jugador2.getNombre() + " gana la batalla!");
        } else {
            System.out.println("La batalla termino empatada.");
        }
    }
}