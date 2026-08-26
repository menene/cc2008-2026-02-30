import java.util.Scanner;

public class VistaConsola {

    private Scanner scanner;

    public VistaConsola() {

        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {

        System.out.println("\n--- SISTEMA DE TALLER AUTOMOTRIZ ---");
        System.out.println("1. Agregar orden");
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

     public int solicitarNumeroOrden() {
        return leerEntero("Ingrese el numero de orden: ");
    }

    public String solicitarNombrePropietario() {
        System.out.print("Ingrese el nombre del propietario: ");
        return scanner.nextLine();
    }

    public String solicitarPlaca() {
        System.out.print("Ingrese la placa del vehiculo: ");
        return scanner.nextLine();
    }

    public String solicitarDescripcion() {
        System.out.print("Ingrese la descripcion del servicio: ");
        return scanner.nextLine();
    }

    public double solicitarCosto() {
        return leerDouble("Ingrese el costo estimado: ");
    }

    public void mostrarOrden(OrdenServicio orden) {

        System.out.println("\n--- ORDEN DE SERVICIO ---");
        System.out.println("Numero de orden: " + orden.getNumeroOrden());
        System.out.println("Propietario: " + orden.getNombrePropietario());
        System.out.println("Placa: " + orden.getPlacaVehiculo());
        System.out.println("Servicio: " + orden.getDescripcionServicio());
        System.out.println("Costo estimado: Q" + orden.getCostoEstimado());
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

    private int leerEntero(String mensaje) {

        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;

            } catch (NumberFormatException e) {
                System.out.println("Error! Debe ingresar un numero entero");
            }

        }

        return numero;
    }

    private double leerDouble(String mensaje) {

        double numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(scanner.nextLine());
                valido = true;

            } catch (NumberFormatException e) {
                System.out.println("Error! Debe ingresar un numero");
            }

        }

        return numero;
    }
}