public class EquipoPokemon{
    Pokemon poke1;
    Pokemon poke2;
    Pokemon poke3;
    Pokemon poke4;
    byte entrenador;

    public void CrearEquipo (Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4){
        poke1= pokemon1;
        poke2=pokemon2;
        poke3=pokemon3;
        poke4=pokemon4;
    }
    public EquipoPokemon(byte entrenador) {
        this.entrenador = entrenador;
    }
    public Pokemon getPoke1() {
        return poke1;
    }
    public Pokemon getPoke2() {
        return poke2;
    }
    public Pokemon getPoke3() {
        return poke3;
    }
    public Pokemon getPoke4() {
        return poke4;
    }
}