import java.util.List;
import java.util.Scanner;

public class VistaTaller {
    private Scanner scanner;
    private ControladorTaller controlador;

    public VistaTaller() {
        scanner = new Scanner(System.in);
        controlador = new ControladorTaller();
    }

    public void iniciar() {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerEnteroSeguro();
            procesarOpcion(opcion);
        } while (opcion != 10);
    }

    private void mostrarMenu() {
        System.out.println("\n--- Taller Automotriz ---");
        System.out.println("1. Registrar orden");
        System.out.println("2. Consultar ordenes");
        System.out.println("3. Buscar orden");
        System.out.println("4. Modificar orden");
        System.out.println("5. Cancelar orden");
        System.out.println("6. Consultar ordenes por placa");
        System.out.println("7. Reporte de costos");
        System.out.println("8. Orden de mayor costo");
        System.out.println("9. Cantidad de ordenes");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private void procesarOpcion(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    Servicio nuevaOrden = solicitarDatosOrden();
                    if (nuevaOrden != null) {
                        controlador.registrarOrden(nuevaOrden);
                        System.out.println("Orden registrada con exito.");
                    }
                    break;
                case 2:
                    List<Servicio> ordenes = controlador.consultarOrden();
                    if (ordenes.isEmpty()) {
                        System.out.println("No hay ordenes registradas.");
                    } else {
                        for (Servicio s : ordenes) {
                            System.out.println(s.toString());
                        }
                    }
                    break;
                case 3:
                    gestionarBusqueda();
                    break;
                case 4:
                    System.out.print("Ingrese el numero de orden a modificar: ");
                    int numModificar = leerEnteroSeguro();
                    System.out.print("Ingrese la nueva descripcion: ");
                    String nuevaDesc = scanner.nextLine();
                    System.out.print("Ingrese el nuevo costo estimado: ");
                    double nuevoCosto = leerDoubleSeguro();
                    controlador.modificarOrden(numModificar, nuevaDesc, nuevoCosto);
                    System.out.println("Orden modificada con exito.");
                    break;
                case 5:
                    System.out.print("Ingrese el numero de orden a cancelar: ");
                    int numCancelar = leerEnteroSeguro();
                    controlador.cancelarOrden(numCancelar);
                    System.out.println("Orden cancelada y eliminada con exito.");
                    break;
                case 6:
                    System.out.print("Ingrese la placa a buscar: ");
                    String placaBusqueda = scanner.nextLine();
                    List<Servicio> porPlaca = controlador.buscarPorPlaca(placaBusqueda);
                    if (porPlaca.isEmpty()) {
                        System.out.println("No se encontraron ordenes para esa placa.");
                    } else {
                        for (Servicio s : porPlaca) {
                            System.out.println(s.toString());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Valor total de ordenes: Q" + controlador.calcularValorTotal());
                    System.out.println("Costo promedio: Q" + controlador.calcularCostoPromedio());
                    break;
                case 8:
                    Servicio mayor = controlador.obtenerOrdenMayorCosto();
                    System.out.println("La orden de mayor costo es:\n" + mayor.toString());
                    break;
                case 9:
                    System.out.println("Cantidad de ordenes registradas: " + controlador.obtenerCantidadOrdenes());
                    break;
                case 10:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Servicio solicitarDatosOrden() {
        System.out.print("Numero de orden: ");
        int numOrden = leerEnteroSeguro();
        
        System.out.print("Nombre del propietario: ");
        String propietario = scanner.nextLine();
        
        System.out.print("Placa del vehiculo: ");
        String placa = scanner.nextLine();
        
        System.out.print("Descripcion del servicio: ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Costo estimado: ");
        double costo = leerDoubleSeguro();

        if (propietario.trim().isEmpty() || placa.trim().isEmpty() || descripcion.trim().isEmpty()) {
            System.out.println("Error: Los campos de texto no pueden estar vacios.");
            return null;
        }
        if (costo <= 0) {
            System.out.println("Error: El costo estimado debe ser mayor a 0.");
            return null;
        }

        return new Servicio(numOrden, propietario, placa, descripcion, costo);
    }

    private void gestionarBusqueda() {
        try {
            System.out.print("Ingrese el numero de orden a buscar: ");
            int numeroBusqueda = leerEnteroSeguro();
            Servicio encontrada = controlador.buscarOrden(numeroBusqueda);
            System.out.println(encontrada.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int leerEnteroSeguro() {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida. Por favor, ingrese un numero entero: ");
            } finally {
                limpiarBufferTeclado();
            }
        }
        return numero;
    }

    private double leerDoubleSeguro() {
        double numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                numero = Double.parseDouble(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida. Por favor, ingrese un valor numerico: ");
            } finally {
                limpiarBufferTeclado();
            }
        }
        return numero;
    }

    private void limpiarBufferTeclado() {
    }
}