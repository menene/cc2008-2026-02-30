import java.util.Random;
public class SistemaVentas{
    private Comprador compradorActual;
    private Localidad[] localidades;
    private Random random;

    public SistemaVentas(){
        localidades = new Localidad[3];
        localidades[0]= new Localidad(1,100);
        localidades[1]= new Localidad(5,500);
        localidades[2]= new Localidad(10,1000);
    }
    public void nuevoComprador(String nombre, String email, int cantidad, double presupuesto){
        compradorActual = new Comprador(nombre,email,cantidad,presupuesto);
    }
    public double reporteCaja(){
        double total=0;
        for(Localidad l : localidades){
            total+= l.getRecaudacion();
        }
        return total;
    }
    public Localidad disponibilidadLocalidad(int numero) {

        for (Localidad l : localidades) {

            if (l.getNumero() == numero) {
                return l;
            }

        }

        return null;
    }
    public Localidad[] disponibilidadTotal() {
        return localidades;
    }
    public void nuevaSolicitud() {

        if (compradorActual == null) {
            System.out.println("No existe un comprador registrado.");
            return;
        }

        Ticket ticket = new Ticket();
            random = new Random();
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;

        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);

        if (ticket.getNumero() < menor || ticket.getNumero() > mayor) {
            System.out.println("El ticket no fue seleccionado.");
            return;
        }

        Localidad localidad = localidades[random.nextInt(3)];

        if (!localidad.hayEspacio()) {
            System.out.println("La localidad está llena.");
            return;
        }

        int boletos = compradorActual.getCantidadBoletos();

        if (boletos > localidad.disponibles()) {
            boletos = localidad.disponibles();
        }

        double total = boletos * localidad.getPrecio();

        if (total > compradorActual.getPresupuesto()) {
            System.out.println("El presupuesto es insuficiente.");
            return;
        }

        localidad.venderBoletos(boletos);

        System.out.println("Compra realizada.");
        System.out.println("Ticket: " + ticket.getNumero());
        System.out.println("Localidad: " + localidad.getNumero());
        System.out.println("Boletos vendidos: " + boletos);
        System.out.println("Total: $" + total);
    }
}
