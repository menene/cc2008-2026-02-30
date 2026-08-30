import java.util.List;
import java.util.NoSuchElementException;

public class ControladorTaller {

    private GestorOrdenes gestor;
    private VistaTaller vista;

    public ControladorTaller() {
        this.gestor = new GestorOrdenes();
        this.vista = new VistaTaller();
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1: procesarRegistro(); break;
                case 2: procesarConsulta(); break;
                case 3: procesarBusqueda(); break;
                case 4: procesarModificacion(); break;
                case 5: procesarCancelacion(); break;
                case 6: procesarConsultaPorPlaca(); break;
                case 7: procesarReporteCostos(); break;
                case 8: procesarMayorCosto(); break;
                case 9: procesarCantidadOrdenes(); break;
                case 10: vista.mostrarMensaje("Saliendo del sistema..."); break;
                default: vista.mostrarMensaje("Opcion invalida. Intente de nuevo.");
            }
        } while (opcion != 10);
    }

    private void procesarRegistro() {
        try {
            String numeroStr = vista.leerLinea("Numero de orden: ");
            int numeroOrden = Integer.parseInt(numeroStr.trim());

            if (gestor.existeNumeroOrden(numeroOrden)) {
                throw new IllegalArgumentException("Ya existe una orden registrada con el numero " + numeroOrden + ".");
            }

            String propietario = vista.leerLinea("Nombre del propietario: ");
            String placa = vista.leerLinea("Placa del vehiculo: ");
            String descripcion = vista.leerLinea("Descripcion del servicio: ");
            String costoStr = vista.leerLinea("Costo estimado: ");
            double costo = Double.parseDouble(costoStr.trim());

            gestor.registrarOrden(numeroOrden, propietario, placa, descripcion, costo);
            vista.mostrarMensaje("Orden registrada exitosamente.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: el numero de orden y el costo deben ser valores numericos validos.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("Proceso de registro finalizado. Regresando al menu principal.");
        }
    }

    private void procesarConsulta() {
        List<OrdenServicio> ordenes = gestor.consultarTodas();
        vista.mostrarMensaje("--- Ordenes registradas ---");
        vista.mostrarListaOrdenes(ordenes);
    }

    private void procesarBusqueda() {
        try {
            String numeroStr = vista.leerLinea("Numero de orden a buscar: ");
            int numeroOrden = Integer.parseInt(numeroStr.trim());
            OrdenServicio orden = gestor.buscarPorNumero(numeroOrden);
            vista.mostrarOrden(orden);
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: el numero de orden debe ser un valor numerico valido.");
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("Busqueda finalizada. Regresando al menu principal.");
        }
    }

    private void procesarModificacion() {
        try {
            String numeroStr = vista.leerLinea("Numero de orden a modificar: ");
            int numeroOrden = Integer.parseInt(numeroStr.trim());

            gestor.buscarPorNumero(numeroOrden);

            String nuevaDescripcion = vista.leerLinea("Nueva descripcion del servicio: ");
            String nuevoCostoStr = vista.leerLinea("Nuevo costo estimado: ");
            double nuevoCosto = Double.parseDouble(nuevoCostoStr.trim());

            gestor.modificarOrden(numeroOrden, nuevaDescripcion, nuevoCosto);
            vista.mostrarMensaje("Orden modificada exitosamente.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: el numero de orden y el costo deben ser valores numericos validos.");
        } catch (NoSuchElementException | IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("Proceso de modificacion finalizado. Regresando al menu principal.");
        }
    }

    private void procesarCancelacion() {
        try {
            String numeroStr = vista.leerLinea("Numero de orden a cancelar: ");
            int numeroOrden = Integer.parseInt(numeroStr.trim());
            gestor.cancelarOrden(numeroOrden);
            vista.mostrarMensaje("Orden cancelada exitosamente.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: el numero de orden debe ser un valor numerico valido.");
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("Proceso de cancelacion finalizado. Regresando al menu principal.");
        }
    }

    private void procesarConsultaPorPlaca() {
        String placa = vista.leerLinea("Placa a consultar: ");
        List<OrdenServicio> resultado = gestor.consultarPorPlaca(placa);
        vista.mostrarMensaje("--- Ordenes asociadas a la placa " + placa + " ---");
        vista.mostrarListaOrdenes(resultado);
    }

    private void procesarReporteCostos() {
        double total = gestor.calcularTotal();
        double promedio = gestor.calcularPromedio();
        vista.mostrarMensaje("Valor total de ordenes activas: Q" + total);
        vista.mostrarMensaje("Costo promedio de ordenes activas: Q" + promedio);
    }

    private void procesarMayorCosto() {
        try {
            OrdenServicio orden = gestor.obtenerMayorCosto();
            vista.mostrarMensaje("Orden con el costo estimado mas alto:");
            vista.mostrarOrden(orden);
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void procesarCantidadOrdenes() {
        vista.mostrarMensaje("Cantidad de ordenes registradas: " + gestor.cantidadOrdenes());
    }
}