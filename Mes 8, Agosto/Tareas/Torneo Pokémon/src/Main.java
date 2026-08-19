import java.util.Random;
public class Main{
    private static String PUsed=",";
    public static void main(String[] args){
        Vista vista = new Vista();
        String name1 = vista.getName(1);
        String name2 = vista.getName(2);
        Entrenador entrenador1 = new Entrenador(name1,getTeam(),true);
        Entrenador entrenador2 = new Entrenador(name2,getTeam(),false);
        Entrenador[] entrenadores = {entrenador1,entrenador2};
        Arbitro arbitro = new Arbitro(entrenadores);
        arbitro.iniciarCombate();
        vista.mostrarResultados(arbitro.getResultados());
    }
    private static Pokémon[] getTeam(){
         Random r = new Random();
         String[] pokemonNames = {
             "Pikachu",
             "Charmander",
             "Squirtle",
             "Bulbasaur",
             "Eevee",
             "Gengar",
             "Snorlax",
             "Lucario",
             "Riolu",
             "Treecko",
             "Torchic",
             "Mudkip",
             "Chimchar",
             "Piplup",
             "Turtwig",
             "Froakie",
             "Fennekin",
             "Chespin",
             "Rowlet",
             "Litten",
             "Popplio",
             "Grookey",
             "Scorbunny",
             "Sobble",
             "Dratini",
             "Abra",
             "Machop",
             "Gastly",
             "Magikarp",
             "Psyduck",
             "Meowth",
             "Jigglypuff"
         };
         Pokémon[] pokemons = new Pokémon[4];
         for (int i =0; i< 4; i++){
             int n = r.nextInt(pokemonNames.length);
             do{
                n = r.nextInt(pokemonNames.length);
             } while (PUsed.contains(String.valueOf(","+n+",")));
            pokemons[i]=new Pokémon(pokemonNames[n]);
            PUsed+= n+",";
         }
         return pokemons;
    } 
}