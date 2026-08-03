import java.util.Random;

public class TicketController {

    public TicketController() {
    }

    public String procesarCompra(String nombre, String email, int cantidadBoletos, double presupuesto) {

        Comprador comprador = new Comprador(nombre, email, cantidadBoletos, presupuesto);
        Ticket ticket = new Ticket();
        Random rd = new Random();

        Localidad[] localidades = {
                new Localidad(1, 100, 20, 20),
                new Localidad(5, 500, 20, 20),
                new Localidad(10, 1000, 20, 20)
        };

        ticket.setNumeroTicket(rd.nextInt(15000) + 1);
        ticket.setLimiteInf(rd.nextInt(15000) + 1);
        ticket.setLimiteSup(rd.nextInt(15000) + 1);

        int limiteInferior = Math.min(ticket.getLimiteInf(), ticket.getLimiteSup());
        int limiteSuperior = Math.max(ticket.getLimiteInf(), ticket.getLimiteSup());

        if (ticket.getNumeroTicket() < limiteInferior || ticket.getNumeroTicket() > limiteSuperior) {
            return "-----------------------------------------\n"
                    + "RESULTADO DE LA COMPRA\n"
                    + "-----------------------------------------\n"
                    + "Ticket generado: " + ticket.getNumeroTicket() + "\n"
                    + "Estado: Ticket no seleccionado para comprar.";
        }

        Localidad localidad = localidades[rd.nextInt(localidades.length)];

        if (localidad.getDisponibilidadEspacios() <= 0) {

            return "-----------------------------------------\n"
                    + "RESULTADO DE LA COMPRA\n"
                    + "-----------------------------------------\n"
                    + "Ticket: " + ticket.getNumeroTicket() + "\n"
                    + "Localidad: " + localidad.getLocalidadNumero() + "\n"
                    + "Estado: La localidad se encuentra agotada.";
        }

        int boletosVendidos = Math.min(cantidadBoletos, localidad.getDisponibilidadEspacios());

        double costoTotal = boletosVendidos * localidad.getPrecio();

        if (comprador.getPresupuestoMax() < costoTotal) {
            return "-----------------------------------------\n"
                    + "RESULTADO DE LA COMPRA\n"
                    + "-----------------------------------------\n"
                    + "Ticket: " + ticket.getNumeroTicket() + "\n"
                    + "Localidad: " + localidad.getLocalidadNumero() + "\n"
                    + "Precio por boleto: Q" + localidad.getPrecio() + "\n"
                    + "Costo total: Q" + costoTotal + "\n"
                    + "Estado: Presupuesto insuficiente.";
        }

        localidad.setDisponibilidadEspacios(
                localidad.getDisponibilidadEspacios() - boletosVendidos);

        String mensaje = "-----------------------------------------\n"
                + "COMPRA REALIZADA CON ÉXITO\n"
                + "-----------------------------------------\n"
                + "Nombre: " + comprador.getNombre() + "\n"
                + "Ticket: " + ticket.getNumeroTicket() + "\n"
                + "Localidad: " + localidad.getLocalidadNumero() + "\n"
                + "Precio por boleto: Q" + localidad.getPrecio() + "\n"
                + "Boletos vendidos: " + boletosVendidos + "\n"
                + "Costo total: Q" + costoTotal + "\n"
                + "Espacios restantes: "
                + localidad.getDisponibilidadEspacios();
        if (boletosVendidos < cantidadBoletos) {
            mensaje += "\n\nSolo fue posible vender "
                    + boletosVendidos
                    + " boletos debido a la disponibilidad.";
        }
        return mensaje;
    }
}