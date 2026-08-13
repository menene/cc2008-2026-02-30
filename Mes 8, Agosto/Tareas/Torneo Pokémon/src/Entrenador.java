public class Entrenador{
    private String name;
    private Pokémon[] pokemones;
    private boolean rolActual;
    public Entrenador(String name, Pokémon[] pokemones, boolean rolActual){
        this.name=name;
        this.pokemones=pokemones;
        this.rolActual=rolActual;
    }
    public void changeRol(){
        this.rolActual = !this.rolActual;
    }
    public String getName(){ return this.name; }
    public Pokémon[] getPokemones(){ return this.pokemones; }
    public boolean getRolActual(){ return this.rolActual; }
}