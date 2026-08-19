public class Venta {

    private Usuario usuario;
    private Localidad localidad;
    private int cantidadBoletos, precioTotal;

    public Venta(Usuario usuario, Localidad localidad) {

        this.usuario = usuario;
        this.localidad = localidad;

        this.cantidadBoletos = usuario.getNoBoletos();

        precioTotal = CalculoTotal(cantidadBoletos, localidad.getPrecio());

    }

    public int CalculoTotal(int cantidadBoletos, int precio) {

        return cantidadBoletos * precio;

    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public String Resumen(String nombre, int total, int cantidadBoletos) {

        return "Nombre: " + nombre +
               "\nCantidad de boletos: " + cantidadBoletos +
               "\nTotal a pagar: Q" + total;

    }

    public void Mostrar() {

        System.out.println(Resumen(usuario.getNombre(), precioTotal, cantidadBoletos));

    }

}