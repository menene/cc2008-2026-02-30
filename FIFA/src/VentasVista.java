import java.util.Scanner;

public class VentasVista {
    private Scanner scanner;

    public VentasVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.print("""
                
                === SISTEMA DE VENTA DE BOLETOS ===
                1. Nuevo Comprador
                2. Nueva Solicitud de Boletos
                3. Consultar Disponibilidad Total
                4. Consultar Disponibilidad Individual
                5. Reporte de Caja
                6. Salir
                Seleccione una opción:\s""");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public Comprador leerComprador() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();
        
        System.out.print("Cantidad de boletos a comprar: ");
        int cantidad = scanner.nextInt();
        
        System.out.print("Presupuesto máximo ($): ");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine();
        return new Comprador(nombre, email, cantidad, presupuesto);
    }

    public int pedirIdLocalidad() {
        System.out.print("Ingrese el ID de la localidad (1, 5 o 10): ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }
}