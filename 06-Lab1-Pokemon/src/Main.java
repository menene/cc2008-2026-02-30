public class Main {
    public static void main(String[] args) {


        //Habilidades del entrenador 1:
        HabilidadEspecial habilidad1 = new HabilidadEspecial("Llama final", 30);
        HabilidadEspecial habilidad2 = new HabilidadEspecial("Escudo Natural", 20);
        HabilidadEspecial habilidad3 = new HabilidadEspecial("Impacto Relámpago", 30);
        HabilidadEspecial habilidad4 = new HabilidadEspecial("Llama supersónica", 40);
        
        //Habilidaddes del entrenador 2:
        HabilidadEspecial habilidad5 = new HabilidadEspecial("Escudo de Árbol", 30);
        HabilidadEspecial habilidad6 = new HabilidadEspecial("Trueno de Thor", 20);
        HabilidadEspecial habilidad7 = new HabilidadEspecial("Volcán de Fuego", 30);
        HabilidadEspecial habilidad8 = new HabilidadEspecial("Escudo Corteza", 40);



        //Pokemones del entrenador 1:
        Pokemon pokemon1 =
            new Pokemon(
                "Charmander",
                "Fuego",
                60,
                40,
                habilidad1
            );

        Pokemon pokemon2 =
            new Pokemon(
                "Squirtle",
                "Agua",
                50,
                60,
                habilidad2
            );

        Pokemon pokemon3 =
            new Pokemon(
                "Bulbasaur",
                "Planta",
                55,
                55,
                habilidad3
            );

        Pokemon pokemon4 =
            new Pokemon(
                "Pikachu",
                "Eléctrico",
                70,
                40,
                habilidad4
            );


        Entrenador entrenador1 =
            new Entrenador(
                "Alejandro Chávez - 26888",
                pokemon1,
                pokemon2,
                pokemon3,
                pokemon4
            );


        //Pokemones del entrenador 2:
        Pokemon pokemon5 =
            new Pokemon(
                "Vulpix",
                "Fuego",
                55,
                45,
                habilidad5
            );

        Pokemon pokemon6 =
            new Pokemon(
                "Psyduck",
                "Agua",
                60,
                50,
                habilidad6
            );

        Pokemon pokemon7 =
            new Pokemon(
                "Oddish",
                "Planta",
                50,
                60,
                habilidad7
            );

        Pokemon pokemon8 =
            new Pokemon(
                "Magnemite",
                "Eléctrico",
                65,
                50,
                habilidad8
            );


        Entrenador entrenador2 =
            new Entrenador(
                "Erick !-_-¡",
                pokemon5,
                pokemon6,
                pokemon7,
                pokemon8
            );


        VistaCombate vista = new VistaCombate();

        ControladorCombate controlador = new ControladorCombate(entrenador1, entrenador2, vista);

        controlador.iniciarCombate();

    }
}