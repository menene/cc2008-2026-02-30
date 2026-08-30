import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner TECLADO = new Scanner(System.in);
    private static final GestorOrdenes GESTOR = new GestorOrdenes();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> registrarOrden();
                case 2 -> consultarOrdenes();
                case 3 -> buscarOrden();
                case 4 -> modificarOrden();
                case 5 -> cancelarOrden();
                case 6 -> consultarPorPlaca();
                case 7 -> mostrarReporteCostos();
                case 8 -> mostrarOrdenMayorCosto();
                case 9 -> System.out.println("Cantidad de ordenes: " + GESTOR.obtenerCantidadOrdenes());
                case 10 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (opcion != 10);
        TECLADO.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== TALLER AUTOMOTRIZ ===");
        System.out.println("1. Registrar orden");
        System.out.println("2. Consultar ordenes");
        System.out.println("3. Buscar orden");
        System.out.println("4. Modificar orden");
        System.out.println("5. Cancelar orden");
        System.out.println("6. Consultar ordenes por placa");
        System.out.println("7. Reporte de costos");
        System.out.println("8. Orden de mayor costo");
        System.out.println("9. Cantidad de ordenes");
        System.out.println("10. Salir");
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(TECLADO.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero entero valido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(TECLADO.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un costo numerico valido.");
            }
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return TECLADO.nextLine().trim();
    }

    private static void registrarOrden() {
        try {
            int numero = leerEntero("Numero de orden: ");
            String propietario = leerTexto("Nombre del propietario: ");
            String placa = leerTexto("Placa del vehiculo: ");
            String descripcion = leerTexto("Descripcion del servicio: ");
            double costo = leerDouble("Costo estimado: Q");
            GESTOR.registrarOrden(new OrdenServicio(numero, propietario, placa, descripcion, costo));
            System.out.println("Orden registrada correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo registrar: " + e.getMessage());
        }
    }

    private static void consultarOrdenes() {
        mostrarLista(GESTOR.obtenerOrdenes(), "No hay ordenes registradas.");
    }

    private static void buscarOrden() {
        try {
            int numero = leerEntero("Numero de orden: ");
            System.out.println("\n" + GESTOR.buscarOrden(numero));
        } catch (OrdenNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Busqueda finalizada. Regresando al menu principal.");
        }
    }

    private static void modificarOrden() {
        try {
            int numero = leerEntero("Numero de orden a modificar: ");
            String descripcion = leerTexto("Nueva descripcion: ");
            double costo = leerDouble("Nuevo costo estimado: Q");
            GESTOR.modificarOrden(numero, descripcion, costo);
            System.out.println("Orden modificada correctamente.");
        } catch (OrdenNoEncontradaException | IllegalArgumentException e) {
            System.out.println("No se pudo modificar: " + e.getMessage());
        }
    }

    private static void cancelarOrden() {
        try {
            int numero = leerEntero("Numero de orden a cancelar: ");
            GESTOR.cancelarOrden(numero);
            System.out.println("Orden cancelada correctamente.");
        } catch (OrdenNoEncontradaException e) {
            System.out.println("No se pudo cancelar: " + e.getMessage());
        }
    }

    private static void consultarPorPlaca() {
        try {
            String placa = leerTexto("Placa del vehiculo: ");
            mostrarLista(GESTOR.buscarPorPlaca(placa), "No se encontraron ordenes para esa placa.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarReporteCostos() {
        System.out.printf("Valor total: Q%.2f%n", GESTOR.calcularTotal());
        System.out.printf("Costo promedio: Q%.2f%n", GESTOR.calcularPromedio());
    }

    private static void mostrarOrdenMayorCosto() {
        try {
            System.out.println("\nOrden de mayor costo:\n" + GESTOR.obtenerOrdenMayorCosto());
        } catch (OrdenNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarLista(List<OrdenServicio> ordenes, String mensajeVacio) {
        if (ordenes.isEmpty()) {
            System.out.println(mensajeVacio);
            return;
        }
        for (OrdenServicio orden : ordenes) {
            System.out.println("\n--------------------");
            System.out.println(orden);
        }
    }
}
