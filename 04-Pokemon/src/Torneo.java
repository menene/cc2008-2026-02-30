public class Torneo {

    Jugador entrenador;
    Jugador entrenador1;

    public void CrearTorneo() {

        HabilidadEspecial habilidad = new HabilidadEspecial("impactrueno", (byte) 47);
        Pokemon Poke = new Pokemon( "Pikachu", (byte) 1,(byte) 100,(byte) 100,false,(byte) 1,habilidad);

        HabilidadEspecial habilidad1 = new HabilidadEspecial("impactrueno", (byte) 47);
        Pokemon Poke1 = new Pokemon("Nulbasur",(byte) 2,(byte) 90,(byte) 90,false,(byte) 2, habilidad1);

        HabilidadEspecial habilidad2 = new HabilidadEspecial("Ascuas", (byte)50);
        Pokemon Poke2 = new Pokemon("Charizard",(byte)3,(byte)80,(byte)80,false,(byte)1,habilidad2);

        HabilidadEspecial habilidad3 =new HabilidadEspecial("Corte",(byte)45);
        Pokemon Poke3 = new Pokemon("Ceruledge",(byte)4,(byte)70,(byte)70,false,(byte)1,habilidad3);
       
        HabilidadEspecial habilidad4 = new HabilidadEspecial("Rayo", (byte)47);
        Pokemon poke4 = new Pokemon("Raichu",(byte)1,(byte)95,(byte)95,false,(byte)2,habilidad4);

        HabilidadEspecial habilidad5 = new HabilidadEspecial("Hoja Afilada", (byte)40);
        Pokemon poke5 = new Pokemon("Ivysaur",(byte)2,(byte)85,(byte)85,false,(byte)2,habilidad5);

        HabilidadEspecial habilidad6 = new HabilidadEspecial("Espada", (byte)45);
        Pokemon poke6 = new Pokemon("Ceruledge2", (byte)4,(byte)65,(byte)65, false,(byte)2, habilidad6 );

        HabilidadEspecial habilidad7 = new HabilidadEspecial("Llamarada", (byte)50);
        Pokemon poke7 = new Pokemon("Charizard2",(byte)3,(byte)75,(byte)75,false,(byte)2,habilidad7);
       
        entrenador = new Jugador( (byte) 1, "Entrenador", (byte) 0,(byte) 2);

        entrenador1 = new Jugador((byte) 2, "Entrenador1",(byte) 0,(byte) 1);

        entrenador.equipo.CrearEquipo(Poke,Poke1, Poke2,Poke3);

        entrenador1.equipo.CrearEquipo(poke4,poke5,poke6,poke7);
    }

    public Jugador getEntrenador() {
        return entrenador;
    }

    public Jugador getEntrenador1() {
        return entrenador1;
    }
}