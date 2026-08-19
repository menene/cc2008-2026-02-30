import java.util.Scanner;

public class Vista {
    private  final Scanner scanner = new Scanner(System.in);
    private Controlador controlador;
    public Vista(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        
        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){

                case 1:

                    nuevoComprador();

                    break;

                case 2:

                    controlador.compra();

                    break;

                case 3:

                    controlador.consultarDisponibilidadTotal();

                    break;

                case 4:

                    consultarIndividual();

                    break;

                case 5:

                    controlador.reporteCaja();

                    break;

                case 6:

                    System.out.println("Gracias por utilizar el sistema.");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while(opcion != 6);

    }
    public void nuevoComprador() {

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Cantidad de boletos: ");
        int cantidad = scanner.nextInt();

        System.out.print("Presupuesto máximo: ");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine();

        Comprador comprador = new Comprador(nombre, email, cantidad, presupuesto);
        controlador.setComprador(comprador);

    }
    public void consultarIndividual() {

        System.out.print("Ingrese la localidad (1,5,10): ");

        int numero = scanner.nextInt();
        scanner.nextLine();

        controlador.consultarDisponibilidadIndividual(numero);

    }
    
}
