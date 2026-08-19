import java.util.Scanner;


public class VistaSistema {

    
    private Scanner scanner;

  
    public VistaSistema() {
        scanner = new Scanner(System.in);
    }

    
    public Comprador leerComprador() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Cantidad de boletos a comprar: ");
        int cantidadBoletos = scanner.nextInt();
        scanner.nextLine(); // limpiar el buffer despues de leer un numero

        System.out.print("Presupuesto maximo: ");
        double presupuesto = scanner.nextDouble();

        return new Comprador(nombre, email, cantidadBoletos, presupuesto);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
