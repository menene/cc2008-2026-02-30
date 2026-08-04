public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Sistema sistema = new Sistema();

        //LAs 3 localidades (numero, precio, boletos)
        Localidad loc1 = new Localidad(1, 100, 20);
        Localidad loc5 = new Localidad(5, 500, 20);
        Localidad loc10 = new Localidad(10, 1000, 20);

        Comprador compradorActual = null;
        int continuar = 1;

        while (continuar == 1) 
        {
            int opcion = menu.MenuOpciones();

            switch (opcion) 
            {
                //La opción 1 es para registrarse.
                case 1:
                    String nombre = menu.LeerNombre();
                    String email = menu.LeerEmail();
                    int tickets = menu.LeerComprTickets();
                    if (tickets <= 0) 
                    {
                        System.out.println("No se pueden comprar tickets iguales o menores a 0");
                        break;
                    }
                    double presupuesto = menu.LeerPresupuesto();
                    if (presupuesto <= 0) 
                    {
                        System.out.println("No se puede tener un presupuesto igual o menor a 0");
                        break;
                    }
                    compradorActual = new Comprador(nombre, email, tickets, presupuesto);
                    System.out.println("Su registro ha sido exitoso");
                    break;

                //La opción 2 es para comprar
                case 2:
                    //Para corroborar que alguien esté registrado
                    if (compradorActual == null) 
                    {
                        System.out.println("Debe de registrar primero antes de comprar, seleccione la opción 1");
                        break;
                    }

                    //Se genera el ticket y genera los números de rango
                    Ticket ticket = new Ticket();
                    int numTicket = ticket.GenerarTicket();
                    int numA = sistema.GenerarNumA();
                    int numB = sistema.GenerarNumB();

                    ticket.setNumA(numA);
                    ticket.setNumB(numB);

                    System.out.println("\nTicket generado: " + numTicket);
                    System.out.println("Rango de validación de " + Math.min(numA, numB) + " a " + Math.max(numA, numB));

                    //La parte de la validación del ticket.
                    if (ticket.TicketValido()) 
                    {}
                    else
                    {
                        System.out.println("El ticket generado no ha podido validarse, por favor intentelo de nuevo");
                        break;
                    }

                    System.out.println("El ticket se ha validado");

                    //Asignación al azar de localidad
                    int locAsignada = sistema.GenerarLoc();
                    Localidad localidadSeleccionada = null;
                    if (locAsignada == 1) localidadSeleccionada = loc1;
                    else if (locAsignada == 5) localidadSeleccionada = loc5;
                    else if (locAsignada == 10) localidadSeleccionada = loc10;

                    System.out.println("Localidad asignada aleatoriamente: localidad " + locAsignada + " - precio: $" + localidadSeleccionada.getPrecioLoc());

                    //Validar si todavía existe espacio
                    if (sistema.CantidadValida(localidadSeleccionada.getCapacidad(), compradorActual.getTicketsCompr(), localidadSeleccionada.getVendidos())) 
                    {}
                    else
                    {
                        System.out.println("NO SE HA PODIDO REALIZAR LA COMPRA. Localidad asignada sin espacio.");
                        break;
                    }

                    //Validación 
                    int disponibles = localidadSeleccionada.getCapacidad() - localidadSeleccionada.getVendidos();
                    int ticketsAVender = compradorActual.getTicketsCompr();
                    if (ticketsAVender > disponibles) {
                        ticketsAVender = disponibles;
                        System.out.println("SOLO TENEMOS DISPONIBLES " + disponibles + " BOLETOS. Se realizará la compra con el máximo posible: " + ticketsAVender + " boletos.");
                    }

                    if (sistema.PresupuestoValido(ticketsAVender, compradorActual.getPresupuesto(), localidadSeleccionada.getPrecioLoc())) 
                    {
                        localidadSeleccionada.setVendidos(localidadSeleccionada.getVendidos() + ticketsAVender);
                        System.out.println("Compra realizada");
                        System.out.println("Se compraron " + ticketsAVender + " ticket(s) en la Localidad " + localidadSeleccionada.getNumLoc() + " por un total de $" + (ticketsAVender * localidadSeleccionada.getPrecioLoc()));
                        break;
                    }
                    else
                    {
                        System.out.println("NO SE HA PODIDO REALIZAR LA COMPRA. Su presupuesto es insuficiente");
                        break;
                    }

                case 3:
                    System.out.println("\n-------DISPONIBILIDAD TOTAL-------");
                    int disp1 = loc1.getCapacidad() - loc1.getVendidos();
                    int disp5 = loc5.getCapacidad() - loc5.getVendidos();
                    int disp10 = loc10.getCapacidad() - loc10.getVendidos();

                    System.out.println("Localidad 1: " + loc1.getVendidos() + " vendidos - " + disp1 + " disponibles");
                    System.out.println("Localidad 5: " + loc5.getVendidos() + " vendidos - " + disp5 + " disponibles");
                    System.out.println("Localidad 10: " + loc10.getVendidos() + " vendidos - " + disp10 + " disponibles");
                    System.out.println("Total disponible: " + (disp1 + disp5 + disp10) + " boletos.");
                    break;

                case 4:
                    System.out.println("\n-------DISPONIBILIDAD INDIVIDUAL-------");
                    System.out.print("Ingrese el número de la localidad a consultar (1, 5, 10): ");
                    int numConsultar = menu.LeerComprTickets(); // Reutiliza la lectura de enteros
                    if (numConsultar == 1) 
                    {
                        System.out.println("Localidad 1 - Disponibles: " + (loc1.getCapacidad() - loc1.getVendidos()));
                    } 
                    else if (numConsultar == 5) 
                    {
                        System.out.println("Localidad 5 - Disponibles: " + (loc5.getCapacidad() - loc5.getVendidos()));
                    } 
                    else if (numConsultar == 10) 
                    {
                        System.out.println("Localidad 10 - Disponibles: " + (loc10.getCapacidad() - loc10.getVendidos()));
                    } 
                    else 
                    {
                        System.out.println("El número ingresado no corresponde a una localidad actual");
                    }
                    break;

                case 5:
                    System.out.println("\n-------REPORTE DE CAJA-------");
                    double totalLoc1 = loc1.getVendidos() * loc1.getPrecioLoc();
                    double totalLoc5 = loc5.getVendidos() * loc5.getPrecioLoc();
                    double totalLoc10 = loc10.getVendidos() * loc10.getPrecioLoc();
                    double totalLocales = totalLoc1 + totalLoc5 + totalLoc10;

                    System.out.println("Localidad 1: $" + totalLoc1);
                    System.out.println("Localidad 5: $" + totalLoc5);
                    System.out.println("Localidad 10: $" + totalLoc10);
                    System.out.println("TOTAL RECAUDADO: $" + totalLocales);
                    break;

                case 6:
                    continuar = 0;
                    System.out.println("Esperamos que vuelva pronto");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}