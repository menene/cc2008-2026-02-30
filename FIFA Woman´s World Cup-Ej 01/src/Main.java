import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SistemaBoletos sistema = new SistemaBoletos();

        System.out.println("===== FIFA Women's World Cup =====");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Cantidad de boletos: ");
        int cantidad = scanner.nextInt();

        System.out.print("Presupuesto: ");
        double presupuesto = scanner.nextDouble();

        Comprador comprador = new Comprador(
                nombre,
                email,
                cantidad,
                presupuesto
        );

        sistema.procesarCompra(comprador);

        scanner.close();

    }

}

