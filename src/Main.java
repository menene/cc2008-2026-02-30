import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner entrada = new Scanner(System.in);
    private static final GestorOrdenes gestor = new GestorOrdenes();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            System.out.println();

            switch (opcion) {
                case 1:
                    registrarOrden();
                    break;

                case 2:
                    consultarOrdenes();
                    break;

                case 3:
                    buscarOrden();
                    break;

                case 4:
                    modificarOrden();
                    break;

                case 5:
                    cancelarOrden();
                    break;

                case 6:
                    consultarPorPlaca();
                    break;

                case 7:
                    mostrarReporteCostos();
                    break;

                case 8:
                    mostrarOrdenMayorCosto();
                    break;

                case 9:
                    mostrarCantidadOrdenes();
                    break;

                case 10:
                    System.out.println(
                            "Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println(
                            "La opción ingresada no es válida.");
            }

            System.out.println();
        } while (opcion != 10);
    }

    private static void mostrarMenu() {
        System.out.println(
                "   Sistema de Órdenes de Servicio");
        System.out.println("1. Registrar orden");
        System.out.println("2. Consultar órdenes");
        System.out.println("3. Buscar orden");
        System.out.println("4. Modificar orden");
        System.out.println("5. Cancelar orden");
        System.out.println("6. Consultar órdenes por placa");
        System.out.println("7. Reporte de costos");
        System.out.println("8. Orden de mayor costo");
        System.out.println("9. Cantidad de órdenes");
        System.out.println("10. Salir");
        System.out.println(
                "============================================");
    }

    private static void registrarOrden() {
        try {
            int numeroOrden = leerEntero(
                    "Número de orden: ");

            String propietario = leerTextoNoVacio(
                    "Nombre del propietario: ");

            String placa = leerTextoNoVacio(
                    "Placa del vehículo: ");

            String descripcion = leerTextoNoVacio(
                    "Descripción del servicio: ");

            double costo = leerDouble(
                    "Costo estimado: Q");

            OrdenServicio orden = new OrdenServicio(
                    numeroOrden,
                    propietario,
                    placa,
                    descripcion,
                    costo);

            gestor.registrarOrden(orden);

            System.out.println(
                    "Orden registrada correctamente.");

        } catch (IllegalArgumentException excepcion) {
            System.out.println(
                    "No se pudo registrar: " + excepcion.getMessage());
        }
    }

    private static void consultarOrdenes() {
        List<OrdenServicio> ordenes =
                gestor.consultarOrdenes();

        if (ordenes.isEmpty()) {
            System.out.println(
                    "No hay órdenes registradas.");
            return;
        }

        System.out.println("Órdenes Registradas");

        for (OrdenServicio orden : ordenes) {
            System.out.println(
                    "--------------------------------------------");
            System.out.println(orden);
        }
    }

    private static void buscarOrden() {
        try {
            int numeroOrden = leerEntero(
                    "Número de orden que desea buscar: ");

            OrdenServicio orden =
                    gestor.buscarOrden(numeroOrden);

            System.out.println("Orden encontrada:");
            System.out.println(orden);

        } catch (OrdenNoEncontradaException excepcion) {
            System.out.println(
                    "Error: " + excepcion.getMessage());

        } finally {
            System.out.println(
                    "Operación de búsqueda finalizada, regresando al menú ");
        }
    }

    private static void modificarOrden() {
        try {
            int numeroOrden = leerEntero(
                    "Número de orden que desea modificar: ");

            String descripcion = leerTextoNoVacio(
                    "Nueva descripción: ");

            double costo = leerDouble(
                    "Nuevo costo estimado: Q");

            gestor.modificarOrden(
                    numeroOrden,
                    descripcion,
                    costo);

            System.out.println(
                    "Orden modificada correctamente.");

        } catch (OrdenNoEncontradaException
                | IllegalArgumentException excepcion) {

            System.out.println(
                    "No se pudo modificar: " + excepcion.getMessage());
        }
    }

    private static void cancelarOrden() {
        try {
            int numeroOrden = leerEntero(
                    "Número de orden que desea cancelar: ");

            gestor.cancelarOrden(numeroOrden);

            System.out.println(
                    "Orden cancelada correctamente.");

        } catch (OrdenNoEncontradaException excepcion) {
            System.out.println(
                    "No se pudo cancelar: "
                            + excepcion.getMessage());
        }
    }

    private static void consultarPorPlaca() {
        try {
            String placa = leerTextoNoVacio(
                    "Placa que desea consultar: ");

            List<OrdenServicio> ordenes =
                    gestor.buscarPorPlaca(placa);

            if (ordenes.isEmpty()) {
                System.out.println(
                        "No hay órdenes asociadas a esa placa.");
                return;
            }

            System.out.println(
                    "Órdenes asociadas a la placa "
                            + placa.toUpperCase());

            for (OrdenServicio orden : ordenes) {
                System.out.println(
                        "--------------------------------------------");
                System.out.println(orden);
            }

        } catch (IllegalArgumentException excepcion) {
            System.out.println(
                    "No se pudo consultar: " + excepcion.getMessage());
        }
    }

    private static void mostrarReporteCostos() {
        double total = gestor.calcularCostoTotal();
        double promedio = gestor.calcularCostoPromedio();

        System.out.printf(
                "Costo total: Q%.2f%n", total);

        System.out.printf(
                "Costo promedio: Q%.2f%n", promedio);
    }

    private static void mostrarOrdenMayorCosto() {
        try {
            OrdenServicio orden =
                    gestor.obtenerOrdenMayorCosto();

            System.out.println("Orden de Mayor Costo");
            System.out.println(orden);

        } catch (OrdenNoEncontradaException excepcion) {
            System.out.println(
                    "Error: " + excepcion.getMessage());
        }
    }

    private static void mostrarCantidadOrdenes() {
        System.out.println(
                "Cantidad de órdenes registradas: "
                        + gestor.obtenerCantidadOrdenes());
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);

                return Integer.parseInt(
                        entrada.nextLine().trim());

            } catch (NumberFormatException excepcion) {
                System.out.println(
                        "Entrada inválida, ingrese un número entero ");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);

                return Double.parseDouble(
                        entrada.nextLine().trim());

            } catch (NumberFormatException excepcion) {
                System.out.println(
                        "Entrada inválida, ingrese un número decimal.");
            }
        }
    }

    private static String leerTextoNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println(
                    "El dato no puede estar vacío.");
        }
    }
}