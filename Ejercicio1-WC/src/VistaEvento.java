import java.util.Scanner;

public class VistaEvento {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int MostrarMenu() {
        System.out.println("\n===== MENU EVENTO =====");
        System.out.println("1. Nuevo cliente");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");

        return Integer.parseInt(sc.nextLine());
    }

    public Cliente LeerDatosCliente() {
        System.out.println("\n--- Datos del cliente ---");
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Boletos a comprar: ");
        int boletosComprar = Integer.parseInt(sc.nextLine());
        System.out.print("Presupuesto: ");
        float presupuesto = Float.parseFloat(sc.nextLine());

        return new Cliente(nombre, email, boletosComprar, presupuesto);
    }

    public void DisponibilidadTotal(Localidad l1, Localidad l2, Localidad l3) {
        System.out.println("\n----- DISPONIBILIDAD TOTAL -----");
        System.out.println("-Localidad 1-");
        System.out.println(l1.Disponibilidad());
        System.out.println("-Localidad 2-");
        System.out.println(l2.Disponibilidad());
        System.out.println("-Localidad 3-");
        System.out.println(l3.Disponibilidad());
    }

    public void DisponibilidadIndividual(Localidad localidad) {
        System.out.println("\n----- DISPONIBILIDAD INDIVIDUAL -----");
        System.out.println("-Localidad " + localidad.GetNumLocalidad() + "-");
        System.out.println(localidad.Disponibilidad());
    }

    public int EscogerLocalidad() {
        System.out.println("1. Localidad 1");
        System.out.println("2. Localidad 2");
        System.out.println("3. Localidad 3");
        System.out.print("Seleccione una opcion: ");

        return Integer.parseInt(sc.nextLine());
    }

    public void ReporteCaja(Localidad l1, Localidad l2, Localidad l3) {
        System.out.println("Ganancias localidad 1: " + l1.Ganancia());
        System.out.println("Ganancias localidad 2: " + l2.Ganancia());
        System.out.println("Ganancias localidad 3: " + l3.Ganancia());
        System.out.println("Ganancias totales: " + (l1.Ganancia() + l2.Ganancia() + l3.Ganancia()));
    }
}