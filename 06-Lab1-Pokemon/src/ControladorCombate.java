public class ControladorCombate {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private VistaCombate vista;

    public ControladorCombate(Entrenador entrenador1, Entrenador entrenador2, VistaCombate vista) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.vista = vista;
    }

    public void iniciarCombate() {
        vista.mostrarInicioCombate();
        int victoriasEntrenador1 = 0;
        int victoriasEntrenador2 = 0;

        for (int ronda = 1; ronda <= 4; ronda++) {
            
            int resultado;
            
            if (ronda % 2 != 0) {

                resultado = ejecutarRonda(entrenador1, entrenador2, ronda);
                
                if (resultado == 1) {
                    victoriasEntrenador1++;
                } else if (resultado == -1) {
                    victoriasEntrenador2++;
                }

            } else {

                resultado = ejecutarRonda(entrenador2, entrenador1, ronda);

                if (resultado == 1) {
                    victoriasEntrenador2++;
                } else if (resultado == -1) {
                    victoriasEntrenador1++;
                }
            }
        }

        if(victoriasEntrenador1 > victoriasEntrenador2) {
            vista.mostrarResultadoFinal(
                "Ganador: " + entrenador1.getNombreEntrenador() 
                + " con " + 
                victoriasEntrenador1 + " rondas ganadas."
                );
        } else if(victoriasEntrenador2 > victoriasEntrenador1) {
            vista.mostrarResultadoFinal(
                "Ganador: " + entrenador2.getNombreEntrenador() 
                + " con " + 
                victoriasEntrenador2 + " rondas ganadas."
                );
        } else {
            vista.mostrarResultadoFinal(
                "La batalla terminó empatada con "
                + victoriasEntrenador1 + " victorias de " + entrenador1.getNombreEntrenador() + " a "
                + victoriasEntrenador2 + " victorias de " + entrenador2.getNombreEntrenador()
            );
        }
    }

    private int ejecutarRonda(Entrenador atacante, Entrenador defensor, int numeroRonda) { 
        vista.mostrarInicioRonda(numeroRonda, atacante.getNombreEntrenador(), defensor.getNombreEntrenador());

        Pokemon pokemonAtacante = atacante.seleccionarPokemon();
        Pokemon pokemonDefensor = defensor.seleccionarPokemon();

        vista.mostrarPokemonSeleccionado(
            "Pokemón atacante:", pokemonAtacante
        );

        vista.mostrarPokemonSeleccionado(
            "Pokemón defensor:", pokemonDefensor
        );

        HabilidadEspecial habilidadAtacante = 
            pokemonAtacante.getHabilidadEspecial();

        HabilidadEspecial habilidadDefensor = 
            pokemonDefensor.getHabilidadEspecial();

        boolean habilidadAtacanteActivada = 
            habilidadAtacante.intentarActivacion();

        boolean habilidadDefensorActivada = 
            habilidadDefensor.intentarActivacion();

        int potenciadorAtacante = 0;
        int potenciadorDefensor = 0;

        if (habilidadAtacanteActivada) {
            potenciadorAtacante = habilidadAtacante.generarPotenciador();
        }

        if (habilidadDefensorActivada) {
            potenciadorDefensor = habilidadDefensor.generarPotenciador();
        }

        vista.mostrarHabilidad(pokemonAtacante, habilidadAtacanteActivada, potenciadorAtacante);
        vista.mostrarHabilidad(pokemonDefensor, habilidadDefensorActivada, potenciadorDefensor);

        double ataqueEfectivo = pokemonAtacante.calcularAtaqueEfectivo(potenciadorAtacante);
        double defensaEfectiva = pokemonDefensor.calcularDefensaEfectiva(potenciadorDefensor);

        int bonoTipo = pokemonAtacante.calcularEfectividadTipo(pokemonDefensor.getTipoPokemon());
        double resultadoAtaque = pokemonAtacante.calcularResultadoAtaque(ataqueEfectivo, bonoTipo, defensaEfectiva);

        if (resultadoAtaque > 0) {
            vista.mostrarResultadoRonda( 
                "Gana " + atacante.getNombreEntrenador() + " con " + pokemonAtacante.getNombrePokemon() + "."
            );
            return 1;
        } else if (resultadoAtaque < 0) {
            vista.mostrarResultadoRonda(
                "Gana " + defensor.getNombreEntrenador() + " con " + pokemonDefensor.getNombrePokemon() + "."
            );
            return -1;
        } else {
            vista.mostrarResultadoRonda(
                "La ronda terminó empatada entre los dos entrenadores ├☼"
            );
            return 0;
        }
    }
}