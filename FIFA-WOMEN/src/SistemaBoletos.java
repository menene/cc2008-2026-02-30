import java.util.ArrayList;
import java.util.Random;


public class SistemaBoletos {
    private ArrayList<Localidad> localidades;
    private Comprador compradorActual;
    private Random random;
    private double dineroRecaudado;


    public SistemaBoletos() {
        this.localidades = new ArrayList<>();
        this.localidades.add(new Localidad(1, 100.0));
        this.localidades.add(new Localidad(5, 500.0));
        this.localidades.add(new Localidad(10, 1000.0));
       
        this.compradorActual = null;
        this.random = new Random();
        this.dineroRecaudado = 0.0;
    }

    public void crearComprador(Comprador comprador) {
        this.compradorActual = comprador;
        System.out.println("¡Comprador registrado exitosamente!");
    }

    public void solicitarCompra() {
        if (this.compradorActual == null) {
            System.out.println("Error: No hay un comprador registrado. Por favor elija la opción 1 primero.");
            return;
        }

        Ticket ticket = new Ticket();
        ticket.generarTicket();


        if (ticket.esApto()) {
            System.out.println("¡Felicidades! Su ticket es apto para continuar.");
           
            Localidad loc = generarLocalidadAleatoria();
            System.out.println("Se le asignó la Localidad " + loc.getNumero() + " (Precio: $" + loc.getPrecio() + ")");


            if (!loc.hayEspacio()) {
                System.out.println("Lamentablemente, la Localidad " + loc.getNumero() + " ya está llena.");
                return;
            }


            if (loc.getPrecio() > this.compradorActual.getPresupuestoMaximo()) {
                System.out.println("Su presupuesto de $" + this.compradorActual.getPresupuestoMaximo() + " no es suficiente para esta localidad.");
                return;
            }


            int deseados = this.compradorActual.getCantidadBoletos();
            int disponibles = loc.boletosDisponibles();
            int boletosAVender = Math.min(deseados, disponibles);


            loc.venderBoletos(boletosAVender);
            this.dineroRecaudado += (boletosAVender * loc.getPrecio());


            System.out.println("¡Compra Exitosa! Se le han vendido " + boletosAVender + " boletos.");
        } else {
            System.out.println("Lo sentimos, su ticket no es ganador esta vez.");
        }
    }

    public Localidad generarLocalidadAleatoria() {
        int indice = this.random.nextInt(this.localidades.size());
        return this.localidades.get(indice);
    }

    public void consultarDisponibilidad() {
        System.out.println("--- DISPONIBILIDAD TOTAL ---");
        for (Localidad loc : this.localidades) {
            System.out.println("Localidad " + loc.getNumero() + " -> Disponibles: " + loc.boletosDisponibles());
        }
    }

    public void consultarLocalidad(int numero) {
        boolean encontrada = false;
        for (Localidad loc : this.localidades) {
            if (loc.getNumero() == numero) {
                System.out.println("Localidad " + numero + " -> Disponibles: " + loc.boletosDisponibles());
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("La localidad ingresada no existe (Solo 1, 5 o 10).");
        }
    }
    public double reporteCaja() {
        return this.dineroRecaudado;
    }
}
