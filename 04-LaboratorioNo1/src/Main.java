import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Entrenador[] entrenadores = new Entrenador[2];

        System.out.println("=================================");
        System.out.println("        LIGA ELEMENTAL");
        System.out.println("=================================");
        System.out.println();

        // Se crean los dos entrenadores
        for (int jugador = 0; jugador < 2; jugador++) {

            System.out.println("========== JUGADOR " + (jugador + 1) + " ==========");
            System.out.print("Ingrese el nombre del entrenador: ");
            String nombreEntrenador = scanner.nextLine();

            Pokemon[] equipo = new Pokemon[4];

            // Se crean los 4 Pokemon de cada entrenador
            for (int i = 0; i < 4; i++) {

                System.out.println();
                System.out.println("--- Pokemon " + (i + 1) + " ---");

                String nombrePokemon;
                boolean nombreRepetido;

                // Evita nombres repetidos dentro del mismo equipo
                do {
                    nombreRepetido = false;

                    System.out.print("Nombre del Pokemon: ");
                    nombrePokemon = scanner.nextLine();

                    for (int j = 0; j < i; j++) {
                        if (equipo[j].getNombre().equalsIgnoreCase(nombrePokemon)) {
                            nombreRepetido = true;
                        }
                    }

                    if (nombreRepetido) {
                        System.out.println(
                                "Ya existe un Pokemon con ese nombre. Elija otro."
                        );
                    }

                } while (nombreRepetido);

                // Seleccion del tipo
                int opcionTipo;

                do {
                    System.out.println();
                    System.out.println("Seleccione el tipo:");
                    System.out.println("1. Fuego");
                    System.out.println("2. Agua");
                    System.out.println("3. Planta");
                    System.out.println("4. Electrico");
                    System.out.print("Opcion: ");

                    opcionTipo = scanner.nextInt();
                    scanner.nextLine();

                    if (opcionTipo < 1 || opcionTipo > 4) {
                        System.out.println("Opcion invalida.");
                    }

                } while (opcionTipo < 1 || opcionTipo > 4);

                String tipo = "";

                switch (opcionTipo) {

                    case 1:
                        tipo = "Fuego";
                        break;

                    case 2:
                        tipo = "Agua";
                        break;

                    case 3:
                        tipo = "Planta";
                        break;

                    case 4:
                        tipo = "Electrico";
                        break;
                }

                // Nombre personalizado de la habilidad
                System.out.print("Nombre de la habilidad especial: ");
                String nombreHabilidad = scanner.nextLine();

                // Estadisticas aleatorias
                int ataque = 40 + random.nextInt(31);
                int defensa = 40 + random.nextInt(31);

                // Probabilidad aleatoria entre 20% y 40%
                int probabilidad = 20 + random.nextInt(21);

                // Crear habilidad
                HabilidadEspecial habilidad =
                        new HabilidadEspecial(
                                nombreHabilidad,
                                probabilidad
                        );

                // Crear Pokemon
                Pokemon pokemon =
                        new Pokemon(
                                nombrePokemon,
                                tipo,
                                ataque,
                                defensa,
                                habilidad
                        );

                equipo[i] = pokemon;

                // Mostrar estadisticas generadas
                System.out.println();
                System.out.println("Pokemon creado:");
                System.out.println("Nombre: " + nombrePokemon);
                System.out.println("Tipo: " + tipo);
                System.out.println("Ataque: " + ataque);
                System.out.println("Defensa: " + defensa);
                System.out.println(
                        "Habilidad: " + nombreHabilidad
                );
                System.out.println(
                        "Probabilidad de activacion: "
                        + probabilidad
                        + "%"
                );
            }

            // Crear entrenador con sus 4 Pokemon
            entrenadores[jugador] =
                    new Entrenador(
                            nombreEntrenador,
                            equipo
                    );

            System.out.println();
        }

        // Crear la vista
        VistaBatalla vista =
                new VistaBatalla();

        // Crear el controlador
        ControladorBatalla controlador =
                new ControladorBatalla(
                        entrenadores[0],
                        entrenadores[1],
                        vista
                );

        System.out.println();
        System.out.println("=================================");
        System.out.println("        INICIA LA BATALLA");
        System.out.println("=================================");
        System.out.println();

        // Iniciar combate
        controlador.iniciarBatalla();

        scanner.close();
    }
}