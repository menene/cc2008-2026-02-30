import java.util.List;
import java.util.Scanner;

public class VistaOrdenes {
    private Scanner sc = new Scanner(System.in);

    public int MostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
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
        System.out.print("Seleccione una opción: ");

        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(
                "Debes ingresar una opción numérica."
            );
            return -1;
        }
    }

    public OrdenServicio LeerOrdenServicio() {
        try {
            System.out.print("Número de orden: ");
            int numOrden =
                    Integer.parseInt(sc.nextLine());

            System.out.print("Nombre del propietario: ");
            String propietario = sc.nextLine();

            System.out.print("Placa del vehículo: ");
            String placa = sc.nextLine();

            System.out.print("Descripción del servicio: ");
            String descripcion = sc.nextLine();

            System.out.print("Costo estimado: Q.");
            double costo =
                    Double.parseDouble(sc.nextLine());

            return new OrdenServicio(
                numOrden,
                propietario,
                placa,
                descripcion,
                costo
            );

        } catch (NumberFormatException e) {
            System.out.println(
                "El número de orden y el costo deben ser numéricos."
            );
            return null;
        }
    }

    public void MostrarOrdenes(
            List<OrdenServicio> ordenes) {

        if (ordenes.isEmpty()) {
            System.out.println(
                "No hay órdenes registradas."
            );
            return;
        }

        System.out.println("\n--- ÓRDENES REGISTRADAS ---");

        for (OrdenServicio orden : ordenes) {
            MostrarDatosOrden(orden);
        }
    }

    public int LeerNumeroOrden() {
        System.out.print("Ingrese el número de orden: ");

        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(
                "Debes ingresar un número."
            );
            return -1;
        }
    }

    public void MostrarOrdenBuscada(
            OrdenServicio orden) {

        if (orden == null) {
            return;
        }

        System.out.println("\nOrden encontrada:");
        MostrarDatosOrden(orden);
    }

    public int MostrarOpcionesModificacion() {
        System.out.println("\n¿Qué desea modificar?");
        System.out.println("1. Descripción");
        System.out.println("2. Costo");
        System.out.print("Seleccione una opción: ");

        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(
                "Debes ingresar una opción numérica."
            );
            return -1;
        }
    }

    public String LeerNuevaDescripcion() {
        System.out.print(
            "Ingrese la nueva descripción: "
        );

        String descripcion = sc.nextLine();

        if (descripcion.isBlank()) {
            System.out.println(
                "La descripción no puede estar vacía."
            );
            return "INVALIDO";
        }

        return descripcion;
    }

    public double LeerNuevoCosto() {
        System.out.print("Ingrese el nuevo costo: Q.");

        try {
            double costo =
                    Double.parseDouble(sc.nextLine());

            if (costo <= 0) {
                System.out.println(
                    "El costo debe ser mayor que cero."
                );
                return -1;
            }

            return costo;

        } catch (NumberFormatException e) {
            System.out.println(
                "Debes ingresar un costo numérico."
            );
            return -1;
        }
    }

    public void OrdenCancelada() {
        System.out.println(
            "La orden fue cancelada correctamente."
        );
    }

    public String LeerPlaca() {
        System.out.print(
            "Ingrese la placa del vehículo: "
        );

        String placa = sc.nextLine();

        if (placa.isBlank()) {
            System.out.println(
                "La placa no puede estar vacía."
            );
            return "INVALIDO";
        }

        return placa;
    }

    public void MostrarOrdenConsultadaPlaca(
            List<OrdenServicio> ordenes) {

        if (ordenes.isEmpty()) {
            System.out.println(
                "No se encontraron órdenes para esa placa."
            );
            return;
        }

        System.out.println(
            "\nÓrdenes asociadas a la placa:"
        );

        for (OrdenServicio orden : ordenes) {
            MostrarDatosOrden(orden);
        }
    }

    public void MostrarReporteCostos(
            double total,
            double promedio) {

        System.out.println("\nReporte de costos:");
        System.out.println(
            "Valor total de todas las órdenes: Q."
            + total
        );
        System.out.println(
            "Promedio de todas las órdenes: Q."
            + promedio
        );
    }

    public void MostrarOrdenDeCostoMayor(
            OrdenServicio orden) {

        if (orden == null) {
            System.out.println(
                "\nNo hay órdenes registradas."
            );
            return;
        }

        System.out.println(
            "\nDatos de la orden de costo mayor:"
        );

        MostrarDatosOrden(orden);
    }

    public void MostrarCantidadOrdenes(
            int cantidad) {

        System.out.println(
            "\nCantidad total de órdenes: "
            + cantidad
        );
    }

    public void MostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    private void MostrarDatosOrden(
            OrdenServicio orden) {

        System.out.println("-------------------------");
        System.out.println(
            "Número de orden: "
            + orden.GetNumOrden()
        );
        System.out.println(
            "Propietario: "
            + orden.GetPropietario()
        );
        System.out.println(
            "Placa: "
            + orden.GetPlaca()
        );
        System.out.println(
            "Descripción: "
            + orden.GetDescripcion()
        );
        System.out.println(
            "Costo estimado: Q."
            + orden.GetCosto()
        );
    }
}