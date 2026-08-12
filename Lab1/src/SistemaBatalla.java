public class SistemaBatalla {
    private Jugador jugador1;
    private Jugador jugador2;

    public SistemaBatalla(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public String ejecutarRonda(Jugador atacante, Jugador defensor) {
        Pokemon pokemonAtacante = atacante.seleccionarPokemon();
        Pokemon pokemonDefensor = defensor.seleccionarPokemon();

        int potenciadorAtacante = 0;
        int potenciadorDefensor = 0;

        boolean habilidadAtacante = pokemonAtacante.getHabilidad().intentarActivacion();
        boolean habilidadDefensor = pokemonDefensor.getHabilidad().intentarActivacion();

        if (habilidadAtacante) {
            potenciadorAtacante = pokemonAtacante.getHabilidad().generarPotenciador();
        }

        if (habilidadDefensor) {
            potenciadorDefensor = pokemonDefensor.getHabilidad().generarPotenciador();
        }

        int ataqueEfectivo = calcularAtaqueEfectivo(pokemonAtacante, potenciadorAtacante);
        int defensaEfectiva = calcularDefensaEfectiva(pokemonDefensor, potenciadorDefensor);
        int bonoTipo = calcularEfectividad(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());

        int ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;

        String ganador;

        if (ataqueTotal > 0) {
            atacante.setRondasGanadas(atacante.getRondasGanadas() + 1);
            ganador = atacante.getNombre();
        } else if (ataqueTotal < 0) {
            defensor.setRondasGanadas(defensor.getRondasGanadas() + 1);
            ganador = defensor.getNombre();
        } else {
            ganador = "Empate";
        }

        String resultado = "";

        resultado += "Atacante: " + pokemonAtacante.getNombre() + " (" + pokemonAtacante.getTipo() + ")\n";
        resultado += "Defensor: " + pokemonDefensor.getNombre() + " (" + pokemonDefensor.getTipo() + ")\n";

        if (habilidadAtacante) {
            resultado += "Habilidad de " + pokemonAtacante.getNombre() + " activada: "
                    + pokemonAtacante.getHabilidad().getNombre() + " (+" + potenciadorAtacante + "%)\n";
        } else {
            resultado += "Habilidad de " + pokemonAtacante.getNombre() + " no activada.\n";
        }

        if (habilidadDefensor) {
            resultado += "Habilidad de " + pokemonDefensor.getNombre() + " activada: "
                    + pokemonDefensor.getHabilidad().getNombre() + " (+" + potenciadorDefensor + "%)\n";
        } else {
            resultado += "Habilidad de " + pokemonDefensor.getNombre() + " no activada.\n";
        }

        resultado += "Ataque efectivo: " + ataqueEfectivo + "\n";
        resultado += "Bono de tipo: " + bonoTipo + "\n";
        resultado += "Defensa efectiva: " + defensaEfectiva + "\n";
        resultado += "Ataque total: " + ataqueTotal + "\n";
        resultado += "Ganador de la ronda: " + ganador + "\n";

        return resultado;
    }

    private int calcularEfectividad(String tipoAtacante, String tipoDefensor) {
        if (tipoAtacante.equals("Fuego")) {

            if (tipoDefensor.equals("Planta")) {
                return 20;
            } else if (tipoDefensor.equals("Agua")) {
                return -10;
            }

        } else if (tipoAtacante.equals("Agua")) {

            if (tipoDefensor.equals("Fuego")) {
                return 20;
            } else if (tipoDefensor.equals("Planta")) {
                return -10;
            }

        } else if (tipoAtacante.equals("Planta")) {

            if (tipoDefensor.equals("Agua")) {
                return 20;
            } else if (tipoDefensor.equals("Fuego")) {
                return -10;
            }

        } else if (tipoAtacante.equals("Electrico")) {

            if (tipoDefensor.equals("Agua")) {
                return 20;
            }

        }

        return 0;
    }

    private int calcularAtaqueEfectivo(Pokemon pokemon, int potenciador) {
        int bono = pokemon.getAtaque() * (potenciador / 100);

        return pokemon.getAtaque() + bono;
    }

    private int calcularDefensaEfectiva(Pokemon pokemon, int potenciador) {
        int bono = pokemon.getDefensa() * (potenciador / 100);

        return pokemon.getDefensa() + bono;
    }

    public String determinarGanadorBatalla() {
        int rondasJ1 = jugador1.getRondasGanadas();
        int rondasJ2 = jugador2.getRondasGanadas();

        if (rondasJ1 > rondasJ2) {
            return jugador1.getNombre() + " ha ganado la batalla con " + rondasJ1 + " rondas ganadas.";
        } else if (rondasJ2 > rondasJ1) {
            return jugador2.getNombre() + " ha ganado la batalla con " + rondasJ2 + " rondas ganadas.";
        } else {
            return "La batalla ha terminado en empate con ambos jugadores ganando " + rondasJ1 + " rondas.";
        }
    }
}
