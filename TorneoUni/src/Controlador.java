import java.util.Scanner;

public class Controlador {

    private Atleta atleta;
    private int max_Intentos;

    public Controlador() {
        this.atleta = null;
        this.max_Intentos = 10;
    }

    public void iniciar() {
        Scanner teclado = new Scanner(System.in);
        VistaResultados vista = new VistaResultados();

        int opcion = 0;

        while (opcion != 9) {
            mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine(); // limpia el salto de línea que deja nextInt()

            if (opcion == 1) {
                System.out.print("Nombre del atleta: ");
                String nombre = teclado.nextLine();
                System.out.print("Número de participante: ");
                int numParticipante = teclado.nextInt();
                System.out.print("Edad: ");
                int edad = teclado.nextInt();
                teclado.nextLine();

                registrarAtleta(nombre, numParticipante, edad);
                vista.mostrarMensaje("Atleta registrado con éxito. Empieza sin intentos.");

            } else if (opcion == 2) {
                if (!hayAtletaActivo()) {
                    vista.mostrarMensaje("Primero debes registrar un atleta.");
                } else {
                    System.out.print("Tiempo obtenido (segundos): ");
                    double tiempo = teclado.nextDouble();
                    boolean exito = registrarIntento(tiempo);
                    if (exito) {
                        vista.mostrarMensaje("Intento registrado correctamente.");
                    } else {
                        vista.mostrarMensaje("No se pudo registrar: el tiempo debe ser mayor que 0 o ya no hay espacio disponible.");
                    }
                }

            } else if (opcion == 3) {
                if (!hayAtletaActivo()) {
                    vista.mostrarMensaje("Primero debes registrar un atleta.");
                } else {
                    vista.mostrarTiempos(obtenerTiempos());
                }

            } else if (opcion == 4) {
                if (!hayAtletaActivo()) {
                    vista.mostrarMensaje("Primero debes registrar un atleta.");
                } else {
                    System.out.print("Número de intento a consultar: ");
                    int numIntento = teclado.nextInt();
                    double tiempo = consultarIntento(numIntento);
                    if (tiempo == -1) {
                        vista.mostrarMensaje("Ese intento todavía no ha sido registrado.");
                    } else {
                        vista.mostrarMensaje("Intento " + numIntento + ": " + tiempo + " s");
                    }
                }

            } else if (opcion == 5) {
                if (!hayAtletaActivo()) {
                    vista.mostrarMensaje("Primero debes registrar un atleta.");
                } else {
                    System.out.print("Número de intento a modificar: ");
                    int numIntento = teclado.nextInt();
                    System.out.print("Nuevo tiempo (segundos): ");
                    double nuevoTiempo = teclado.nextDouble();
                    boolean exito = modificarIntento(numIntento, nuevoTiempo);
                    if (exito) {
                        vista.mostrarMensaje("Tiempo modificado con éxito.");
                    } else {
                        vista.mostrarMensaje("No se pudo modificar: revisa que el intento exista y que el tiempo sea mayor que 0.");
                    }
                }

            } else if (opcion == 6) {
                if (!hayAtletaActivo()) {
                    vista.mostrarMensaje("Primero debes registrar un atleta.");
                } else {
                    double[] resumen = obtenerResumen();
                    vista.mostrarMensaje("Promedio: " + resumen[0] + " s");
                }

            } else if (opcion == 7) {
                if (!hayAtletaActivo()) {
                    vista.mostrarMensaje("Primero debes registrar un atleta.");
                } else {
                    double[] resumen = obtenerResumen();
                    vista.mostrarMensaje("Mejor tiempo: " + resumen[1] + " s");
                    vista.mostrarMensaje("Peor tiempo: " + resumen[2] + " s");
                }

            } else if (opcion == 8) {
                if (!hayAtletaActivo()) {
                    vista.mostrarMensaje("Primero debes registrar un atleta.");
                } else {
                    double[] resumen = obtenerResumen();
                    vista.mostrarMensaje("Intentos registrados: " + obtenerIntentosRegistrados());
                    vista.mostrarMensaje("Intentos disponibles: " + (int) resumen[3]);
                }

            } else if (opcion == 9) {
                vista.mostrarMensaje("Gracias por usar el sistema. ¡Hasta pronto!");

            } else {
                vista.mostrarMensaje("Opción no válida, intenta de nuevo.");
            }
        }

        teclado.close();
    }

    // Reemplaza al atleta activo por uno nuevo, sin intentos previos
    public void registrarAtleta(String nombre, int numParticipante, int edad) {
        this.atleta = new Atleta(nombre, numParticipante, edad);
    }

    public boolean registrarIntento(double tiempo) {
        if (atleta == null) {
            return false;
        }
        return atleta.registrarTiempo(tiempo);
    }

    public boolean modificarIntento(int numIntento, double nuevoTiempo) {
        if (atleta == null) {
            return false;
        }
        return atleta.modificarTiempo(numIntento, nuevoTiempo);
    }

    public double consultarIntento(int numIntento) {
        if (atleta == null) {
            return -1;
        }
        return atleta.consultarTiempo(numIntento);
    }

    // Promedio, el mejor tiempo, el peor tiempo y los espacios disponibles
    public double[] obtenerResumen() {
        double[] resumen = new double[4];
        if (atleta == null) {
            return resumen;
        }
        resumen[0] = atleta.calcularPromedio();
        resumen[1] = atleta.obtenerMejorTiempo();
        resumen[2] = atleta.obtenerPeorTiempo();
        resumen[3] = atleta.espaciosDisponibles();
        return resumen;
    }

    // Método de apoyo para saber si ya hay un atleta cargado
    public boolean hayAtletaActivo() {
        return atleta != null;
    }

    // Método de apoyo para que la Vista pueda imprimir los tiempos
    public double[] obtenerTiempos() {
        if (atleta == null) {
            return new double[0];
        }
        return atleta.consultarTiempos();
    }

    public int obtenerIntentosRegistrados() {
        if (atleta == null) {
            return 0;
        }
        return atleta.getIntentosRegistrados();
    }

    public void mostrarMenu() {
        System.out.println("\n===== Torneo de Atletismo UVG =====");
        System.out.println("1. Nuevo atleta");
        System.out.println("2. Registrar nuevo intento");
        System.out.println("3. Consultar tiempos");
        System.out.println("4. Consultar un intento");
        System.out.println("5. Modificar tiempo");
        System.out.println("6. Mostrar promedio");
        System.out.println("7. Mostrar mejor y mayor tiempo");
        System.out.println("8. Consultar intentos disponibles");
        System.out.println("9. Salir");
        System.out.print("Elige una opción: ");
    }
}