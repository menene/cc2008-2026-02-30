import java.util.List;
import java.util.Scanner;

public class Vista {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n======================================");
        System.out.println("   TALLER AUTOMOTRIZ - MENÚ PRINCIPAL");
        System.out.println("======================================");
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
        System.out.println("======================================");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine();

                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {
                System.out.println(
                        "Error: debe ingresar un número entero válido."
                );
            }
        }
    }

    public double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine();

                // Permite utilizar punto o coma decimal
                entrada = entrada.replace(',', '.');

                double numero = Double.parseDouble(entrada);

                if (numero <= 0) {
                    System.out.println(
                            "Error: el costo debe ser mayor que cero."
                    );
                    continue;
                }

                return numero;

            } catch (NumberFormatException e) {
                System.out.println(
                        "Error: debe ingresar un número válido."
                );
            }
        }
    }

    public String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println(
                        "Error: este campo no puede estar vacío."
                );
            } else {
                return texto;
            }
        }
    }

    public void mostrarOrden(Orden orden) {
        if (orden != null) {
            System.out.println("\n--- Información de la orden ---");
            System.out.println(orden);
        } else {
            System.out.println("No se encontró la orden.");
        }
    }

    public void mostrarOrdenes(List<Orden> ordenes) {
        if (ordenes == null || ordenes.isEmpty()) {
            System.out.println("No hay órdenes para mostrar.");
            return;
        }

        System.out.println("\n--- Órdenes registradas ---");

        for (Orden orden : ordenes) {
            System.out.println(orden);
            System.out.println("------------------------------");
        }
    }

    public void mostrarCostos(double total, double promedio) {
        System.out.println("\n--- Reporte de costos ---");
        System.out.printf("Costo total: Q%.2f%n", total);
        System.out.printf("Costo promedio: Q%.2f%n", promedio);
    }

    public void mostrarCantidad(int cantidad) {
        System.out.println(
                "Cantidad de órdenes registradas: " + cantidad
        );
    }

    public void Mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}