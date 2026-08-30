import java.util.ArrayList;
import java.util.List;

public class Controlador {

    private List<OrdenServicio> ordenes;
    private Vista vista;

    public Controlador(Vista vista) {

        this.vista = vista;
        ordenes = new ArrayList<>();
    }

    public void nuevoOrden() {

        try {

            int numeroOrden = vista.pedirNumeroOrden();

            for (OrdenServicio orden : ordenes) {

                if (orden.getNumeroOrden() == numeroOrden) {
                    throw new Exception("El número de orden ya existe.");
                }
            }

            String nombrePropietario = vista.pedirNombrePropietario();
            String placa = vista.pedirPlaca();
            String descripcionServicio = vista.pedirDescripcionServicio();
            double costoEstimado = vista.pedirCostoEstimado();

            if (nombrePropietario.isEmpty()) {
                throw new Exception("El nombre no puede estar vacío.");
            }

            if (placa.isEmpty()) {
                throw new Exception("La placa no puede estar vacía.");
            }

            if (descripcionServicio.isEmpty()) {
                throw new Exception("La descripción no puede estar vacía.");
            }

            if (costoEstimado <= 0) {
                throw new Exception("El costo debe ser mayor que 0.");
            }

            OrdenServicio nuevaOrden = new OrdenServicio(
                    numeroOrden,
                    nombrePropietario,
                    placa,
                    descripcionServicio,
                    costoEstimado
            );

            ordenes.add(nuevaOrden);

            vista.mostrarMensaje("Orden registrada correctamente.");

        } catch (Exception e) {

            vista.mostrarMensaje("Error: " + e.getMessage());

        } finally {

            vista.mostrarMensaje("Proceso de registro finalizado.");
        }
    }

    public void consultaOrdenes() {

        if (ordenes.isEmpty()) {

            vista.mostrarMensaje("No hay órdenes registradas.");

        } else {

            vista.mostrarOrdenes(ordenes);
        }
    }

    public void buscarOrden() {

        try {

            int numeroOrden = vista.pedirNumeroOrden();
            OrdenServicio encontrada = null;

            for (OrdenServicio orden : ordenes) {

                if (orden.getNumeroOrden() == numeroOrden) {
                    encontrada = orden;
                    break;
                }
            }

            if (encontrada == null) {
                throw new Exception("La orden no existe.");
            }

            vista.mostrarOrden(encontrada);

        } catch (Exception e) {

            vista.mostrarMensaje("Error: " + e.getMessage());

        } finally {

            vista.mostrarMensaje("Proceso de búsqueda finalizado.");
        }
    }

    public void modificarOrden() {

        try {

            int numeroOrden = vista.pedirNumeroOrden();
            OrdenServicio encontrada = null;

            for (OrdenServicio orden : ordenes) {

                if (orden.getNumeroOrden() == numeroOrden) {
                    encontrada = orden;
                    break;
                }
            }

            if (encontrada == null) {
                throw new Exception("La orden no existe.");
            }

            String descripcion = vista.pedirDescripcionServicio();
            double costo = vista.pedirCostoEstimado();

            if (descripcion.isEmpty()) {
                throw new Exception("La descripción no puede estar vacía.");
            }

            if (costo <= 0) {
                throw new Exception("El costo debe ser mayor que 0.");
            }

            encontrada.setDescripcionServicio(descripcion);
            encontrada.setCostoEstimado(costo);

            vista.mostrarMensaje("Orden modificada correctamente.");

        } catch (Exception e) {

            vista.mostrarMensaje("Error: " + e.getMessage());

        } finally {

            vista.mostrarMensaje("Proceso de modificación finalizado.");
        }
    }

    public void cancelarOrden() {

        try {

            int numeroOrden = vista.pedirNumeroOrden();
            OrdenServicio encontrada = null;

            for (OrdenServicio orden : ordenes) {

                if (orden.getNumeroOrden() == numeroOrden) {
                    encontrada = orden;
                    break;
                }
            }

            if (encontrada == null) {
                throw new Exception("La orden no existe.");
            }

            ordenes.remove(encontrada);

            vista.mostrarMensaje("Orden cancelada correctamente.");

        } catch (Exception e) {

            vista.mostrarMensaje("Error: " + e.getMessage());

        } finally {

            vista.mostrarMensaje("Proceso de cancelación finalizado.");
        }
    }

    public void consultaPorPlaca() {

        String placa = vista.pedirPlaca();
        boolean encontrada = false;

        for (OrdenServicio orden : ordenes) {

            if (orden.getPlaca().equalsIgnoreCase(placa)) {

                vista.mostrarOrden(orden);
                System.out.println("-------------------------");

                encontrada = true;
            }
        }

        if (!encontrada) {

            vista.mostrarMensaje("No existen órdenes para esa placa.");
        }
    }

    public void reporteCostos() {

        if (ordenes.isEmpty()) {

            vista.mostrarMensaje("No hay órdenes registradas.");

        } else {

            double total = 0;

            for (OrdenServicio orden : ordenes) {
                total += orden.getCostoEstimado();
            }

            double promedio = total / ordenes.size();

            vista.mostrarReporteCostos(total, promedio);
        }
    }

    public void ordenMayorCosto() {

        if (ordenes.isEmpty()) {

            vista.mostrarMensaje("No hay órdenes registradas.");

        } else {

            OrdenServicio mayor = ordenes.get(0);

            for (OrdenServicio orden : ordenes) {

                if (orden.getCostoEstimado() > mayor.getCostoEstimado()) {
                    mayor = orden;
                }
            }

            vista.mostrarOrden(mayor);
        }
    }

    public void cantidadOrdenes() {

        vista.mostrarCantidad(ordenes.size());
    }

    public void iniciar() {

        int opcion;

        do {

            try {

                opcion = vista.mostrarMenu();

                switch (opcion) {

                    case 1:
                        nuevoOrden();
                        break;

                    case 2:
                        consultaOrdenes();
                        break;

                    case 3:
                        buscarOrden();
                        break;

                    case 4:
                        modificarOrden();
                        break;

                    case 5:
                        cancelarOrden();
                        break;

                    case 6:
                        consultaPorPlaca();
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
                        vista.salir();
                        break;

                    default:
                        vista.mostrarMensaje("Opción no válida.");
                }

            } catch (Exception e) {

                vista.mostrarMensaje("Entrada inválida.");

                opcion = 0;
            }

        } while (opcion != 10);
    }
}