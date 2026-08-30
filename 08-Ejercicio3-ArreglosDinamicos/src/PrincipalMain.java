//Importar librerias necesarias
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Se define la clase PrincipalMain que contiene el metodo main y la logica del programa.
public class PrincipalMain {

    private static Scanner scanner = new Scanner(System.in);
    private static Taller taller = new Taller();

    // Metodo main que inicia la ejecucion del programa y maneja excepciones inesperadas.
    public static void main(String[] args) {
        try {
            ejecutarPrograma();
        } catch (Exception e) {
            System.out.println("Ocurrio un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Recursos cerrados. Programa finalizado.");
        }
    }

    // Metodo que ejecuta el programa, mostrando un menu y permitiendo al usuario seleccionar opciones hasta que decida salir.
    private static void ejecutarPrograma() {
        int opcion;

    // Bucle principal que muestra el menu y procesa las opciones seleccionadas por el usuario.
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            System.out.println();

            //Usamos switch para las opciones del menu, llamando a los metodos correspondientes para cada accion.
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
                    mostrarReporteCostos();
                    break;
                case 8:
                    mostrarOrdenMayorCosto();
                    break;
                case 9:
                    mostrarCantidadOrdenes();
                    break;
                case 10:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }

            System.out.println();
        } while (opcion != 10);
    }

    //Metodo que muestra el menu principal del programa con las opciones disponibles para el usuario.
    private static void mostrarMenu() {
        System.out.println("============================================");
        System.out.println("   SISTEMA DE ORDENES DEL TALLER AUTOMOTRIZ");
        System.out.println("============================================");
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
    }

    //Metodo que solicita al usuario los datos de una nueva orden y la registra en el taller, manejando posibles excepciones (try y catch).
    private static void registrarOrden() {
        try {
            int numeroOrden = leerEntero("Numero de orden: ");
            String propietario = leerTexto("Nombre del propietario: ");
            String placa = leerTexto("Placa del vehiculo: ");
            String descripcion = leerTexto("Descripcion del servicio: ");
            double costo = leerDouble("Costo estimado: Q");

            OrdenServicio nuevaOrden = new OrdenServicio(numeroOrden,
                    propietario, placa, descripcion, costo);
            taller.registrarOrden(nuevaOrden);

            System.out.println("Orden registrada correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("No fue posible registrar la orden: "
                    + e.getMessage());
        }
    }

    //Metodo que obtiene todas las ordenes registradas en el taller y las muestra al usuario, indicando si no hay ordenes registradas.
    private static void consultarOrdenes() {
        List<OrdenServicio> ordenes = taller.obtenerOrdenes();

        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes registradas.");
            return;
        }

        System.out.println("ORDENES REGISTRADAS");
        mostrarListaOrdenes(ordenes);
    }
    
    //Metodo que solicita al usuario el numero de una orden y la busca en el taller, mostrando la orden si se encuentra o un mensaje de error si no se encuentra.
    private static void buscarOrden() {
        try {
            int numeroOrden = leerEntero("Numero de la orden a buscar: ");
            OrdenServicio orden = taller.buscarOrden(numeroOrden);

            System.out.println("Orden encontrada:");
            System.out.println(orden);
        } catch (NoSuchElementException e) {
            System.out.println("Error de busqueda: " + e.getMessage());
        } finally {
            System.out.println("Busqueda finalizada; regresando al menu principal.");
        }
    }

    //
    private static void modificarOrden() {
        try {
            int numeroOrden = leerEntero("Numero de la orden a modificar: ");
            String descripcion = leerTexto("Nueva descripcion del servicio: ");
            double costo = leerDouble("Nuevo costo estimado: Q");

            taller.modificarOrden(numeroOrden, descripcion, costo);
            System.out.println("Orden modificada correctamente.");
        } catch (NoSuchElementException e) {
            System.out.println("No fue posible modificar la orden: "
                    + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Datos invalidos: " + e.getMessage());
        }
    }

    //Metodo que solicita al usuario el numero de una orden y la cancela en el taller, manejando posibles excepciones (try y catch).
    private static void cancelarOrden() {
        try {
            int numeroOrden = leerEntero("Numero de la orden a cancelar: ");
            taller.cancelarOrden(numeroOrden);
            System.out.println("Orden cancelada correctamente.");
        } catch (NoSuchElementException e) {
            System.out.println("No fue posible cancelar la orden: "
                    + e.getMessage());
        }
    }

    //Metodo que mediante la placa busca las ordenes asociadas y las muestra, manejando posibles excepciones (try y catch).
    private static void consultarPorPlaca() {
        try {
            String placa = leerTexto("Placa que desea consultar: ");
            List<OrdenServicio> coincidencias =
                    taller.buscarOrdenesPorPlaca(placa);

            if (coincidencias.isEmpty()) {
                System.out.println("No existen ordenes asociadas a esa placa.");
                return;
            }

            System.out.println("ORDENES ASOCIADAS A LA PLACA "
                    + placa.toUpperCase());
            mostrarListaOrdenes(coincidencias);
        } catch (IllegalArgumentException e) {
            System.out.println("No fue posible realizar la consulta: "
                    + e.getMessage());
        }
    }

    //Metodo que muestra el costo total y promedio de todas las ordenes registradas en el taller.
    //Usa printf para formatear la salida de los costos a dos decimales.
    private static void mostrarReporteCostos() {
        System.out.printf("Costo total de las ordenes: Q%.2f%n", taller.calcularCostoTotal());
        System.out.printf("Costo promedio de las ordenes: Q%.2f%n", taller.calcularCostoPromedio());
    }

    //Metodo que obtiene la orden con el mayor costo estimado y la muestra al usuario, manejando posibles excepciones (try y catch).
    private static void mostrarOrdenMayorCosto() {
        try {
            OrdenServicio orden = taller.obtenerOrdenMayorCosto();
            System.out.println("ORDEN DE MAYOR COSTO");
            System.out.println(orden);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodo que obtiene la cantidad de ordenes registradas en el taller y la muestra al usuario.
    private static void mostrarCantidadOrdenes() {
        System.out.println("Cantidad de ordenes registradas: "
                + taller.obtenerCantidadOrdenes());
    }

    //Metodo que recibe una lista de ordenes y las muestra en la consola, separadas por lineas.
    private static void mostrarListaOrdenes(List<OrdenServicio> ordenes) {
        for (OrdenServicio orden : ordenes) {
            System.out.println("--------------------------------------------");
            System.out.println(orden);
        }
        System.out.println("--------------------------------------------");
    }

    //Metodo que lee un entero y controla las entradas no numericas con try-catch.
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Debe ingresar un numero entero.");
            }
        }
    }

    //Metodo que lee un double y controla las entradas no numericas con try-catch.
    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Debe ingresar un numero.");
            }
        }
    }

    //Metodo que lee un texto y valida que no este vacio, lanzando una excepcion si lo esta.
    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            } else {
                System.out.println("Entrada invalida. No puede estar vacia.");
            }
        }
    }
}