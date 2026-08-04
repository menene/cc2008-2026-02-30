import java.util.ArrayList;
import java.util.Random;

public class SistemaVentas {

    private ArrayList<Localidad> localidades;
    private ArrayList<Ticket> tickets;
    private Random random;

    public SistemaVentas() {
        this.localidades = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.random = new Random();

        localidades.add(new Localidad("Localidad 1", 20, 100f));
        localidades.add(new Localidad("Localidad 5", 20, 500f));
        localidades.add(new Localidad("Localidad 10", 20, 1000f));
    }

    private int[] generarNumeros() {
        int numeroTicket = random.nextInt(15000) + 1;
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;
        return new int[]{numeroTicket, a, b};
    }

    private boolean validarRango(int numeroTicket, int a, int b) {
        int minimo = Math.min(a, b);
        int maximo = Math.max(a, b);
        return numeroTicket >= minimo && numeroTicket <= maximo;
    }

    private Localidad seleccionarLocalidadAleatoria() {
        int indice = random.nextInt(localidades.size());
        return localidades.get(indice);
    }

    public boolean procesarSolicitud(Ticket ticket) {
        int[] numeros = generarNumeros();
        int numeroTicket = numeros[0];
        int a = numeros[1];
        int b = numeros[2];
        ticket.setNumeros(numeroTicket, a, b);

        boolean apto = validarRango(numeroTicket, a, b);
        if (!apto) {
            tickets.add(ticket);
            return false;
        }

        Localidad localidad = seleccionarLocalidadAleatoria();

        if (!localidad.tieneEspacio()) {
            tickets.add(ticket);
            return false;
        }

        if (localidad.getPrecio() > ticket.getPresupuesto()) {
            tickets.add(ticket);
            return false;
        }

        int vendidos = localidad.venderBoletos(ticket.getCantidadBoletos());

        if (vendidos > 0) {
            ticket.setLocalidadAsignada(localidad);
            ticket.setCantidadVendida(vendidos);
            tickets.add(ticket);
            return true;
        }

        tickets.add(ticket);
        return false;
    }

    private Localidad buscarLocalidad(String nombre) {
        for (Localidad localidad : localidades) {
            if (localidad.getNombre().equals(nombre)) {
                return localidad;
            }
        }
        return null;
    }

    public String mostrarDisponibilidad() {
        String resultado = "";
        for (Localidad localidad : localidades) {
            resultado = resultado + localidad.getNombre() + ": " + localidad.getAsientosDisponibles() + " disponibles\n";
        }
    return resultado;
    }

    public String mostrarDisponibilidad(String nombreLocalidad) {
        Localidad localidad = buscarLocalidad(nombreLocalidad);

        if (localidad == null) {
            return "No se encontró la localidad: " + nombreLocalidad;
        }

        return localidad.getNombre() + ": " + localidad.getAsientosDisponibles() + " disponibles";
    }

    public float calcularTotalRecaudado() {
        float total = 0f;
        for (Ticket ticket : tickets) {
            if (ticket.esApto()) {
                total = total + (ticket.getCantidadVendida() * ticket.getLocalidadAsignada().getPrecio());
            }
        }
        return total;
    }   
}