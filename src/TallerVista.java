import java.util.List;
import java.util.Scanner;

public class TallerVista {

    private Scanner scanner;

    public TallerVista() {
        scanner = new Scanner(System.in);
    }

    //menu
    public void mostrarMenu() {
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
    }

    //pedir texto
    public String solicitarDato(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    //ahora pedir numeros
    public int solicitarEntero(String mensaje) {
        System.out.print(mensaje);
        String entrada = scanner.nextLine();
        return Integer.parseInt(entrada);
    }

    public double solicitarDouble(String mensaje) {
        System.out.print(mensaje);
        String entrada = scanner.nextLine();
        return Double.parseDouble(entrada);
    }

    //con estos, si el usuario mete algun dato que no va aqui, 
    //no lo agarro aca en vista, si no que lo mando a controlador con try catch

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarOrden(OrdenServicio orden) {
        System.out.println(orden);
    }


    public void mostrarOrdenes(List<OrdenServicio> ordenes) {
        if (ordenes.isEmpty()) {
            System.out.println("No hay órdenes para mostrar.");
            return;
        }

        for (OrdenServicio orden : ordenes) {
            System.out.println("\n" + orden);
        }
    }

}