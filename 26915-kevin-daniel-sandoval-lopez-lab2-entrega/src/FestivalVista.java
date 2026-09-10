import java.util.InputMismatchException;
import java.util.Scanner;

public class FestivalVista {

    private Festival festivalActual;
    private Scanner scanner;

    public FestivalVista() {
        this.scanner = new Scanner(System.in);
        this.festivalActual = null;
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");

//todas las opciones que pueden seleccionarse en el menú
            switch (opcion) {
                case 1:
                    NuevoFestival();
                    break;
                case 2:
                    ConfigurarEscenario();
                    break;
                case 3:
                    if (festivalActual == null) {
                        System.out.println("Debe crear un festival primero.");
                    } else {
                        System.out.println(festivalActual.consultarEscenarios());
                    }
                    break;
                case 4:
                    if (festivalActual == null) {
                        System.out.println("Debe crear un festival primero.");
                    } else {
                        int posicionUsuario = leerEntero("Ingrese la posición a consultar (1-5): ");
                        int posicion = posicionUsuario - 1;
                        System.out.println(festivalActual.consultarEscenario(posicion));
                    }
                    break;
                case 5:
                    ModificarEscenario();
                    break;
                case 6:
                    if (festivalActual == null) {
                        System.out.println("Debe crear un festival primero.");
                    } else {
                        int posicionUsuario = leerEntero("Ingrese la posición del escenario a retirar (1-5): "); //1-5 y no 0-4 para ser amigable con el usuario
                        int posicion = posicionUsuario - 1;
                        festivalActual.retirarEscenario(posicion);
                        System.out.println("Operación de retiro finalizada.");
                    }
                    break;
                case 7:
                    RegistrarArtista();
                    break;
                case 8:
                    if (festivalActual == null) {
                        System.out.println("Debe crear un festival primero.");
                    } else {
                        System.out.println(festivalActual.consultarArtistas());
                    }
                    break;
                case 9:
                    if (festivalActual == null) {
                        System.out.println("Debe crear un festival primero.");
                    } else {
                        System.out.print("Ingrese el código del artista a buscar: ");
                        String codigo = scanner.nextLine();
                        Artista encontrado = festivalActual.buscarArtista(codigo);
                        if (encontrado == null) {
                            System.out.println("No se encontró ningún artista con ese código.");
                        } else {
                            System.out.println("Código: " + encontrado.getCodigo() + ", Nombre Artístico: " + encontrado.getNombreArtistico() + ", Género Musical: " + encontrado.getGeneroMusical() + ", Duración: " + encontrado.getDuracionPresentacion() + " min" + ", Asistentes Estimados: " + encontrado.getCantidadEstimadaAsistentes());
                        }
                    }
                    break;
                case 10:
                    ModificarArtista();
                    break;
                case 11:
                    if (festivalActual == null) {
                        System.out.println("Debe crear un festival primero.");
                    } else {
                        System.out.print("Ingrese el código del artista a cancelar: ");
                        String codigo = scanner.nextLine();
                        festivalActual.cancelarParticipacion(codigo);
                        System.out.println("Operación de cancelación finalizada.");
                    }
                    break;
                case 12:
                    MostrarReporte();
                    break;
                case 13:
                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        }
        scanner.close();
    }

//para mostrar todo el menú
    private void mostrarMenu() {
        System.out.println("===== FESTIVAL UNIVERSITARIO DE MÚSICA =====");
        System.out.println("1. Nuevo festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar escenarios");
        System.out.println("4. Consultar un escenario");
        System.out.println("5. Modificar escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar artistas");
        System.out.println("9. Buscar artista");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participación");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
    }

    private int leerEntero(String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextInt();
                scanner.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                scanner.nextLine();
            }
        }
        return valor;
    }

    private void NuevoFestival() {
        System.out.print("Ingrese el nombre del festival: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el código del festival: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el nombre del coordinador: ");
        String coordinador = scanner.nextLine();

        festivalActual = new Festival(nombre, codigo, coordinador);
        System.out.println("Festival creado exitosamente. No tiene escenarios ni artistas registrados aún.");
    }

//todo lo necesario para registrar un escenario
    private void ConfigurarEscenario() {
        if (festivalActual == null) {
            System.out.println("Debe crear un festival primero.");
            return;
        }
        try {
            int posicionUsuario = leerEntero("Ingrese la posición del arreglo (1-5): ");
            int posicion = posicionUsuario - 1;
            System.out.print("Ingrese el código del escenario: ");
            String codigo = scanner.nextLine();
            System.out.print("Ingrese el nombre del escenario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la ubicación del escenario: ");
            String ubicacion = scanner.nextLine();
            int capacidad = leerEntero("Ingrese la capacidad máxima de asistentes: ");
            System.out.print("Ingrese el estado del escenario: ");
            String estado = scanner.nextLine();

            Escenario nuevoEscenario = new Escenario(codigo, nombre, ubicacion, capacidad, estado);
            festivalActual.configurarEscenario(posicion, nuevoEscenario);
            System.out.println("Escenario configurado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Proceso de configuración de escenario finalizado.");
        }
    }

    private void ModificarEscenario() {
        if (festivalActual == null) {

            System.out.println("Debe crear un festival primero");
            return;
        }
        try {

            int posicionUsuario = leerEntero("Ingrese la posición del escenario a modificar (1-5): ");
            int posicion = posicionUsuario - 1;
            int nuevaCapacidad = leerEntero("Ingrese la nueva capacidad máxima: ");
            System.out.print("Ingrese el nuevo estado del escenario: ");
            String nuevoEstado = scanner.nextLine();

            festivalActual.modificarEscenario(posicion, nuevaCapacidad, nuevoEstado);
            System.out.println("Escenario modificado exitosamente");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Proceso de modificación de escenario finalizado");
        }
    }

    private void RegistrarArtista() {

        if (festivalActual == null) {

            System.out.println("Debe crear un festival primero");
            return;
        }
        try {

            System.out.print("Ingrese el código del artista: ");
            String codigo = scanner.nextLine();
            System.out.print("Ingrese el nombre artístico: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el género musical: ");
            String genero = scanner.nextLine();
            int duracion = leerEntero("Ingrese la duración de la presentación (minutos): ");
            int asistentes = leerEntero("Ingrese la cantidad estimada de asistentes: ");

            Artista nuevoArtista = new Artista(codigo, nombre, genero, duracion, asistentes);
            festivalActual.registrarArtista(nuevoArtista);
            System.out.println("Artista registrado exitosamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Proceso de registro de artista finalizado");
        }
    }

    private void ModificarArtista() {

        if (festivalActual == null) {
            System.out.println("Debe crear un festival primero");
            return;
        }
        try {
            System.out.print("Ingrese el código del artista a modificar: ");
            String codigo = scanner.nextLine();
            System.out.print("Ingrese el nuevo nombre artístico: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo género musical: ");
            String genero = scanner.nextLine();
            int duracion = leerEntero("Ingrese la nueva duración de la presentación (minutos): ");
            int asistentes = leerEntero("Ingrese la nueva cantidad estimada de asistentes: ");

            festivalActual.modificarArtista(codigo, nombre, genero, duracion, asistentes);
            System.out.println("Artista modificado exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Proceso de modificación de artista finalizado");
        }
    }

    private void MostrarReporte() {
        if (festivalActual == null) {
            System.out.println("Debe crear un festival primero");
            return;
        }
        System.out.println("===== REPORTE DEL FESTIVAL: " + festivalActual.getNombre() + " ======");
        System.out.println(festivalActual.generarReporte());
    }
}
