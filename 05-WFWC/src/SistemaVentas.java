public class SistemaVentas {
    private Comprador compradorActual;
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;

    public SistemaVentas() {
        localidad1 = new Localidad("Localidad 1", 100);
        localidad5 = new Localidad("Localidad 5", 500);
        localidad10 = new Localidad("Localidad 10", 1000);
    }

    public void crearComprador(String nombre, String email, int cantidadBoletos, double presupuestoMaximo) {
        compradorActual = new Comprador(nombre, email, cantidadBoletos, presupuestoMaximo);
    }

    public Comprador getCompradorActual() {
        return compradorActual;
    }

    public void generarTicket() {
        // Generar número de ticket.
        int numero = (int)(Math.random()*15000)+1;

        //Asignarle el numeroAleatorio al Ticket
        compradorActual 
            .getTicket() 
            .setNumeroAleatorio(numero);
    }

    public boolean validarTicket() {

        int a = (int)(Math.random() * 15000) + 1;
        int b = (int)(Math.random() * 15000) + 1;

        Ticket ticket = compradorActual.getTicket();
        int numero = ticket.getNumeroAleatorio();

        if (numero >= Math.min(a, b) 
            && 
            numero <= Math.max(a, b)) {

            ticket.setValido(true);

        } else {

            ticket.setValido(false);

        }

        return ticket.isValido();
    }

    public void asignarLocalidad() {
        Ticket ticket = compradorActual.getTicket();
        int opcion = (int)(Math.random() * 3);

        switch (opcion) {

            case 0:
                ticket.setLocalidadAsignada(localidad1);
                break;

            case 1:
                ticket.setLocalidadAsignada(localidad5);
                break;

            default:
                ticket.setLocalidadAsignada(localidad10);
                break;
        }
    }

    public boolean validarEspacio() {
        Localidad localidad = compradorActual.getTicket().getLocalidadAsignada();
        return localidad.getBoletosDisponibles() >= compradorActual.getCantidadBoletos();
    }

    public void venderBoletos() {
        Localidad localidad = compradorActual.getTicket().getLocalidadAsignada();
        localidad.venderBoletos(compradorActual.getCantidadBoletos());
    }

    public String consultarDisponibilidadTotal() {
        return "Localidad 1: " + localidad1.getBoletosDisponibles()
                + "\nLocalidad 5: " + localidad5.getBoletosDisponibles()
                + "\nLocalidad 10: " + localidad10.getBoletosDisponibles();
    }

    public String consultarDisponibilidadLocalidad(String nombreLocalidad) {
        if (nombreLocalidad.equalsIgnoreCase("Localidad 1")) {
            return "Disponibles: " + localidad1.getBoletosDisponibles() + " espacios.";
        }

        if (nombreLocalidad.equalsIgnoreCase("Localidad 5")) {
            return "Disponibles: " + localidad5.getBoletosDisponibles() + " espacios.";
        }

        if (nombreLocalidad.equalsIgnoreCase("Localidad 10")) {
            return "Disponibles: " + localidad10.getBoletosDisponibles() + " espacios.";
        }

        return "Localidad no encontrada :(.";
    }

    public String generarReporteCaja() {
        double total =
                localidad1.getBoletosVendidos() * localidad1.getPrecio()
                + localidad5.getBoletosVendidos() * localidad5.getPrecio()
                + localidad10.getBoletosVendidos() * localidad10.getPrecio();

        return "Total generado: $" + total;
    }  
}