public class ControladorCombate {
    private Combate combate;
    private VistaCombate vista;

    public ControladorCombate() {
        Habilidad h1 = new Habilidad("Llama Final", 30);
        Habilidad h2 = new Habilidad("Chorro de agua", 40);
        Habilidad h3 = new Habilidad("Escudo Natural", 20);
        Habilidad h4 = new Habilidad("Impacto Relampago", 30);

        Pokemon p1 = new Pokemon("Charizard", "Fuego", 50, 35, h1);
        Pokemon p2 = new Pokemon("Squirtle", "Agua", 37, 25, h2);
        Pokemon p3 = new Pokemon("Ivyasaur", "Planta", 38, 38, h3);
        Pokemon p4 = new Pokemon("Pikachu", "Electrico", 45, 30, h4);

        Pokemon p5 = new Pokemon("Incineroar", "Fuego", 39, 32, h1);
        Pokemon p6 = new Pokemon("Greninja", "Agua", 37, 36, h2);
        Pokemon p7 = new Pokemon("Leafeon", "Planta", 36, 39, h3);
        Pokemon p8 = new Pokemon("Pichu", "Electrico", 43, 34, h4);

        Entrenador entrenador1 = new Entrenador("Jugador 1", p1, p2, p3, p4);
        Entrenador entrenador2 = new Entrenador("Jugador 2", p5, p6, p7, p8);

        this.combate = new Combate(entrenador1, entrenador2);
        this.vista = new VistaCombate();
    }

    public void Iniciar() {
        vista.MostrarInicio();
        Entrenador entrenador1 = this.combate.GetEntrenador1();
        Entrenador entrenador2 = this.combate.GetEntrenador2();

        for (int ronda = 1; ronda <=4; ronda++) {
            if (ronda %2 != 0) {
                EjecutarRonda(entrenador1, entrenador2, ronda);
            } else {
                EjecutarRonda(entrenador2, entrenador1, ronda);
            }
        }
        vista.MostrarResultadoFinal(combate);
    }

    private void EjecutarRonda(Entrenador atacante, Entrenador defensor, int ronda) {
        Pokemon pokemonAtacante = atacante.SeleccionarPokemon();
        Pokemon pokemonDefensor = defensor.SeleccionarPokemon();
        vista.MostrarRonda(ronda, atacante, defensor, pokemonAtacante, pokemonDefensor);

        double ataqueEfectivo = pokemonAtacante.GetAtaque();
        double defensaEfectiva = pokemonDefensor.GetDefensa();

        if (pokemonAtacante.GetHabilidad().Activacion()) {
            double potenciador = pokemonAtacante.GetHabilidad().Potenciador();
            ataqueEfectivo = ataqueEfectivo + (ataqueEfectivo * potenciador);
            vista.MostrarHabilidad(pokemonAtacante, potenciador);
        }

        if (pokemonDefensor.GetHabilidad().Activacion()) {
            double potenciador = pokemonDefensor.GetHabilidad().Potenciador();
            defensaEfectiva = defensaEfectiva + (defensaEfectiva * potenciador);
            vista.MostrarHabilidad(pokemonDefensor, potenciador);
        }

        int bonoTipo = CalcularEfectividad(pokemonAtacante.GetTipo(), pokemonDefensor.GetTipo());
        vista.MostrarEfectividad(bonoTipo);

        double dañoTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;

        if (dañoTotal > 0) {
            atacante.aumentarVictorias();
            vista.MostrarResultadoRonda(atacante);
        } else if (dañoTotal < 0) {
            defensor.aumentarVictorias();
            vista.MostrarResultadoRonda(defensor);
        } else {
            vista.MostrarResultadoRonda(null);
        }
    }

    private int CalcularEfectividad(String tipoAtk, String tipoDef) {
        if (tipoAtk.equals("Fuego") && tipoDef.equals("Planta")) {
            return 20;
        }

        if (tipoAtk.equals("Fuego") && tipoDef.equals("Agua")) {
            return -10;
        }

        if (tipoAtk.equals("Agua") && tipoDef.equals("Fuego")) {
            return 20;
        }

        if (tipoAtk.equals("Agua") && tipoDef.equals("Planta")) {
            return -10;
        }

        if (tipoAtk.equals("Planta") && tipoDef.equals("Agua")) {
            return 20;
        }

        if (tipoAtk.equals("Planta") && tipoDef.equals("Fuego")) {
            return -10;
        }

        if (tipoAtk.equals("Electrico") && tipoDef.equals("Agua")) {
            return 20;
        }

        return 0;
    }
}