
public class Main {

    public static void main(String[] args) {
        VistaSistema vista = new VistaSistema();
        Venta venta = new Venta();

        vista.mostrarMensaje("===== Venta de boletos - Mundial Femenino 2027 =====");
        Comprador comprador = vista.leerComprador();

        vista.mostrarMensaje("\nProcesando solicitud...");
        venta.procesarCompra(comprador);

        vista.mostrarMensaje("\nDisponibilidad de localidades:");
        venta.mostrarDisponibilidad();

        vista.mostrarMensaje("\nReporte de caja:");
        venta.mostrarCaja();
    }
}
