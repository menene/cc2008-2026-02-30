import java.util.Scanner;

public class VistaTaller {

    private Scanner sc;

    public VistaTaller() {
        sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("""
                
                +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                        TALLER AUTOMOTRIZ 
                +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                1. Registrar orden
                2. Consultar órdenes
                3. Buscar orden
                4. Modificar orden
                5. Cancelar orden
                6. Consultar órdenes por placa
                7. Reporte de costos
                8. Orden de mayor costo
                9. Cantidad de órdenes

                0. Salir
                """);

        return pedirEntero("Seleccione una opción: ");
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    public int pedirEntero(String mensaje) {
        System.out.println(mensaje);
        return Integer.parseInt(sc.nextLine());
    }

    public double pedirDecimal(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(sc.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}