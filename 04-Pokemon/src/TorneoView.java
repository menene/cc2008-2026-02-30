
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

}