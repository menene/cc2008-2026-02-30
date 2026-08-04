package controller;
import model.Localidad;
import model.Ticket;
import model.Comprador;
import java.util.Random;

public class GestorVentas {
    private Localidad[] localidades;
    private Comprador compradorActual;
    private double dineroRecaudado;
    private final Random random;

    public GestorVentas(Localidad[] localidades) {
        this.localidades = localidades;
        this.dineroRecaudado = 0.0;
        this.random = new Random();
    }

    private Ticket generarTicket() {
        return new Ticket();
    }

    private Localidad localidadAleatoria() {
        int indice = random.nextInt(localidades.length);
        return localidades[indice];
    }

    private boolean validarCompra(Localidad l, Comprador c) {
        if(!l.espacioDisponible()) {
            return false;
        }
        if(l.getPrecio() > c.getPresupuestoMax()) {
            return false;
        }
        return true;
    }

    public String procesarSolicitud(Comprador c){
        this.compradorActual = c;
        StringBuilder resultado = new StringBuilder();

        Ticket ticket = generarTicket();
        resultado.append("Ticket generado: ").append(ticket.getNumeroTicket()).append("\n");
        resultado.append("Rango sorteado: [")
            .append(Math.min(ticket.getNumeroA(), ticket.getNumeroB())).append(" - ")
            .append(Math.max(ticket.getNumeroA(), ticket.getNumeroB())).append("]\n");

        if(!ticket.isValid()) {
            resultado.append("El ticket no está dentro del rango sorteado. No se puede procesar la solicitud.\n");
            return resultado.toString();
        }
        resultado.append("El ticket está dentro del rango sorteado.\n");

        Localidad l = localidadAleatoria();
        ticket.setLocalidadAsig(l);
        resultado.append("Localidad asignada: ").append(l.getNombre()).append("\n");

        if(!validarCompra(l, c)) {
            resultado.append("No se puede procesar la compra. Verifique disponibilidad y presupuesto.\n");
            return resultado.toString();
        }
        
        int vendidos = l.ventaBoletos(c.getCantidadBoletos());
        double total = vendidos * l.getPrecio();
        dineroRecaudado += total;

        resultado.append("Compra exitosa. Boletos vendidos: ").append(vendidos)
            .append(" bolento(s) en: ").append(l.getNombre())
            .append(", Total: $").append(total).append("\n");

        return resultado.toString();
    }

    public String disponibilidadTotal() {
        StringBuilder sb = new StringBuilder("\n--- Disponibilidad total ---\n");
        for (Localidad l : localidades) {
            sb.append(l.getNombre()).append(": ")
                    .append(l.getBoletosVendidos()).append(" vendidos, ")
                    .append(l.getDisponibles()).append(" disponibles\n");
        }
        return sb.toString();
    }
 
    public String disponibilidadIndividual(Localidad l) {
        return l.getNombre() + ": " + l.getDisponibles()
                + " boletos disponibles de " + l.getCapacidadMax();
    }
 
    public double reporteCaja() {
        return dineroRecaudado;
    }

    public Comprador getCompradorActual() {
        return compradorActual;
    }
 
    public Localidad[] getLocalidades() {
        return localidades;
    }

    public void setCompradorActual(Comprador compradorActual) {
        this.compradorActual = compradorActual;
    }

}
