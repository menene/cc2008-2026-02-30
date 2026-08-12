package model;

public class SistemaBoletos {

    private Localidad[] localidades;
    private Comprador compradorActual;
    private Ticket ticketActual;

    public SistemaBoletos() {

        localidades = new Localidad[3];

        localidades[0] = new Localidad(1, 100);
        localidades[1] = new Localidad(5, 500);
        localidades[2] = new Localidad(10, 1000);

        compradorActual = null;
        ticketActual = null;
    }

    public void nuevoComprador(Comprador comprador) {
        compradorActual = comprador;
    }

    public String solicitarCompra() {

        if (compradorActual == null) {
            return "No hay comprador";
        }

        ticketActual = new Ticket();

        if (!ticketActual.validarTicket()) {

            return "Solicitud Rechazada"
                    + "\nTicket: " + ticketActual.getNumeroTicket()
                    + "\na = " + ticketActual.getA()
                    + "\nb = " + ticketActual.getB()
                    + "\nEl ticket no fue seleccionado para comprar";
        }

        ticketActual.asignarLocalidad(localidades);

        Localidad localidad = ticketActual.getLocalidad();

        if (!localidad.hayEspacio()) {

            return "La localidad "
                    + localidad.getNumero()
                    + " ya no tiene espacio disponible";
        }

        int boletosAVender = localidad.cantidadDisponibleParaVenta(
                compradorActual.getCantidadBoletos());

        if (boletosAVender == 0) {

            return "No existen boletos disponibles";
        }

        double total = boletosAVender * localidad.getPrecio();

        if (total > compradorActual.getPresupuestoMaximo()) {

            return "Presupuesto insuficiente."
                    + "\nCosto: $" + total
                    + "\nPresupuesto disponible: $"
                    + compradorActual.getPresupuestoMaximo();
        }

        localidad.venderBoletos(boletosAVender);

        String mensaje = "Compra Existosa"
                + "\nTicket: " + ticketActual.getNumeroTicket()
                + "\na = " + ticketActual.getA()
                + "\nb = " + ticketActual.getB()
                + "\nLocalidad: " + localidad.getNumero()
                + "\nPrecio por boleto: $" + localidad.getPrecio();

        if (boletosAVender < compradorActual.getCantidadBoletos()) {

            mensaje += "\nSolo fue posible vender "
                    + boletosAVender
                    + " boleto(s) de los "
                    + compradorActual.getCantidadBoletos()
                    + " solicitados.";
        } else {

            mensaje += "\nBoletos comprados: " + boletosAVender;
        }

        mensaje += "\nTotal pagado: $" + total;

        return mensaje;
    }

    public String consultarDisponibilidadTotal() {

        String reporte = "Disponibilidad\n\n";

        for (Localidad localidad : localidades) {

            reporte += "Localidad " + localidad.getNumero()
                    + "\nVendidos: " + localidad.getVendidos()
                    + "\nDisponibles: " + localidad.getDisponibles()
                    + "\n\n";
        }

        return reporte;
    }

    public String consultarDisponibilidadIndividual(int numero) {

        for (Localidad localidad : localidades) {

            if (localidad.getNumero() == numero) {

                return "Localidad " + numero
                        + "\nVendidos: " + localidad.getVendidos()
                        + "\nDisponibles: " + localidad.getDisponibles();
            }
        }

        return "La localidad no existe";
    }

    public double reporteCaja() {

        double total = 0;

        for (Localidad localidad : localidades) {

            total += localidad.getIngresos();
        }

        return total;
    }

    public Comprador getCompradorActual() {
        return compradorActual;
    }

    public Ticket getTicketActual() {
        return ticketActual;
    }

    public Localidad[] getLocalidades() {
        return localidades;
    }
}