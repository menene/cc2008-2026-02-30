import java.util.List;
import java.util.Scanner;

public class VistaTaller {

    private Scanner sc;

    public VistaTaller() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("==================================");
        System.out.println(" SISTEMA DE ÓRDENES DEL TALLER");
        System.out.println("==================================");
        System.out.println("1. Registrar una orden");
        System.out.println("2. Consultar todas las órdenes");
        System.out.println("3. Buscar una orden por número");
        System.out.println("4. Modificar una orden");
        System.out.println("5. Cancelar una orden");
        System.out.println("6. Consultar órdenes por placa");
        System.out.println("7. Mostrar reporte de costos");
        System.out.println("8. Mostrar orden de mayor costo");
        System.out.println("9. Mostrar cantidad de órdenes");
        System.out.println("10. Salir");
        System.out.println("==================================");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);

        return sc.nextLine().trim();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);

        String entrada = sc.nextLine().trim();

        return Integer.parseInt(entrada);
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);

        String entrada = sc.nextLine()
                .trim()
                .replace(",", ".");

        return Double.parseDouble(entrada);
    }

    public void mostrarOrden(
            OrdenServicio orden) {

        if (orden == null) {
            mostrarMensaje("No existe una orden para mostrar.");
            return;
        }

        System.out.println();
        System.out.println("------------------------------");
        System.out.println("Número de orden: " + orden.getNumeroOrden());
        System.out.println("Propietario: " + orden.getNombrePropietario());
        System.out.println("Placa: " + orden.getPlacaVehiculo());
        System.out.println("Descripción: " + orden.getDescripcionServicio());
        System.out.printf("Costo estimado: Q%.2f%n", orden.getCostoEstimado());
        System.out.println("------------------------------");
    }

    public void mostrarOrdenes(List<OrdenServicio> ordenes) {
        if (ordenes == null || ordenes.isEmpty()) {
            mostrarMensaje("No existen órdenes para mostrar.");
            return;
        }

        System.out.println();
        System.out.println("LISTADO DE ÓRDENES");

        for (OrdenServicio orden : ordenes) {
            mostrarOrden(orden);
        }
    }

    public void mostrarReporteCostos(double total, double promedio) {
        System.out.println();
        System.out.println("==============================");
        System.out.println(" REPORTE DE COSTOS");
        System.out.println("==============================");
        System.out.printf("Costo total estimado: Q%.2f%n", total);
        System.out.printf("Costo promedio estimado: Q%.2f%n", promedio);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println();
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.err.println();
        System.err.println("Error: " + mensaje);
    }

    public void cerrar() {
        sc.close();
    }
}