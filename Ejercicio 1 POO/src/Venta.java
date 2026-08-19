import java.util.Random;

public class Venta {

    // Comprador actual
    private Comprador comprador;

    // Localidades
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;

    // Caja
    private double caja;

    // Generador de números aleatorios
    private Random random;

    // Constructor
    public Venta() {

        random = new Random();

        localidad1 = new Localidad(1, 100, 20, 0);
        localidad5 = new Localidad(5, 500, 20, 0);
        localidad10 = new Localidad(10, 1000, 20, 0);

        caja = 0;
    }

    // Registrar o reemplazar comprador
    public void nuevoComprador(Comprador comprador) {
        this.comprador = comprador;
        System.out.println("\nComprador registrado correctamente.");
    }

    // Devuelve el comprador actual
    public Comprador getComprador() {
        return comprador;
    }
    public void solicitarBoletos() {

        if (comprador == null) {
            System.out.println("\nNo existe un comprador registrado.");
            return;
        }

        // Generación de números
        int ticket = random.nextInt(15000) + 1;
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;

        System.out.println("\n===== SOLICITUD DE BOLETOS =====");
        System.out.println("Ticket generado: " + ticket);
        System.out.println("Numero A: " + a);
        System.out.println("Numero B: " + b);

        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);

        // Validar si puede comprar
        if (ticket < menor || ticket > mayor) {
            System.out.println("\nEl ticket NO fue seleccionado.");
            System.out.println("No puede comprar boletos.");
            return;
        }

        System.out.println("\n¡El ticket fue seleccionado!");

        // Elegir localidad aleatoria
        int opcion = random.nextInt(3);

        Localidad localidad;

        switch (opcion) {

            case 0:
                localidad = localidad1;
                break;

            case 1:
                localidad = localidad5;
                break;

            default:
                localidad = localidad10;
                break;
        }

        System.out.println("Localidad asignada: " + localidad.getNumero());
        if (localidad.getBoletosDisponibles() == 0) {

            System.out.println("\nLa localidad ya no tiene espacio.");
            return;

        }
                int boletosVenta;

        if (comprador.getCantidadBoletos() <= localidad.getBoletosDisponibles()) {

            boletosVenta = comprador.getCantidadBoletos();

        } else {

            boletosVenta = localidad.getBoletosDisponibles();

            System.out.println("\nNo hay suficientes boletos.");
            System.out.println("Solo se venderán "
                    + boletosVenta + " boletos.");

        }
                double total = boletosVenta * localidad.getPrecio();

        if (total > comprador.getPresupuesto()) {

            System.out.println("\nEl presupuesto no alcanza.");
            System.out.println("Total: $" + total);
            return;

        }
                localidad.venderBoletos(boletosVenta);

        caja += total;

        System.out.println("\n===== COMPRA EXITOSA =====");

        System.out.println("Comprador: " + comprador.getNombre());

        System.out.println("Localidad: " + localidad.getNumero());

        System.out.println("Boletos comprados: " + boletosVenta);

        System.out.println("Total pagado: $" + total);

    }
        public void consultarDisponibilidadTotal() {

        System.out.println("\n========= DISPONIBILIDAD =========");

        System.out.println("LOCALIDAD 1");
        System.out.println("Vendidos: " + localidad1.getBoletosVendidos());
        System.out.println("Disponibles: " + localidad1.getBoletosDisponibles());

        System.out.println();

        System.out.println("LOCALIDAD 5");
        System.out.println("Vendidos: " + localidad5.getBoletosVendidos());
        System.out.println("Disponibles: " + localidad5.getBoletosDisponibles());

        System.out.println();

        System.out.println("LOCALIDAD 10");
        System.out.println("Vendidos: " + localidad10.getBoletosVendidos());
        System.out.println("Disponibles: " + localidad10.getBoletosDisponibles());

    }
        public void consultarDisponibilidadIndividual(int numeroLocalidad) {

        Localidad localidad = null;

        switch (numeroLocalidad) {

            case 1:
                localidad = localidad1;
                break;

            case 5:
                localidad = localidad5;
                break;

            case 10:
                localidad = localidad10;
                break;

            default:
                System.out.println("\nLocalidad inválida.");
                return;

        }

        System.out.println("\n===== LOCALIDAD " + localidad.getNumero() + " =====");

        System.out.println("Precio: $" + localidad.getPrecio());

        System.out.println("Boletos vendidos: "
                + localidad.getBoletosVendidos());

        System.out.println("Boletos disponibles: "
                + localidad.getBoletosDisponibles());

    }
        public double reporteCaja() {

        return caja;

    }

}