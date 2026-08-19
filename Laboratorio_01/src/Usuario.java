public class Usuario{
    private Pokemones pokemon_1;
    private Pokemones pokemon_2;
    private Pokemones pokemon_3;
    private Pokemones pokemon_4;
    private int victorias;
    public Usuario(Pokemones pokemon_1, Pokemones pokemon_2, Pokemones pokemon_3, Pokemones pokemon_4){
        this.pokemon_1 = pokemon_1;
        this.pokemon_2 = pokemon_2;
        this.pokemon_3 = pokemon_3;
        this.pokemon_4 = pokemon_4;
        this.victorias = 0;
    }
    public Pokemones get_Pokemon1() {
        return pokemon_1;
    }

    public Pokemones get_Pokemon2() {
        return pokemon_2;
    }

    public Pokemones get_Pokemon3() {
        return pokemon_3;
    }

    public Pokemones get_Pokemon4() {
        return pokemon_4;
    }

    public int get_Victorias() {
        return victorias;
    }

    public void aumentar_Victoria() {
        victorias++;
    }
}