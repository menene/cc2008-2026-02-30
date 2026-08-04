import java.util.Random;

public class ControladorEvento {

    
    private Evento evento;
    private Usuario usuario;
    private Ticket ticket;
    private VistaEvento vista;

    // Constructor
    public ControladorEvento() {

        Localidad loc1 = new Localidad("Localidad 1", 100, 20);
        Localidad loc5 = new Localidad("Localidad 5", 500, 20);
        Localidad loc10 = new Localidad("Localidad 10", 1000, 20);

        evento = new Evento(
                "2027 FIFA Women's World Cup",
                loc1,
                loc5,
                loc10);

        vista = new VistaEvento();

    }

    // Metodo principal controlador
    public void controlador() {

        int opcion = 0;

        do {

            vista.menu();

            if (vista.sc.hasNextInt()) {

             opcion = vista.sc.nextInt();
             vista.sc.nextLine();

            } else {

             vista.sc.nextLine(); 
             opcion = 0;

            }

            switch (opcion) {

                case 1:

                    usuario();

                    break;

                case 2:

                    compra();

                    break;

                case 3:

                    disponibilidadTotal();

                    break;

                case 4:

                    disponibilidadLocal();

                    break;

                case 5:

                    vista.mostrarGanancias(evento.ganancias());

                    break;

                case 6:

                    System.out.println("Gracias por utilizar el sistema.");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 6);

    }

    // Crear un nuevo usuario
    public void usuario() {

        usuario = vista.comprador();

    }

    // Mostrar disponibilidad total
    public void disponibilidadTotal() {

        vista.disponibilidadTotal(
                evento.disponibilidadTotal(),
                evento.vendidosTotal());

    }

    // Mostrar disponibilidad individual
    public void disponibilidadLocal() {

        int localidad = vista.leerLocalidad();

        int disponibles = evento.disponibilidadLocal(localidad);

        if (disponibles == -1) {

            System.out.println("Localidad inválida.");

        } else {

            vista.disponibilidadLocal(disponibles);

        }

    }

    // Compra
    public void compra() {

        if (usuario == null) {

            vista.compraRechazada(
                    "Debe registrar un comprador primero.");

            return;

        }

        ticket = new Ticket();

        vista.mostrarTicket(ticket);

        if (!ticket.getValidTicket()) {

            vista.compraRechazada(
                    "El ticket no fue seleccionado para comprar.");

            return;

        }

        Random random = new Random();

        int numeroLocalidad = random.nextInt(3) + 1;

        Localidad localidadAsignada;

        if (numeroLocalidad == 1) {

            localidadAsignada = evento.getLocalidad1();

        } else if (numeroLocalidad == 2) {

            localidadAsignada = evento.getLocalidad2();

        } else {

            localidadAsignada = evento.getLocalidad3();

        }

        if (localidadAsignada.getBoletosDisponibles() == 0) {

            vista.compraRechazada(
                    "La " + localidadAsignada.getNombre()
                    + " ya no tiene boletos disponibles.");

            return;

        }

        // Cantidad que el usuario desea comprar
        int cantidad = usuario.getCantidad();

        // Venta parcial if insuficientes boletos
        if (cantidad > localidadAsignada.getBoletosDisponibles()) {

            System.out.println("\nSolo había "
                    + localidadAsignada.getBoletosDisponibles()
                    + " boletos disponibles.");

            cantidad = localidadAsignada.getBoletosDisponibles();

            System.out.println("Se venderán únicamente "
                    + cantidad + " boletos.");

        }

        float total = cantidad * localidadAsignada.getPrecio();

        // Validar presupuesto
        if (total > usuario.getPresupuesto()) {

            vista.compraRechazada(
                    "El presupuesto no alcanza para comprar en "
                    + localidadAsignada.getNombre());

            return;

        }

        // Actualizar boletos vendidos
        localidadAsignada.setBoletosComprados(
                localidadAsignada.getBoletosComprados() + cantidad);

        // Actualizar boletos disponibles
        localidadAsignada.setBoletosDisponibles(
                localidadAsignada.getBoletosDisponibles() - cantidad);

        // Mostrar compra realizada
        vista.compra(
                usuario.getNombre(),
                localidadAsignada.getNombre(),
                cantidad,
                total);

    }

}