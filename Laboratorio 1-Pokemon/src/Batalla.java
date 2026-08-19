public class Batalla {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int victoriasEntrenador1;
    private int victoriasEntrenador2;
    private int rondaActual;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.victoriasEntrenador1 = 0;
        this.victoriasEntrenador2 = 0;
        this.rondaActual = 1;
    }

    public int calcularAtaqueEfectivo(Pokemon pokemon) {

        int ataqueEfectivo = pokemon.getAtaque();

        HabilidadEspecial habilidad = pokemon.getHabilidadEspecial();

        if (habilidad.seActiva()) {

            int potenciador = habilidad.generarPotenciador();

            ataqueEfectivo = ataqueEfectivo
                    + (ataqueEfectivo * potenciador / 100);
        }

        return ataqueEfectivo;
    }

    public int calcularDefensaEfectiva(Pokemon pokemon) {

        int defensaEfectiva = pokemon.getDefensa();

        HabilidadEspecial habilidad = pokemon.getHabilidadEspecial();

        if (habilidad.seActiva()) {

            int potenciador = habilidad.generarPotenciador();

            defensaEfectiva = defensaEfectiva
                    + (defensaEfectiva * potenciador / 100);
        }

        return defensaEfectiva;
    }

    public int calcularEfectividadTipo(String tipoAtacante, String tipoDefensor) {

        if (tipoAtacante.equals("Fuego")
                && tipoDefensor.equals("Planta")) {
            return 20;
        }

        if (tipoAtacante.equals("Fuego")
                && tipoDefensor.equals("Agua")) {
            return -10;
        }

        if (tipoAtacante.equals("Agua")
                && tipoDefensor.equals("Fuego")) {
            return 20;
        }

        if (tipoAtacante.equals("Agua")
                && tipoDefensor.equals("Planta")) {
            return -10;
        }

        if (tipoAtacante.equals("Planta")
                && tipoDefensor.equals("Agua")) {
            return 20;
        }

        if (tipoAtacante.equals("Planta")
                && tipoDefensor.equals("Fuego")) {
            return -10;
        }

        if (tipoAtacante.equals("Electrico")
                && tipoDefensor.equals("Agua")) {
            return 20;
        }

        return 0;
    }

    public int realizarRonda(Entrenador atacante, Entrenador defensor) {

        Pokemon pokemonAtacante = atacante.seleccionarPokemon();
        Pokemon pokemonDefensor = defensor.seleccionarPokemon();

        int ataqueEfectivo = calcularAtaqueEfectivo(pokemonAtacante);
        int defensaEfectiva = calcularDefensaEfectiva(pokemonDefensor);

        int bonoTipo = calcularEfectividadTipo(
                pokemonAtacante.getTipo(),
                pokemonDefensor.getTipo()
        );

        int ataqueTotal =
                ataqueEfectivo + bonoTipo - defensaEfectiva;

        if (ataqueTotal > 0) {

            registrarVictoria(atacante);
            rondaActual++;

            return 1;
        }

        if (ataqueTotal < 0) {

            registrarVictoria(defensor);
            rondaActual++;

            return 2;
        }

        rondaActual++;

        return 0;
    }

    private void registrarVictoria(Entrenador ganador) {

        if (ganador == entrenador1) {
            victoriasEntrenador1++ ;
        }

        if (ganador == entrenador2) {
            victoriasEntrenador2++ ;
        }
    }

    public String determinarGanador() {

        if (victoriasEntrenador1 > victoriasEntrenador2) {
            return entrenador1.getNombre();
        }

        if (victoriasEntrenador2 > victoriasEntrenador1) {
            return entrenador2.getNombre();
        }

        return "Empate";
    }

    public int getRondaActual() {
        return rondaActual;
    }

    public int getVictoriasEntrenador1() {
        return victoriasEntrenador1;
    }

    public int getVictoriasEntrenador2() {
        return victoriasEntrenador2;
    }

    public Entrenador getEntrenador1() {
    return entrenador1;
    }

    public Entrenador getEntrenador2() {
    return entrenador2;
    }
}