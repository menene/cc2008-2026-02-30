package controller;
import java.util.Random;

import model.*;
import view.VistaEvento;

public class ControladorEvento {
    // Atributos
    private Evento evento;
    private VistaEvento vista = new VistaEvento();
    private Comprador comprador;
    private Ticket ticket;

    // Métodos
    // Se crea el evento y las localidades en el constructor.
    public ControladorEvento() {
        Localidad loc1 = new Localidad("Localidad 1", 100, 20);
        Localidad loc5 = new Localidad("Localidad 5", 500, 20);
        Localidad loc10 = new Localidad("Localidad 10", 1000, 20);
        evento = new Evento("2027 FIFA Women´s World Cup", loc1, loc5, loc10);
    }

    // Inicia el flujo del programa
    public void iniciar() {

        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu(evento.getNombre());

            switch (opcion) {
                case 1:
                    nuevoComprador();
                    break;
                case 2:
                    if (comprador == null) {
                        vista.mensajeFaltaDatosComprador();
                        break;
                    }
                    solicitudCompra();
                    break;
                
                case 3:
                    disponibilidad();
                    break;
                case 4:
                    disponibilidadPorLocalidad();
                    break;
                case 5:
                    reporteCaja();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    vista.mensajeOpcionInvalida();
                    break;
            }
            
        }

    }

    // Asigna una nueva instancia de comprador al actual
    private void nuevoComprador() {
        comprador = vista.leerComprador();
    }

    // Método que maneja toda la lógica y validación de una solicitud de compra
    private void solicitudCompra() {
        comprador.setCantidadYPresupuesto(vista.leerCantidadBoletosAComprar(), vista.leerPresupuesto());
        ticket = new Ticket();
        if (ticket.getValido()) {
            Random random = new Random();
            int numAleatorio = random.nextInt(3) + 1;
            Localidad locAsignada = evento.getLocalidad(numAleatorio);

            int disponibles = locAsignada.getBoletosDisponibles();
            if (disponibles > 0) {
                if (disponibles >= comprador.getCantidad()) {
                    float totalPagar = comprador.getCantidad() * locAsignada.getPrecio();

                    if (totalPagar <= comprador.getPresupuesto()) {
                        locAsignada.venderBoletos(comprador.getCantidad());
                        vista.mostrarCompra(
                        false, 
                                    locAsignada.getNombre(), 
                                    comprador.getCantidad(), 
                                    comprador.getCantidad() * locAsignada.getPrecio()
                                );
                    } else {
                        vista.mostrarCompraRechazada(3); // Rechazo por poco presupuesto
                    }      
                } else {
                    float totalPagar = disponibles * locAsignada.getPrecio();

                    if (totalPagar <= comprador.getPresupuesto()) {
                        locAsignada.venderBoletos(disponibles);
                        vista.mostrarCompra(
                                    true, 
                                    locAsignada.getNombre(), 
                                    disponibles, 
                                    disponibles * locAsignada.getPrecio()
                                );
                    } else {
                        vista.mostrarCompraRechazada(3); // Rechazo por poco presupuesto
                    } 
                }
            } else {
                vista.mostrarCompraRechazada(2); // Rechazo por falta de disponibilidad
            }
        } else {
            vista.mostrarCompraRechazada(1); //Rechazo por ticket no válido
        }
    }

    // Métodos que llaman a metodos de la vista y muestran datos en la terminal
    private void disponibilidad() {
        vista.mostrarDisponibilidad(evento.disponibilidad());
    }

    private void disponibilidadPorLocalidad() {
        int numLocalidad = vista.pedirLocalidad(evento.nombreLocalidades());
        vista.mostrarDisponibilidad(evento.disponibilidadPorLocalidad(numLocalidad));
    }

    private void reporteCaja() {
        vista.mostrarReporteCaja(evento.reporteCaja());
    }
}