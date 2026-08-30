import java.util.List;
import java.util.NoSuchElementException;


public class Controlador {

    private GestorOrdenes gestor;
    private Vista vista;

    public Controlador(GestorOrdenes gestor, Vista vista) {
        this.gestor = gestor;
        this.vista = vista;
    }


    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            vista.mostrarMenu();

            try {
                int opcion = vista.leerEntero("Seleccione una opcion: ");
                if (opcion == 10) {
                    salir = true;
                    vista.mostrarMensaje("Saliendo");
                } else {
                    procesarOpcion(opcion);
                }
            } catch (NumberFormatException e) {
                vista.mostrarMensaje("Opcion invalida. Debe ingresar un numero.");
            }
        }
    }


    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarOrden();
                break;
            case 2:
                vista.mostrarOrdenes(gestor.obtenerOrdenes());
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
                consultarPorPlaca();
                break;
            case 7:
                reporteCostos();
                break;
            case 8:
                mostrarOrdenMayorCosto();
                break;
            case 9:
                vista.mostrarMensaje("Cantidad de ordenes registradas: " + gestor.cantidadOrdenes());
                break;
            default:
                vista.mostrarMensaje("Opcion no valida. Intente nuevamente.");
        }
    }


    private void registrarOrden() {
        try {
            int numeroOrden = vista.leerEntero("Numero de orden: ");
            String propietario = vista.leerTexto("Nombre del propietario: ");
            String placa = vista.leerTexto("Placa del vehiculo: ");
            String descripcion = vista.leerTexto("Descripcion del servicio: ");
            double costo = vista.leerDouble("Costo estimado: ");

            OrdenServicio orden = new OrdenServicio(numeroOrden, propietario, placa, descripcion, costo);
            gestor.agregarOrden(orden);
            vista.mostrarMensaje("Orden registrada correctamente.");

        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: el numero de orden o el costo ingresado no es valido.");
        } catch (IllegalArgumentException e) {
            // Cubre campos vacios, costo <= 0 y numero de orden repetido.
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }


    private void buscarOrden() {
        try {
            int numeroOrden = vista.leerEntero("Numero de orden a buscar: ");
            OrdenServicio orden = gestor.buscarOrden(numeroOrden);
            vista.mostrarOrden(orden);

        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: debe ingresar un numero de orden valido.");
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("Busqueda finalizada.");
        }
    }


    private void modificarOrden() {
        try {
            int numeroOrden = vista.leerEntero("Numero de orden a modificar: ");
            String descripcion = vista.leerTexto("Nueva descripcion del servicio: ");
            double costo = vista.leerDouble("Nuevo costo estimado: ");

            gestor.modificarOrden(numeroOrden, descripcion, costo);
            vista.mostrarMensaje("Orden modificada correctamente.");

        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: el numero de orden o el costo ingresado no es valido.");
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }


    private void cancelarOrden() {
        try {
            int numeroOrden = vista.leerEntero("Numero de orden a cancelar: ");
            gestor.cancelarOrden(numeroOrden);
            vista.mostrarMensaje("Orden cancelada correctamente.");

        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: debe ingresar un numero de orden valido.");
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void consultarPorPlaca() {
        String placa = vista.leerTexto("Placa del vehiculo a consultar: ");
        List<OrdenServicio> ordenes = gestor.buscarPorPlaca(placa);
        vista.mostrarOrdenes(ordenes);
    }

    private void reporteCostos() {
        double total = gestor.calcularTotal();
        double promedio = gestor.calcularPromedio();
        vista.mostrarMensaje("Valor total de las ordenes: Q" + total);
        vista.mostrarMensaje("Costo promedio de las ordenes: Q" + promedio);
    }


    private void mostrarOrdenMayorCosto() {
        try {
            OrdenServicio orden = gestor.obtenerOrdenMayorCosto();
            vista.mostrarMensaje("Orden con el costo estimado mas alto:");
            vista.mostrarOrden(orden);
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }
}
