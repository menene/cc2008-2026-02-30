public class ConfiguradorJuego {
    public ControladorCombate armarEscenario() {
        // Crear 8 Habilidades
        HabilidadEspecial h1 = new HabilidadEspecial("Llamarada", 30.0);
        HabilidadEspecial h2 = new HabilidadEspecial("Torrente", 45.0);
        HabilidadEspecial h3 = new HabilidadEspecial("Espesura", 25.0);
        HabilidadEspecial h4 = new HabilidadEspecial("Impactrueno", 35.0);
        HabilidadEspecial h5 = new HabilidadEspecial("Ascuas", 20.0);
        HabilidadEspecial h6 = new HabilidadEspecial("Pistola Agua", 30.0);
        HabilidadEspecial h7 = new HabilidadEspecial("Látigo Cepa", 50.0);
        HabilidadEspecial h8 = new HabilidadEspecial("Rayo", 30.0);

        // Crear Entrenador 1 y asignarle 4 Pokémon
        Entrenador jugador1 = new Entrenador();
        jugador1.setRol(true); // Empieza atacando
        jugador1.setP1(new Pokemon("Charizard", Tipo.FUEGO, 75.0, 70.0, h1));
        jugador1.setP2(new Pokemon("Blastoise", Tipo.AGUA, 65.0, 85.0, h2)); // Tanque defensivo
        jugador1.setP3(new Pokemon("Venusaur", Tipo.PLANTA, 70.0, 75.0, h3));
        jugador1.setP4(new Pokemon("Pikachu", Tipo.ELECTRICO, 85.0, 50.0, h4)); // Daño rápido

        // Crear Entrenador 2 y asignarle 4 Pokémon
        Entrenador jugador2 = new Entrenador();
        jugador2.setRol(false); // Empieza defendiendo
        jugador2.setP1(new Pokemon("Arcanine", Tipo.FUEGO, 80.0, 65.0, h5));
        jugador2.setP2(new Pokemon("Gyarados", Tipo.AGUA, 85.0, 60.0, h6));
        jugador2.setP3(new Pokemon("Sceptile", Tipo.PLANTA, 75.0, 70.0, h7));
        jugador2.setP4(new Pokemon("Jolteon", Tipo.ELECTRICO, 80.0, 55.0, h8));

        CombateVista vista = new CombateVista();
        return new ControladorCombate(jugador1, jugador2, vista);
    }
}