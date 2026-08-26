import java.util.Scanner;

public class Vista {
    //scanner utilizado para leer los datos ingresados por el usuario
    private Scanner scanner;

    //constructor que prepara la lectura de datos desde la consola
    public Vista() {
        scanner = new Scanner(System.in);
    }

    //muestra las opciones principales y devuelve la opcion seleccionada
    public int mostrarMenu() {
        System.out.println("\nSistema de Control de Ordenes de Servicio");
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

        return pedirEntero("Seleccione una opcion: ");
    }

    //muestra un mensaje y devuelve el texto ingresado
    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    //muestra un mensaje y convierte la entrada a un numero decimal
    public double pedirDouble(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }

    //muestra un mensaje y convierte la entrada a un numero entero
    public int pedirEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    //muestra informacion o resultados en la consola
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
