import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Festival festivalActual;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(" FESTIVAL UNIVERSITARIO DE MUSICA");
        System.out.println("========================================");

        try {
            festivalActual = crearFestival();
            ejecutarMenu();
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }

    private static Festival crearFestival() {
        while (true) {
            System.out.println("\n--- DATOS DEL FESTIVAL ---");
            String nombre = leerTexto("Nombre: ");
            String codigo = leerTexto("Codigo de identificacion: ");
            String coordinador = leerTexto("Nombre del coordinador: ");

            try {
                return new Festival(nombre, codigo, coordinador);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void ejecutarMenu() {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    festivalActual = crearFestival();
                    System.out.println("Nuevo festival creado correctamente.");
                    break;
                case 2:
                    configurarEscenario();
                    break;
                case 3:
                    consultarEscenarios();
                    break;
                case 4:
                    consultarEscenario();
                    break;
                case 5:
                    modificarEscenario();
                    break;
                case 6:
                    retirarEscenario();
                    break;
                case 7:
                    registrarArtista();
                    break;
                case 8:
                    consultarArtistas();
                    break;
                case 9:
                    buscarArtista();
                    break;
                case 10:
                    modificarArtista();
                    break;
                case 11:
                    cancelarParticipacion();
                    break;
                case 12:
                    mostrarReporte();
                    break;
                case 13:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion invalida. Seleccione un numero del 1 al 13.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n========== MENU PRINCIPAL ==========");
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
        System.out.println("11. Cancelar participacion");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada incorrecta. Debe ingresar un numero entero.");
                scanner.nextLine();
            }
        }
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("La entrada no puede estar vacia.");
        }
    }

    private static void configurarEscenario() {
        int posicion = leerEntero("Posicion del arreglo (0-4): ");

        if (!festivalActual.esPosicionValida(posicion)) {
            System.out.println("La posicion indicada no existe.");
            return;
        }
        if (festivalActual.getEscenario(posicion) != null) {
            System.out.println("La posicion seleccionada ya esta ocupada.");
            return;
        }

        String codigo = leerTexto("Codigo del escenario: ");
        String nombre = leerTexto("Nombre del escenario: ");
        String ubicacion = leerTexto("Ubicacion: ");
        int capacidad = leerEntero("Capacidad maxima: ");
        String estado = leerTexto("Estado: ");

        try {
            Escenario escenario = new Escenario(codigo, nombre, ubicacion, capacidad, estado);
            if (festivalActual.configurarEscenario(posicion, escenario)) {
                System.out.println("Escenario configurado correctamente.");
            } else {
                System.out.println("No fue posible configurar el escenario.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void consultarEscenarios() {
        boolean existenEscenarios = false;
        System.out.println("\n--- ESCENARIOS CONFIGURADOS ---");

        for (int i = 0; i < festivalActual.getCantidadPosicionesEscenarios(); i++) {
            Escenario escenario = festivalActual.getEscenario(i);
            if (escenario != null) {
                existenEscenarios = true;
                System.out.println("\nPosicion " + i + ":");
                System.out.println(escenario);
            }
        }

        if (!existenEscenarios) {
            System.out.println("No hay escenarios configurados.");
        }
    }

    private static void consultarEscenario() {
        int posicion = leerEntero("Posicion del escenario (0-4): ");

        if (!festivalActual.esPosicionValida(posicion)) {
            System.out.println("La posicion indicada no existe.");
            return;
        }

        Escenario escenario = festivalActual.getEscenario(posicion);
        if (escenario == null) {
            System.out.println("La posicion se encuentra vacia.");
        } else {
            System.out.println(escenario);
        }
    }

    private static void modificarEscenario() {
        int posicion = leerEntero("Posicion del escenario que desea modificar (0-4): ");

        if (!festivalActual.esPosicionValida(posicion)) {
            System.out.println("La posicion indicada no existe.");
            return;
        }
        if (festivalActual.getEscenario(posicion) == null) {
            System.out.println("No existe un escenario en esa posicion.");
            return;
        }

        int nuevaCapacidad = leerEntero("Nueva capacidad maxima: ");
        String nuevoEstado = leerTexto("Nuevo estado: ");

        try {
            festivalActual.modificarEscenario(posicion, nuevaCapacidad, nuevoEstado);
            System.out.println("Escenario modificado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void retirarEscenario() {
        int posicion = leerEntero("Posicion del escenario que desea retirar (0-4): ");

        if (!festivalActual.esPosicionValida(posicion)) {
            System.out.println("La posicion indicada no existe.");
        } else if (festivalActual.retirarEscenario(posicion)) {
            System.out.println("Escenario retirado correctamente.");
        } else {
            System.out.println("La posicion ya se encontraba vacia.");
        }
    }

    private static void registrarArtista() {
        String codigo = leerTexto("Codigo del artista: ");
        String nombre = leerTexto("Nombre artistico: ");
        String genero = leerTexto("Genero musical: ");
        int duracion = leerEntero("Duracion de la presentacion en minutos: ");
        int asistentes = leerEntero("Cantidad estimada de asistentes: ");

        try {
            Artista artista = new Artista(codigo, nombre, genero, duracion, asistentes);
            if (festivalActual.registrarArtista(artista)) {
                System.out.println("Artista registrado correctamente.");
            } else {
                System.out.println("No se puede registrar: el codigo ya existe.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void consultarArtistas() {
        if (festivalActual.getCantidadArtistas() == 0) {
            System.out.println("No hay artistas registrados.");
            return;
        }

        System.out.println("\n--- ARTISTAS REGISTRADOS ---");
        for (int i = 0; i < festivalActual.getCantidadArtistas(); i++) {
            System.out.println("\nArtista " + (i + 1) + ":");
            System.out.println(festivalActual.getArtista(i));
        }
    }

    private static void buscarArtista() {
        String codigo = leerTexto("Codigo del artista que desea buscar: ");
        Artista artista = festivalActual.buscarArtista(codigo);

        if (artista == null) {
            System.out.println("No se encontro un artista con ese codigo.");
        } else {
            System.out.println(artista);
        }
    }

    private static void modificarArtista() {
        String codigoActual = leerTexto("Codigo actual del artista: ");
        if (festivalActual.buscarArtista(codigoActual) == null) {
            System.out.println("No se encontro un artista con ese codigo.");
            return;
        }

        String nuevoCodigo = leerTexto("Nuevo codigo: ");
        String nuevoNombre = leerTexto("Nuevo nombre artistico: ");
        String nuevoGenero = leerTexto("Nuevo genero musical: ");
        int nuevaDuracion = leerEntero("Nueva duracion en minutos: ");
        int nuevosAsistentes = leerEntero("Nueva cantidad estimada de asistentes: ");

        try {
            boolean modificado = festivalActual.modificarArtista(codigoActual, nuevoCodigo,
                    nuevoNombre, nuevoGenero, nuevaDuracion, nuevosAsistentes);
            if (modificado) {
                System.out.println("Artista modificado correctamente.");
            } else {
                System.out.println("No se puede modificar: el nuevo codigo ya existe.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void cancelarParticipacion() {
        String codigo = leerTexto("Codigo del artista que desea eliminar: ");
        if (festivalActual.cancelarParticipacion(codigo)) {
            System.out.println("Participacion cancelada correctamente.");
        } else {
            System.out.println("No se encontro un artista con ese codigo.");
        }
    }

    private static void mostrarReporte() {
        System.out.println("\n========== REPORTE DEL FESTIVAL ==========");
        System.out.println("Nombre: " + festivalActual.getNombre());
        System.out.println("Codigo: " + festivalActual.getCodigoIdentificacion());
        System.out.println("Coordinador: " + festivalActual.getNombreCoordinador());
        System.out.println("Escenarios configurados: "
                + festivalActual.contarEscenariosConfigurados());
        System.out.println("Espacios disponibles: "
                + festivalActual.contarEspaciosDisponibles());

        Escenario escenarioMayor = festivalActual.obtenerEscenarioMayorCapacidad();
        if (escenarioMayor == null) {
            System.out.println("Escenario con mayor capacidad: no hay escenarios configurados.");
        } else {
            System.out.println("\nEscenario con mayor capacidad:");
            System.out.println(escenarioMayor);
        }

        System.out.println("\nCantidad de artistas registrados: "
                + festivalActual.getCantidadArtistas());
        if (festivalActual.getCantidadArtistas() == 0) {
            System.out.println("No existen artistas para realizar los demas calculos.");
            return;
        }

        System.out.println("\nArtista con la presentacion de mayor duracion:");
        System.out.println(festivalActual.obtenerArtistaMayorDuracion());
        System.out.println("\nArtista con mayor cantidad estimada de asistentes:");
        System.out.println(festivalActual.obtenerArtistaMayorAsistencia());
        System.out.printf("%nPromedio de duracion de las presentaciones: %.2f minutos%n",
                festivalActual.calcularPromedioDuracion());
    }
}

