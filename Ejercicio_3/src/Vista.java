import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    private Scanner scanner;
    public Vista() {
        scanner = new Scanner(System.in);
    }
    public int Mostrar_Menu() {
        System.out.println("\n===== SISTEMA DE ÓRDENES =====");
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
    public double PedirNumeroOrden() {
        System.out.print("Ingrese el número de orden: ");
        return scanner.nextDouble();
    }
    public String PedirNombre() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del propietario: ");
        return scanner.nextLine();
    }
    public String PedirPlaca() {
        scanner.nextLine();
        System.out.print("Ingrese la placa del vehículo: ");
        return scanner.nextLine();
    }
    public String PedirDescripcion() {
        scanner.nextLine();
        System.out.print("Ingrese la descripción del servicio: ");
        return scanner.nextLine();
    }
    public double PedirCosto() {
        System.out.print("Ingrese el costo estimado: ");
        return scanner.nextDouble();
    }
    public int MostrarMenuModificar() {
        System.out.println("\n===== MODIFICAR ORDEN =====");
        System.out.println("1. Modificar nombre");
        System.out.println("2. Modificar placa");
        System.out.println("3. Modificar descripción");
        System.out.println("4. Modificar costo");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
    public void MostrarOrden(Orden_Servicio orden) {
        System.out.println("\n===== ORDEN DE SERVICIO =====");
        System.out.println("Número de orden: " + orden.getNum_Orden());
        System.out.println("Propietario: " + orden.getNombre());
        System.out.println("Placa: " + orden.getPlaca());
        System.out.println("Descripción: " + orden.getDescripcion());
        System.out.println("Costo: " + orden.getCosto());
    }
    public void MostrarOrdenes(ArrayList<Orden_Servicio> ordenes) {
        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes para mostrar");
            return;
        }
        for (Orden_Servicio orden : ordenes) {
            MostrarOrden(orden);
        }
    }
    public void MostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public void MostrarCostoTotal(double total) {
        System.out.println("Costo total de las órdenes: " + total);
    }
    public void MostrarCostoPromedio(double promedio) {
        System.out.println("Costo promedio de las órdenes: " + promedio);
    }
    public void LimpiarScanner() {
        scanner.nextLine();
    }
}