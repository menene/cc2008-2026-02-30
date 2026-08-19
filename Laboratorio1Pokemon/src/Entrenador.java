import java.util.ArrayList;
import java.util.Random;
public class Entrenador{
    private String nombre;
    private ArrayList<Pokemon> equipo;

    public Entrenador(String nombre){
        this.nombre = nombre;
        //lista vacia pokemones pq asi los tenemos random de la lista que hice en Main 
        this.equipo = new ArrayList<Pokemon>();
    }

    public void seleccionarEquipo(ArrayList<Pokemon> Pokemones){
        Random random = new Random();
        while (equipo.size() < 4){
            int position = random.nextInt(Pokemones.size());
            Pokemon pokemonSeleccionado = Pokemones.get(position);

            equipo.add(pokemonSeleccionado);
            //hace que se elimine el pokemon y asi no se repite de que en el otro equipo
            Pokemones.remove(position);
        }
    }
    public ArrayList<Pokemon> getEquipo() {
    return equipo;
    }

    public String getNombre() {
        return nombre;
    }

}