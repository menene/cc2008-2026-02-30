import java.util.Scanner;

public class VistaConsola {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("==== Menu ====");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Solicitud de entradas");
        System.out.println("3. Revisar disponibilad de entradas");
        System.out.println("4. Revisar disponibilad de entrdas individuales");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        
    }

    public Comprador leerComprador(){

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email= scanner.nextLine();

        System.out.print("Cantidad de boletos deseados: ");
        int cantidad = scanner.nextInt();

        System.out.print("Presupuesto disponible: ");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine();

        return new Comprador(nombre, email, cantidad, presupuesto);
    }

    public String leerCodigoAutorizacion(){

        System.out.print("Ingrese el codigo de acceso: ");
        return scanner.nextLine();

    }

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }
}