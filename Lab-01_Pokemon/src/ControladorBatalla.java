public class ControladorBatalla {

    private BasePokemon basePokemon;
    private VistaConsola vista;
    private Batalla batalla;

    public ControladorBatalla(){

        basePokemon = new BasePokemon();
        vista = new VistaConsola();
    }

    public void iniciar(){

        crearEntrenadores();

        vista.mostrarPokemones(

            batalla.getEntrenador1(),
            batalla.getEntrenador2()
        );

        for (int ronda = 1; ronda <= 4; ronda++){

            if(ronda % 2 != 0){

                ejecutarRonda(ronda, batalla.getEntrenador1(), batalla.getEntrenador2());

            } else{

                ejecutarRonda(ronda, batalla.getEntrenador2(), batalla.getEntrenador1());
            }
        }

        vista.mostrarResultadoFinal(batalla);
    }

    private void crearEntrenadores(){

        Pokemon[] seleccionados = basePokemon.seleccionarPokemones();

        Pokemon[] equipo1 = new Pokemon[4];
        Pokemon[] equipo2 = new Pokemon[4];

        for (int i = 0; i < 4; i++){

            equipo1[i] = seleccionados[i];
            equipo2[i] = seleccionados[i + 4];
        }

        Entrenador entrenador1 = new Entrenador("Ash Ketchum", equipo1);
        Entrenador entrenador2 = new Entrenador("Gary Oak", equipo2);
        batalla = new Batalla(entrenador1, entrenador2);
    }

    private void ejecutarRonda(int numeroRonda, Entrenador entrenadorAtacante, Entrenador entrenadorDefensor)
        {
            Pokemon atacante = entrenadorAtacante.seleccionarPokemon();
            Pokemon defensor = entrenadorDefensor.seleccionarPokemon();

            vista.mostrarInicioRonda(numeroRonda, atacante, defensor, entrenadorAtacante, entrenadorDefensor);

            HabilidadEspecial habilidadAtaque = atacante.getHabilidadEspecial();
            boolean habilidadAtaqueActiva = habilidadAtaque.seActiva();
            int porcentajeAtaque = 0;

            if(habilidadAtaqueActiva){

                porcentajeAtaque = habilidadAtaque.generarPotenciador();
            }

            HabilidadEspecial habilidadDefensa = defensor.getHabilidadEspecial();
            boolean habilidadDefensaActiva = habilidadDefensa.seActiva();
            int porcentajeDefensa = 0;

            if(habilidadDefensaActiva) {

                porcentajeDefensa = habilidadDefensa.generarPotenciador();

            }

            double bonoAtaque = batalla.calcularBono(atacante.getAtaque(), porcentajeAtaque);

            double ataqueEfectivo = atacante.getAtaque() + bonoAtaque;

            double bonoDefensa = batalla.calcularBono(defensor.getDefensa(), porcentajeDefensa);

            double defensaEfectiva = defensor.getDefensa() + bonoDefensa;

            vista.mostrarAtaque(atacante, habilidadAtaqueActiva, porcentajeAtaque, bonoAtaque, ataqueEfectivo);

            vista.mostrarDefensa(defensor, habilidadDefensaActiva, porcentajeDefensa, bonoDefensa, defensaEfectiva);

            int bonoTipo = batalla.calcularBonoTipo(atacante, defensor);

            vista.mostrarBonoTipo(atacante, defensor, bonoTipo);

            double ataqueTotal = batalla.calcularAtaqueTotal(ataqueEfectivo, bonoTipo, defensaEfectiva);

            Entrenador ganador = null;

            if(ataqueTotal > 0){

                ganador = entrenadorAtacante;
            } else if(ataqueTotal < 0){

                ganador = entrenadorDefensor;
            }
            if(ganador != null){

                batalla.registrarVictoria(ganador);
            }

            vista.mostrarResultadoRonda(ataqueEfectivo, bonoTipo, defensaEfectiva, ataqueTotal, ganador);
                             
        }
}