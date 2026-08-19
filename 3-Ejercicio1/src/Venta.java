import java.text.NumberFormat;
import java.util.Random;

public class Venta {

    // atributos (composicion: 1 Venta -> 3 Localidad)
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;

    // constructor
    public Venta() {
        localidad1 = new Localidad(1, 100.0);
        localidad5 = new Localidad(5, 500.0);
        localidad10 = new Localidad(10, 1000.0);
    }

    
    public void procesarCompra(Comprador comprador) {
        
        Ticket ticket = new Ticket();
        ticket.generarTicket();

        System.out.println("Ticket generado: #" + ticket.getNumero());

        if (!ticket.validarTicket()) {
            System.out.println("El ticket no fue seleccionado para comprar boletos.");
            return;
        }
        System.out.println("El ticket es apto para comprar boletos.");

        Localidad localidadAsignada = asignarLocalidad();
        System.out.println("Localidad asignada: " + localidadAsignada.getNumero());

        
        if (!localidadAsignada.hayEspacio()) {
            System.out.println("La localidad " + localidadAsignada.getNumero() + " ya no tiene espacio disponible.");
            return;
        }

        
        int cantidadDeseada = comprador.getCantidadBoletos();
        int cantidadAVender = Math.min(cantidadDeseada, localidadAsignada.disponibles());

        
        if (localidadAsignada.getPrecio() > comprador.getPresupuesto()) {
            System.out.println("El presupuesto de " + comprador.getNombre() + " no alcanza para esa localidad.");
            return;
        }

        int cantidadVendida = localidadAsignada.venderBoletos(cantidadAVender);
        System.out.println(comprador.getNombre() + " compro " + cantidadVendida
                + " boleto(s) en la localidad " + localidadAsignada.getNumero() + ".");
    }

    public Localidad asignarLocalidad() {
        Random random = new Random();
        int seleccion = random.nextInt(3);

        if (seleccion == 0) {
            return localidad1;
        } else if (seleccion == 1) {
            return localidad5;
        } else {
            return localidad10;
        }
    }

    public void mostrarDisponibilidad() {
        System.out.println("Localidad 1  -> " + localidad1.disponibles() + " de 20 disponibles");
        System.out.println("Localidad 5  -> " + localidad5.disponibles() + " de 20 disponibles");
        System.out.println("Localidad 10 -> " + localidad10.disponibles() + " de 20 disponibles");
    }

    public void mostrarCaja() {
        NumberFormat moneda = NumberFormat.getCurrencyInstance();
        double total = localidad1.dineroGenerado() + localidad5.dineroGenerado() + localidad10.dineroGenerado();

        System.out.println("Localidad 1  -> " + moneda.format(localidad1.dineroGenerado()));
        System.out.println("Localidad 5  -> " + moneda.format(localidad5.dineroGenerado()));
        System.out.println("Localidad 10 -> " + moneda.format(localidad10.dineroGenerado()));
        System.out.println("Total generado: " + moneda.format(total));
    }
}
