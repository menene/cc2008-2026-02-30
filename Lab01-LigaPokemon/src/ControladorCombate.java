public class ControladorCombate {

    private Combate combate;
    private VistaCombate vista;

    public ControladorCombate() {

        // Entrenador 1
        AtaqueEspecial llamaFinal = new AtaqueEspecial("Llama Final", 30);
        AtaqueEspecial escudoNatural = new AtaqueEspecial("Escudo Natural", 40);
        AtaqueEspecial impactoRelampago = new AtaqueEspecial("Impacto Relampago", 20);
        AtaqueEspecial hojaAfilada = new AtaqueEspecial("Hoja Afilada", 35);

        Pokemon charizard = new Pokemon("Charizard", "Fuego", 55, 40, llamaFinal);
        Pokemon blastoise = new Pokemon("Blastoise", "Agua", 48, 50, escudoNatural);
        Pokemon pikachu = new Pokemon("Pikachu", "Electrico", 50, 35, impactoRelampago);
        Pokemon venusaur = new Pokemon("Venusaur", "Planta", 45, 45, hojaAfilada);

        Entrenador entrenador1 = new Entrenador("Ash", charizard, blastoise, pikachu, venusaur);

        // Entrenador 2
        AtaqueEspecial olaGigante = new AtaqueEspecial("Ola Gigante", 30);
        AtaqueEspecial rayoSolar = new AtaqueEspecial("Rayo Solar", 25);
        AtaqueEspecial chispaElectrica = new AtaqueEspecial("Chispa Electrica", 40);
        AtaqueEspecial llamaradaFinal = new AtaqueEspecial("Llamarada Final", 35);

        Pokemon gyarados = new Pokemon("Gyarados", "Agua", 50, 42, olaGigante);
        Pokemon tangela = new Pokemon("Tangela", "Planta", 40, 48, rayoSolar);
        Pokemon raichu = new Pokemon("Raichu", "Electrico", 52, 38, chispaElectrica);
        Pokemon arcanine = new Pokemon("Arcanine", "Fuego", 53, 43, llamaradaFinal);

        Entrenador entrenador2 = new Entrenador("Misty", gyarados, tangela, raichu, arcanine);

        this.combate = new Combate(entrenador1, entrenador2);
        this.vista = new VistaCombate();
    }

    public void iniciarCombate() {
        for (int i = 1; i <= 4; i++) {
            String resumenRonda = combate.jugarRonda();
            vista.mostrarMensaje(resumenRonda);
        }

        vista.mostrarMensaje("Ganador final: " + combate.getGanadorFinal());
    }
}