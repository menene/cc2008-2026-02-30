import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ControladorTaller {
    // Atributos
    private Taller taller;
    private VistaTaller vista;

    // Controlador
    public ControladorTaller() {
        taller = new Taller();
        vista = new VistaTaller();
    }

    // Menú
    public void iniciar() {
        boolean salirPrograma = false;
        int opcion = 0;

        while (!salirPrograma) {
            try {
                opcion = vista.mostrarMenu();

                switch (opcion) {
                    case 0:
                        salirPrograma = true;
                        vista.mostrarMensaje("Programa finalizado");
                        break;
                    case 1:
                        registrarOrden();
                        break;
                    case 2:
                        consultarOrdenes();
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
                        consultarOrdenesPorPlaca();
                        break;
                    case 7:
                        mostrarReporteCostos();
                        break;
                    case 8:
                        mostrarOrdenMayorCosto();
                        break;
                    case 9:
                        mostrarCantidadOrdenes();
                        break; 
                    default:
                        vista.mostrarMensaje("Opción inválida");
                        break;
                }
            } catch (NumberFormatException e) {
                vista.mostrarMensaje("Error: debe ingresar un número válido.");
            }
        }
    }

    private void registrarOrden() {
        try {
            int numeroOrden = vista.pedirEntero("Número de orden: ");

            if (taller.existeOrden(numeroOrden)) {
                throw new IllegalArgumentException("Ya existe una orden con el número " + numeroOrden); // Esta excepción se usa cuando se pasa un argumento inválido a un método. En este caso se usa porque están intentando guardar una orden que probablemente ya existe. 
            }


            String propietario = vista.pedirTexto("Nombre del propietario: ");

            if (propietario.isEmpty()) {
                throw new IllegalArgumentException("El nombre del propietario no puede estár vacío :(");
            }


            String placa = vista.pedirTexto("Placa del vehículo: ");

            if (placa.isEmpty()) {
                throw new IllegalArgumentException("La placa no puede estar vacía. :/");
            }

            String descripcion = vista.pedirTexto("Descripción del servicio: ");

            if (descripcion.isEmpty()) {
                throw new IllegalArgumentException("La descripción no puede estar vacía. :/");
            }
            

            double costo = vista.pedirDecimal("Costo estimado: Q");

            if (costo <= 0 ) {
                throw new IllegalArgumentException("El costo estimado debe de ser mayor a 0 :/");
            }

            Orden orden = new Orden(numeroOrden, propietario, placa, descripcion, costo);

            taller.agregarOrden(orden);

            vista.mostrarMensaje("Orden registrada correctamente.");

        } catch(NumberFormatException e) {
            vista.mostrarMensaje("Error: ingrese un dato numérico válido");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage()); // Aquí se maneja la excepción propagada por la vista y por validación de datos.
        } finally {
            vista.mostrarMensaje("\nRegresando al menú... UwU");
        }
    }

    private void consultarOrdenes() {
        ArrayList<Orden> ordenes = taller.obtenerOrdenes();

        if (ordenes.isEmpty()) {
            vista.mostrarMensaje("No hay órdenes registradas.");
            return;
        }

        String resultado = """
        +-+-+-+-+-+-+-+-+-+-+-+-+-
                  ÓRDENES
        +-+-+-+-+-+-+-+-+-+-+-+-+-
        """;

        for (Orden orden : ordenes) {
            resultado += orden.toString() + "\n";
            resultado += "--------------------------\n";
        }

        vista.mostrarMensaje(resultado);
    }

    private void buscarOrden() {
        try {
            int numeroOrden = vista.pedirEntero("Número de orden a buscar: ");
            Orden orden = taller.buscaOrden(numeroOrden);
            vista.mostrarMensaje("""

                    +-+-+-+-+-+-+-+-+-+-+-+-+-
                              ÓRDEN
                    +-+-+-+-+-+-+-+-+-+-+-+-+-
                    """);
            vista.mostrarMensaje("\n" + orden.toString());

        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: debe ingresar un número válido."); // al ingresar una orden y se pone texto en vez de número
        }
        catch (NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage()); // Se maneja la excepción propagada y originada por la vista

        } finally {
            vista.mostrarMensaje("\nBúsqueda finalizada. Regresando al menú :)"); // para indicarle al usuario que finalizó el proceso de búsqueda se haya encontrado o no.
        }
    }

    private void modificarOrden() {
        try {
            int numeroOrden = vista.pedirEntero("Número de orden a modificar: ");
            Orden orden = taller.buscaOrden(numeroOrden);
            String descripcion = vista.pedirTexto("Nueva descripción del servicio: ");
            if (descripcion.isEmpty()) {
                throw new IllegalArgumentException("La descripción no puede estar vacía. :/");
            }

            double costo = vista.pedirDecimal("Nuevo costo estimado: Q");
            if (costo <= 0 ) {
                throw new IllegalArgumentException("El costo estimado debe de ser mayor a 0 :/");
            }
            taller.modificarOrden(orden, descripcion, costo);
            vista.mostrarMensaje("Orden modificada correctamente.");

        } catch (NoSuchElementException | IllegalArgumentException e) { // Maneja 2 excepciones a la vez 
            vista.mostrarMensaje("Error: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("\nBúsqueda finalizada. Regresando al menú :)"); // para indicarle al usuario que finalizó el proceso de búsqueda se haya encontrado o no.
        }
    }

    private void cancelarOrden() {
        try {
            int numeroOrden = vista.pedirEntero("Número de orden a cancelar: ");
            taller.eliminarOrden(numeroOrden);
            vista.mostrarMensaje("Orden cancelada correctamente.");

        } catch (NoSuchElementException | IllegalArgumentException e) { // maneja excepción propagada por 
            vista.mostrarMensaje("Error: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("\nRegresando al menú... UwU");
        }
    }

    private void consultarOrdenesPorPlaca() {
        String placa = vista.pedirTexto("Placa del vehículo: ");
        ArrayList<Orden> ordenes = taller.buscarOrdenesPorPlaca(placa);

        if (ordenes.isEmpty()) {
            vista.mostrarMensaje("No se encontraron órdenes asociadas a esa placa.");
            return;
        }

        String resultado = "";

        for (Orden orden : ordenes) {
            resultado += "\n" + orden.toString() + "\n";
        }
        vista.mostrarMensaje(resultado);
    }
    
    private void mostrarReporteCostos() {
        double total = taller.calcularCostoTotal();
        double promedio = taller.calcularCostoPromedio();

        String reporte = String.format(
            """
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                    REPORTE DE COSTOS
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
            Costo total: Q%.2f
            Costo promedio: Q%.2f
            """,
            total,
            promedio
        );

        vista.mostrarMensaje(reporte);
    }

    private void mostrarOrdenMayorCosto() {
        try {
            Orden orden = taller.obtenerOrdenMayorCosto();
            vista.mostrarMensaje("\nOrden de mayor costo:\n" + orden.toString());
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void mostrarCantidadOrdenes() {
        int cantidad = taller.obtenerCantidadOrdenes();
        vista.mostrarMensaje("Cantidad de órdenes registradas: " + cantidad);
    }
}