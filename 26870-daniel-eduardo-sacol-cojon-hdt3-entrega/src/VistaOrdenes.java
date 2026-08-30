import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VistaOrdenes {
    private ControladorOrdenes controlador;
    private Scanner scanner;

    public VistaOrdenes() {
        this.controlador = new ControladorOrdenes();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            imprimirOpcionesMenu();
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1: ejecutarRegistroOrden(); break;
                    case 2: ejecutarConsultaTodas(); break;
                    case 3: ejecutarBusquedaPorNumero(); break;
                    case 4: ejecutarBusquedaPorPlaca(); break;
                    case 5: ejecutarModificacionOrden(); break;
                    case 6: ejecutarCancelacionOrden(); break;
                    case 7: ejecutarCalculoTotal(); break;
                    case 8: ejecutarCalculoPromedio(); break;
                    case 9: ejecutarObtenerMayorCosto(); break;
                    case 10: mostrarMensaje("Saliendo del sistema del taller. ¡Hasta pronto!"); break;
                    default: mostrarMensaje("Opción no válida. Por favor, intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                mostrarMensaje("Error: Por favor, ingrese un número válido para elegir una opción del menú.");
                scanner.nextLine(); 
                opcion = 0; 
            } finally {
                System.out.println("----------------------------------------");
            }
        } while (opcion != 10);
    }

    private void imprimirOpcionesMenu() {
        System.out.println("\n===== TALLER AUTOMOTRIZ =====");
        System.out.println("1. Registrar nueva orden");
        System.out.println("2. Consultar todas las órdenes");
        System.out.println("3. Buscar orden por número");
        System.out.println("4. Buscar órdenes por placa");
        System.out.println("5. Modificar orden");
        System.out.println("6. Cancelar orden");
        System.out.println("7. Calcular valor total");
        System.out.println("8. Calcular costo promedio");
        System.out.println("9. Obtener orden de mayor costo");
        System.out.println("10. Salir");
        System.out.print("Elija una opción: ");
    }


    private void ejecutarRegistroOrden() {
        try {
            Orden nuevaOrden = leerNuevaOrden();
            controlador.registrarOrden(nuevaOrden);
            mostrarMensaje("¡Orden registrada exitosamente!");
        } catch (InputMismatchException e) {
            mostrarMensaje("Error: Formato numérico incorrecto en el número de orden o costo.");
            scanner.nextLine();
        } catch (Exception e) {
            mostrarMensaje("Error en el registro: " + e.getMessage());
        }
    }

    private void ejecutarConsultaTodas() {
        System.out.println("\n--- LISTADO DE ÓRDENES ---");
        mostrarListaOrdenes(controlador.consultarOrdenes());
    }

    private void ejecutarBusquedaPorNumero() {
        try {
            System.out.print("Ingrese el número de orden a buscar: ");
            int numBuscar = scanner.nextInt();
            scanner.nextLine();
            
            Orden encontrada = controlador.buscarOrden(numBuscar);
            mostrarMensaje("Orden encontrada:\n" + encontrada.toString());
        } catch (InputMismatchException e) {
            mostrarMensaje("Error: Ingrese un número válido.");
            scanner.nextLine();
        } catch (NoSuchElementException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void ejecutarBusquedaPorPlaca() {
        System.out.print("Ingrese la placa a buscar: ");
        String placaBuscar = scanner.nextLine();
        try {
            List<Orden> porPlaca = controlador.buscarOrdenesPorPlaca(placaBuscar);
            System.out.println("\n--- ÓRDENES DE LA PLACA " + placaBuscar.toUpperCase() + " ---");
            mostrarListaOrdenes(porPlaca);
        } catch (NoSuchElementException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void ejecutarModificacionOrden() {
        try {
            System.out.print("Ingrese número de orden a modificar: ");
            int numModificar = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese nueva descripción: ");
            String nuevaDesc = scanner.nextLine();
            System.out.print("Ingrese nuevo costo: Q");
            double nuevoCosto = scanner.nextDouble();
            scanner.nextLine();
            
            controlador.modificarOrden(numModificar, nuevaDesc, nuevoCosto);
            mostrarMensaje("¡Orden modificada exitosamente!");
        } catch (InputMismatchException e) {
            mostrarMensaje("Error: Formato numérico incorrecto.");
            scanner.nextLine();
        } catch (NoSuchElementException | IllegalArgumentException e) {
            mostrarMensaje("Error al modificar: " + e.getMessage());
        }
    }

    private void ejecutarCancelacionOrden() {
        try {
            System.out.print("Ingrese número de orden a cancelar: ");
            int numCancelar = scanner.nextInt();
            scanner.nextLine();
            
            controlador.cancelarOrden(numCancelar);
            mostrarMensaje("¡Orden cancelada exitosamente!");
        } catch (InputMismatchException e) {
            mostrarMensaje("Error: Ingrese un número válido.");
            scanner.nextLine();
        } catch (NoSuchElementException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void ejecutarCalculoTotal() {
        mostrarMensaje("Valor total de todas las órdenes activas: Q" + controlador.calcularTotalOrdenes());
    }

    private void ejecutarCalculoPromedio() {
        try {
            mostrarMensaje("El costo promedio por orden es: Q" + controlador.calcularCostoPromedio());
        } catch (IllegalStateException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void ejecutarObtenerMayorCosto() {
        try {
            Orden mayor = controlador.obtenerOrdenMayorCosto();
            mostrarMensaje("La orden con mayor costo es:\n" + mayor.toString());
        } catch (IllegalStateException e) {
            mostrarMensaje(e.getMessage());
        }
    }


    public Orden leerNuevaOrden() {
        System.out.println("\n--- INGRESAR DATOS DE LA ORDEN ---");
        System.out.print("Ingrese número de orden: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese nombre del propietario: ");
        String propietario = scanner.nextLine();

        System.out.print("Ingrese placa del vehículo: ");
        String placa = scanner.nextLine();

        System.out.print("Ingrese descripción del servicio: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese costo estimado: Q");
        double costo = scanner.nextDouble();
        scanner.nextLine();

        return new Orden(numero, propietario, placa, descripcion, costo);
    }

    public void mostrarListaOrdenes(List<Orden> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay órdenes registradas para mostrar.");
        } else {
            for (Orden o : lista) {
                System.out.println(o.toString());
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}