import java.util.Scanner;

public class Vista {

    // Constructor
    public Vista() {
    }

    // Muestra el menú principal
    public void mostrarMenu() {

        System.out.println("\n===== FIFA Women's World Cup 2027 =====");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

    }

    // Solicita los datos del comprador
    public Comprador solicitarDatosComprador(Scanner teclado) {

        Comprador comprador = new Comprador();

        System.out.print("Nombre: ");
        comprador.setNombre(teclado.nextLine());

        System.out.print("Email: ");
        comprador.setEmail(teclado.nextLine());

        System.out.print("Cantidad de tickets: ");
        comprador.setCantidadTickets(teclado.nextInt());

        System.out.print("Presupuesto máximo: ");
        comprador.setPresupuestoMaximo(teclado.nextDouble());

        teclado.nextLine(); // Limpia el buffer

        return comprador;

    }

    // Muestra los resultados de la compra
    public void mostrarResultadosCompra(Comprador comprador,
                                        Ticket ticket,
                                        Localidad localidad) {

        System.out.println("\n===== RESULTADO DE LA COMPRA =====");
        System.out.println("Comprador: " + comprador.getNombre());
        System.out.println("Correo: " + comprador.getEmail());
        System.out.println("Ticket: " + ticket.getNumeroTicket());
        System.out.println("Localidad: " + localidad.getNumeroLocalidad());
        System.out.println("Precio por boleto: Q" + localidad.getPrecio());

    }

    // Muestra un mensaje
    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);

    }

    // Finaliza el programa
    public void salir() {

        System.out.println("\nGracias por utilizar el sistema.");

    }

}