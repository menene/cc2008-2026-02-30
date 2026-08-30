import java.util.List;
import java.util.Scanner;

public class VistaTaller {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n===== GESTIÓN DE ÓRDENES DE SERVICIO =====");
        System.out.println("1. Listar órdenes");
        System.out.println("2. Crear orden");
        System.out.println("3. Actualizar orden");
        System.out.println("4. Eliminar orden");
        System.out.println("5. Salir");
        System.out.println("=========================================");
    }

    public int leerOpcion() {
        return leerEntero("Seleccione una opción: ");
    }

    public OrdenServicio pedirDatosOrden() {
        int numero = leerEntero("Número de orden: ");
        String nombreCliente = leerTexto("Nombre del cliente: ");
        String placaVehiculo = leerTexto("Placa del vehículo: ");
        String descripcionServicio = leerTexto("Descripción del servicio: ");
        double costoEstimado = leerDouble("Costo estimado: ");

        return new OrdenServicio(numero, nombreCliente, placaVehiculo, descripcionServicio, costoEstimado);
    }

    public int leerNumeroOrden(String mensaje) {
        return leerEntero(mensaje);
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    public double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un valor numérico válido.");
            }
        }
    }

    public void mostrarOrdenes(List<OrdenServicio> ordenes) {
        if (ordenes.isEmpty()) {
            System.out.println("No hay órdenes registradas.");
            return;
        }

        System.out.println("\n--- LISTADO DE ÓRDENES ---");
        for (OrdenServicio orden : ordenes) {
            System.out.println("Número: " + orden.getNumeroOrden()
                    + " | Cliente: " + orden.getNombreCliente()
                    + " | Placa: " + orden.getPlacaVehiculo()
                    + " | Servicio: " + orden.getDescripcionServicio()
                    + " | Costo: $" + orden.getCostoEstimado());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTotal(double total) {
        System.out.println("Total acumulado: $" + total);
    }
}
