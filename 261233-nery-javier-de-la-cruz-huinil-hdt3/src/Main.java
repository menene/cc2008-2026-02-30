import java.util.List;
import java.util.Scanner;

/* Programa principal. Muestra el menu y manda a ejecutar cada operacion del taller. */
public class Main {

    private static Scanner entrada;
    private static TallerServicio taller;

    /* Arranca el programa y mantiene el menu activo hasta que el usuario decide salir */
    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        taller = new TallerServicio();
        boolean salir = false;

        System.out.println("=== Sistema de Control de Ordenes de Servicio ===");

        while (!salir) {
            mostrarMenu();
            try {
                int opcion = Integer.parseInt(entrada.nextLine().trim());

                switch (opcion) {
                    case 1:
                        opcionRegistrar();
                        break;

                    case 2: {
                        System.out.print("Numero de orden a buscar: ");
                        int numero = Integer.parseInt(entrada.nextLine().trim());
                        OrdenServicio encontrada = taller.buscarPorNumero(numero);
                        if (encontrada == null) {
                            System.out.println("No existe la orden #" + numero + ".");
                        } else {
                            System.out.println(encontrada);
                        }
                        break;
                    }

                    case 3: {
                        System.out.print("Numero de orden a modificar: ");
                        int numero = Integer.parseInt(entrada.nextLine().trim());
                        System.out.print("Nueva descripcion: ");
                        String nuevaDescripcion = entrada.nextLine();
                        double nuevoCosto = leerCosto();
                        if (nuevoCosto < 0) {
                            System.out.println("No se modifico la orden.");
                        } else {
                            taller.modificarOrden(numero, nuevaDescripcion, nuevoCosto);
                            System.out.println("Orden #" + numero + " modificada.");
                        }
                        break;
                    }

                    case 4: {
                        System.out.print("Numero de orden a cancelar: ");
                        int numero = Integer.parseInt(entrada.nextLine().trim());
                        taller.cancelarOrden(numero);
                        System.out.println("Orden #" + numero + " cancelada.");
                        break;
                    }

                    case 5: {
                        System.out.print("Placa a consultar: ");
                        String placa = entrada.nextLine();
                        List<OrdenServicio> delVehiculo = taller.consultarPorPlaca(placa);
                        if (delVehiculo.isEmpty()) {
                            System.out.println("La placa " + placa + " no tiene ordenes.");
                        } else {
                            System.out.println("Ordenes de la placa " + placa + ":");
                            for (OrdenServicio orden : delVehiculo) {
                                System.out.println("  " + orden);
                            }
                        }
                        break;
                    }

                    case 6: {
                        List<OrdenServicio> todas = taller.listarOrdenes();
                        if (todas.isEmpty()) {
                            System.out.println("Todavia no hay ordenes registradas.");
                        } else {
                            System.out.println("Listado de ordenes:");
                            for (OrdenServicio orden : todas) {
                                System.out.println("  " + orden);
                            }
                        }
                        break;
                    }

                    case 7:
                        System.out.println("Total acumulado: Q"
                                + String.format("%.2f", taller.calcularTotal()));
                        break;

                    case 8:
                        System.out.println("Costo promedio: Q"
                                + String.format("%.2f", taller.calcularPromedio()));
                        break;

                    case 9: {
                        OrdenServicio mayor = taller.obtenerMayorCosto();
                        if (mayor == null) {
                            System.out.println("Todavia no hay ordenes registradas.");
                        } else {
                            System.out.println("Orden de mayor costo:");
                            System.out.println("  " + mayor);
                        }
                        break;
                    }

                    case 10:
                        System.out.println("Ordenes registradas: " + taller.cantidadOrdenes());
                        break;

                    case 0:
                        salir = true;
                        System.out.println("Programa terminado.");
                        break;

                    default:
                        System.out.println("Opcion invalida. Escoja del 0 al 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe escribir un numero entero, no letras ni simbolos.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        entrada.close();
    }

    /* Presenta las diez opciones disponibles del sistema */
    private static void mostrarMenu() {
        System.out.println();
        System.out.println("1.  Registrar orden");
        System.out.println("2.  Buscar orden por numero");
        System.out.println("3.  Modificar orden");
        System.out.println("4.  Cancelar orden");
        System.out.println("5.  Consultar ordenes por placa");
        System.out.println("6.  Listar todas las ordenes");
        System.out.println("7.  Calcular total acumulado");
        System.out.println("8.  Calcular costo promedio");
        System.out.println("9.  Ver orden de mayor costo");
        System.out.println("10. Ver cantidad de ordenes");
        System.out.println("0.  Salir");
        System.out.print("Opcion: ");
    }

    /* Pide los datos de la orden nueva y manda a registrarla */
    private static void opcionRegistrar() {
        System.out.print("Numero de orden: ");
        int numeroOrden = Integer.parseInt(entrada.nextLine().trim());

        System.out.print("Propietario: ");
        String propietario = entrada.nextLine();

        System.out.print("Placa: ");
        String placa = entrada.nextLine();

        System.out.print("Descripcion del trabajo: ");
        String descripcion = entrada.nextLine();

        double costoEstimado = leerCosto();
        if (costoEstimado < 0) {
            System.out.println("No se registro la orden.");
            return;
        }

        OrdenServicio orden = new OrdenServicio(numeroOrden, propietario, placa,
                                               descripcion, costoEstimado);
        taller.registrarOrden(orden);
        System.out.println("Orden #" + numeroOrden + " registrada.");
    }

    /* Lee el costo y avisa cuando el valor no es numerico. Devuelve -1 si el dato no sirve */
    private static double leerCosto() {
        double costo = -1;
        try {
            System.out.print("Costo estimado: Q");
            costo = Double.parseDouble(entrada.nextLine().trim());
            if (costo < 0) {
                System.out.println("El costo no puede ser negativo.");
                costo = -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("El costo debe ser un numero. Ejemplo: 350.75");
            costo = -1;
        } finally {
            System.out.println("(lectura del costo terminada)");
        }
        return costo;
    }
}
