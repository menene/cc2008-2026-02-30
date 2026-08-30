import java.util.Scanner;
import java.util.List;

public class Vista {

    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {

        System.out.println("\n===== TALLER AUTOMOTRIZ =====");
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
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public int pedirNumeroOrden() {

        System.out.print("Ingrese el número de orden: ");

        return scanner.nextInt();
    }

    public String pedirNombrePropietario() {

        scanner.nextLine();

        System.out.print("Ingrese el nombre del propietario: ");

        return scanner.nextLine();
    }

    public String pedirPlaca() {

        System.out.print("Ingrese la placa del vehículo: ");

        return scanner.nextLine();
    }

    public String pedirDescripcionServicio() {

        System.out.print("Ingrese la descripción del servicio: ");

        return scanner.nextLine();
    }

    public double pedirCostoEstimado() {

        System.out.print("Ingrese el costo estimado: ");

        return scanner.nextDouble();
    }

    public void mostrarOrden(OrdenServicio orden) {

        System.out.println("Número de orden: " + orden.getNumeroOrden());
        System.out.println("Propietario: " + orden.getNombrePropietario());
        System.out.println("Placa: " + orden.getPlaca());
        System.out.println("Descripción: " + orden.getDescripcionServicio());
        System.out.println("Costo estimado: " + orden.getCostoEstimado());
    }

    public void mostrarOrdenes(List<OrdenServicio> ordenes) {

        for (OrdenServicio orden : ordenes) {
            mostrarOrden(orden);
            System.out.println("-------------------------");
        }
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

    public void mostrarReporteCostos(double total, double promedio) {

        System.out.println("Valor total: " + total);
        System.out.println("Costo promedio: " + promedio);
    }

    public void mostrarCantidad(int cantidad) {

        System.out.println("Cantidad de órdenes: " + cantidad);
    }

    public void salir() {

        System.out.println("Programa finalizado.");
    }
}