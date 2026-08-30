import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ControladorOrdenes {

    private GestorOrdenes gestor;
    private Scanner teclado;

    public ControladorOrdenes() {
        gestor = new GestorOrdenes();
        teclado = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = -1;

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número de opción válido.");
                teclado.nextLine();
                continue;
            }

            switch (opcion) {
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
                    consultarPorPlaca();
                    break;
                case 7:
                    reporteDeCostos();
                    break;
                case 8:
                    ordenMayorCosto();
                    break;
                case 9:
                    cantidadOrdenes();
                    break;
                case 10:
                    salir = true;
                    System.out.println("Cerrando el sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        teclado.close();
    }

    private void mostrarMenu() {
        System.out.println("\n===== Taller Automotriz - Menú Principal =====");
        System.out.println("1. Registrar orden");
        System.out.println("2. Consultar órdenes");
        System.out.println("3. Buscar orden");
        System.out.println("4. Modificar orden");
        System.out.println("5. Cancelar orden");
        System.out.println("6. Consultar órdenes por placa");
        System.out.println("7. Reporte de costos");
        System.out.println("8. Orden de mayor costo");
        System.out.println("9. Cantidad de órdenes");
        System.out.println("10. Salir");
        System.out.print("Elija una opción: ");
    }

    private void registrarOrden() {
        try {
            System.out.print("Número de orden: ");
            int numeroOrden = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Nombre del propietario: ");
            String nombre = teclado.nextLine();

            System.out.print("Placa del vehículo: ");
            String placa = teclado.nextLine();

            System.out.print("Descripción del servicio: ");
            String descripcion = teclado.nextLine();

            System.out.print("Costo estimado: ");
            double costo = teclado.nextDouble();
            teclado.nextLine();

            Cliente cliente = new Cliente(nombre);
            Vehiculo vehiculo = new Vehiculo(placa);

            gestor.registrarOrden(numeroOrden, cliente, vehiculo, descripcion, costo);
            System.out.println("Orden registrada con éxito.");

        } catch (InputMismatchException e) {
            System.out.println("Error: el número de orden y el costo deben ser valores numéricos.");
            teclado.nextLine();
        } catch (DatosInvalidosException | OrdenDuplicadaException e) {
            System.out.println("No se pudo registrar la orden: " + e.getMessage());
        } finally {
            System.out.println("Proceso de registro finalizado.");
        }
    }

    private void consultarOrdenes() {
        List<OrdenServicio> ordenes = gestor.consultarOrdenes();

        if (ordenes.isEmpty()) {
            System.out.println("No hay órdenes registradas actualmente.");
            return;
        }

        for (OrdenServicio orden : ordenes) {
            orden.mostrarInformacion();
        }
    }

    private void buscarOrden() {
        try {
            System.out.print("Ingrese el número de orden a buscar: ");
            int numeroOrden = teclado.nextInt();
            teclado.nextLine();

            OrdenServicio orden = gestor.buscarOrden(numeroOrden);
            orden.mostrarInformacion();

        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número de orden válido.");
            teclado.nextLine();
        } catch (OrdenNoEncontradaException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Búsqueda finalizada.");
        }
    }

    private void modificarOrden() {
        try {
            System.out.print("Ingrese el número de orden a modificar: ");
            int numeroOrden = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Nueva descripción del servicio: ");
            String nuevaDescripcion = teclado.nextLine();

            System.out.print("Nuevo costo estimado: ");
            double nuevoCosto = teclado.nextDouble();
            teclado.nextLine();

            gestor.modificarOrden(numeroOrden, nuevaDescripcion, nuevoCosto);
            System.out.println("Orden modificada con éxito.");

        } catch (InputMismatchException e) {
            System.out.println("Error: el costo estimado debe ser un valor numérico.");
            teclado.nextLine();
        } catch (OrdenNoEncontradaException | DatosInvalidosException e) {
            System.out.println("No se pudo modificar la orden: " + e.getMessage());
        } finally {
            System.out.println("Proceso de modificación finalizado.");
        }
    }

    private void cancelarOrden() {
        try {
            System.out.print("Ingrese el número de orden a cancelar: ");
            int numeroOrden = teclado.nextInt();
            teclado.nextLine();

            gestor.cancelarOrden(numeroOrden);
            System.out.println("Orden cancelada con éxito.");

        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número de orden válido.");
            teclado.nextLine();
        } catch (OrdenNoEncontradaException e) {
            System.out.println("No se pudo cancelar la orden: " + e.getMessage());
        } finally {
            System.out.println("Proceso de cancelación finalizado.");
        }
    }

    private void consultarPorPlaca() {
        System.out.print("Ingrese la placa a consultar: ");
        String placa = teclado.nextLine();

        List<OrdenServicio> encontradas = gestor.consultarPorPlaca(placa);

        if (encontradas.isEmpty()) {
            System.out.println("No se encontraron órdenes para la placa " + placa + ".");
            return;
        }

        for (OrdenServicio orden : encontradas) {
            orden.mostrarInformacion();
        }
    }

    private void reporteDeCostos() {
        double total = gestor.calcularValorTotal();
        double promedio = gestor.calcularCostoPromedio();

        System.out.println("Valor total de las órdenes activas: Q" + total);
        System.out.println("Costo promedio de las órdenes activas: Q" + promedio);
    }

    private void ordenMayorCosto() {
        try {
            OrdenServicio orden = gestor.ordenMayorCosto();
            System.out.println("La orden con el costo estimado más alto es:");
            orden.mostrarInformacion();
        } catch (OrdenNoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cantidadOrdenes() {
        System.out.println("Cantidad de órdenes registradas: " + gestor.cantidadOrdenes());
    }
}
