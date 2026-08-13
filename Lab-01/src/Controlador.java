import java.util.ArrayList;
import java.util.Random;

public class Controlador {
    private Vista vista;
    private Pelea pelea;

    public Controlador(Vista vista) {
        this.vista = vista;
    }

    public void iniciar() {

        vista.mostrarMensaje("========== LIGA ELEMENTAL ==========");

        crearEntrenadores();

        ejecutarPelea();
    }

     private void crearEntrenadores() {
        Random random = new Random();
        // Habilidades especiales

        HabilidadEspecial llamaFinal = new HabilidadEspecial("Llama Final", 30);

        HabilidadEspecial escudoNatural = new HabilidadEspecial("Escudo Natural", 40);

        HabilidadEspecial impactoRelampago = new HabilidadEspecial("Impacto Relampago", 20);

        HabilidadEspecial furiaElemental = new HabilidadEspecial("Furia Elemental", 35);

        HabilidadEspecial poderAncestral = new HabilidadEspecial("Poder Ancestral", 25);

        HabilidadEspecial instintoSalvaje = new HabilidadEspecial("Instinto Salvaje", 45);

        HabilidadEspecial energiaSuprema = new HabilidadEspecial("Energia Suprema", 15);

        HabilidadEspecial fuerzaOculta = new HabilidadEspecial("Fuerza Oculta", 50);

        // Pokemones disponibles (12)
        ArrayList<Pokemon> disponibles = new ArrayList<>();

        // tipo fuego
        disponibles.add(new Pokemon("Charmander", "Fuego", 40, 30, llamaFinal));
        disponibles.add(new Pokemon("Vulpix", "Fuego", 37, 35, furiaElemental));
        disponibles.add(new Pokemon("Growlithe", "Fuego", 43, 32, instintoSalvaje));

        // tipo agua
        disponibles.add(new Pokemon("Squirtle", "Agua", 35, 45, escudoNatural));
        disponibles.add(new Pokemon("Psyduck", "Agua", 40, 36, poderAncestral));
        disponibles.add(new Pokemon("Poliwag", "Agua", 38, 38, fuerzaOculta));

        // tipo planta
        disponibles.add(new Pokemon("Bulbasaur", "Planta", 38, 42, poderAncestral));
        disponibles.add(new Pokemon("Chikorita", "Planta", 35, 45, escudoNatural));
        disponibles.add(new Pokemon("Bellsprout", "Planta", 44, 30, instintoSalvaje));

        // tipo electrico
        disponibles.add(new Pokemon("Pikachu", "Electrico", 45, 30, impactoRelampago));
        disponibles.add(new Pokemon("Voltorb", "Electrico", 42, 35, energiaSuprema));
        disponibles.add(new Pokemon("Magnemite", "Electrico", 36, 44, fuerzaOculta));

        //equipos
        ArrayList<Pokemon> pokemones1 = new ArrayList<>();

        ArrayList<Pokemon> pokemones2 = new ArrayList<>();

        // 4 para cada jugador
        for (int i = 0; i < 4; i++) {
            int indice = random.nextInt(disponibles.size());
            Pokemon seleccionado = disponibles.remove(indice);
            pokemones1.add(seleccionado);
        }
        
        for (int i = 0; i < 4; i++) {
            int indice = random.nextInt(disponibles.size());
            Pokemon seleccionado = disponibles.remove(indice);
            pokemones2.add(seleccionado);
        }

        // Entrenadores 
        Entrenador entrenador1 = new Entrenador("Jugador 1", pokemones1);
        Entrenador entrenador2 = new Entrenador("Jugador 2", pokemones2);

        vista.mostrarEquipo(entrenador1);
        vista.mostrarEquipo(entrenador2);

        pelea = new Pelea(entrenador1, entrenador2);
    }

    private void ejecutarPelea() {
            for (int i = 0; i < 4; i++) {
                String resultadoRonda = pelea.ejecutarRonda();
                vista.mostrarResultadosRonda(resultadoRonda);
            }

            String resultadoFinal = pelea.determinarGanador();
            vista.mostrarResultadoFinal(resultadoFinal);
        
    }

}