import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() 
    {
        this.scanner = new Scanner(System.in);
    }

    public String LeerNombre() 
    {
        System.out.print("Ingrese su nombre: ");
        return scanner.nextLine();
    }

    public String LeerEmail() 
    {
        System.out.print("Ingrese su email: ");
        return scanner.nextLine();
    }

    public int LeerComprTickets() 
    {
        System.out.print("Ingrese la cantidad de tickets que quiera comprar: ");
        int tickets = scanner.nextInt();
        scanner.nextLine();
        return tickets;
    }

    public double LeerPresupuesto() 
    {
        System.out.print("Ingrese su presupuesto para la compra: $");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine();
        return presupuesto;
    }

    public int MenuOpciones() {
        System.out.println("\n-------MENÚ DE COMPRA 2027 FIFA Women's World Cup-------");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione la opción deseada: ");
        
        int opcion = 0;

        //Esto es para que el número que se ingrese sea igual al de alguna opción disponible.
        while (true) {
            if (scanner.hasNextInt()) 
            {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 6) 
                {
                break;
                }
            } 
            else 
            {
            scanner.next();
            }
            System.out.print("Por favor, ingrese un número del 1 y 6: ");
        }
        scanner.nextLine();
        return opcion;
    }
}
