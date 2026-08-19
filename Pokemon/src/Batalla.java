import java.util.ArrayList;

public class Batalla {

    private int resultados_ronda;
    private String ganador_ronda;
    private int ganador;
    private String ganador_perdedor;
    private int victoriasEntrenador1;
    private int victoriasEntrenador2;
    private ArrayList<Ronda> rondas;

    public Batalla() {
        resultados_ronda = 0;
        ganador_ronda = "";
        ganador = 0;
        ganador_perdedor = "";
        victoriasEntrenador1 = 0;
        victoriasEntrenador2 = 0;
        rondas = new ArrayList<>();
    }

    public void iniciarBatalla(
            Entrenador entrenador1,
            Entrenador entrenador2) {

        victoriasEntrenador1 = 0;
        victoriasEntrenador2 = 0;
        ganador = 0;
        ganador_perdedor = "";
        rondas.clear();

        ArrayList<Pokemon> disponibles1 =
                new ArrayList<>(
                        entrenador1.getEleccion_pokemon());

        ArrayList<Pokemon> disponibles2 =
                new ArrayList<>(
                        entrenador2.getEleccion_pokemon());

        for (int numeroRonda = 1;
             numeroRonda <= 4;
             numeroRonda++) {

            Entrenador atacante;
            Entrenador defensor;

            ArrayList<Pokemon> disponiblesAtacante;
            ArrayList<Pokemon> disponiblesDefensor;

            if (numeroRonda % 2 != 0) {

                atacante = entrenador1;
                defensor = entrenador2;

                disponiblesAtacante = disponibles1;
                disponiblesDefensor = disponibles2;

            } else {

                atacante = entrenador2;
                defensor = entrenador1;

                disponiblesAtacante = disponibles2;
                disponiblesDefensor = disponibles1;
            }

            Entrenador atacanteTemporal =
                    crearEntrenadorTemporal(
                            atacante,
                            disponiblesAtacante);

            Entrenador defensorTemporal =
                    crearEntrenadorTemporal(
                            defensor,
                            disponiblesDefensor);

            Ronda ronda = new Ronda();

            String resultado =
                    ronda.realizarRonda(
                            atacanteTemporal,
                            defensorTemporal);

            rondas.add(ronda);

            ganador_ronda = resultado;
            resultados_ronda = ronda.getResultado();

            Pokemon pokemonAtacante =
                    ronda.getPokemonAtaque();

            Pokemon pokemonDefensor =
                    ronda.getPokemonDefensa();

            disponiblesAtacante.remove(
                    pokemonAtacante);

            disponiblesDefensor.remove(
                    pokemonDefensor);

            if (resultado.equals("Atacante")) {

                if (atacante == entrenador1) {
                    victoriasEntrenador1++;
                } else {
                    victoriasEntrenador2++;
                }

            } else if (resultado.equals("Defensor")) {

                if (defensor == entrenador1) {
                    victoriasEntrenador1++;
                } else {
                    victoriasEntrenador2++;
                }
            }
        }

        determinarGanador(
                entrenador1,
                entrenador2);
    }

    private Entrenador crearEntrenadorTemporal(
            Entrenador original,
            ArrayList<Pokemon> disponibles) {

        Entrenador temporal =
                new Entrenador(
                        original.getNombre());

        for (Pokemon pokemon : disponibles) {
            temporal.agregarPokemon(pokemon);
        }

        return temporal;
    }

    private void determinarGanador(
            Entrenador entrenador1,
            Entrenador entrenador2) {

        if (victoriasEntrenador1
                > victoriasEntrenador2) {

            ganador = 1;
            ganador_perdedor =
                    entrenador1.getNombre();

        } else if (victoriasEntrenador2
                > victoriasEntrenador1) {

            ganador = 2;
            ganador_perdedor =
                    entrenador2.getNombre();

        } else {

            ganador = 0;
            ganador_perdedor = "Empate";
        }
    }

    public int getResultados_ronda() {
        return resultados_ronda;
    }

    public String getGanador_ronda() {
        return ganador_ronda;
    }

    public int getGanador() {
        return ganador;
    }

    public String getGanador_perdedor() {
        return ganador_perdedor;
    }

    public int getVictoriasEntrenador1() {
        return victoriasEntrenador1;
    }

    public int getVictoriasEntrenador2() {
        return victoriasEntrenador2;
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }
}