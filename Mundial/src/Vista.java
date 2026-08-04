import java.util.Scanner;

public class Vista{
    private Scanner scanner;
    public Vista(){
        scanner= new Scanner(System.in);
    }
    public void mostrar_Menu(){
        System.out.println("---------------------------Mostrar Menu ---------------------------");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar Disponibilidad Total");
        System.out.println("4. Consultar Disponibilidad Individual");
        System.out.println("5. Reporte de Caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione la opcion: ");

    }
    public int Leer_Opcion(){
        return scanner.nextInt();
    }
    public Usuario leer_Comprador(){
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Cantidad de boletos: ");
        int cantidad = scanner.nextInt();

        System.out.print("Presupuesto máximo: ");
        double presupuesto = scanner.nextDouble();
        return new Usuario(nombre,email,cantidad,presupuesto);
    }
}