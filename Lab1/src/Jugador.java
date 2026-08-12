import java.util.Random;

public class Jugador {
    private String nombre;
    private Pokemon p1;
    private Pokemon p2;
    private Pokemon p3;
    private Pokemon p4;
    private int rondasGanadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        rondasGanadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon getP1() {
        return p1;
    }

    public Pokemon getP2() {
        return p2;
    }

    public Pokemon getP3() {
        return p3;
    }

    public Pokemon getP4() {
        return p4;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public void setRondasGanadas(int rondasGanadas) {
        this.rondasGanadas = rondasGanadas;
    }

    public void asignarPokemon(int posicion, Pokemon pokemon) {
        if (posicion == 1) {
            p1 = pokemon;
        } else if (posicion == 2) {
            p2 = pokemon;
        } else if (posicion == 3) {
            p3 = pokemon;
        } else if (posicion == 4) {
            p4 = pokemon;
        }
    }

    public Pokemon seleccionarPokemon() {
        Random random = new Random();

        while (true) {
            int numero = random.nextInt(4) + 1;

            if (numero == 1 && !p1.haPeleado()) {
                p1.setHaPeleado(true);
                return p1;
            } else if (numero == 2 && !p2.haPeleado()) {
                p2.setHaPeleado(true);
                return p2;
            } else if (numero == 3 && !p3.haPeleado()) {
                p3.setHaPeleado(true);
                return p3;
            } else if (numero == 4 && !p4.haPeleado()) {
                p4.setHaPeleado(true);
                return p4;
            }
        }
    }
}
