public class ControladorCombate {
    // Atributos
    private Combate combate;
    private VistaCombate vistaCombate;

    // Constructor de la clase
    public ControladorCombate() {
        vistaCombate = new VistaCombate();
    }
    
    // Este método inicia el combate entre pokemones
    public void iniciarCombate() {
        // Pide nombres de los 2 jugadores
        String nombreJugador1 = vistaCombate.pedirNombreJugador(1);
        String nombreJugador2 =vistaCombate.pedirNombreJugador(2);

        // Crea las habilidades especiales de los pockemones, son 8 en total
        HabilidadEspecial marLlamas = new HabilidadEspecial("Mar Llamas", 30);
        HabilidadEspecial electricidadEstatica = new HabilidadEspecial("Electricidad Estatica", 25);
        HabilidadEspecial torrente = new HabilidadEspecial("Torrente", 35);
        HabilidadEspecial espesura = new HabilidadEspecial("Espesura", 40);
        HabilidadEspecial absorbeAgua = new HabilidadEspecial("Absorbe Agua", 30);
        HabilidadEspecial lanzallamas = new HabilidadEspecial("Lanzallamas", 25);
        HabilidadEspecial hojaAfilada = new HabilidadEspecial("Hoja Afilada", 35);
        HabilidadEspecial impactoTrueno = new HabilidadEspecial("Impacto Trueno", 20);

        // Creación de 4 instancias de Pokemon que le pertenecerán al jugador 1
        Pokemon charmander = new Pokemon("Charmander", 1, 70, 40, marLlamas);
        Pokemon pikachu = new Pokemon("Pikachu", 4, 75, 45, electricidadEstatica);
        Pokemon squirtle = new Pokemon("Squirtle", 2, 55, 75, torrente);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 3, 60, 60, espesura);

        // Creación de 4 instancias de Pokemon que le pertenecerán al jugador 2
        Pokemon vaporeon = new Pokemon("Vaporeon", 2, 65, 70, absorbeAgua);
        Pokemon vulpix = new Pokemon("Vulpix", 1, 65, 50, lanzallamas);
        Pokemon bellsprout = new Pokemon("Bellsprout", 3, 70, 45, hojaAfilada);
        Pokemon magnemite = new Pokemon("Magnemite", 4, 60, 80, impactoTrueno);
    
        // Se crean los jugadores con los nombres ingresados anteriormente
        Jugador jugador1 = new Jugador(nombreJugador1, charmander, pikachu, squirtle, bulbasaur);
        Jugador jugador2 = new Jugador(nombreJugador2, vaporeon, vulpix, bellsprout, magnemite);

        // Se crea una instancia del torneo
        combate = new Combate(jugador1, jugador2);

        // Se muestra el título del juego, los jugadores y sus pokemones
        vistaCombate.mostrarInicioCombate(jugador1.getNombre(), charmander.getNombre(), pikachu.getNombre(), squirtle.getNombre(), bulbasaur.getNombre(),
        jugador2.getNombre(), vaporeon.getNombre(), vulpix.getNombre(), bellsprout.getNombre(), magnemite.getNombre());

        // Comienza ronda 1 donde jugador 1 es atacante y el 2 es defensor
        Pokemon atacante = jugador1.seleccionarPokemon();
        Pokemon defensor = jugador2.seleccionarPokemon();
        Ronda ronda1 = new Ronda(atacante, defensor);

        vistaCombate.mostrarRonda(1, atacante.getNombre(), defensor.getNombre(), jugador1.getNombre(), jugador2.getNombre());
        
        ronda1.iniciarBatalla();

        Pokemon ganadorRonda = ronda1.getGanador();

        if (ganadorRonda == atacante) {
            jugador1.aumentarRondasGanadas();
        } else if (ganadorRonda == defensor) {
            jugador2.aumentarRondasGanadas();
        }

        String nombreGanador = null;
        if (ganadorRonda != null) {
            nombreGanador = ganadorRonda.getNombre();
        }

