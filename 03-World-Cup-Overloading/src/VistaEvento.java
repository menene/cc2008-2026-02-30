import java.util.Scanner;

public class VistaEvento {
    public Scanner sc = new Scanner(System.in);
    
    int error = 0;

    // Menú
    public void menu() {

        System.out.println("\n======================================");
        System.out.println("   FIFA WOMEN'S WORLD CUP 2027");
        System.out.println("======================================");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

    }

    // Solicita los datos del comprador
    public Usuario comprador() {
        

        System.out.println("\n----- NUEVO COMPRADOR -----");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        int cantidad = 0;

        do{
        System.out.print("Cantidad de boletos: ");
         if (sc.hasNextInt()) {
            
             cantidad = sc.nextInt();
             sc.nextLine();
             error = 0;

            } else {
             error = 1;
             sc.nextLine(); 
             System.out.println("Ingrese un número válido. ");

            }
        } while (error != 0);
        
        float presupuesto = 0;

        do{
        System.out.print("Presupuesto máximo: ");
         if (sc.hasNextInt()) {
            
             presupuesto = sc.nextFloat();
             sc.nextLine();
             error = 0;

            } else {
             error = 1;
             sc.nextLine(); 
             System.out.println("Ingrese un número válido. ");

            }
        } while (error != 0);


        return new Usuario(nombre, correo, cantidad, presupuesto);

    }

    // Vompra exitosa
    public void compra(String nombre, String localidad,
                       int cantidad, float total) {

        System.out.println("\n=====================================");
        System.out.println("        COMPRA EXITOSA");
        System.out.println("======================================");
        System.out.println("Comprador: " + nombre);
        System.out.println("Localidad: " + localidad);
        System.out.println("Boletos comprados: " + cantidad);
        System.out.println("Total pagado: $" + total);
        System.out.println("======================================");

    }

    // Compra rechazada
    public void compraRechazada(String motivo) {

        System.out.println("\n======================================");
        System.out.println("      COMPRA RECHAZADA");
        System.out.println("======================================");
        System.out.println(motivo);
        System.out.println("======================================");

    }

    // Disponibilidad total
    public void disponibilidadTotal(int disponibles, int vendidos) {

        System.out.println("\n======================================");
        System.out.println(" DISPONIBILIDAD DEL EVENTO");
        System.out.println("======================================");
        System.out.println("Boletos disponibles: " + disponibles);
        System.out.println("Boletos vendidos: " + vendidos);

    }

    // Leer localidad
    public int leerLocalidad() {

        int localidadALeer = 0;
         do{
        System.out.println("\n¿Qué localidad desea consultar?");
        System.out.println("1. Localidad 1");
        System.out.println("5. Localidad 5");
        System.out.println("10. Localidad 10");
        System.out.print("Opción: ");
        if (sc.hasNextInt()) {
             error = 0;
             localidadALeer = sc.nextInt();
            } else {
             error = 1;
             sc.nextLine(); 
             System.out.println("Ingrese una opción válida. ");

            }
        } while (error != 0);
        return localidadALeer;
    }

    // Disponibilidad individual
    public void disponibilidadLocal(int disponibles) {

        System.out.println("\nBoletos disponibles: " + disponibles);

    }

    // Mostrar ganancias
    public void mostrarGanancias(float ganancias) {

        System.out.println("\n======================================");
        System.out.println("       REPORTE DE CAJA");
        System.out.println("======================================");
        System.out.println("Ganancias del evento: $" + ganancias);

    }

    // Mostrar información del ticket
    public void mostrarTicket(Ticket ticket) {

        System.out.println("\n======================================");
        System.out.println("        TICKET GENERADO");
        System.out.println("======================================");
        System.out.println("Número: " + ticket.getNumTicket());
        System.out.println("Rango: " + ticket.getLimiteInferior()
                + " - " + ticket.getLimiteSuperior());

        if (ticket.getValidTicket()) {
            System.out.println("Estado: APTO PARA COMPRAR");
        } else {
            System.out.println("Estado: NO APTO PARA COMPRAR");
        }

        System.out.println("======================================");

    }

}