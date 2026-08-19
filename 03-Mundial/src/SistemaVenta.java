import java.util.Random;

public class SistemaVenta {
    private Localidad[] localidades;

    public SistemaVenta() {
        localidades = new Localidad[3];

        localidades[0] = new Localidad(1, 100, 20);
        localidades[1] = new Localidad(5, 500, 20);
        localidades[2] = new Localidad(10, 1000, 20);
    }

    public Localidad seleccionarLocalidadAleatoria() {
        Random random = new Random();
        int posicion = random.nextInt(localidades.length);

        return localidades[posicion];
    }

    public String procesarCompra(
            Comprador comprador,
            SolicitudCompra solicitud
    ) {
        if (!solicitud.esTicketApto()) {
            return "El ticket "
                    + solicitud.getNumeroTicket()
                    + " no es apto para comprar boletos.";
        }

        Localidad localidadSeleccionada =
                seleccionarLocalidadAleatoria();

        // Validación 1:
        if (localidadSeleccionada.getDisponibles() == 0) {
            return "La localidad "
                    + localidadSeleccionada.getNumeroLocalidad()
                    + " ya no tiene espacio disponible.";
        }

        // Validación 2:
        int cantidadAVender = Math.min(
                solicitud.getCantidadBoletos(),
                localidadSeleccionada.getDisponibles()
        );

        // Validación 3:
        if (localidadSeleccionada.getPrecio()
                > solicitud.getPresupuestoMaximo()) {

            return "La localidad "
                    + localidadSeleccionada.getNumeroLocalidad()
                    + " cuesta $"
                    + String.format(
                            "%.2f",
                            localidadSeleccionada.getPrecio()
                    )
                    + " por boleto y supera el presupuesto máximo.";
        }

        localidadSeleccionada.venderBoletos(cantidadAVender);

        double totalCompra =
                cantidadAVender * localidadSeleccionada.getPrecio();

        return "Compra realizada para "
                + comprador.getNombre()
                + "\nTicket: "
                + solicitud.getNumeroTicket()
                + "\nLocalidad: "
                + localidadSeleccionada.getNumeroLocalidad()
                + "\nBoletos vendidos: "
                + cantidadAVender
                + "\nTotal: $"
                + String.format("%.2f", totalCompra);
    }

    public String consultarDisponibilidad() {
        StringBuilder reporte = new StringBuilder();
        int totalDisponibles = 0;

        for (Localidad localidad : localidades) {
            reporte.append("Localidad ")
                    .append(localidad.getNumeroLocalidad())
                    .append(": vendidos = ")
                    .append(localidad.getBoletosVendidos())
                    .append(", disponibles = ")
                    .append(localidad.getDisponibles())
                    .append("\n");

            totalDisponibles += localidad.getDisponibles();
        }

        reporte.append("Total de boletos disponibles: ")
                .append(totalDisponibles);

        return reporte.toString();
    }

    public String consultarDisponibilidad(
            int numeroLocalidad
    ) {
        Localidad localidad =
                buscarLocalidad(numeroLocalidad);

        if (localidad == null) {
            return "La localidad ingresada no existe.";
        }

        return "Localidad "
                + localidad.getNumeroLocalidad()
                + ": vendidos = "
                + localidad.getBoletosVendidos()
                + ", disponibles = "
                + localidad.getDisponibles();
    }

    public double calcularReporteCaja() {
        double total = 0;

        for (Localidad localidad : localidades) {
            total += localidad.getBoletosVendidos()
                    * localidad.getPrecio();
        }

        return total;
    }

    private Localidad buscarLocalidad(
            int numeroLocalidad
    ) {
        for (Localidad localidad : localidades) {
            if (localidad.getNumeroLocalidad()
                    == numeroLocalidad) {
                return localidad;
            }
        }

        return null;
    }
}