import java.util.Random;

public class Batalla {

    // Atributos
    private Entrenador entrenador1;
    private Entrenador entrenador2;

    private int rondaActual;
    private int rondasGanadas1;
    private int rondasGanadas2;

    private Pokemon[] disponibles1;
    private Pokemon[] disponibles2;

    private VistaBatalla vista;

    // Constructor
    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;

        this.rondaActual = 1;
        this.rondasGanadas1 = 0;
        this.rondasGanadas2 = 0;

        this.disponibles1 = entrenador1.getPokemones().clone(); //
        this.disponibles2 = entrenador2.getPokemones().clone();

        this.vista = new VistaBatalla();
    }

    //Selecciona Pokemon que no haya peleado
    private Pokemon seleccionarPokemon(Pokemon[] disponibles) {
        //crea un numero random que representa una posición 
        Random random = new Random();

        int indice = random.nextInt(disponibles.length); //el random es de la longitud de la lista

        // Si ese Pokemon ya fue seleccionado, busca otra posicion
        while (disponibles[indice] == null) {
            indice = random.nextInt(disponibles.length);
        }

        Pokemon seleccionado = disponibles[indice]; //Selecciona el pokemon en la posición del numero random

        // Lo quitamos de los disponibles para que no vuelva a pelear (se vuelve null)
        disponibles[indice] = null;

        return seleccionado;
    }

    public void iniciarBatalla() {

            for (rondaActual = 1; rondaActual <= 4; rondaActual++) {
            jugarRonda();
        }

        String ganador = determinarGanador();

        vista.mostrarResultadoFinal(ganador, rondasGanadas1, rondasGanadas2
        );

    }

    private void jugarRonda() {
        

        // Seleccionar un Pokemon disponible de cada entrenador
        Pokemon pokemon1 = seleccionarPokemon(disponibles1);
        Pokemon pokemon2 = seleccionarPokemon(disponibles2);

        Pokemon atacante;
        Pokemon defensor;

        // Determinar quien ataca y quien defiende
        // Rondas 1 y 3: entrenador 1 ataca
        // Rondas 2 y 4: entrenador 2 ataca
        if (rondaActual % 2 != 0) {
            atacante = pokemon1;
            defensor = pokemon2;
        } else {
            atacante = pokemon2;
            defensor = pokemon1;
        }

        // Los potenciadores empiezan en 0
        int potenciadorAtaque = 0;
        int potenciadorDefensa = 0;

        // Intentar activar la habilidad del atacante
        if (atacante.getHabilidad().activarHabilidad()) {
            potenciadorAtaque = atacante.getHabilidad().generarPotenciador();
        }

        // Intentar activar la habilidad del defensor
        if (defensor.getHabilidad().activarHabilidad()) {
            potenciadorDefensa = defensor.getHabilidad().generarPotenciador();
        }

        // Calcular ataque efectivo del atacante
        double ataqueEfectivo = calcularEstadisticaEfectiva(
                atacante.getAtaque(),
                potenciadorAtaque
        );

        // Calcular defensa efectiva del defensor
        double defensaEfectiva = calcularEstadisticaEfectiva(
                defensor.getDefensa(),
                potenciadorDefensa
        );

        // Calcular bono segun los tipos
        int bonoTipo = calcularBonoTipo(atacante, defensor);

        // Calcular resultado de la ronda
        double resultado = calcularTotal(
                ataqueEfectivo,
                bonoTipo,
                defensaEfectiva
        );

        // Determinar quien gano la ronda
        if (resultado > 0) {

            // Gano el atacante
            if (rondaActual % 2 != 0) {
                rondasGanadas1++;
            } else {
                rondasGanadas2++;
            }

        } else if (resultado < 0) {

            // Gano el defensor
            if (rondaActual % 2 != 0) {
                rondasGanadas2++;
            } else {
                rondasGanadas1++;
            }
        }

    // Si resultado == 0, nadie suma punto

    // Mandar el resultado a la vista
    vista.mostrarEstadoRonda(
            rondaActual,
            atacante,
            defensor,
            resultado
    );
}

    

    private double calcularEstadisticaEfectiva(double valorBase, int potenciador) {

        double bono = valorBase * potenciador / 100;

        return valorBase + bono;
    }

    //private int calcularBonoTipo(Pokemon atacante, Pokemon defensor) {
       // return 0;
    //}

    private double calcularTotal(double ataque, int bonoTipo, double defensa) {
        return ataque + bonoTipo - defensa;
    }

    public String determinarGanador() {
            
        if (rondasGanadas1 > rondasGanadas2) {
            return entrenador1.getNombre();
        }

        if (rondasGanadas2 > rondasGanadas1) {
            return entrenador2.getNombre();
        }

        return "Empate";
    }
    

    //Método tipos
    private int calcularBonoTipo(Pokemon atacante, Pokemon defensor) {

        String tipoAtacante = atacante.getTipo();
        String tipoDefensor = defensor.getTipo();

        // Fuego
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Planta")) {
            return 20;
        }

        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Agua")) {
            return -10;
        }

        // Agua
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Fuego")) {
            return 20;
        }

        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Planta")) {
            return -10;
        }

        // Planta
        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Agua")) {
            return 20;
        }

        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Fuego")) {
            return -10;
        }

        // Electrico
        if (tipoAtacante.equals("Electrico") 
            && tipoDefensor.equals("Agua")) {
            return 20;
        }

        // Cualquier otra combinacion es neutral
        return 0;
    }


    

}
