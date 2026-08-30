package view;

import java.util.Arrays;
import java.util.Scanner;
import controller.Controller;
import model.Athlete;

/* Clase de la vista. Es la unica que imprime y lee los datos del usuario. */
public class View {

    private Controller controller;
    private Scanner scanner;

    /* Constructor. Recibe el controlador y prepara el Scanner */
    public View(Controller controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    /* Muestra el menu, lee la opcion del usuario y repite hasta que elija salir */
    public void showMenu() {
        int opcion = 0;

        while (opcion != 11) {
            System.out.println("");
            System.out.println("TORNEO DE ATLETISMO UVG");
            System.out.println("1. Nuevo atleta");
            System.out.println("2. Registrar nuevo intento");
            System.out.println("3. Consultar tiempos");
            System.out.println("4. Consultar un intento");
            System.out.println("5. Modificar tiempo");
            System.out.println("6. Mostrar promedio");
            System.out.println("7. Mostrar mejor y mayor tiempo");
            System.out.println("8. Consultar intentos disponibles");
            System.out.println("9. Resultados del torneo");
            System.out.println("10. Ganador del torneo");
            System.out.println("11. Salir");

            opcion = readInt("Opcion: ");

            if (opcion == 1) {
                registerAthlete();

            } else if (opcion == 2) {
                registerAttempt();

            } else if (opcion == 3) {
                /* 3. Consultar tiempos. Recorre solo las posiciones usadas del arreglo */
                Athlete atleta = controller.getActiveAthlete();

                if (atleta == null) {
                    System.out.println("Primero debe registrar un atleta");
                } else {
                    int[] tiempos = atleta.getAttemptTimes();

                    if (tiempos.length == 0) {
                        System.out.println("El atleta todavia no tiene intentos registrados");
                    } else {
                        System.out.println("Tiempos de " + atleta.getName());

                        for (int i = 0; i < tiempos.length; i++) {
                            System.out.println("  Intento " + (i + 1) + ": " + tiempos[i] + " segundos");
                        }

                        System.out.println("Arreglo de tiempos: " + Arrays.toString(tiempos));
                    }
                }

            } else if (opcion == 4) {
                /* 4. Consultar un intento. Pide el numero y busca ese tiempo en el arreglo */
                Athlete atleta = controller.getActiveAthlete();

                if (atleta == null) {
                    System.out.println("Primero debe registrar un atleta");
                } else {
                    int numeroIntento = readInt("Numero de intento a consultar: ");

                    if (numeroIntento < 1) {
                        System.out.println("Debe ingresar un numero mayor que 0");
                    } else {
                        int tiempo = atleta.getAttemptTime(numeroIntento);

                        if (tiempo == -1) {
                            System.out.println("Ese intento todavia no ha sido registrado");
                        } else {
                            System.out.println("El intento " + numeroIntento + " tiene " + tiempo + " segundos");
                        }
                    }
                }

            } else if (opcion == 5) {
                modifyAttempt();

            } else if (opcion == 6) {
                /* 6. Mostrar promedio. Usa casting para pasar el promedio a entero */
                Athlete atleta = controller.getActiveAthlete();

                if (atleta == null) {
                    System.out.println("Primero debe registrar un atleta");
                } else if (atleta.getAttemptsCounter() == 0) {
                    System.out.println("El atleta todavia no tiene intentos registrados");
                } else {
                    double promedio = atleta.getAverageTime();
                    int promedioEntero = (int) promedio;

                    System.out.println("Promedio de " + atleta.getName() + ": " + promedio + " segundos");
                    System.out.println("Promedio en segundos enteros: " + promedioEntero);
                }

            } else if (opcion == 7) {
                /* 7. Mostrar mejor y mayor tiempo */
                Athlete atleta = controller.getActiveAthlete();

                if (atleta == null) {
                    System.out.println("Primero debe registrar un atleta");
                } else {
                    int mejorTiempo = atleta.getBestTime();
                    int tiempoMasAlto = atleta.getHighestTime();

                    if (mejorTiempo == -1) {
                        System.out.println("El atleta todavia no tiene intentos registrados");
                    } else {
                        System.out.println("Mejor tiempo: " + mejorTiempo + " segundos");
                        System.out.println("Tiempo mas alto: " + tiempoMasAlto + " segundos");
                    }
                }

            } else if (opcion == 8) {
                /* 8. Consultar intentos disponibles */
                Athlete atleta = controller.getActiveAthlete();

                if (atleta == null) {
                    System.out.println("Primero debe registrar un atleta");
                } else {
                    System.out.println("Intentos registrados: " + atleta.getAttemptsCounter());
                    System.out.println("Intentos disponibles: " + atleta.getAvailableAttempts() + " de 10");
                }

            } else if (opcion == 9) {
                showAllAthletes();

            } else if (opcion == 10) {
                showWinner();

            } else if (opcion == 11) {
                System.out.println("Adios");

            } else {
                System.out.println("Opcion invalida");
            }
        }

        scanner.close();
    }

    /* 1. Pide los datos, crea el atleta y lo manda al controlador */
    public void registerAthlete() {
        if (controller.hasSpace() == false) {
            System.out.println("Ya no hay espacio, el torneo solo permite 5 atletas");
            return;
        }

        String nombre = readText("Nombre del atleta: ");

        if (nombre.length() == 0) {
            System.out.println("El nombre no puede quedar vacio");
            return;
        }

        int numero = readInt("Numero de participante: ");

        if (numero <= 0) {
            System.out.println("El numero de participante debe ser un numero mayor que 0");
            return;
        }

        int edad = readInt("Edad: ");

        if (edad <= 0) {
            System.out.println("La edad debe ser un numero mayor que 0");
            return;
        }

        if (controller.getAthlete(numero) != null) {
            System.out.println("Ya existe un atleta con ese numero");
            return;
        }

        Athlete atleta = new Athlete(nombre, numero, edad);
        controller.addAthlete(atleta);

        System.out.println("Atleta registrado, ahora es el atleta activo");
    }

    /* 2. Pide el tiempo y lo guarda en el arreglo del atleta activo */
    public void registerAttempt() {
        Athlete atleta = controller.getActiveAthlete();

        if (atleta == null) {
            System.out.println("Primero debe registrar un atleta");
            return;
        }

        if (atleta.getAvailableAttempts() == 0) {
            System.out.println("El atleta ya uso sus 10 intentos");
            return;
        }

        int tiempo = readInt("Tiempo obtenido en segundos: ");

        if (tiempo <= 0) {
            System.out.println("El tiempo debe ser un numero mayor que 0");
            return;
        }

        atleta.addAttempt(tiempo);

        System.out.println("Intento " + atleta.getAttemptsCounter() + " registrado con " + tiempo + " segundos");
    }

    /* 5. Cambia el tiempo de un intento que ya estaba registrado */
    public void modifyAttempt() {
        Athlete atleta = controller.getActiveAthlete();

        if (atleta == null) {
            System.out.println("Primero debe registrar un atleta");
            return;
        }

        if (atleta.getAttemptsCounter() == 0) {
            System.out.println("El atleta todavia no tiene intentos registrados");
            return;
        }

        int numeroIntento = readInt("Numero de intento a modificar: ");

        if (numeroIntento < 1 || numeroIntento > atleta.getAttemptsCounter()) {
            System.out.println("Ese intento todavia no ha sido registrado");
            return;
        }

        int tiempoNuevo = readInt("Nuevo tiempo en segundos: ");

        if (tiempoNuevo <= 0) {
            System.out.println("El tiempo debe ser un numero mayor que 0");
            return;
        }

        int tiempoAnterior = atleta.getAttemptTime(numeroIntento);
        atleta.changeAttemptTime(tiempoNuevo, numeroIntento);

        System.out.println("El intento " + numeroIntento + " cambio de " + tiempoAnterior + " a " + tiempoNuevo + " segundos");
    }

    /* 9. Muestra el listado de todos los atletas del torneo */
    public void showAllAthletes() {
        System.out.println(controller.getResults());
    }

    /* 10. Muestra el atleta con el mejor tiempo del torneo */
    public void showWinner() {
        Athlete ganador = controller.getWinner();

        if (ganador == null) {
            System.out.println("Todavia no hay tiempos registrados en el torneo");
            return;
        }

        System.out.println("Ganador: " + ganador.getName() + " con " + ganador.getBestTime() + " segundos");
    }

    /* Lee un texto y le quita los espacios de los extremos */
    private String readText(String mensaje) {
        System.out.print(mensaje);
        String texto = scanner.nextLine();
        return texto.trim();
    }

    /* Lee un numero entero. Devuelve -1 si el usuario no escribe un numero valido */
    private int readInt(String mensaje) {
        System.out.print(mensaje);
        String texto = scanner.nextLine();
        texto = texto.trim();

        /* Revisa letra por letra que lo escrito sea solo numeros */
        boolean esNumero = true;

        if (texto.length() == 0 || texto.length() > 9) {
            esNumero = false;
        }

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (caracter < '0' || caracter > '9') {
                esNumero = false;
            }
        }

        if (esNumero == false) {
            return -1;
        }

        return Integer.parseInt(texto);
    }
}
