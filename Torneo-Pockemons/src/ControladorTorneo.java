public class ControladorTorneo{

    // atributos
    Torneo torneo;
    ControladorRonda controladorRonda;
    VistaTorneo vistaTorneo;

    // métodos

    // Constructor 
    public ControladorTorneo(){
        // instanciar los objetos necesarios para el programa
        torneo = new Torneo();
        controladorRonda = new ControladorRonda();
        vistaTorneo = new VistaTorneo();
        
        // inicializar a los jugadores y sus pockemons
        iniciaralizarJugadores();
    }

    // Crea los ocho pokemon y los dos jugadores con datos fijos en el codigo y los guarda dentro del torneo
    private void iniciaralizarJugadores(){

        // crear los 8 objetos pockemons
        Pockemon pockemon1 = new Pockemon("Pockemon 1", "Fuego", 100, 100, "Llama podedora", 100);
        Pockemon pockemon2 = new Pockemon("Pockemon 2", "Agua", 99, 101, "Agua podedora", 100);
        Pockemon pockemon3 = new Pockemon("Pockemon 3", "Planta", 95, 102, "Planta podedora", 100);
        Pockemon pockemon4 = new Pockemon("Pockemon 4", "Electrico", 89, 193, "Chispa podedora", 100);
        Pockemon pockemon5 = new Pockemon("Pockemon 5", "Fuego", 78, 104, "Fueguito podedoro", 100);
        Pockemon pockemon6 = new Pockemon("Pockemon 6", "Agua", 98, 105, "Aguita podedora", 100);
        Pockemon pockemon7 = new Pockemon("Pockemon 7", "Planta", 101, 106, "Plantita podedora", 100);
        Pockemon pockemon8 = new Pockemon("Pockemon 8", "Electrico", 96, 107, "Chispita podedora", 100);

        // crear los 2 objetos jugadores
        Jugador jugador1 = new Jugador("Daniel", pockemon1, pockemon2, pockemon3, pockemon4);
        Jugador jugador2 = new Jugador("Fernando", pockemon5, pockemon6, pockemon7, pockemon8);
        
        // guardar los judadores dentro del torneo
        torneo.setJugador1(jugador1);
        torneo.setJugador2(jugador2);
    }

    // Crea y resuelve las cuatro rondas del combate alternando quien ataca y quien defiende, guarda cada ronda dentro del torneo, muestra cada resultado con la vista, y al final determina y muestra el ganador
    public void iniciarJuego(){

        // obtener los jugadores guardados en el torneo
        Jugador jugador1 = torneo.getJugador1();
        Jugador jugador2 = torneo.getJugador2();

        // crear las 4 rondas del torneo alternando quien ataca y quien defiende
        Ronda ronda1 = new Ronda(1, jugador1, jugador2);
        Ronda ronda2 = new Ronda(2, jugador2, jugador1);
        Ronda ronda3 = new Ronda(3, jugador1, jugador2);
        Ronda ronda4 = new Ronda(4, jugador2, jugador1);

        // jugar la ronda 1 y guardarla en el torneo
        controladorRonda.jugarRonda(ronda1);
        torneo.setRonda1(ronda1);

        // jugar la ronda 2 y guardarla en el torneo
        controladorRonda.jugarRonda(ronda2);
        torneo.setRonda2(ronda2);

        // jugar la ronda 3 y guardarla en el torneo
        controladorRonda.jugarRonda(ronda3);
        torneo.setRonda3(ronda3);

        // jugar la ronda 4 y guardarla en el torneo
        controladorRonda.jugarRonda(ronda4);
        torneo.setRonda4(ronda4);

        // mostrar resultados con la vista

        // mostrar los pockemon y el resultado de la ronda 1
        vistaTorneo.mostrarPockemon(ronda1.getPokemonAtacante().getNombre(), ronda1.getPokemonAtacante().getTipo(), ronda1.getPokemonAtacante().getAtaque(), ronda1.getPokemonAtacante().getDefensa(), ronda1.getPokemonAtacante().getNombreHabilidad(), ronda1.getPokemonAtacante().getProbabilidadActivacion());
        vistaTorneo.mostrarPockemon(ronda1.getPokemonDefensor().getNombre(), ronda1.getPokemonDefensor().getTipo(), ronda1.getPokemonDefensor().getAtaque(), ronda1.getPokemonDefensor().getDefensa(), ronda1.getPokemonDefensor().getNombreHabilidad(), ronda1.getPokemonDefensor().getProbabilidadActivacion());
        vistaTorneo.mostrarResultado(ronda1.getNumeroRonda(), ronda1.getJugadorAtacante().getNombre(), ronda1.getJugadorDefensor().getNombre(), ronda1.getPokemonAtacante().getNombre(), ronda1.getPokemonDefensor().getNombre(), ronda1.getAtaqueEfectivo(), ronda1.getDefensaEfectiva(), ronda1.getBonoTipo(), ronda1.getAtaqueTotal(), ronda1.getGanadorRonda());

        // mostrar los pockemon y el resultado de la ronda 2
        vistaTorneo.mostrarPockemon(ronda2.getPokemonAtacante().getNombre(), ronda2.getPokemonAtacante().getTipo(), ronda2.getPokemonAtacante().getAtaque(), ronda2.getPokemonAtacante().getDefensa(), ronda2.getPokemonAtacante().getNombreHabilidad(), ronda2.getPokemonAtacante().getProbabilidadActivacion());
        vistaTorneo.mostrarPockemon(ronda2.getPokemonDefensor().getNombre(), ronda2.getPokemonDefensor().getTipo(), ronda2.getPokemonDefensor().getAtaque(), ronda2.getPokemonDefensor().getDefensa(), ronda2.getPokemonDefensor().getNombreHabilidad(), ronda2.getPokemonDefensor().getProbabilidadActivacion());
        vistaTorneo.mostrarResultado(ronda2.getNumeroRonda(), ronda2.getJugadorAtacante().getNombre(), ronda2.getJugadorDefensor().getNombre(), ronda2.getPokemonAtacante().getNombre(), ronda2.getPokemonDefensor().getNombre(), ronda2.getAtaqueEfectivo(), ronda2.getDefensaEfectiva(), ronda2.getBonoTipo(), ronda2.getAtaqueTotal(), ronda2.getGanadorRonda());

        // mostrar los pockemon y el resultado de la ronda 3
        vistaTorneo.mostrarPockemon(ronda3.getPokemonAtacante().getNombre(), ronda3.getPokemonAtacante().getTipo(), ronda3.getPokemonAtacante().getAtaque(), ronda3.getPokemonAtacante().getDefensa(), ronda3.getPokemonAtacante().getNombreHabilidad(), ronda3.getPokemonAtacante().getProbabilidadActivacion());
        vistaTorneo.mostrarPockemon(ronda3.getPokemonDefensor().getNombre(), ronda3.getPokemonDefensor().getTipo(), ronda3.getPokemonDefensor().getAtaque(), ronda3.getPokemonDefensor().getDefensa(), ronda3.getPokemonDefensor().getNombreHabilidad(), ronda3.getPokemonDefensor().getProbabilidadActivacion());
        vistaTorneo.mostrarResultado(ronda3.getNumeroRonda(), ronda3.getJugadorAtacante().getNombre(), ronda3.getJugadorDefensor().getNombre(), ronda3.getPokemonAtacante().getNombre(), ronda3.getPokemonDefensor().getNombre(), ronda3.getAtaqueEfectivo(), ronda3.getDefensaEfectiva(), ronda3.getBonoTipo(), ronda3.getAtaqueTotal(), ronda3.getGanadorRonda());

        // mostrar los pockemon y el resultado de la ronda 4
        vistaTorneo.mostrarPockemon(ronda4.getPokemonAtacante().getNombre(), ronda4.getPokemonAtacante().getTipo(), ronda4.getPokemonAtacante().getAtaque(), ronda4.getPokemonAtacante().getDefensa(), ronda4.getPokemonAtacante().getNombreHabilidad(), ronda4.getPokemonAtacante().getProbabilidadActivacion());
        vistaTorneo.mostrarPockemon(ronda4.getPokemonDefensor().getNombre(), ronda4.getPokemonDefensor().getTipo(), ronda4.getPokemonDefensor().getAtaque(), ronda4.getPokemonDefensor().getDefensa(), ronda4.getPokemonDefensor().getNombreHabilidad(), ronda4.getPokemonDefensor().getProbabilidadActivacion());
        vistaTorneo.mostrarResultado(ronda4.getNumeroRonda(), ronda4.getJugadorAtacante().getNombre(), ronda4.getJugadorDefensor().getNombre(), ronda4.getPokemonAtacante().getNombre(), ronda4.getPokemonDefensor().getNombre(), ronda4.getAtaqueEfectivo(), ronda4.getDefensaEfectiva(), ronda4.getBonoTipo(), ronda4.getAtaqueTotal(), ronda4.getGanadorRonda());

        // determinar el ganador del torneo
        GanadorTorneo();

        // mostrar el marcador final y el campeon del combate
        vistaTorneo.mostrarResultado(jugador1.getNombre(), jugador1.getRondasGanadas(), jugador2.getNombre(), jugador2.getRondasGanadas(), torneo.ganadorTorneo);
    }

    // Compara las rondas ganadas de ambos jugadores y guarda el resultado dentro del torneo
    private void GanadorTorneo(){

        // obtener los jugadores guardados en el torneo
        Jugador jugador1 = torneo.getJugador1();
        Jugador jugador2 = torneo.getJugador2();

        // comparar las rondas ganadas de cada jugador
        if (jugador1.getRondasGanadas() > jugador2.getRondasGanadas()){
            torneo.setGanadorTorneo(jugador1.getNombre());
        }
        if (jugador2.getRondasGanadas() > jugador1.getRondasGanadas()){
            torneo.setGanadorTorneo(jugador2.getNombre());
        }
        if (jugador1.getRondasGanadas() == jugador2.getRondasGanadas()){
            torneo.setGanadorTorneo("Empate");
        }
    }




}
