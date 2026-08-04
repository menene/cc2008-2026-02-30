import java.util.Random;

public class SistemaVentas {
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;
    private float recaudacion;

    public SistemaVentas() {
        localidad1 = new Localidad(1, 100);
        localidad5 = new Localidad(5, 500);
        localidad10 = new Localidad(10, 1000);
        recaudacion = 0;
    }

    public String procesarCompra(Comprador usuario) {
    
        Ticket ticket = new Ticket();

        if (ticket.verificarTicket() == false) {
            return "\nSu ticket no fue seleccionado para realizar la compra de boletos, intente de nuevo.";
        }
        String tAprobado = "\n¡El ticket fue seleccionado!";

        Localidad localidad = asignarLocalidad();

        if (localidad.getBoletosDisponibles() == 0) {
            return "\nLa localidad asignada ya no tiene boletos disponibles, intente de nuevo";
        }

        int boletosAVender;

        if (usuario.getCantidadBoletos() <= localidad.getBoletosDisponibles()) {
            boletosAVender = usuario.getCantidadBoletos();
        }
        else {
            boletosAVender = localidad.getBoletosDisponibles();
        }

        while ((boletosAVender * localidad.getPrecio()) > usuario.getPresupuestoMax()) {
            boletosAVender = boletosAVender - 1;
        }

        if (boletosAVender == 0) {
            return "\nEl presupuesto no es suficiente para comprar boletos.";
        }

        localidad.venderBoletos(boletosAVender);

        recaudacion = recaudacion + (boletosAVender * localidad.getPrecio());

        return tAprobado 
                + "\nCompra realizada con éxito."
                + "\nLocalidad asignada: " + localidad.getNumero()
                + "\nBoletos comprados: " + boletosAVender
                + "\nTotal pagado: Q" + (boletosAVender * localidad.getPrecio());

    }

    private Localidad asignarLocalidad() {
        Random random = new Random();
        int opcion = random.nextInt(3);

        if (opcion == 0) {
            return localidad1;
        } 
        else if (opcion == 1) {
            return localidad5;
        } 
        else {
            return localidad10;
        }

        }
    

    public float reporteRecaudacion() {
        return recaudacion;
    }

    public String disponibilidadTotal() {
        int totalDisponibles = localidad1.getBoletosDisponibles() + localidad5.getBoletosDisponibles() + localidad10.getBoletosDisponibles();
        return "Total de boletos disponibles: " + totalDisponibles;
    } 

    public String disponibilidadIndividual(int numeroLocalidad) {
        if (numeroLocalidad == 1) {
            return "Boletos disponibles en la localidad 1: " + localidad1.getBoletosDisponibles();
        }
        if (numeroLocalidad == 5) {
            return "Boletos disponibles en la localidad 5: " + localidad5.getBoletosDisponibles();
        }
        if (numeroLocalidad == 10) {
            return "Boletos disponibles en la localidad 10: " + localidad10.getBoletosDisponibles();
        }
        return "La localidad ingresada no existe.";
    }
}