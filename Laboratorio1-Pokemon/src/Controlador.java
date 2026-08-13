public class Controlador {
    //atributos
    private Jugador jugador1;
    private Jugador jugador2;
    private Combate combateActual;
    private Vista vista;

    //constructor
    public Controlador() {
        this.vista = new Vista();
        this.combateActual = new Combate();

        //se crean las habilidades 
        HabilidadEspecial habFuego = new HabilidadEspecial("Llama Final", (byte) 30);
        HabilidadEspecial habAgua = new HabilidadEspecial("Coraza Marina", (byte) 30);
        HabilidadEspecial habPlanta = new HabilidadEspecial("Escudo Natural", (byte) 30);
        HabilidadEspecial habElect = new HabilidadEspecial("Impacto Relámpago", (byte) 30);

        //se crean los pokemon para el jugador 1
        Pokemon p1J1 = new Pokemon("Charizard", "Fuego", (short) 50, (short) 50, habFuego);
        Pokemon p2J1 = new Pokemon("Blastoise", "Agua", (short) 50, (short) 50, habAgua);
        Pokemon p3J1 = new Pokemon("Venusaur", "Planta", (short) 50, (short) 50, habPlanta);
        Pokemon p4J1 = new Pokemon("Pikachu", "Eléctrico", (short) 50, (short) 50, habElect);
        
        this.jugador1 = new Jugador("Entrenador 1", p1J1, p2J1, p3J1, p4J1);

        //se crean los pokemon para el jugador 2
        Pokemon p1J2 = new Pokemon("Arcanine", "Fuego", (short) 50, (short) 50, habFuego);
        Pokemon p2J2 = new Pokemon("Gyarados", "Agua", (short) 50, (short) 50, habAgua);
        Pokemon p3J2 = new Pokemon("Sceptile", "Planta", (short) 50, (short) 50, habPlanta);
        Pokemon p4J2 = new Pokemon("Jolteon", "Eléctrico", (short) 50, (short) 50, habElect);

        this.jugador2 = new Jugador("Entrenador 2", p1J2, p2J2, p3J2, p4J2);
    }

    //metodo para arrancar el juego
    public void iniciarJuego() {
        vista.mostrarMensaje("=================================");
        vista.mostrarMensaje("inicia el combate pokemon");
        vista.mostrarMensaje("=================================\n");
        
        //inicia el combate
        combateActual.coordinarCombate(jugador1, jugador2);
        
        //se evaluan los resultados
        determinarGanadorFinal();
    }

    //metodo para ver quien gano al final
    public void determinarGanadorFinal() {
        vista.mostrarMensaje("--- resultados finales ---");
        vista.mostrarMensaje(jugador1.getNombre() + " gano " + jugador1.getRondasGanadas() + " rondas.");
        vista.mostrarMensaje(jugador2.getNombre() + " gano " + jugador2.getRondasGanadas() + " rondas.\n");

        if (jugador1.getRondasGanadas() > jugador2.getRondasGanadas()) {
            vista.mostrarMensaje("el ganador es " + jugador1.getNombre());
        } else if (jugador2.getRondasGanadas() > jugador1.getRondasGanadas()) {
            vista.mostrarMensaje("el ganador es " + jugador2.getNombre());
        } else {
            vista.mostrarMensaje("el combate termino en empate");
        }
    }
}