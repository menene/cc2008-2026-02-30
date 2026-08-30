import java.util.Scanner;
public class Vista{
    private Scanner scanner;
    public Vista(){
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu(){
        System.out.println("\n---------menu-----------");
        System.out.println("1. Registra orden");
        System.out.println("2. Consultar ordenes");
        System.out.println("3. Buscar orden especifica");
        System.out.println("4. Modificar orden");
        System.out.println("5. Cancelar orden");
        System.out.println("6. Buscar orden por placa");
        System.out.println("7. Reporte sobre los costos");
        System.out.println("8. Orden más costosa");
        System.out.println("9. Cantidad de ordenes");
        System.out.println("10. Salir");
        System.out.println("Seleccionar una opción valida");
    }

    public String leerText(){
        return scanner.nextLine();
    }

    public int leerInt(){
        return Integer.parseInt(scanner.nextLine());
    }

     public double leerDouble() {
        return Double.parseDouble(scanner.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}