public class Pokemones{
    private String nombre_pokemon;
    private int ataque;
    private String tipo;
    private int defensa;
    private Habilidad_Especial habilidad_especial;
    public Pokemones(String nombre_pokemon, int ataque, String tipo, int defensa, Habilidad_Especial habilidad_especial){
        this.nombre_pokemon = nombre_pokemon;
        this.ataque = ataque;
        this.tipo = tipo;
        this.defensa = defensa;
        this.habilidad_especial = habilidad_especial;
    }
    public String getNombre_Pokemon(){
        return nombre_pokemon;
    }
    public int get_Ataque(){
        return ataque;
    }
    public String get_Tipo(){
        return tipo;
    }
    public int get_Defensa(){
        return defensa;
    }
    public Habilidad_Especial get_Habilidad_Especial(){
        return habilidad_especial;
    }
}