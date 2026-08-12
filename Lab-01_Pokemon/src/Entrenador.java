import  java.util.Random;

public class Entrenador {

    private String nombre;
    private Pokemon[] pokemones;
    private boolean[] usados;

    public Entrenador(String nombre, Pokemon[] pokemones){

        this.nombre = nombre;
        this.pokemones = pokemones;
        this.usados = new boolean[4];
    }

    public String getNombre(){

        return nombre;
    }

    public Pokemon[] getPokemones(){

        return pokemones;
    }

    public Pokemon seleccionarPokemon(){

        Random random = new Random();
        int disponibles = 0;

        for (int i = 0; i < usados.length; i++){

            if(!usados[i]) {
                disponibles++;
            }
        }

        int elegido = random.nextInt(disponibles);
        int contador = 0;

        for(int i = 0; i < usados.length; i++){

            if(!usados[i]) {

                if (contador == elegido){

                    usados[i] = true;
                    return pokemones[i];
                }

                contador++;
            }
        }

        return null;


    }
}