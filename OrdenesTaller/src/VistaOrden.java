//para tener scanner, lista y exceptions
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VistaOrden {

    private Scanner scanner;
    private SistemaOrden gestor;

    //scanner
    public VistaOrden(SistemaOrden gestor) {
        this.scanner = new Scanner(System.in);
        this.gestor = gestor;
    }

    public void iniciarMenu() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerMenu();

//acá se lee si el usuaior quiere la opción 1,2,3,4,5...
            switch (opcion) {
                case 1:
                    registrarOrdenDesdeConsola();
                    break;
                case 2:
                    mostarTodasOrdenes();
                    break;
                case 3:
                    mostrarOrden();
                    break;
                case 4:
                    leerModificacion();
                    break;
                case 5:
                    leerCancelarOdern();
                    break;
                case 6:
                    leerConsultarPlaca();
                    break;
                case 7:
                    mostrarCostos();
                    break;
                case 8:
                    mostrarMayorCosto();
                    break;
                case 9:
                    mostrarCantidadOrdenes();
                    break;
                case 10:
                    System.out.println("Saliendo del sistema, ¡vuelva pronto!");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente.");
            }
        } while (opcion != 10);

        scanner.close();
    }

    //para mostrar el menú
    private void mostrarMenu() {
        System.out.println("\n--------SISTEMA DE ORDENES DE SERVICIO--------");
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

    //para leer lo que se ingresa
    private int leerMenu() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero de opcion valido.");
            return -1; //por si es opcion invalida, vuelve a mostrar el menu
        }
    }

    //todo lo necesario para leer los datos de una nueva orden
    private void registrarOrdenDesdeConsola() {
        try {
            System.out.print("Número de orden: ");
            int numOrden = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Nombre del propietario: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Placa del vehiculo: ");
            String placa = scanner.nextLine().trim();

            System.out.print("Descripción del servicio: ");
            String descripcion = scanner.nextLine().trim();

            System.out.print("Costo estimado: ");
            double costo = Double.parseDouble(scanner.nextLine().trim());

            boolean registrada = gestor.registrarOrden(numOrden, nombre, placa, descripcion, costo);

            if (registrada) 
            {
                System.out.println("Orden registrada exitosamente.");
            }

        //catch por si algo sale mal y se necesita saber el error que se cometió
        } catch (NumberFormatException e) {
            System.out.println("Error: el número de orden y el costo deben ser valores numericos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar la orden: " + e.getMessage());
        } finally {
            System.out.println("Proceso de registro finalizado.");
        }
    }

    //para mostrar todas las ordenes registradas
    private void mostarTodasOrdenes() {
        List<Orden> todas = gestor.consultaOrden();
        if (todas.isEmpty()) {
            System.out.println("No hay ordenes registradas actualmente.");
            return;
        }
        System.out.println("\n--- Ordenes registradas ---");
        for (Orden orden : todas) {
            System.out.println(orden);
        }
    }

    //para leer la orden que se quiere buscar
    private void mostrarOrden() {
        try {
            System.out.print("\nIngrese el numero de orden a buscar: ");
            int numOrden = Integer.parseInt(scanner.nextLine().trim());

            Orden orden = gestor.buscarOrden(numOrden);
            System.out.println("Orden encontrada:");
            System.out.println(orden);
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero de orden valido.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Busqueda finalizada.");
        }
    }

    //lee las modificaciones que se quieren hacer
    private void leerModificacion() {
        try {
            System.out.print("\nNumero de orden a modificar: ");
            int numOrden = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Nueva descripcion del servicio: ");
            String descripcion = scanner.nextLine().trim();

            System.out.print("Nuevo costo estimado: ");
            double costo = Double.parseDouble(scanner.nextLine().trim());

            gestor.modificarOrden(numOrden, descripcion, costo);
            System.out.println("Orden modificada exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Error: el numero de orden y el costo deben ser valores numericos.");
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Proceso de modificacion finalizado.");
        }
    }

    //leer para cancelar la orden
    private void leerCancelarOdern() {
        try {
            System.out.print("\nNumero de orden a cancelar: ");
            int numOrden = Integer.parseInt(scanner.nextLine().trim());

            gestor.cancelarOrden(numOrden);
            System.out.println("Orden cancelada exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero de orden valido.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Proceso de cancelacion finalizado.");
        }
    }

    //leer para consultar con la placa
    private void leerConsultarPlaca() {
        System.out.print("\nIngrese la placa a consultar: ");
        String placa = scanner.nextLine().trim();

        List<Orden> resultado = gestor.consultaOrdenesPlaca(placa);
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron ordenes asociadas a la placa " + placa + ".");
            return;
        }
        System.out.println("\n--- Ordenes asociadas a la placa " + placa + " ---");
        for (Orden orden : resultado) {
            System.out.println(orden);
        }
    }

    //para mostrar todo lo de costos
    private void mostrarCostos() {
        double total = gestor.calculoCostoTotal();
        double promedio = gestor.calculoCostoPromedio();
        System.out.printf("\nValor total de las ordenes activas: Q%.2f%n", total);
        System.out.printf("Costo promedio de las ordenes activas: Q%.2f%n", promedio);
    }

    //para mostrar el que tiene el mayor costo
    private void mostrarMayorCosto() {
        try {
            Orden mayor = gestor.consultaMayorCosto();
            System.out.println("\nOrden con el costo estimado mas alto:");
            System.out.println(mayor);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //para omstrar la cantidad de ordenes
    private void mostrarCantidadOrdenes() {
        System.out.println("\nCantidad de ordenes registradas actualmente: "
                + gestor.consultaCantidadOrden());
    }
}
