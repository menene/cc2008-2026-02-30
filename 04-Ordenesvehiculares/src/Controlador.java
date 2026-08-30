import java.util.List;

public class Controlador{
    private Taller taller;
    private Vista vista;

    public Controlador(Taller taller, Vista vista) {
        this.taller = taller;
        this.vista = vista;
    }
    public void iniciar(){
        int opcion = 0;

        while (opcion != 10){
        
            try {
                vista.mostrarMenu();
                opcion = vista.leerInt();
                switch (opcion){
                    case 1:
                        registrar();
                        break;
                    case 2:
                        consultarOrdenes();
                        break;
                    case 3:
                        buscarOrden();
                        break;
                    case 4:
                        modificar();
                        break;
                    case 5:
                        cancelarOrden();
                        break;
                    case 6:
                        buscarPorPlaca();
                        break;
                    case 7:
                        reporteCostos();
                        break;
                    case 8:
                        ordenMayorCosto();
                        break;
                    case 9:
                        cantidadOrdenes();
                        break;
                    case 10:
                        vista.mostrarMensaje("OK SALDRE");
                        break;
                    
                    default:
                        vista.mostrarMensaje("Ponga una opcion valida");
                }
            } catch (Exception e){
                vista.mostrarMensaje("Error: ");
            } finally{
                vista.mostrarMensaje("Fin de operacion");
            }
        }
    }
    public void registrar() throws Exception{
        vista.mostrarMensaje("Numero : ");
        int numero = vista.leerInt();

        if (taller.buscarOrden(numero) != null) {
            throw new Exception("Numero repetido");
        }
        vista.mostrarMensaje("Propietario:");
        String propietario = vista.leerText();

        vista.mostrarMensaje("Placa: ");
        String placa = vista.leerText();

        vista.mostrarMensaje("Servicio:");
        String servicio = vista.leerText();

        vista.mostrarMensaje("Costo:");
        double costo = vista.leerDouble();

        OrdenServicio orden = new OrdenServicio(numero, propietario, placa, servicio, costo);

    }

    public void modificar() throws Exception{
        vista.mostrarMensaje("Numero: ");
        OrdenServicio orden = taller.buscarOrden(vista.leerInt());
        if (orden == null){
            throw new Exception("Orden no encontrada");

        }

        vista.mostrarMensaje("Nuevo servicio: ");
        String servicio = vista.leerText();

        vista.mostrarMensaje("Nuevo costo: ");
        double costo = vista.leerDouble();

        orden.modificar(servicio, costo);
    }
    public void consultarOrdenes(){
        for (OrdenServicio orden: taller.consultarOrdenes()){
            vista.mostrarMensaje(orden.toString());
        }
    }

    public void cancelarOrden() throws Exception {
        vista.mostrarMensaje("Numero:");
        int numero = vista.leerInt();

        taller.cancelarOrden(numero);
    }

    public void buscarOrden() throws Exception{
        vista.mostrarMensaje("Numero: ");
        int numero = vista.leerInt();

        OrdenServicio orden = taller.buscarOrden(numero);

        if (orden ==null){
            throw new Exception("Orden no encontrada");
        }

        vista.mostrarMensaje(orden.toString());
    }
    public void buscarPorPlaca(){
        vista.mostrarMensaje("Placa : ");
        String placa = vista.leerText();
        for (OrdenServicio orden : taller.buscarPorPlaca(placa)) {
            vista.mostrarMensaje(orden.toString());
        }

    }
    public void reporteCostos(){
        vista.mostrarMensaje("Total: Q" + taller.calcularCostoTotal());
        vista.mostrarMensaje("Promedio: Q" + taller.calcularCostoPromedio());
    }
    
    public void ordenMayorCosto(){
        OrdenServicio orden = taller.obtenerOrdenMayorCosto();

        if (orden==null){
            vista.mostrarMensaje("No hay ordenes :(");
        } else{
            vista.mostrarMensaje(orden.toString());
        }
    }

    public void cantidadOrdenes() {
        vista.mostrarMensaje(
            "Cantidad: " + taller.obtenercantidadOrdenes());
    }
}