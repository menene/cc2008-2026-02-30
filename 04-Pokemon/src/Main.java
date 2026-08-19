
public class Main {
    public static void main(String[] args) {

        // Jugador entrenador = new Jugador((byte)1, "Entrenador de prueva", (byte)2,
        // (byte)2);
        // System.out.println(entrenador.getNombre());
        // System.out.println(entrenador.equipo);
        //HabilidadEspecial habilidad = new HabilidadEspecial("impactrueno", (byte) 47);
        //Pokemon Poke = new Pokemon("Pikachu", (byte) 1, (byte) 100, (byte) 100, false, (byte) 0, habilidad);
        //HabilidadEspecial habilidad1 = new HabilidadEspecial("impactrueno", (byte) 47);
        //Pokemon Poke1 = new Pokemon("Nulbasur", (byte) 2, (byte) 200, (byte) 200, false, (byte) 0, habilidad1);
        //HabilidadEspecial habilidad2 = new HabilidadEspecial("impactrueno", (byte) 47);
        //Pokemon Poke2 = new Pokemon("Charizar", (byte) 3, (byte) 300, (byte) 300, false, (byte) 0, habilidad2);
        //HabilidadEspecial habilidad3 = new HabilidadEspecial("impactrueno", (byte) 47);
        //Pokemon Poke3 = new Pokemon("Cereulege", (byte) 4, (byte) 400, (byte) 400, false, (byte) 0, habilidad3);
//
        //Jugador entrenador1 = new Jugador((byte) 2,"Entrenador1",+(byte) 0,(byte) 1);
        //Jugador entrenador = new Jugador((byte) 1, "Entrenador", (byte) 1, (byte) 2);
        //entrenador.equipo.CrearEquipo(Poke, Poke1, Poke2, Poke3);
//
        //System.out.println(entrenador.equipo.getPoke1().getNombre());
        //System.out.println("Ataque: " + Poke.Movimiento(true));
        //System.out.println("Defensa: " + Poke.Movimiento(false));
//
        //System.out.println(entrenador.equipo.getPoke2().getNombre());
        //System.out.println("Ataque: " + Poke1.Movimiento(true));
        //System.out.println("Defensa: " + Poke1.Movimiento(false));
//
        //System.out.println(entrenador.equipo.getPoke3().getNombre());
        //System.out.println("Ataque: " + Poke2.Movimiento(true));
        //System.out.println("Defensa: " + Poke2.Movimiento(false));
       //
        //System.out.println(entrenador.equipo.getPoke4().getNombre());
        //System.out.println("Ataque: " + Poke3.Movimiento(true));
        //System.out.println("Defensa: " + Poke3.Movimiento(false));
//
        //Ronda ronda = new Ronda((byte) 1,entrenador,entrenador1);
//
        //Pokemon ganador = ronda.Combate(Poke, Poke1);
//
        //if (ganador == null) {
        //    System.out.println("Empate");
        //} else {
        //    System.out.println("Ganador: " + ganador.getNombre());
        //}
//
        //System.out.println(
        //        entrenador.getNombre() + " victorias: " + entrenador.getVictorias());
//
        //System.out.println(
        //        entrenador1.getNombre() + " victorias: " + entrenador1.getVictorias());
        TorneoController controller = new TorneoController();
        controller.IniciarTorneo();
    }
}