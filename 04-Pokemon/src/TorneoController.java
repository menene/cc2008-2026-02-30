public class TorneoController {
    private TorneoView vista;

    public TorneoController() {
        vista = new TorneoView();
    }

    public void IniciarTorneo() {
        Torneo torneo=new Torneo();
        torneo.CrearTorneo();
        Jugador entrenador = torneo.getEntrenador();
        Jugador entrenador1= torneo.getEntrenador1();
        vista.Inicio(entrenador.getNombre(),entrenador1.getNombre(),entrenador.equipo.poke1.getNombre(),entrenador1.equipo.poke1.getNombre(),String.valueOf(entrenador.getRol()),String.valueOf(entrenador1.getRol()));
        
        Ronda ronda = new Ronda((byte)1, entrenador, entrenador1);
        
        Pokemon ganador1 = ronda.Combate(entrenador.equipo.getPoke1(),entrenador1.equipo.getPoke1());
        vista.Ronda((byte)1,entrenador.equipo.getPoke1().getNombre(),entrenador1.equipo.getPoke1().getNombre());
        if (ganador1 == null) {
            vista.Ganador("Empate en ronda 1");
        } else {
            vista.Ganador(ganador1.getNombre());
        }


        Pokemon ganador2 = ronda.Combate(entrenador.equipo.getPoke2(),entrenador1.equipo.getPoke2());
        vista.Ronda((byte)2, entrenador.equipo.getPoke2().getNombre(),entrenador1.equipo.getPoke2().getNombre());
        if (ganador2 == null) {
            vista.Ganador("Empate en ronda 2");
        } else {
            vista.Ganador(ganador1.getNombre());
        }

        Pokemon ganador3 = ronda.Combate(entrenador.equipo.getPoke3(),entrenador1.equipo.getPoke3());
        vista.Ronda((byte)3,entrenador.equipo.getPoke3().getNombre(),entrenador1.equipo.getPoke3().getNombre());
        if (ganador3 == null) {
            vista.Ganador("Empate en ronda 3");
        } else {
            vista.Ganador(ganador1.getNombre());
        }

        Pokemon ganador4 = ronda.Combate(entrenador.equipo.getPoke4(),entrenador1.equipo.getPoke4());
        vista.Ronda((byte) 4, entrenador.equipo.getPoke4().getNombre(), entrenador1.equipo.getPoke4().getNombre());
        if (ganador4 == null) {
            vista.Ganador("Empate en ronda 4");
        } else {
            vista.Ganador(ganador1.getNombre());
        }

        if (entrenador.getVictorias() > entrenador1.getVictorias()) {
            vista.Ganador(entrenador.getNombre());
        } else if (entrenador1.getVictorias() > entrenador.getVictorias()) {
            vista.Ganador(entrenador1.getNombre());
        } else {
            vista.Ganador("Empate");
        }

        if(entrenador.victorias > entrenador1.victorias){
            vista.MostrarGanador(entrenador);
        }else {
            vista.MostrarGanador(entrenador1);
        }

        vista.Resultados(entrenador, entrenador1);
        

    }
}