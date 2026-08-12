public class Main {

    public static void main(String[] args) {


        Pokemon charmander = new Pokemon("Charmander", "Fuego", 45, 39,
                new HabilidadEspecial("Llama Final", 30));
        Pokemon squirtle = new Pokemon("Squirtle", "Agua", 48, 65,
                new HabilidadEspecial("Escudo Natural", 40));
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Planta", 49, 49,
                new HabilidadEspecial("Latigo Cepa", 25));
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 55, 40,
                new HabilidadEspecial("Impacto Relámpago", 20));

        Pokemon[] pokemonesAsh = {charmander, squirtle, bulbasaur, pikachu};
        Entrenador ash = new Entrenador("Ash", pokemonesAsh);


        Pokemon vulpix = new Pokemon("Vulpix", "Fuego", 41, 40,
                new HabilidadEspecial("Ascuas", 35));
        Pokemon staryu = new Pokemon("Staryu", "Agua", 45, 55,
                new HabilidadEspecial("Hidrobomba", 30));
        Pokemon oddish = new Pokemon("Oddish", "Planta", 50, 45,
                new HabilidadEspecial("Somnifero", 20));
        Pokemon voltorb = new Pokemon("Voltorb", "Eléctrico", 30, 33,
                new HabilidadEspecial("Chispazo", 45));

        Pokemon[] pokemonesMisty = {vulpix, staryu, oddish, voltorb};
        Entrenador misty = new Entrenador("Misty", pokemonesMisty);


        Batalla batalla = new Batalla(ash, misty);
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, batalla);

        controlador.iniciarJuego();
    }
}