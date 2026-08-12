import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        // Habilidades de cada pokémon

        HabilidadEspecial habilidad1 =
            new HabilidadEspecial("Llama Final", 30);

        HabilidadEspecial habilidad2 =
            new HabilidadEspecial("Furia Ardiente", 35);

        HabilidadEspecial habilidad3 =
            new HabilidadEspecial("Escudo Natural", 40);

        HabilidadEspecial habilidad4 =
            new HabilidadEspecial("Torrente", 30);

        HabilidadEspecial habilidad5 =
            new HabilidadEspecial("Poder Natural", 35);

        HabilidadEspecial habilidad6 =
            new HabilidadEspecial("Raiz Fuerte", 40);

        HabilidadEspecial habilidad7 =
            new HabilidadEspecial("Impacto Relampago", 20);

        HabilidadEspecial habilidad8 =
            new HabilidadEspecial("Carga Electrica", 30);


        // Se crean los 8 pokemones que se le pueden asignar a los entrenadores de manera aleatoria

        Pokemon pokemon1 = new Pokemon(
            "Charizard", "Fuego", 48, 42, habilidad1
        );

        Pokemon pokemon2 = new Pokemon(
            "Moltres", "Fuego", 50, 40, habilidad2
        );

        Pokemon pokemon3 = new Pokemon(
            "Blastoise", "Agua", 42, 50, habilidad3
        );

        Pokemon pokemon4 = new Pokemon(
            "Gyarados", "Agua", 50, 40, habilidad4
        );

        Pokemon pokemon5 = new Pokemon(
            "Venusaur", "Planta", 44, 46, habilidad5
        );

        Pokemon pokemon6 = new Pokemon(
            "Vileplume", "Planta", 46, 44, habilidad6
        );

        Pokemon pokemon7 = new Pokemon(
            "Pikachu", "Electrico", 50, 35, habilidad7
        );

        Pokemon pokemon8 = new Pokemon(
            "Zapdos", "Electrico", 48, 42, habilidad8
        );


        // Realiza la seleccion de los 4 pokemones de cada entrenador de manera aleatoria

        Pokemon e1Pokemon1 = null;
        Pokemon e1Pokemon2 = null;
        Pokemon e1Pokemon3 = null;
        Pokemon e1Pokemon4 = null;

        Pokemon e2Pokemon1 = null;
        Pokemon e2Pokemon2 = null;
        Pokemon e2Pokemon3 = null;
        Pokemon e2Pokemon4 = null;

        boolean usado1 = false;
        boolean usado2 = false;
        boolean usado3 = false;
        boolean usado4 = false;
        boolean usado5 = false;
        boolean usado6 = false;
        boolean usado7 = false;
        boolean usado8 = false;


        // Seleccion de los 4 Pokemon del Entrenador 1

        int seleccionados = 0;

        while (seleccionados < 4) {

            int numero = random.nextInt(8) + 1;

            Pokemon seleccionado = null;

            if (numero == 1 && !usado1) {
                seleccionado = pokemon1;
                usado1 = true;
            } else if (numero == 2 && !usado2) {
                seleccionado = pokemon2;
                usado2 = true;
            } else if (numero == 3 && !usado3) {
                seleccionado = pokemon3;
                usado3 = true;
            } else if (numero == 4 && !usado4) {
                seleccionado = pokemon4;
                usado4 = true;
            } else if (numero == 5 && !usado5) {
                seleccionado = pokemon5;
                usado5 = true;
            } else if (numero == 6 && !usado6) {
                seleccionado = pokemon6;
                usado6 = true;
            } else if (numero == 7 && !usado7) {
                seleccionado = pokemon7;
                usado7 = true;
            } else if (numero == 8 && !usado8) {
                seleccionado = pokemon8;
                usado8 = true;
            }


            if (seleccionado != null) {

                seleccionados++;

                if (seleccionados == 1) {
                    e1Pokemon1 = seleccionado;
                } else if (seleccionados == 2) {
                    e1Pokemon2 = seleccionado;
                } else if (seleccionados == 3) {
                    e1Pokemon3 = seleccionado;
                } else if (seleccionados == 4) {
                    e1Pokemon4 = seleccionado;
                }
            }
        }



        // Los demas pokemones que no fueron seleccionados para el entrenador 1 se asignan al entrenador 2

        int posicionE2 = 1;

        if (!usado1) {
            e2Pokemon1 = pokemon1;
            posicionE2++;
        }

        if (!usado2) {
            if (posicionE2 == 1) {
                e2Pokemon1 = pokemon2;
            } else if (posicionE2 == 2) {
                e2Pokemon2 = pokemon2;
            } else if (posicionE2 == 3) {
                e2Pokemon3 = pokemon2;
            } else {
                e2Pokemon4 = pokemon2;
            }

            posicionE2++;
        }

        if (!usado3) {
            if (posicionE2 == 1) {
                e2Pokemon1 = pokemon3;
            } else if (posicionE2 == 2) {
                e2Pokemon2 = pokemon3;
            } else if (posicionE2 == 3) {
                e2Pokemon3 = pokemon3;
            } else {
                e2Pokemon4 = pokemon3;
            }

            posicionE2++;
        }

        if (!usado4) {
            if (posicionE2 == 1) {
                e2Pokemon1 = pokemon4;
            } else if (posicionE2 == 2) {
                e2Pokemon2 = pokemon4;
            } else if (posicionE2 == 3) {
                e2Pokemon3 = pokemon4;
            } else {
                e2Pokemon4 = pokemon4;
            }

            posicionE2++;
        }

        if (!usado5) {
            if (posicionE2 == 1) {
                e2Pokemon1 = pokemon5;
            } else if (posicionE2 == 2) {
                e2Pokemon2 = pokemon5;
            } else if (posicionE2 == 3) {
                e2Pokemon3 = pokemon5;
            } else {
                e2Pokemon4 = pokemon5;
            }

            posicionE2++;
        }

        if (!usado6) {
            if (posicionE2 == 1) {
                e2Pokemon1 = pokemon6;
            } else if (posicionE2 == 2) {
                e2Pokemon2 = pokemon6;
            } else if (posicionE2 == 3) {
                e2Pokemon3 = pokemon6;
            } else {
                e2Pokemon4 = pokemon6;
            }

            posicionE2++;
        }

        if (!usado7) {
            if (posicionE2 == 1) {
                e2Pokemon1 = pokemon7;
            } else if (posicionE2 == 2) {
                e2Pokemon2 = pokemon7;
            } else if (posicionE2 == 3) {
                e2Pokemon3 = pokemon7;
            } else {
                e2Pokemon4 = pokemon7;
            }

            posicionE2++;
        }

        if (!usado8) {
            if (posicionE2 == 1) {
                e2Pokemon1 = pokemon8;
            } else if (posicionE2 == 2) {
                e2Pokemon2 = pokemon8;
            } else if (posicionE2 == 3) {
                e2Pokemon3 = pokemon8;
            } else {
                e2Pokemon4 = pokemon8;
            }
        }


        // Se crea cada entrenador con su respectivo nombre y los 4 pokemones seleccionados de manera aleatoria

        Entrenador entrenador1 = new Entrenador(
            "Entrenador 1",
            e1Pokemon1,
            e1Pokemon2,
            e1Pokemon3,
            e1Pokemon4
        );

        Entrenador entrenador2 = new Entrenador(
            "Entrenador 2",
            e2Pokemon1,
            e2Pokemon2,
            e2Pokemon3,
            e2Pokemon4
        );


        // Se crea el combate con los dos entrenadores

        Combate combate = new Combate(
            entrenador1,
            entrenador2
        );


        // Iniciador del combate

        ControladorCombate controlador =
            new ControladorCombate();

        controlador.iniciarCombate(combate);
    }
}