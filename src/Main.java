import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GestorOrdenes gestor = new GestorOrdenes();

    public static void main(String[] args) {

        int opcion = 0;

        do {

            mostrarMenu();

            try {

                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());

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
                        consultarOrdenesPorPlaca();
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
                        System.out.println("\nSaliendo del sistema...");
                        break;

                    default:
                        System.out.println("\nOpción inválida.");
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nError: debe ingresar un número válido."
                );
            }

        } while (opcion != 10);

        scanner.close();
    }

    private static void mostrarMenu() {

        System.out.println("\n======================================");
        System.out.println("     TALLER AUTOMOTRIZ");
        System.out.println("======================================");
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
        System.out.println("======================================");
    }

    private static void registrarOrden() {

        try {

            System.out.println("\n--- REGISTRAR ORDEN ---");

            System.out.print("Número de orden: ");
            int numeroOrden = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre del propietario: ");
            String propietario = scanner.nextLine();

            System.out.print("Placa del vehículo: ");
            String placa = scanner.nextLine();

            System.out.print("Descripción del servicio: ");
            String descripcion = scanner.nextLine();

            System.out.print("Costo estimado: Q");
            double costo = Double.parseDouble(scanner.nextLine());

            OrdenServicio orden = new OrdenServicio(
                    numeroOrden,
                    propietario,
                    placa,
                    descripcion,
                    costo
            );

            gestor.registrarOrden(orden);

            System.out.println("\nOrden registrada correctamente.");

        } catch (NumberFormatException e) {

            System.out.println(
                    "\nError: el número de orden y el costo deben ser numéricos."
            );

        } catch (IllegalArgumentException e) {

            System.out.println("\nError: " + e.getMessage());

        } finally {

            System.out.println(
                    "Proceso de registro finalizado. Regresando al menú principal."
            );
        }
    }

    private static void consultarOrdenes() {

        System.out.println("\n--- ORDENES REGISTRADAS ---");

        List<OrdenServicio> ordenes = gestor.consultarOrdenes();

        if (ordenes.isEmpty()) {

            System.out.println("No existen órdenes registradas.");
            return;
        }

        for (OrdenServicio orden : ordenes) {

            System.out.println(orden);
            System.out.println("------------------------------");
        }
    }

    private static void buscarOrden() {

        try {

            System.out.println("\n--- BUSCAR ORDEN ---");

            System.out.print("Ingrese el número de orden: ");
            int numeroOrden = Integer.parseInt(scanner.nextLine());

            OrdenServicio orden = gestor.buscarOrden(numeroOrden);

            System.out.println("\nOrden encontrada:");
            System.out.println(orden);

        } catch (NumberFormatException e) {

            System.out.println(
                    "\nError: debe ingresar un número válido."
            );

        } catch (IllegalArgumentException e) {

            System.out.println("\nError: " + e.getMessage());
        }
    }

    private static void modificarOrden() {

        try {

            System.out.println("\n--- MODIFICAR ORDEN ---");

            System.out.print("Número de orden: ");
            int numeroOrden = Integer.parseInt(scanner.nextLine());

            System.out.print("Nueva descripción del servicio: ");
            String nuevaDescripcion = scanner.nextLine();

            System.out.print("Nuevo costo estimado: Q");
            double nuevoCosto = Double.parseDouble(scanner.nextLine());

            gestor.modificarOrden(
                    numeroOrden,
                    nuevaDescripcion,
                    nuevoCosto
            );

            System.out.println("\nOrden modificada correctamente.");

        } catch (NumberFormatException e) {

            System.out.println(
                    "\nError: debe ingresar valores numéricos válidos."
            );

        } catch (IllegalArgumentException e) {

            System.out.println("\nError: " + e.getMessage());
        }
    }

    private static void cancelarOrden() {

        try {

            System.out.println("\n--- CANCELAR ORDEN ---");

            System.out.print("Número de orden: ");
            int numeroOrden = Integer.parseInt(scanner.nextLine());

            gestor.cancelarOrden(numeroOrden);

            System.out.println("\nOrden cancelada correctamente.");

        } catch (NumberFormatException e) {

            System.out.println(
                    "\nError: debe ingresar un número válido."
            );

        } catch (IllegalArgumentException e) {

            System.out.println("\nError: " + e.getMessage());
        }
    }

    private static void consultarOrdenesPorPlaca() {

        System.out.println("\n--- BUSCAR POR PLACA ---");

        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();

        List<OrdenServicio> resultados =
                gestor.buscarPorPlaca(placa);

        if (resultados.isEmpty()) {

            System.out.println(
                    "\nNo existen órdenes asociadas a esa placa."
            );

            return;
        }

        System.out.println("\nOrdenes encontradas:");

        for (OrdenServicio orden : resultados) {

            System.out.println(orden);
            System.out.println("------------------------------");
        }
    }

    private static void mostrarReporteCostos() {

        System.out.println("\n--- REPORTE DE COSTOS ---");

        double total = gestor.calcularTotalCostos();
        double promedio = gestor.calcularCostoPromedio();

        System.out.printf(
                "Valor total de órdenes: Q%.2f%n",
                total
        );

        System.out.printf(
                "Costo promedio: Q%.2f%n",
                promedio
        );
    }

    private static void mostrarOrdenMayorCosto() {

        System.out.println("\n--- ORDEN DE MAYOR COSTO ---");

        OrdenServicio orden =
                gestor.obtenerOrdenMayorCosto();

        if (orden == null) {

            System.out.println(
                    "No existen órdenes registradas."
            );

            return;
        }

        System.out.println(orden);
    }

    private static void mostrarCantidadOrdenes() {

        System.out.println("\n--- CANTIDAD DE ORDENES ---");

        System.out.println(
                "Ordenes registradas actualmente: "
                        + gestor.obtenerCantidadOrdenes()
        );
    }
}