        int bono = ronda1.getDiferencia() - ronda1.getAtaqueFinal() + ronda1.getDefensaFinal();
        vistaCombate.mostrarResultadoRonda(ronda1.getAtaqueFinal(), ronda1.getDefensaFinal(), ronda1.getDiferencia(), bono, nombreGanador);

        combate.setRonda1(ronda1);

        // Comienza ronda 2 donde jugador 1 es atacante y el 2 es defensor
        atacante = jugador2.seleccionarPokemon();
        defensor = jugador1.seleccionarPokemon();
        Ronda ronda2 = new Ronda(atacante, defensor);

        vistaCombate.mostrarRonda(2, atacante.getNombre(), defensor.getNombre(), jugador2.getNombre(), jugador1.getNombre());
        ronda2.iniciarBatalla();

        ganadorRonda = ronda2.getGanador();

        if (ganadorRonda == atacante) {
            jugador2.aumentarRondasGanadas();
        } else if (ganadorRonda == defensor) {
            jugador1.aumentarRondasGanadas();
        }

        nombreGanador = null;

        if (ganadorRonda != null) {
            nombreGanador = ganadorRonda.getNombre();
        }

        bono = ronda2.getDiferencia() - ronda2.getAtaqueFinal() + ronda2.getDefensaFinal();
        vistaCombate.mostrarResultadoRonda(ronda2.getAtaqueFinal(), ronda2.getDefensaFinal(), ronda2.getDiferencia(), bono, nombreGanador);

        combate.setRonda2(ronda2);

        // Comienza ronda 3 donde jugador 1 es atacante y el 2 es defensor
        atacante = jugador1.seleccionarPokemon();

        defensor = jugador2.seleccionarPokemon();

        Ronda ronda3 = new Ronda(atacante, defensor);

        vistaCombate.mostrarRonda(3, atacante.getNombre(), defensor.getNombre(), jugador1.getNombre(), jugador2.getNombre());

        ronda3.iniciarBatalla();

        ganadorRonda = ronda3.getGanador();

        if (ganadorRonda == atacante) {
            jugador1.aumentarRondasGanadas();
        } else if (ganadorRonda == defensor) {
            jugador2.aumentarRondasGanadas();
        }

        nombreGanador = null;
        if (ganadorRonda != null) {
            nombreGanador = ganadorRonda.getNombre();
        }

        bono = ronda3.getDiferencia() - ronda3.getAtaqueFinal() + ronda3.getDefensaFinal();
        vistaCombate.mostrarResultadoRonda(ronda3.getAtaqueFinal(), ronda3.getDefensaFinal(), ronda3.getDiferencia(), bono, nombreGanador);

        combate.setRonda3(ronda3);

        // Comienza ronda 4 donde jugador 1 es atacante y el 2 es defensor
        atacante = jugador2.seleccionarPokemon();

        defensor = jugador1.seleccionarPokemon();

        Ronda ronda4 = new Ronda(atacante, defensor);

        vistaCombate.mostrarRonda(4, atacante.getNombre(), defensor.getNombre(), jugador2.getNombre(), jugador1.getNombre());

        ronda4.iniciarBatalla();

        ganadorRonda = ronda4.getGanador();

        if (ganadorRonda == atacante) {
            jugador2.aumentarRondasGanadas();
        } else if (ganadorRonda == defensor) {
            jugador1.aumentarRondasGanadas();
        }

        nombreGanador = null;
        if (ganadorRonda != null) {
            nombreGanador = ganadorRonda.getNombre();
        }
        bono = ronda4.getDiferencia() - ronda4.getAtaqueFinal() + ronda4.getDefensaFinal();
        vistaCombate.mostrarResultadoRonda(ronda4.getAtaqueFinal(), ronda4.getDefensaFinal(), ronda4.getDiferencia(), bono, nombreGanador);

        combate.setRonda4(ronda4);

        // Al finalizar las 4 rondas se determina al ganador o si hay empate y se muestra en consola
        Jugador ganadorCombate = combate.determinarGanador();
        if (ganadorCombate != null) {
            vistaCombate.mostrarGanadorCombate(ganadorCombate.getNombre());
        } else {
            vistaCombate.mostrarEmpate();
        }
    }    
}
