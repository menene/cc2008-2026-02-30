import java.util.Random;
import java.util.Scanner;
public class Controlador {

    private Venta venta;
    private Vista vista = new Vista();

    private Usuario comprador;
    private Ticket ticket;

    private Localidad localidad1;
    private Localidad localidad2;
    private Localidad localidad3;
    private Localidad localidadAsignada;

    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);

    private int cajaTotal = 0;
    private int cajaLocalidad1 = 0;
    private int cajaLocalidad2 = 0;
    private int cajaLocalidad3 = 0;
    private int presupuesto=0;

    public void Iniciar() {

        localidad1 = new Localidad("Localidad 1", 100);
        localidad2 = new Localidad("Localidad 5", 500);
        localidad3 = new Localidad("Localidad 10", 1000);

        boolean continuar = true;

        while (continuar) {

            int opcion = vista.Menu();

            switch (opcion) {

                case 1:
                    nuevoComprador();
                    break;
                case 2:
                    nuevaSolicitud();
                    break;
                case 3:
                    disponibilidadTotal();
                    break;
                case 4:
                    disponibilidadIndividual();
                    break;
                case 5:
                    reporteVentas();
                    break;
                case 6:
                    continuar = false;
                    vista.mensaje("\n Gracias por utilizar el sistema.");
                    break;
                default:
                    vista.mensaje("Opción inválida.");
            }
        }
    }

    private void nuevoComprador() {
        comprador = vista.leerComprador();
        vista.mensaje("\n Comprador registrado correctamente.");

    }

    private void nuevaSolicitud() {

        if (comprador == null) {
            vista.mensaje("\n Primero debe registrar un comprador.");
            return;
        }

        ticket = new Ticket();

        if (!ticket.validarTicket()) {
            vista.mensaje("\n El ticket no fue seleccionado para comprar.");
            return;
        }

        int opcion = random.nextInt(3);

        switch (opcion) {

            case 0:
                localidadAsignada = localidad1;
                break;
            case 1:
                localidadAsignada = localidad2;
                break;
            default:
                localidadAsignada = localidad3;
                break;
        }

        System.out.println("\nLa localidad asignada es: " + localidadAsignada.getLocalidad());
        System.out.println("Precio por boleto: Q"+ localidadAsignada.getPrecio());
        System.out.print("¿Desea continuar con la compra? (S/N): ");
        String respuesta = sc.nextLine();
        if (!respuesta.equalsIgnoreCase("S")) {
            vista.mensaje("Compra cancelada.");
            return;
            }

        if (localidadAsignada.getBoletosDisponibles() < comprador.getNoBoletos()) {
            vista.mensaje("No hay suficientes boletos disponibles.");
            return;
        }

        int total = comprador.getNoBoletos() * localidadAsignada.getPrecio();

        if (total > comprador.getPresupuesto()) {
            vista.mensaje("\n El presupuesto no alcanza para realizar la compra.");
            return;
        }

        venta = new Venta(comprador, localidadAsignada);

        localidadAsignada.venderBoletos(comprador.getNoBoletos());

        if (localidadAsignada == localidad1) {
            cajaLocalidad1 += venta.getPrecioTotal();
        } else if (localidadAsignada == localidad2) {
            cajaLocalidad2 += venta.getPrecioTotal();
        } else {
            cajaLocalidad3 += venta.getPrecioTotal();
        }

        int presupuesto = comprador.getPresupuesto() - venta.getPrecioTotal();
        comprador.setPresupuesto(presupuesto);
        System.out.println("Presupuesto restante: Q" + comprador.getPresupuesto());
        vista.Resumen(venta);
        vista.mensaje("\n Compra realizada exitosamente.");
    }

    private void disponibilidadTotal() {
        System.out.println("\n===== DISPONIBILIDAD TOTAL =====");

        System.out.println("\n" + localidad1.getLocalidad());
        System.out.println("Vendidos: " + localidad1.getBoletosVendidos());
        System.out.println("Disponibles: " + localidad1.getBoletosDisponibles());

        System.out.println("\n" + localidad2.getLocalidad());
        System.out.println("Vendidos: " + localidad2.getBoletosVendidos());
        System.out.println("Disponibles: " + localidad2.getBoletosDisponibles());

        System.out.println("\n" + localidad3.getLocalidad());
        System.out.println("Vendidos: " + localidad3.getBoletosVendidos());
        System.out.println("Disponibles: " + localidad3.getBoletosDisponibles());
    }

    private void disponibilidadIndividual() {

        int opcion = vista.leerLocalidad();

        switch (opcion) {

            case 1:
                System.out.println("\n" + localidad1.getLocalidad());
                System.out.println("Vendidos: " + localidad1.getBoletosVendidos());
                System.out.println("Disponibles: " + localidad1.getBoletosDisponibles());
                break;
            case 2:
                System.out.println("\n" + localidad2.getLocalidad());
                System.out.println("Vendidos: " + localidad2.getBoletosVendidos());
                System.out.println("Disponibles: " + localidad2.getBoletosDisponibles());
                break;
            case 3:
                System.out.println("\n" + localidad3.getLocalidad());
                System.out.println("Vendidos: " + localidad3.getBoletosVendidos());
                System.out.println("Disponibles: " + localidad3.getBoletosDisponibles());
                break;
            default:

                vista.mensaje("Localidad inválida.");
        }
    }

    private void reporteVentas() {
        System.out.println("\n===== REPORTE DE CAJA =====");

        System.out.println(localidad1.getLocalidad() + ": Q" + cajaLocalidad1);
        System.out.println(localidad2.getLocalidad() + ": Q" + cajaLocalidad2);
        System.out.println(localidad3.getLocalidad() + ": Q" + cajaLocalidad3);

        System.out.println("-----------------------------");
        System.out.println("TOTAL: Q" + cajaTotal);
    }
}