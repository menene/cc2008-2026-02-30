import java.util.Random;

public class Venta {

    private Localidad localidad1;
    private Localidad localidad2;
    private Localidad localidad3;
    private byte cuarto_sorteo;

    public Venta() {

        localidad1 = new Localidad(100);
        localidad2 = new Localidad(500);
        localidad3 = new Localidad(1000);

    }

    public void randomCuarto_Sorteo() {

        Random random = new Random();

        cuarto_sorteo = (byte)(random.nextInt(3) + 1);

    }

    public boolean validarDisponibilidad() {

        if (cuarto_sorteo == 1) {
            return localidad1.getDisponibilidad() > 0;
        }

        if (cuarto_sorteo == 2) {
            return localidad2.getDisponibilidad() > 0;
        }

        return localidad3.getDisponibilidad() > 0;

    }

    public boolean validarPresupuesto(Comprador comprador) {

        if (cuarto_sorteo == 1) {
            return comprador.getPresupuesto() >= localidad1.getPrecio();
        }

        if (cuarto_sorteo == 2) {
            return comprador.getPresupuesto() >= localidad2.getPrecio();
        }

        return comprador.getPresupuesto() >= localidad3.getPrecio();

    }

    public String realizarVenta(Comprador comprador) {

        randomCuarto_Sorteo();

        if (!validarDisponibilidad()) {
            return "No hay boletos disponibles.";
        }

        if (!validarPresupuesto(comprador)) {
            return "El presupuesto no es suficiente.";
        }

        if (cuarto_sorteo == 1) {
            localidad1.venderBoletos(comprador.getCantidad_Boletos());
            return "Compra realizada en Localidad 1.";
        }

        if (cuarto_sorteo == 2) {
            localidad2.venderBoletos(comprador.getCantidad_Boletos());
            return "Compra realizada en Localidad 2.";
        }

        localidad3.venderBoletos(comprador.getCantidad_Boletos());
        return "Compra realizada en Localidad 10.";

    }

    public void mostrarDisponibilidadTotal() {

        System.out.println("Localidad 1: " + localidad1.getDisponibilidad());
        System.out.println("Localidad 5: " + localidad2.getDisponibilidad());
        System.out.println("Localidad 10: " + localidad3.getDisponibilidad());

    }

    public void mostrarDisponibilidad(int localidad) {

        if (localidad == 1) {
            System.out.println(localidad1.getDisponibilidad());
        } else if (localidad == 5) {
            System.out.println(localidad2.getDisponibilidad());
        } else if (localidad == 10) {
            System.out.println(localidad3.getDisponibilidad());
        }

    }

    public void mostrarReporteCaja() {

        int total = localidad1.getDinero()
                + localidad2.getDinero()
                + localidad3.getDinero();

        System.out.println("Dinero generado: $" + total);

    }

}