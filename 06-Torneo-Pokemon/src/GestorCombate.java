import java.util.ArrayList;

public class GestorCombate {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private ArrayList<Ronda> rondas;

    public GestorCombate(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.rondas = new ArrayList<>();
    }

    public void iniciarCombate() {

        for (int numeroRonda = 1; numeroRonda <= 4; numeroRonda++) {

            Entrenador atacante;
            Entrenador defensor;

            if (numeroRonda % 2 != 0) {
                atacante = entrenador1;
                defensor = entrenador2;
            } else {
                atacante = entrenador2;
                defensor = entrenador1;
            }

            Ronda ronda = jugarRonda(numeroRonda, atacante, defensor);
            rondas.add(ronda);
        }
    }

    private Ronda jugarRonda(int numeroRonda,
                             Entrenador atacante,
                             Entrenador defensor) {

        Pokemon pokemonAtacante =
            atacante.seleccionarPokemonDisponible();

        Pokemon pokemonDefensor =
            defensor.seleccionarPokemonDisponible();

        int potenciadorAtaque =
            pokemonAtacante.intentarActivarHabilidad();

        int potenciadorDefensa =
            pokemonDefensor.intentarActivarHabilidad();

        int bonoTipo =
            calcularBonoTipo(
                pokemonAtacante.getTipo(),
                pokemonDefensor.getTipo()
            );

        Ronda ronda = new Ronda(
            numeroRonda,
            atacante,
            defensor,
            pokemonAtacante,
            pokemonDefensor
        );

        ronda.calcularResultado(
            bonoTipo,
            potenciadorAtaque,
            potenciadorDefensa
        );

        return ronda;
    }

    private int calcularBonoTipo(TipoPokemon tipoAtacante,
                                 TipoPokemon tipoDefensor) {

        if (tipoAtacante == TipoPokemon.FUEGO
                && tipoDefensor == TipoPokemon.PLANTA) {
            return 20;
        }

        if (tipoAtacante == TipoPokemon.FUEGO
                && tipoDefensor == TipoPokemon.AGUA) {
            return -10;
        }

        if (tipoAtacante == TipoPokemon.AGUA
                && tipoDefensor == TipoPokemon.FUEGO) {
            return 20;
        }

        if (tipoAtacante == TipoPokemon.AGUA
                && tipoDefensor == TipoPokemon.PLANTA) {
            return -10;
        }

        if (tipoAtacante == TipoPokemon.PLANTA
                && tipoDefensor == TipoPokemon.AGUA) {
            return 20;
        }

        if (tipoAtacante == TipoPokemon.PLANTA
                && tipoDefensor == TipoPokemon.FUEGO) {
            return -10;
        }

        if (tipoAtacante == TipoPokemon.ELECTRICO
                && tipoDefensor == TipoPokemon.AGUA) {
            return 20;
        }

        return 0;
    }

    public String obtenerGanadorCombate() {

        int victoriasEntrenador1 = 0;
        int victoriasEntrenador2 = 0;

        for (int i = 0; i < rondas.size(); i++) {

            Ronda ronda = rondas.get(i);

            boolean entrenador1Ataca = (i % 2 == 0);

            if (ronda.getResultado().equals("ATACANTE")) {

                if (entrenador1Ataca) {
                    victoriasEntrenador1++;
                } else {
                    victoriasEntrenador2++;
                }

            } else if (ronda.getResultado().equals("DEFENSOR")) {

                if (entrenador1Ataca) {
                    victoriasEntrenador2++;
                } else {
                    victoriasEntrenador1++;
                }
            }
        }

        if (victoriasEntrenador1 > victoriasEntrenador2) {
            return entrenador1.getNombre();
        }

        if (victoriasEntrenador2 > victoriasEntrenador1) {
            return entrenador2.getNombre();
        }

        return "EMPATE";
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }
}