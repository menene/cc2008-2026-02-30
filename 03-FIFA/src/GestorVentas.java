public class GestorVentas {

    // Constructor
    public GestorVentas() {
    }

    // Coordina el proceso de compra
    public Localidad procesarCompra(Comprador comprador,
                                    Ticket ticket,
                                    Localidad localidad1,
                                    Localidad localidad5,
                                    Localidad localidad10) {

        // Generar ticket
        boolean ticketValido = ticket.generarTicket();

        if (ticketValido == false) {

            System.out.println("El ticket no fue seleccionado para comprar.");
            return null;

        }

        // Asignar una localidad
        Localidad localidadAsignada =
                asignarLocalidad(localidad1, localidad5, localidad10);

        // Cantidad de boletos solicitados
        int cantidadVendida = comprador.getCantidadTickets();

        // Boletos disponibles
        int disponibles = localidadAsignada.espaciosDisponibles();

        // Si ya no hay boletos
        if (disponibles == 0) {

            System.out.println("No hay boletos disponibles en esta localidad.");
            return null;

        }

        // Venta parcial
        if (cantidadVendida > disponibles) {

            cantidadVendida = disponibles;

            System.out.println("Solo hay "
                    + disponibles
                    + " boletos disponibles.");

            System.out.println("Se venderán "
                    + cantidadVendida
                    + " boletos.");

        }

        // Validar presupuesto
        boolean presupuesto =
                validarPresupuesto(
                        comprador,
                        localidadAsignada,
                        cantidadVendida);

        if (presupuesto == false) {

            System.out.println("El presupuesto es insuficiente.");
            return null;

        }

        // Registrar venta
        venderTickets(localidadAsignada,
                cantidadVendida);

        System.out.println("Compra realizada con éxito.");

        return localidadAsignada;

    }

    // Asigna una localidad aleatoriamente
    private Localidad asignarLocalidad(Localidad localidad1,
                                       Localidad localidad5,
                                       Localidad localidad10) {

        int opcion = (int) (Math.random() * 3);

        if (opcion == 0) {

            return localidad1;

        } else if (opcion == 1) {

            return localidad5;

        } else {

            return localidad10;

        }

    }

    // Valida disponibilidad
    private boolean validarDisponibilidad(Localidad localidad,
                                          int cantidadTickets) {

        if (localidad.espaciosDisponibles() >= cantidadTickets) {

            return true;

        } else {

            return false;

        }

    }

    // Valida presupuesto
    private boolean validarPresupuesto(Comprador comprador,
                                       Localidad localidad,
                                       int cantidadTickets) {

        double totalCompra =
                cantidadTickets * localidad.getPrecio();

        if (comprador.getPresupuestoMaximo() >= totalCompra) {

            return true;

        } else {

            return false;

        }

    }

    // Registra la venta
    private void venderTickets(Localidad localidad,
                               int cantidadTickets) {

        int vendidos = localidad.getTicketsVendidos();

        vendidos = vendidos + cantidadTickets;

        localidad.setTicketsVendidos(vendidos);

    }

    // Consulta la disponibilidad total
    public void consultarDisponibilidadTotal(Localidad localidad1,
                                             Localidad localidad5,
                                             Localidad localidad10) {

        System.out.println("\n===== DISPONIBILIDAD TOTAL =====");

        System.out.println("Localidad "
                + localidad1.getNumeroLocalidad());
        System.out.println("Vendidos: "
                + localidad1.getTicketsVendidos());
        System.out.println("Disponibles: "
                + localidad1.espaciosDisponibles());

        System.out.println();

        System.out.println("Localidad "
                + localidad5.getNumeroLocalidad());
        System.out.println("Vendidos: "
                + localidad5.getTicketsVendidos());
        System.out.println("Disponibles: "
                + localidad5.espaciosDisponibles());

        System.out.println();

        System.out.println("Localidad "
                + localidad10.getNumeroLocalidad());
        System.out.println("Vendidos: "
                + localidad10.getTicketsVendidos());
        System.out.println("Disponibles: "
                + localidad10.espaciosDisponibles());

    }

    // Consulta la disponibilidad de una localidad
    public void consultarDisponibilidadIndividual(Localidad localidad) {

        System.out.println("\n===== DISPONIBILIDAD =====");

        System.out.println("Localidad: "
                + localidad.getNumeroLocalidad());

        System.out.println("Vendidos: "
                + localidad.getTicketsVendidos());

        System.out.println("Disponibles: "
                + localidad.espaciosDisponibles());

    }

    // Calcula el dinero generado
    public double reporteCaja(Localidad localidad1,
                              Localidad localidad5,
                              Localidad localidad10) {

        double cajaLocalidad1 =
                localidad1.getTicketsVendidos()
                        * localidad1.getPrecio();

        double cajaLocalidad5 =
                localidad5.getTicketsVendidos()
                        * localidad5.getPrecio();

        double cajaLocalidad10 =
                localidad10.getTicketsVendidos()
                        * localidad10.getPrecio();

        return cajaLocalidad1
                + cajaLocalidad5
                + cajaLocalidad10;

    }

}
