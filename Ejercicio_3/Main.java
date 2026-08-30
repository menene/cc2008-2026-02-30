import java.util.List;
import java.util.Scanner;

// Clase principal del programa (driver)
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorOrdenes gestor = new GestorOrdenes();
        int opcion = 0;

        while (opcion != 10) {

            System.out.println("");
            System.out.println("===== Menu Taller Automotriz =====");
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
            System.out.print("Elija una opcion: ");

            // Try-catch para cuando el usuario no escribe un numero
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero.");
                opcion = 0;
            }

            if (opcion == 1) {
                // Registrar orden
                try {
                    System.out.print("Numero de orden: ");
                    int numero = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre del propietario: ");
                    String nombre = sc.nextLine();

                    System.out.print("Placa del vehiculo: ");
                    String placa = sc.nextLine();

                    System.out.print("Descripcion del servicio: ");
                    String descripcion = sc.nextLine();

                    System.out.print("Costo estimado: ");
                    double costo = Double.parseDouble(sc.nextLine());

                    OrdenServicio nueva = new OrdenServicio(numero, nombre, placa, descripcion, costo);
                    gestor.registrarOrden(nueva);
                    System.out.println("Orden registrada con exito.");

                } catch (NumberFormatException e) {
                    System.out.println("El numero de orden y el costo deben ser numeros.");
                } catch (OrdenException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (opcion == 2) {
                // Consultar ordenes
                List<OrdenServicio> lista = gestor.consultarOrdenes();
                if (lista.size() == 0) {
                    System.out.println("No hay ordenes registradas.");
                } else {
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }
                }

            } else if (opcion == 3) {
                // Buscar orden
                try {
                    System.out.print("Numero de orden a buscar: ");
                    int numero = Integer.parseInt(sc.nextLine());

                    OrdenServicio orden = gestor.buscarOrden(numero);
                    System.out.println("Orden encontrada: " + orden);

                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un numero valido.");
                } catch (OrdenException e) {
                    System.out.println("Error: " + e.getMessage());
                } finally {
                    System.out.println("Busqueda finalizada.");
                }

            } else if (opcion == 4) {
                // Modificar orden
                try {
                    System.out.print("Numero de orden a modificar: ");
                    int numero = Integer.parseInt(sc.nextLine());

                    System.out.print("Nueva descripcion: ");
                    String descripcion = sc.nextLine();

                    System.out.print("Nuevo costo: ");
                    double costo = Double.parseDouble(sc.nextLine());

                    gestor.modificarOrden(numero, descripcion, costo);
                    System.out.println("Orden modificada con exito.");

                } catch (NumberFormatException e) {
                    System.out.println("El numero de orden y el costo deben ser numeros.");
                } catch (OrdenException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (opcion == 5) {
                // Cancelar orden
                try {
                    System.out.print("Numero de orden a cancelar: ");
                    int numero = Integer.parseInt(sc.nextLine());

                    gestor.cancelarOrden(numero);
                    System.out.println("Orden cancelada con exito.");

                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un numero valido.");
                } catch (OrdenException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (opcion == 6) {
                // Consultar por placa
                System.out.print("Placa del vehiculo: ");
                String placa = sc.nextLine();

                List<OrdenServicio> lista = gestor.consultarPorPlaca(placa);
                if (lista.size() == 0) {
                    System.out.println("No hay ordenes con esa placa.");
                } else {
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }
                }

            } else if (opcion == 7) {
                // Reporte de costos
                System.out.println("Valor total: Q" + gestor.calcularValorTotal());
                System.out.println("Costo promedio: Q" + gestor.calcularCostoPromedio());

            } else if (opcion == 8) {
                // Orden de mayor costo
                try {
                    OrdenServicio mayor = gestor.obtenerOrdenMayorCosto();
                    System.out.println("Orden de mayor costo: " + mayor);
                } catch (OrdenException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (opcion == 9) {
                // Cantidad de ordenes
                System.out.println("Cantidad de ordenes: " + gestor.cantidadOrdenes());

            } else if (opcion == 10) {
                System.out.println("Saliendo del programa...");

            } else {
                System.out.println("Opcion no valida.");
            }
        }

        sc.close();
    }
}
