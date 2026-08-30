import java.util.List;

public class Controlador {
    //vista y taller utilizados durante la ejecucion del programa
    private Vista vista;
    private Taller taller;

    //constructor que prepara la vista y el taller
    public Controlador() {
        vista = new Vista();
        taller = new Taller();
    }

    //mantiene activo el menu y dirige cada opcion a su operacion
    public void iniciar() {
        vista.mostrarMensaje("Bienvenido al sistema de control de ordenes.");

        int opcion = 0;
        do {
            try {
                opcion = vista.mostrarMenu();

                switch (opcion) {
                    case 1:
                        int numero = vista.pedirEntero("Ingrese el numero de orden: ");

                        if (taller.existeOrden(numero)) {
                            vista.mostrarMensaje("Ese numero de orden ya se encuentra registrado.");
                            break;
                        }

                        String propietario = vista.pedirTexto("Ingrese el propietario: ");
                        String placa = vista.pedirTexto("Ingrese la placa: ");
                        String descripcion = vista.pedirTexto("Ingrese la descripcion: ");
                        double costo = vista.pedirDouble("Ingrese el costo estimado: ");

                        if (propietario.trim().isEmpty() || placa.trim().isEmpty()
                                || descripcion.trim().isEmpty()) {
                            vista.mostrarMensaje("Los datos de texto no pueden estar vacios.");
                        } else if (!Double.isFinite(costo) || costo <= 0) {
                            vista.mostrarMensaje("El costo estimado debe ser mayor que 0.");
                        } else {
                            OrdenServicio nuevaOrden = new OrdenServicio(numero, propietario,
                                    placa, descripcion, costo);
                            taller.agregarOrden(nuevaOrden);
                            vista.mostrarMensaje("Orden registrada correctamente.");
                        }
                        break;

                    case 2:
                        List<OrdenServicio> todas = taller.obtenerTodas();

                        if (todas.size() == 0) {
                            vista.mostrarMensaje("No hay ordenes registradas.");
                        } else {
                            for (OrdenServicio orden : todas) {
                                vista.mostrarMensaje("\n" + orden);
                            }
                        }
                        break;

                    case 3:
                        int numeroBuscar = vista.pedirEntero("Ingrese el numero de orden: ");
                        OrdenServicio encontrada = taller.buscarPorNumero(numeroBuscar);
                        vista.mostrarMensaje("\n" + encontrada);
                        break;

                    case 4:
                        int numeroModificar = vista.pedirEntero("Ingrese el numero de orden: ");
                        taller.buscarPorNumero(numeroModificar);
                        String nuevaDescripcion = vista.pedirTexto("Ingrese la nueva descripcion: ");
                        double nuevoCosto = vista.pedirDouble("Ingrese el nuevo costo: ");

                        if (nuevaDescripcion.trim().isEmpty()) {
                            vista.mostrarMensaje("La descripcion no puede estar vacia.");
                        } else if (!Double.isFinite(nuevoCosto) || nuevoCosto <= 0) {
                            vista.mostrarMensaje("El costo estimado debe ser mayor que 0.");
                        } else {
                            taller.modificarOrden(numeroModificar, nuevaDescripcion, nuevoCosto);
                            vista.mostrarMensaje("Orden modificada correctamente.");
                        }
                        break;

                    case 5:
                        int numeroCancelar = vista.pedirEntero("Ingrese el numero de orden: ");
                        taller.cancelarOrden(numeroCancelar);
                        vista.mostrarMensaje("Orden cancelada correctamente.");
                        break;

                    case 6:
                        String placaBuscar = vista.pedirTexto("Ingrese la placa: ");
                        List<OrdenServicio> coincidencias = taller.buscarPorPlaca(placaBuscar);

                        if (coincidencias.size() == 0) {
                            vista.mostrarMensaje("No se encontraron ordenes para esa placa.");
                        } else {
                            for (OrdenServicio orden : coincidencias) {
                                vista.mostrarMensaje("\n" + orden);
                            }
                        }
                        break;

                    case 7:
                        vista.mostrarMensaje("Costo total: Q" + taller.calcularTotal());
                        vista.mostrarMensaje("Costo promedio: Q" + taller.calcularPromedio());
                        break;

                    case 8:
                        OrdenServicio mayor = taller.obtenerMayorCosto();

                        if (mayor == null) {
                            vista.mostrarMensaje("No hay ordenes registradas.");
                        } else {
                            vista.mostrarMensaje("Orden de mayor costo:\n" + mayor);
                        }
                        break;

                    case 9:
                        vista.mostrarMensaje("Cantidad de ordenes: " + taller.obtenerCantidad());
                        break;

                    case 10:
                        vista.mostrarMensaje("Programa finalizado.");
                        break;

                    default:
                        vista.mostrarMensaje("Opcion invalida. Seleccione un numero del 1 al 10.");
                }
            } catch (NumberFormatException errorFormatoNumero) {
                vista.mostrarMensaje("Debe ingresar un numero valido.");
            } catch (IllegalArgumentException errorOrdenInexistente) {
                vista.mostrarMensaje(errorOrdenInexistente.getMessage());
            } finally {
                if (opcion != 10) {
                    vista.mostrarMensaje("Operacion finalizada. Regresando al menu principal.");
                }
            }
        } while (opcion != 10);
    }
}
