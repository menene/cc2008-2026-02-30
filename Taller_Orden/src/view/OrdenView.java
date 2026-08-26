package view;
 
import controller.OrdenController;
import model.OrdenServicio;
 
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
 
public class OrdenView {
 
    private Scanner scanner;
    private OrdenController controller;
 
    public OrdenView(OrdenController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }
 
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");
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
                    reporteCostos();
                    break;
                case 8:
                    ordenMayorCosto();
                    break;
                case 9:
                    cantidadOrdenes();
                    break;
                case 10:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
            System.out.println();
        }
    }
 
    private void mostrarMenu() {
        System.out.println("===== Sistema de Control de Ordenes de Servicio =====");
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
    }
 
    private void registrarOrden() {
        try {
            int numeroOrden = leerEntero("Número de orden: ");
            System.out.print("Nombre del propietario: ");
            String propietario = scanner.nextLine();
            System.out.print("Placa del vehículo: ");
            String placa = scanner.nextLine();
            System.out.print("Descripción del servicio: ");
            String descripcion = scanner.nextLine();
            double costo = leerDouble("Costo estimado: ");
 
            controller.registrarOrden(numeroOrden, propietario, placa, descripcion, costo);
            System.out.println("Orden registrada exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar la orden: " + e.getMessage());
        }
    }
 
    private void consultarOrdenes() {
        List<OrdenServicio> ordenes = controller.listarOrdenes();
        if (ordenes.isEmpty()) {
            System.out.println("No hay órdenes registradas actualmente.");
            return;
        }
        System.out.println("----- Ordenes registradas -----");
        for (OrdenServicio orden : ordenes) {
            System.out.println(orden);
        }
    }
 
    private void buscarOrden() {
        int numeroOrden = leerEntero("Número de orden a buscar: ");
        try {
            OrdenServicio orden = controller.buscarPorNumero(numeroOrden);
            System.out.println("Orden encontrada:");
            System.out.println(orden);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    private void modificarOrden() {
        int numeroOrden = leerEntero("Número de orden a modificar: ");
        try {
            System.out.print("Nueva descripción del servicio: ");
            String nuevaDescripcion = scanner.nextLine();
            double nuevoCosto = leerDouble("Nuevo costo estimado: ");
 
            controller.modificarOrden(numeroOrden, nuevaDescripcion, nuevoCosto);
            System.out.println("Orden modificada exitosamente.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos ingresados: " + e.getMessage());
        } finally {
            System.out.println("Operación de modificación finalizada. Regresando al menú principal.");
        }
    }
 
    private void cancelarOrden() {
        int numeroOrden = leerEntero("Número de orden a cancelar: ");
        try {
            controller.cancelarOrden(numeroOrden);
            System.out.println("Orden cancelada exitosamente.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    private void consultarPorPlaca() {
        System.out.print("Placa a consultar: ");
        String placa = scanner.nextLine();
        List<OrdenServicio> coincidencias = controller.consultarPorPlaca(placa);
        if (coincidencias.isEmpty()) {
            System.out.println("No se encontraron órdenes para la placa " + placa + ".");
            return;
        }
        System.out.println("----- Órdenes asociadas a la placa " + placa + " -----");
        for (OrdenServicio orden : coincidencias) {
            System.out.println(orden);
        }
    }
 
    private void reporteCostos() {
        try {
            double total = controller.calcularValorTotal();
            double promedio = controller.calcularCostoPromedio();
            System.out.println("Valor total de órdenes activas    : Q" + String.format("%.2f", total));
            System.out.println("Costo promedio de órdenes activas : Q" + String.format("%.2f", promedio));
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    private void ordenMayorCosto() {
        try {
            OrdenServicio mayor = controller.obtenerOrdenMayorCosto();
            System.out.println("Orden con el costo estimado más alto:");
            System.out.println(mayor);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    private void cantidadOrdenes() {
        System.out.println("Cantidad de órdenes registradas: " + controller.cantidadOrdenes());
    }
 
    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine();
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
            }
        }
    }
 
    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine();
                return Double.parseDouble(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número (puede tener decimales).");
            }
        }
    }
}