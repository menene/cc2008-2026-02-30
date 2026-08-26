public class Main {
    public static void main(String[] args) {
        OrdenArrayList repositorio = new OrdenArrayList();
        ServicioOrdenes servicio = new ServicioOrdenes(repositorio);
        VistaTaller vista = new VistaTaller();
        ControladorTaller controlador = new ControladorTaller(servicio, vista);

        controlador.iniciar();
    }
}