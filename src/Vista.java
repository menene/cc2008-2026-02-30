import java.util.List;
import java.util.Scanner;


public class Vista {

    private Scanner sc;

    public Vista() {
        sc = new Scanner(System.in);
    }


    public void mostrarMenu() {
        System.out.println("Taller");
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

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        String texto = sc.nextLine();
        return Integer.parseInt(texto.trim());
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        String texto = sc.nextLine();
        return Double.parseDouble(texto.trim());
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public void mostrarOrden(OrdenServicio orden) {
        System.out.println("Numero de orden : " + orden.getNumeroOrden());
        System.out.println("Propietario     : " + orden.getNombrePropietario());
        System.out.println("Placa            : " + orden.getPlacaVehiculo());
        System.out.println("Descripcion     : " + orden.getDescripcionServicio());
        System.out.println("Costo estimado  : Q" + orden.getCostoEstimado());
    }

    public void mostrarOrdenes(List<OrdenServicio> ordenes) {
        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes registradas actualmente.");
            return;
        }
        for (OrdenServicio o : ordenes) {
            mostrarOrden(o);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
