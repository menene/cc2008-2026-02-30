import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Vista vista = new Vista();
        SistemaVentas sistema = new SistemaVentas();

        int opcion;

        do {

            opcion = vista.mostrarMenu();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Cantidad de boletos: ");
                    int cantidad = sc.nextInt();

                    System.out.print("Presupuesto: ");
                    double presupuesto = sc.nextDouble();
                    sc.nextLine();

                    sistema.nuevoComprador(nombre, email, cantidad, presupuesto);

                    break;

                case 2:

                    sistema.nuevaSolicitud();

                    break;

                case 3:

                    for (Localidad l : sistema.disponibilidadTotal()) {

                        System.out.println(
                                "Localidad " + l.getNumero()
                                + " | Disponibles: " + l.disponibles()
                        );

                    }

                    break;

                case 4:

                    System.out.print("Ingrese la localidad (1, 5 o 10): ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    Localidad localidad = sistema.disponibilidadLocalidad(numero);

                    if (localidad != null) {

                        System.out.println("Disponibles: " + localidad.disponibles());

                    } else {

                        System.out.println("Localidad no encontrada.");

                    }

                    break;

                case 5:

                    System.out.println("Total recaudado: $" + sistema.reporteCaja());

                    break;

                case 6:

                    System.out.println("Saliendo del sistema...");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 6);

        sc.close();

    }
}