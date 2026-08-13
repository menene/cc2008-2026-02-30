package Model;

public class Ronda {

    private int numeroRonda;
    private Entrenador atacante;
    private Entrenador defensor;
    private Pokemon pokemonAtacante;
    private Pokemon pokemonDefensor;

    public Ronda(
            int numeroRonda,
            Entrenador atacante,
            Entrenador defensor) {

        this.numeroRonda = numeroRonda;
        this.atacante = atacante;
        this.defensor = defensor;
    }

    public void seleccionarPokemones() {
        pokemonAtacante = atacante.seleccionarPokemon();
        pokemonDefensor = defensor.seleccionarPokemon();
    }

    private double calcularAtaqueEfectivo(Pokemon pokemon) {

        double ataqueEfectivo = pokemon.getAtaque();

        if (pokemon.getHabilidadEspecial().intentarActivacion()) {

            int potenciador =
                    pokemon.getHabilidadEspecial().generarPotenciador();

            ataqueEfectivo =
                    ataqueEfectivo
                    + (ataqueEfectivo * potenciador / 100.0);
        }

        return ataqueEfectivo;
    }

    private double calcularDefensaEfectiva(Pokemon pokemon) {

        double defensaEfectiva = pokemon.getDefensa();

        if (pokemon.getHabilidadEspecial().intentarActivacion()) {

            int potenciador =
                    pokemon.getHabilidadEspecial().generarPotenciador();

            defensaEfectiva =
                    defensaEfectiva
                    + (defensaEfectiva * potenciador / 100.0);
        }

        return defensaEfectiva;
    }

    private int calcularBonoTipo(
            Pokemon atacante,
            Pokemon defensor) {

        String tipoAtacante = atacante.getTipo();
        String tipoDefensor = defensor.getTipo();

        if (tipoAtacante.equals("Fuego")
                && tipoDefensor.equals("Planta")) {
            return 20;
        }

        if (tipoAtacante.equals("Agua")
                && tipoDefensor.equals("Fuego")) {
            return 20;
        }

        if (tipoAtacante.equals("Planta")
                && tipoDefensor.equals("Agua")) {
            return 20;
        }

        if (tipoAtacante.equals("Electrico")
                && tipoDefensor.equals("Agua")) {
            return 20;
        }

        if (tipoAtacante.equals("Fuego")
                && tipoDefensor.equals("Agua")) {
            return -10;
        }

        if (tipoAtacante.equals("Agua")
                && tipoDefensor.equals("Planta")) {
            return -10;
        }

        if (tipoAtacante.equals("Planta")
                && tipoDefensor.equals("Fuego")) {
            return -10;
        }

        return 0;
    }

    public int ejecutarRonda() {

        seleccionarPokemones();

        double ataqueEfectivo =
                calcularAtaqueEfectivo(pokemonAtacante);

        double defensaEfectiva =
                calcularDefensaEfectiva(pokemonDefensor);

        int bonoTipo =
                calcularBonoTipo(
                        pokemonAtacante,
                        pokemonDefensor);

        double ataqueTotal =
                ataqueEfectivo
                + bonoTipo
                - defensaEfectiva;

        if (ataqueTotal > 0) {
            return 1;
        }

        if (ataqueTotal < 0) {
            return -1;
        }

        return 0;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public Entrenador getAtacante() {
        return atacante;
    }

    public Entrenador getDefensor() {
        return defensor;
    }

    public Pokemon getPokemonAtacante() {
        return pokemonAtacante;
    }

    public Pokemon getPokemonDefensor() {
        return pokemonDefensor;
    }
} 