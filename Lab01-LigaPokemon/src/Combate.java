public class Combate {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int rondaActual;
    private int victoriasEntrenador1;
    private int victoriasEntrenador2;

    public Combate(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.rondaActual = 1;
        this.victoriasEntrenador1 = 0;
        this.victoriasEntrenador2 = 0;
    }

    public String jugarRonda() {
        Entrenador atacante;
        Entrenador defensor;
        boolean atacaEntrenador1;

        if (rondaActual % 2 != 0) {
            atacante = entrenador1;
            defensor = entrenador2;
            atacaEntrenador1 = true;
        } else {
            atacante = entrenador2;
            defensor = entrenador1;
            atacaEntrenador1 = false;
        }

        Pokemon pokemonAtacante = atacante.obtenerPokemonDisponible();
        Pokemon pokemonDefensor = defensor.obtenerPokemonDisponible();

        int ataqueEfectivo = pokemonAtacante.getAtaque();
        if (pokemonAtacante.getAtaqueEspecial().seActiva()) {
            int potenciador = pokemonAtacante.getAtaqueEspecial().calcularPotenciador();
            ataqueEfectivo += ataqueEfectivo * potenciador / 100;
        }

        int defensaEfectiva = pokemonDefensor.getDefensa();
        if (pokemonDefensor.getAtaqueEspecial().seActiva()) {
            int potenciador = pokemonDefensor.getAtaqueEspecial().calcularPotenciador();
            defensaEfectiva += defensaEfectiva * potenciador / 100;
        }

        int bonoTipo = calcularBonoTipo(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());

        int ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;

        String ganadorRonda;
        if (ataqueTotal > 0) {
            ganadorRonda = atacante.getNombre();
            if (atacaEntrenador1) {
                victoriasEntrenador1++;
            } else {
                victoriasEntrenador2++;
            }
        } else if (ataqueTotal < 0) {
            ganadorRonda = defensor.getNombre();
            if (atacaEntrenador1) {
                victoriasEntrenador2++;
            } else {
                victoriasEntrenador1++;
            }
        } else {
            ganadorRonda = "Empate";
        }

        pokemonAtacante.marcarComoUsado();
        pokemonDefensor.marcarComoUsado();

        String resumen = "Ronda " + rondaActual + ": " + pokemonAtacante.getNombre() + " (" + atacante.getNombre()
                + ") ataca con " + ataqueEfectivo + " + bono de tipo " + bonoTipo + " vs " + pokemonDefensor.getNombre()
                + " (" + defensor.getNombre() + ") con defensa " + defensaEfectiva
                + ".\nGanador de la ronda: " + ganadorRonda;

        rondaActual++;

        return resumen;
    }

    private int calcularBonoTipo(String tipoAtacante, String tipoDefensor) {
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Agua")) {
            return -10;
        } else if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Planta")) {
            return 20;
        } else if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Fuego")) {
            return 20;
        } else if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Planta")) {
            return -10;
        } else if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Fuego")) {
            return -10;
        } else if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Agua")) {
            return 20;
        } else if (tipoAtacante.equals("Electrico") && tipoDefensor.equals("Agua")) {
            return 20;
        }
        return 0;
    }

    public String getGanadorFinal() {
        if (victoriasEntrenador1 > victoriasEntrenador2) {
            return entrenador1.getNombre();
        } else if (victoriasEntrenador2 > victoriasEntrenador1) {
            return entrenador2.getNombre();
        } else {
            return "Empate";
        }
    }
}