package view;
import controller.GestorVentas;
import model.Localidad;
import model.Comprador;
import java.util.Scanner;

public class Menu {
    private final GestorVentas gestor;
    private final Scanner reader;
 
    public Menu(GestorVentas gestor) {
        this.gestor = gestor;
        this.reader = new Scanner(System.in);
    }

    private int leerEntero() {
        while (!reader.hasNextInt()) {
            System.out.print("Ingrese un numero entero valido: ");
            reader.next();
        }
        return reader.nextInt();
    }

    private double leerDouble() {
        while (!reader.hasNextDouble()) {
            System.out.print("Ingrese un numero valido: ");
            reader.next();
        }
        return reader.nextDouble();
    }

    private Comprador solicitarDatosComprador() {
        reader.nextLine(); // limpia el salto de linea pendiente del ultimo nextInt()
        System.out.print("Nombre: ");
        String nombre = reader.nextLine();
        System.out.print("Email: ");
        String email = reader.nextLine();
        System.out.print("Cantidad de boletos a comprar: ");
        int cantidad = leerEntero();
        System.out.print("Presupuesto maximo: $");
        double presupuesto = leerDouble();
        return new Comprador(nombre, email, cantidad, presupuesto);
    }

    private void procesarNuevaSolicitud() {
        if (gestor.getCompradorActual() == null) {
            System.out.println("Debe registrar un comprador primero (opcion 1).");
            return;
        }
        System.out.println(gestor.procesarSolicitud(gestor.getCompradorActual()));
    }

    private void consultarIndividual() {
        Localidad[] localidades = gestor.getLocalidades();
        System.out.println("Seleccione una localidad:");
        for (int i = 0; i < localidades.length; i++) {
            System.out.println((i + 1) + ". " + localidades[i].getNombre());
        }
        int seleccion = leerEntero();
        if (seleccion < 1 || seleccion > localidades.length) {
            System.out.println("Opcion invalida.");
            return;
        }
        System.out.println(gestor.disponibilidadIndividual(localidades[seleccion - 1]));
    }

    public void mostrarMenu() {
        System.out.println("\n===== MENU DE VENTAS - MUNDIAL FEMENINO 2027 =====");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    

    public void ejecutar() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero();
 
            switch (opcion) {
                case 1:
                    Comprador nuevo = solicitarDatosComprador();
                    gestor.setCompradorActual(nuevo);
                    System.out.println("Comprador registrado: " + nuevo.getNombre());
                    break;
                case 2:
                    procesarNuevaSolicitud();
                    break;
                case 3:
                    System.out.println(gestor.disponibilidadTotal());
                    break;
                case 4:
                    consultarIndividual();
                    break;
                case 5:
                    System.out.printf("Total recaudado: $%.2f%n", gestor.reporteCaja());
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Gracias por usar el sistema. Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        }
        reader.close();
    }
}
