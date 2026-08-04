public class ControladorVenta {
    private SistemaVenta sistemaVenta;
    private VistaConsola vista;
    private Comprador compradorActivo;

    public ControladorVenta(
            SistemaVenta sistemaVenta,
            VistaConsola vista
    ) {
        this.sistemaVenta = sistemaVenta;
        this.vista = vista;
        this.compradorActivo = null;
    }

    public void iniciar() {
        int opcion;

        do {
            vista.mostrarMenu();

            opcion = vista.leerEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {
                case 1:
                    crearComprador();
                    break;

                case 2:
                    crearSolicitud();
                    break;

                case 3:
                    mostrarDisponibilidadTotal();
                    break;

                case 4:
                    mostrarDisponibilidadIndividual();
                    break;

                case 5:
                    mostrarReporteCaja();
                    break;

                case 6:
                    vista.mostrarMensaje(
                            "Programa finalizado."
                    );
                    break;

                default:
                    vista.mostrarMensaje(
                            "Opción no válida."
                    );
            }

        } while (opcion != 6);
    }

    private void crearComprador() {
        String nombre = vista.leerTexto(
                "Ingrese el nombre: "
        );

        String email = vista.leerTexto(
                "Ingrese el email: "
        );

        compradorActivo =
                new Comprador(nombre, email);

        vista.mostrarMensaje(
                "Comprador activo creado correctamente."
        );
    }

    private void crearSolicitud() {
        if (compradorActivo == null) {
            vista.mostrarMensaje(
                    "Primero debe crear un comprador."
            );
            return;
        }

        int cantidad = vista.leerEntero(
                "Cantidad de boletos que desea comprar: "
        );

        double presupuesto = vista.leerDouble(
                "Presupuesto máximo por boleto: $"
        );

        if (cantidad <= 0 || presupuesto <= 0) {
            vista.mostrarMensaje(
                    "La cantidad y el presupuesto "
                            + "deben ser mayores que cero."
            );
            return;
        }

        SolicitudCompra solicitud =
                new SolicitudCompra(
                        cantidad,
                        presupuesto
                );

        String resultado =
                sistemaVenta.procesarCompra(
                        compradorActivo,
                        solicitud
                );

        vista.mostrarMensaje(resultado);
    }

    private void mostrarDisponibilidadTotal() {
        vista.mostrarMensaje(
                sistemaVenta.consultarDisponibilidad()
        );
    }

    private void mostrarDisponibilidadIndividual() {
        int numeroLocalidad = vista.leerEntero(
                "Ingrese la localidad que desea "
                        + "consultar (1, 5 o 10): "
        );

        vista.mostrarMensaje(
                sistemaVenta.consultarDisponibilidad(
                        numeroLocalidad
                )
        );
    }

    private void mostrarReporteCaja() {
        double total =
                sistemaVenta.calcularReporteCaja();

        vista.mostrarMensaje(
                "Dinero total generado: $"
                        + String.format("%.2f", total)
        );
    }
}