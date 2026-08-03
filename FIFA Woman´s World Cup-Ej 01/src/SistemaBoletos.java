import java.util.Random;

public class SistemaBoletos {

    // ===== ATRIBUTOS =====
    private Localidad[] localidades;
    private double caja;
    private Random random;

    // ===== CONSTRUCTOR =====
    public SistemaBoletos() {

        localidades = new Localidad[3];

        localidades[0] = new Localidad(1, 100);
        localidades[1] = new Localidad(5, 500);
        localidades[2] = new Localidad(10, 1000);

        caja = 0;
        random = new Random();

    }

    // ===== METODOS =====
    public void procesarCompra(Comprador comprador) {

        comprador.generarTicket();

        int ticket = comprador.getNumeroTicket();

        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;

        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);

        if (ticket >= menor && ticket <= mayor) {

            System.out.println("Su ticket fue seleccionado.");

            int indice = random.nextInt(3);

            Localidad localidad = localidades[indice];

            if (comprador.getPresupuestoMaximo() < localidad.getPrecio()) {

                System.out.println("El presupuesto no alcanza para esa localidad.");
                return;

            }

            int cantidad = comprador.getCantidadBoletos();

            if (cantidad > localidad.getDisponibles()) {

                cantidad = localidad.getDisponibles();

            }

            localidad.venderBoletos(cantidad);

            caja += cantidad * localidad.getPrecio();

            System.out.println("Se vendieron " + cantidad + " boletos.");

        } else {

            System.out.println("El ticket no fue seleccionado para compra.");
            return;

        }

    }

    public void consultarDisponibilidadTotal() {

        for (Localidad localidad : localidades) {

            System.out.println(
                    "Vendidos: " + localidad.getBoletosVendidos()
                            + " | Disponibles: "
                            + localidad.getDisponibles());

        }

    }

    public void consultarDisponibilidadIndividual(int indice) {

        if (indice >= 0 && indice < localidades.length) {

            System.out.println(
                    "Disponibles: "
                            + localidades[indice].getDisponibles());

        }

    }

    public double reporteCaja() {

        return caja;

    }

}