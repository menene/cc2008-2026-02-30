
public class TorneoView{
    public void Inicio(String Entrenador, String Entrenador1, String Pokemon, String Pokemon1, String Rol, String Rol1){
        System.out.println("=============Inicio Del torneo=============");
        System.out.println("Rol: "+Rol+" Entrenador: " + Entrenador);
        System.out.println("   Pokemon: "+Pokemon);
        System.out.println("Rol: "+Rol1+" Entrenador: " + Entrenador1);
        System.out.println("   Pokemon: "+Pokemon1);
    }
    public void Ronda(byte Nronda, String pokemon, String pokemon1){
        System.out.println("=> Ronda No."+Nronda );
        System.out.println("============= Combate empieza =============");
        System.out.println(pokemon+" VS "+pokemon1);
    }

    public void Ganador(String ganador){
        System.out.println("Ganador: "+ganador);
    }

    public void Resultados(Jugador jugador, Jugador jugador1){
        System.out.println("========== RESULTADOS ==========");
        System.out.println(jugador.getVictorias()+" Victorias");
        System.out.println(jugador1.getVictorias()+" Victorias");
        System.out.println("================================");
    }

    public void MostrarGanador(Jugador ganador){
        System.out.println("=> GANADOR DEL TORNEO"+ganador.getNombre());
        System.out.println("Victorias: "+ganador.getVictorias());
    }

}