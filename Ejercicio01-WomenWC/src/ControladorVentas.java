public class ControladorVentas {

    private SistemaVentas sistemaVentas;
    private VistaVentas vista;
    private Comprador compradorActivo;

    public ControladorVentas() {
        this.sistemaVentas = new SistemaVentas();
        this.vista = new VistaVentas();
        this.compradorActivo = null;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();

            if (opcion == 1) {
            crearNuevoComprador();
            } else if (opcion == 2) {
                nuevaSolicitud();
            } else if (opcion == 3) {
                consultarDisponibilidadTotal();
            } else if (opcion == 4) {
                consultarDisponibilidadIndividual();
            } else if (opcion == 5) {
                reporteCaja();
            } else if (opcion == 6) {
                vista.mostrarMensaje("Saliendo del sistema");
                continuar = false;
            } else {
                vista.mostrarMensaje("Opción inválida.");
            }
        }
    }

    private void crearNuevoComprador() {
        String nombre = vista.pedirNombreComprador();
        String email = vista.pedirEmailComprador();

        compradorActivo = new Comprador(nombre, email);
        vista.mostrarMensaje("Comprador creado: " + compradorActivo .getNombre());
    }
    

    private void nuevaSolicitud() {
        if (compradorActivo == null) {
            vista.mostrarMensaje("Primero debes crear un comprador.");
            return;
        }

        int cantidad = vista.pedirCantidadBoletos();
        float presupuesto = vista.pedirPresupuesto();

        Ticket ticket = new Ticket(cantidad, presupuesto, compradorActivo);
        boolean aceptado = sistemaVentas.procesarSolicitud(ticket);

        if (aceptado) {
            vista.mostrarMensaje("¡Compra exitosa! Localidad: " + ticket.getLocalidadAsignada().getNombre()
                    + ", boletos vendidos: " + ticket.getCantidadVendida());
        } else {
            vista.mostrarMensaje("La solicitud no pudo completarse.");
        }
    }

    private void consultarDisponibilidadTotal() {
        vista.mostrarMensaje(sistemaVentas.mostrarDisponibilidad());
    }

    private void consultarDisponibilidadIndividual() {
        String nombre = vista.pedirNombreLocalidad();
        vista.mostrarMensaje(sistemaVentas.mostrarDisponibilidad(nombre));
    }

    private void reporteCaja() {
        vista.mostrarMensaje("Total recaudado: $" + sistemaVentas.calcularTotalRecaudado());
    }
}
        
