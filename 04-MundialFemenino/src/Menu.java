import java.util.Scanner;
public class Menu {

//Atributos
private Scanner scanner;
private ControladorVenta controlador;

//Constructor
public Menu(ControladorVenta controlador) {

    this.controlador = controlador;
    scanner = new Scanner(System.in);

}

//Metodos
public void Mostrar_menu() {
//Se muestra el menu de opciones al usuario

    System.out.println("\n--- Menú de opciones ---");
    System.out.println("1. Registrar comprador");
    System.out.println("2. Solicitar compra");
    System.out.println("3. Consultar disponibilidad de localidades");
    System.out.println("4. Consultar disponibilidad individual de localidad");
    System.out.println("5. Reporte de caja");
    System.out.println("6. Salir");
    System.out.print("\nSeleccione una opción: ");

}

//Metodos de lectura y escritura
private String Leer_cadena(String mensaje) {

    System.out.print(mensaje);
    return scanner.nextLine();

}

private int Leer_entero(String mensaje) {

    System.out.print(mensaje);

    int numero = scanner.nextInt();
    scanner.nextLine(); // Limpiar el buffer de entrada

    return numero;

}

private float Leer_float(String mensaje) {

    System.out.print(mensaje);

    float numero = scanner.nextFloat();
    scanner.nextLine(); // Limpiar el buffer de entrada

    return numero;

}

//Metodo para mostrar mensajes al usuario
private void Mostrar_mensajes(String mensaje) {

    System.out.println(mensaje);

}

//Metodo para ejecutar el menu y las opciones seleccionadas por el usuario
public void Ejecutar() {

    int opcion;

    do {

        Mostrar_menu();
        opcion = Leer_entero("");

        switch (opcion) {

            case 1:
                String Nombre = Leer_cadena("Ingrese el nombre del comprador: ");
                String Email = Leer_cadena("Ingrese el email del comprador: ");
                int Cant_boletos = Leer_entero("Ingrese la cantidad de boletos que desea comprar: ");
                float Presupuesto_max = Leer_float("Ingrese el presupuesto máximo que tiene para gastar en boletos: ");

                controlador.Registrar_comprador(Nombre, Email, Cant_boletos, Presupuesto_max);

                Mostrar_mensajes("Comprador registrado exitosamente.");
                break;

            case 2:
                controlador.Solicitar_compra();
                break;

            case 3:
                controlador.Consultar_dispoTotal();
                break;

            case 4:
                int numLocalidad =
                        Leer_entero("Ingrese el número de localidad (1, 5 o 10):");

                controlador.Consultar_DispoIndividual(numLocalidad);

                break;

            case 5:
                Mostrar_mensajes(
                        "El total de dinero recaudado es: Q"
                        + controlador.Reporte_caja());

                break;

            case 6:
                Mostrar_mensajes("Saliendo del programa...");
                break;

            default:
                Mostrar_mensajes("Opción inválida.");
                break;

        }

    } while (opcion != 6);

}
}