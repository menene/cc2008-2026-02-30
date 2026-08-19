import java.util.Random;

public class CombateController {

    private final Entrenador entrenador1;
    private final Entrenador entrenador2;
    private final CombateView combateView;
    private final Random random;

    private int victoriasEntrenador1;
    private int victoriasEntrenador2;

    public CombateController(
            Entrenador entrenador1,
            Entrenador entrenador2,
            CombateView combateView) {

        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.combateView = combateView;
        this.random = new Random();
    }

    public void iniciarBatalla() {
        combateView.mostrarInicioBatalla();

        boolean entrenador1Ataca = true;

        for (int ronda = 1; ronda <= 4; ronda++) {
            combateView.mostrarRonda(ronda);

            Entrenador entrenadorAtacante;
            Entrenador entrenadorDefensor;

            if (entrenador1Ataca) {
                entrenadorAtacante = entrenador1;
                entrenadorDefensor = entrenador2;
            } else {
                entrenadorAtacante = entrenador2;
                entrenadorDefensor = entrenador1;
            }

            Pokemon pokemonAtacante = seleccionarPokemon(entrenadorAtacante);
            Pokemon pokemonDefensor = seleccionarPokemon(entrenadorDefensor);

            combateView.mostrarEnfrentamiento(pokemonAtacante, pokemonDefensor);

            boolean habilidadAtacante = verificarHabilidad(pokemonAtacante.getHabilidadEspecial());
            int potenciadorAtaque = habilidadAtacante ? generarPotenciador() : 0;
            combateView.mostrarHabilidad(pokemonAtacante, habilidadAtacante, potenciadorAtaque);

            boolean habilidadDefensor = verificarHabilidad(pokemonDefensor.getHabilidadEspecial());
            int potenciadorDefensa = habilidadDefensor ? generarPotenciador() : 0;
            combateView.mostrarHabilidad(pokemonDefensor, habilidadDefensor, potenciadorDefensa);

            int ataqueEfectivo = calcularAtaqueEfectivo(pokemonAtacante, potenciadorAtaque);
            int defensaEfectiva = calcularDefensaEfectiva(pokemonDefensor, potenciadorDefensa);
            int efectividadTipo = calcularEfectividadTipo(pokemonAtacante, pokemonDefensor);

            int ataqueTotal = ataqueEfectivo + efectividadTipo - defensaEfectiva;
            int resultado = resultadoRonda(ataqueTotal);

            combateView.mostrarCalculos(ataqueEfectivo, defensaEfectiva, efectividadTipo, ataqueTotal);
            combateView.mostrarResultadoRonda(resultado, pokemonAtacante, pokemonDefensor);

            registrarVictoria(resultado, entrenador1Ataca);
            entrenador1Ataca = !entrenador1Ataca;
        }

        int ganador = ganadorBatalla();
        combateView.mostrarGanadorBatalla(
                ganador,
                entrenador1.getNombre(),
                entrenador2.getNombre(),
                victoriasEntrenador1,
                victoriasEntrenador2);
    }

    private Pokemon seleccionarPokemon(Entrenador entrenador) {
        while (true) {
            int indice = random.nextInt(4);

            if (entrenador == entrenador1) {
                Pokemon pokemon = obtenerPokemon(entrenador, indice);

                if (pokemon != null) {
                    quitarPokemon(entrenador, indice);
                    return pokemon;
                }
            } else {
                Pokemon pokemon = obtenerPokemon(entrenador, indice);

                if (pokemon != null) {
                    quitarPokemon(entrenador, indice);
                    return pokemon;
                }
            }
        }
    }

    private Pokemon obtenerPokemon(Entrenador entrenador, int indice) {
        if (indice == 0) {
            return entrenador.getPokemon1();
        }

        if (indice == 1) {
            return entrenador.getPokemon2();
        }

        if (indice == 2) {
            return entrenador.getPokemon3();
        }

        return entrenador.getPokemon4();
    }

    private void quitarPokemon(Entrenador entrenador, int indice) {
        if (indice == 0) {
            entrenador.setPokemon1(null);
            return;
        }

        if (indice == 1) {
            entrenador.setPokemon2(null);
            return;
        }

        if (indice == 2) {
            entrenador.setPokemon3(null);
            return;
        }

        entrenador.setPokemon4(null);
    }

    private boolean verificarHabilidad(HabilidadEspecial habilidad) {
        if (habilidad == null) {
            return false;
        }

        int numeroAleatorio = random.nextInt(101);
        return numeroAleatorio <= habilidad.getProbabilidadEspecial();
    }

    private int generarPotenciador() {
        return random.nextInt(26);
    }

    private int calcularAtaqueEfectivo(Pokemon pokemon, int potenciador) {
        return pokemon.getAtaque() + (pokemon.getAtaque() * potenciador / 100);
    }

    private int calcularDefensaEfectiva(Pokemon pokemon, int potenciador) {
        return pokemon.getDefensa() + (pokemon.getDefensa() * potenciador / 100);
    }

    private int calcularEfectividadTipo(Pokemon atacante, Pokemon defensor) {
        String tipoAtacante = atacante.getTipo();
        String tipoDefensor = defensor.getTipo();

        if (tipoAtacante.equalsIgnoreCase("Fuego")) {
            if (tipoDefensor.equalsIgnoreCase("Agua")) {
                return -10;
            }

            if (tipoDefensor.equalsIgnoreCase("Planta")) {
                return 20;
            }
        } else if (tipoAtacante.equalsIgnoreCase("Agua")) {
            if (tipoDefensor.equalsIgnoreCase("Fuego")) {
                return 20;
            }

            if (tipoDefensor.equalsIgnoreCase("Planta")) {
                return -10;
            }
        } else if (tipoAtacante.equalsIgnoreCase("Planta")) {
            if (tipoDefensor.equalsIgnoreCase("Fuego")) {
                return -10;
            }

            if (tipoDefensor.equalsIgnoreCase("Agua")) {
                return 20;
            }
        } else if (tipoAtacante.equalsIgnoreCase("Electrico")
                || tipoAtacante.equalsIgnoreCase("Eléctrico")) {
            if (tipoDefensor.equalsIgnoreCase("Agua")) {
                return 20;
            }
        }

        return 0;
    }

    private int resultadoRonda(int ataqueTotal) {
        if (ataqueTotal > 0) {
            return 1;
        }

        if (ataqueTotal < 0) {
            return -1;
        }

        return 0;
    }

    private void registrarVictoria(int resultado, boolean entrenador1Ataca) {
        if (resultado == 0) {
            return;
        }

        if (entrenador1Ataca) {
            if (resultado == 1) {
                victoriasEntrenador1++;
            } else {
                victoriasEntrenador2++;
            }
        } else {
            if (resultado == 1) {
                victoriasEntrenador2++;
            } else {
                victoriasEntrenador1++;
            }
        }
    }

    private int ganadorBatalla() {
        if (victoriasEntrenador1 > victoriasEntrenador2) {
            return 1;
        }

        if (victoriasEntrenador2 > victoriasEntrenador1) {
            return 2;
        }

        return 0;
    }
}