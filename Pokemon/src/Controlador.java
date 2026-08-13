public class Controlador {

    private Batalla batalla;
    private Vista vista;

    public Controlador(Batalla batalla, Vista vista) {
        this.batalla = batalla;
        this.vista = vista;
    }

    public void iniciar() {
        combate();
    }

    private void combate() {

        Pokemon pokemonJ1;
        Pokemon pokemonJ2;
        int resultado;

        Entrenador jugador1 = batalla.getJ1();
        Entrenador jugador2 = batalla.getJ2();

        for (int ronda = 1; ronda <= 4; ronda++) {

            pokemonJ1 = jugador1.seleccion();
            pokemonJ2 = jugador2.seleccion();

            if (ronda == 1 || ronda == 3) {

                resultado = batalla.ronda(
                        pokemonJ1,
                        pokemonJ2
                );
                vista.mostrarHabilidades(pokemonJ1, pokemonJ2, batalla);
                if (resultado == 1) {

                    batalla.victoriaJ1();

                    vista.mostrarRonda(
                            ronda,
                            jugador1,
                            pokemonJ1,
                            jugador2,
                            pokemonJ2,
                            jugador1
                    );

                } else if (resultado == 2) {

                    batalla.victoriaJ2();

                    vista.mostrarRonda(
                            ronda,
                            jugador1,
                            pokemonJ1,
                            jugador2,
                            pokemonJ2,
                            jugador2
                    );
                    vista.mostrarHabilidades(pokemonJ1, pokemonJ2, batalla);
                } else {

                    vista.mostrarRonda(
                            ronda,
                            jugador1,
                            pokemonJ1,
                            jugador2,
                            pokemonJ2,
                            null
                    );
                }
            }

            else {

                resultado = batalla.ronda(
                        pokemonJ2,
                        pokemonJ1
                );

                if (resultado == 1) {

                    batalla.victoriaJ2();

                    vista.mostrarRonda(
                            ronda,
                            jugador2,
                            pokemonJ2,
                            jugador1,
                            pokemonJ1,
                            jugador2
                    );

                } else if (resultado == 2) {

                    batalla.victoriaJ1();

                    vista.mostrarRonda(
                            ronda,
                            jugador2,
                            pokemonJ2,
                            jugador1,
                            pokemonJ1,
                            jugador1
                    );
            
                } else {

                    vista.mostrarRonda(
                            ronda,
                            jugador2,
                            pokemonJ2,
                            jugador1,
                            pokemonJ1,
                            null
                    );
                }
            }
        }

        String ganador = batalla.ganador();

        vista.mostrarResultadoFinal(ganador);
    }
}