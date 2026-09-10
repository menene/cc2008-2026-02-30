import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaFestival {
    private Scanner sc;

    public VistaFestival() {
        sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
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

        return leerEntero("Seleccione una opción: ");
    }

    public Festival leerFestival() {
        while (true) {
            try {
                String nombre = leerTexto("Nombre del festival: ");
                String codigo = leerTexto("Código: ");
                String coordinador = leerTexto("Coordinador: ");

                return new Festival(nombre, codigo, coordinador);

            } catch (IllegalArgumentException e) {
                mostrarMensaje(e.getMessage());
            }
        }
    }

    public Escenario leerEscenario(int ubicacion) {
        try {
            String codigo = leerTexto("Código del escenario: ");
            String nombre = leerTexto("Nombre del escenario: ");
            int capacidad = leerEntero("Capacidad máxima: ");
            String estado = leerTexto("Estado del escenario: ");

            return new Escenario(codigo, nombre, ubicacion, capacidad, estado);

        } catch (IllegalArgumentException e) {
            mostrarMensaje(e.getMessage());
            return null;

        } finally {
            System.out.println("Proceso de lectura de escenario finalizado.");
        }
    }

    public Artista leerArtista() {
        try {
            String codigo = leerTexto("Código del artista: ");
            String nombre = leerTexto("Nombre artístico: ");
            String genero = leerTexto("Género musical: ");
            double duracion = leerDouble("Duración en minutos: ");
            int asistentes = leerEntero("Asistentes estimados: ");

            return new Artista(codigo, nombre, genero, duracion, asistentes);

        } catch (IllegalArgumentException e) {
            mostrarMensaje(e.getMessage());
            return null;
        }
    }

    public int leerPosicionEscenario() {
        int posicion = leerEntero("Posición del escenario (1-5): ");

        if (posicion < 1 || posicion > 5) {
            mostrarMensaje("La posición debe estar entre 1 y 5.");
            return -1;
        }

        return posicion - 1;
    }

    public int menuModificarEscenario() {
        System.out.println("\n1. Modificar capacidad");
        System.out.println("2. Modificar estado");
        System.out.println("3. Cancelar");

        return leerEntero("Seleccione una opción: ");
    }

    public int menuModificarArtista() {
        System.out.println("\n1. Modificar nombre");
        System.out.println("2. Modificar género");
        System.out.println("3. Modificar duración");
        System.out.println("4. Modificar asistentes");
        System.out.println("5. Cancelar");

        return leerEntero("Seleccione una opción: ");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public int leerEntero(String mensaje) {
        try {
            System.out.print(mensaje);
            int valor = sc.nextInt();
            sc.nextLine();

            return valor;

        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar un número entero.");
            sc.nextLine();
            return -1;
        }
    }

    public double leerDouble(String mensaje) {
        try {
            System.out.print(mensaje);
            double valor = sc.nextDouble();
            sc.nextLine();

            return valor;

        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar un número.");
            sc.nextLine();
            return -1;
        }
    }

    public void mostrarEscenario(int posicion, Escenario escenario) {
        System.out.println("\nPosición " + (posicion + 1) + ": " + escenario);
    }

    public void mostrarArtista(Artista artista) {
        System.out.println("\n" + artista);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje);
    }

    public void mostrarReporte(Festival festival, int cantidadArtistas, Artista mayorDuracion,
            Artista mayorAsistencia, double promedio) {

        int configurados = festival.contarEscenarios();

        System.out.println("\n--- REPORTE DEL FESTIVAL ---");
        System.out.println("Festival: " + festival.getNombre());
        System.out.println("Escenarios configurados: " + configurados);
        System.out.println("Espacios disponibles: " + (5 - configurados));

        Escenario mayorEscenario = festival.escenarioMayorCapacidad();

        if (mayorEscenario == null) {
            System.out.println("Escenario con mayor capacidad: No hay escenarios");
        } else {
            System.out.println("Escenario con mayor capacidad: " + mayorEscenario);
        }

        System.out.println("Artistas registrados: " + cantidadArtistas);

        if (cantidadArtistas == 0) {
            System.out.println("No hay estadísticas de artistas disponibles.");
        } else {
            System.out.println("Artista con mayor duración: " + mayorDuracion);
            System.out.println("Artista con más asistentes: " + mayorAsistencia);
            System.out.printf("Promedio de duración: %.2f minutos%n", promedio);
        }
    }
}