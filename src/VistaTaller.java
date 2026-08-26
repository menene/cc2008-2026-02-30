import java.util.List;
import java.util.Scanner;

public class VistaTaller {
    private Scanner lector;

    public VistaTaller() {
        lector = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println();
        System.out.println("--- TALLER AUTOMOTRIZ ---");
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

        return leerEntero("Seleccione una opcion: ");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return lector.nextLine();
    }

    public int leerEntero(String mensaje) {
        String entrada = leerTexto(mensaje);
        return Integer.parseInt(entrada);
    }

    public double leerDecimal(String mensaje) {
        String entrada = leerTexto(mensaje);
        return Double.parseDouble(entrada);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarOrden(OrdenServicio orden) {
        System.out.println("Numero de orden: "
                + orden.getNumeroOrden());
        System.out.println("Propietario: "
                + orden.getNombrePropietario());
        System.out.println("Placa: "
                + orden.getPlacaVehiculo());
        System.out.println("Servicio: "
                + orden.getDescripcionServicio());
        System.out.println("Costo estimado: Q"
                + orden.getCostoEstimado());
        System.out.println("--------------------------------");
    }

    public void mostrarOrdenes(List<OrdenServicio> ordenes) {
        if (ordenes.size() == 0) {
            mostrarMensaje("No se encontraron ordenes.");
            return;
        }

        for (OrdenServicio orden : ordenes) {
            mostrarOrden(orden);
        }
    }

    public void mostrarReporteCostos(double total, double promedio) {
        System.out.println("Costo total: Q" + total);
        System.out.println("Costo promedio: Q" + promedio);
    }

    public void cerrarLector() {
        lector.close();
    }
}
