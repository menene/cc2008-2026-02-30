public class Controlador {

    private Combate combate;
    private Vista vista;


    //constructor controlador
    public Controlador() {
        this.vista = new Vista();
    }


    //crear todo lo necesario para el combate
    private void crearCombate() {

        //habilidades para los pokemon del entrenador 1
        HabilidadEspecial habilidad1 = new HabilidadEspecial("Llama Final", 30);
        HabilidadEspecial habilidad2 = new HabilidadEspecial("Escudo Natural", 40);
        HabilidadEspecial habilidad3 = new HabilidadEspecial("Impacto Relampago", 20);
        HabilidadEspecial habilidad4 = new HabilidadEspecial("Escudo Natural", 40);

        //pokemon del entrenador 1
        Pokemon pokemon1 = new Pokemon("Charmander", "Fuego", 40, 35, habilidad1);
        Pokemon pokemon2 = new Pokemon("Squirtle", "Agua", 35, 45, habilidad2);
        Pokemon pokemon3 = new Pokemon("Bulbasaur", "Planta", 38, 40, habilidad3);
        Pokemon pokemon4 = new Pokemon("Pikachu", "Electrico", 45, 30, habilidad4);


        //habilidades para los pokemon del entrenador 2
        HabilidadEspecial habilidad5 = new HabilidadEspecial("Llama Final", 30);
        HabilidadEspecial habilidad6 = new HabilidadEspecial("Escudo Natural", 40);
        HabilidadEspecial habilidad7 = new HabilidadEspecial("Impacto Relampago", 20);
        HabilidadEspecial habilidad8 = new HabilidadEspecial("Llama Final", 30);

        //pokemon del entrenador 2
        Pokemon pokemon5 = new Pokemon("Vulpix", "Fuego", 42, 34, habilidad5);
        Pokemon pokemon6 = new Pokemon("Psyduck", "Agua", 37, 42, habilidad6);
        Pokemon pokemon7 = new Pokemon("Oddish", "Planta", 39, 38, habilidad7);
        Pokemon pokemon8 = new Pokemon("Voltorb", "Electrico", 44, 32, habilidad8);


        //crear los 2 entrenadores con sus 4 pokemon
        Entrenador entrenador1 = new Entrenador(
            "Entrenador 1",
            pokemon1,
            pokemon2,
            pokemon3,
            pokemon4
        );

        Entrenador entrenador2 = new Entrenador(
            "Entrenador 2",
            pokemon5,
            pokemon6,
            pokemon7,
            pokemon8
        );


        //crear el combate con los 2 entrenadores
        this.combate = new Combate(entrenador1, entrenador2);
    }


    //iniciar el programa
    public void iniciar() {

        //primero crear el combate
        crearCombate();

        //mostrar que empieza el combate
        vista.mostrarInicioCombate("Entrenador 1", "Entrenador 2");

        //ejecutar y mostrar las 4 rondas
        for (int i = 0; i < 4; i++) {
            String resultado = combate.ejecutarRonda();
            vista.mostrarResultadoRonda(resultado);
        }

        //mostrar el resultado final
        vista.mostrarResultadoFinal(combate.determinarGanador());
    }
}