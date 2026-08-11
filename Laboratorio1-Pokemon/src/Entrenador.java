import java.util.Random;
public class Entrenador {
    private String nombre;
    private Pokemon p1;
    private Pokemon p2;
    private Pokemon p3;
    private Pokemon p4;
    private int victorias;

    public Entrenador(String nombre, Pokemon p1, Pokemon p2, Pokemon p3, Pokemon p4) {
        this.nombre = nombre;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.victorias = 0;
    }

    public Pokemon SeleccionarPokemon() {
        boolean bandera = false;
        Pokemon pokemonSeleccionado = null;
        Random random = new Random();
        while (bandera == false) {
            int numeroAleatorio = random.nextInt(4)+1;
            switch (numeroAleatorio) {
                case 1:
                    if (this.p1.GetUsado() == false){
                        this.p1.SetUsado();
                        pokemonSeleccionado = this.p1;
                        bandera = true;
                    }
                    break;
                case 2:
                    if (this.p2.GetUsado() == false){
                        this.p2.SetUsado();
                        pokemonSeleccionado = this.p2;
                        bandera = true;
                    }
                    break;
                case 3:
                    if (this.p3.GetUsado() == false){
                        this.p3.SetUsado();
                        pokemonSeleccionado = this.p3;
                        bandera = true;
                    }
                    break;
                case 4:
                    if (this.p4.GetUsado() == false){
                        this.p4.SetUsado();
                        pokemonSeleccionado = this.p4;
                        bandera = true;
                    }
                    break;
                default:
                    break;
            }
        }
        return pokemonSeleccionado;
    }

    public void aumentarVictorias() {
        this.victorias += 1;
    }

    public int GetVictorias() {
        return this.victorias;
    }

    public String GetNombre() {
        return this.nombre;
    }
}