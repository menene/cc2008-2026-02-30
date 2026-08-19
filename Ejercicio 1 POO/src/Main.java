import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Venta venta = new Venta();

        int opcion;

        do {

            
            System.out.println("      FIFA WOMEN'S WORLD CUP 2027");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\n===== NUEVO COMPRADOR =====");

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Cantidad de boletos: ");
                    int cantidad = sc.nextInt();

                    System.out.print("Presupuesto máximo: ");
                    double presupuesto = sc.nextDouble();
                    sc.nextLine();

                    Comprador comprador =
                            new Comprador(nombre, email, cantidad, presupuesto);

                    venta.nuevoComprador(comprador);

                    break;

                case 2:

                    venta.solicitarBoletos();

                    break;

                case 3:

                    venta.consultarDisponibilidadTotal();

                    break;

                case 4:

                    System.out.print("\nIngrese la localidad (1, 5 o 10): ");

                    int localidad = sc.nextInt();

                    venta.consultarDisponibilidadIndividual(localidad);

                    break;

                case 5:

                    System.out.println("\n===== REPORTE DE CAJA =====");
                    System.out.println("Total generado: $"
                            + venta.reporteCaja());

                    break;

                case 6:

                    System.out.println("\nGracias por utilizar el sistema.");

                    break;

                default:

                    System.out.println("\nOpción inválida.");

            }

        } while (opcion != 6);

        sc.close();

    }

}