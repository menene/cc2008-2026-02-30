import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VistaOrdenes {

    private Scanner scanner;

    public VistaOrdenes() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== TALLER AUTOMOTRIZ =====");
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
        System.out.print("Seleccione una opcion: ");
    }

    public int solicitarOpcion() {

    try {
            return scanner.nextInt(); //prueba ejecutar y si salta algún error, lo atrapa

        } catch (InputMismatchException e) { 

            scanner.nextLine(); 
            return -1;
        }
    }

    public OrdenServicio solicitarOrden() {

        scanner.nextLine();

        System.out.println("\n--- Nueva Orden ---");

        System.out.print("Numero de orden: ");
        int numeroOrden = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Nombre del propietario: ");
        String propietario = scanner.nextLine();

        System.out.print("Placa del vehiculo: ");
        String placa = scanner.nextLine();

        System.out.print("Descripcion del servicio: ");
        String descripcion = scanner.nextLine();

        System.out.print("Costo estimado: ");
        double costo = scanner.nextDouble();

        //devuelve el nuevo objeto con lo solicitado al usuario
        return new OrdenServicio(numeroOrden, propietario,placa, descripcion,costo);
    }


    //mas opciones del menu
        public int solicitarNumeroOrden() {
        System.out.print("Ingrese el numero de orden: ");
        return scanner.nextInt();
    }

    public String solicitarPlaca() {
        scanner.nextLine();

        System.out.print("Ingrese la placa del vehiculo: ");
        return scanner.nextLine();
    }

    public String solicitarDescripcion() {
        scanner.nextLine();

        System.out.print("Ingrese la nueva descripcion del servicio: ");
        return scanner.nextLine();
    }

    public double solicitarCosto() {
        System.out.print("Ingrese el nuevo costo estimado: ");
        return scanner.nextDouble();
    }

    public void mostrarOrden(OrdenServicio orden) {

        System.out.println("\n--- Orden de Servicio ---");
        System.out.println("Numero de orden: " + orden.getNumeroOrden());
        System.out.println("Propietario: " + orden.getNombrePropietario());
        System.out.println("Placa: " + orden.getPlacaVehiculo());
        System.out.println("Servicio: " + orden.getDescripcionServicio());
        System.out.println("Costo estimado: Q" + orden.getCostoEstimado());
    }

    //Mostrar Ordenes
    public void mostrarOrdenes(List<OrdenServicio> ordenes) {

        System.out.println("\n--- Ordenes Registradas ---");

        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes registradas.");
            return;
        }

        for (OrdenServicio orden : ordenes) {
            mostrarOrden(orden);
        }
    }

    public void mostrarReporteCostos(double total, double promedio) {
        System.out.println("\n--- Reporte de Costos ---");
        System.out.println("Costo total: Q" + total);
        System.out.println("Costo promedio: Q" + promedio);
    }   

    public void mostrarCantidadOrdenes(int cantidad) {
        System.out.println("Cantidad de ordenes registradas: " + cantidad);
    }   

    public void mostrarMensaje(String mensaje) { //Muestra la informacion de errores o confirmaciones al usuario
        System.out.println(mensaje);
    }

    
}
