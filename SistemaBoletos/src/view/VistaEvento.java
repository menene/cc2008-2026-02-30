package view;

import java.text.DecimalFormat;
import java.util.Scanner;

import model.Comprador;

public class VistaEvento {
    //Atributos
    public Scanner sc = new Scanner(System.in);

    // Métodos
    public int mostrarMenu(String nombreEvento) {
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("BIENVENIDO A " + nombreEvento);
        System.out.println("---------------------------------------");
        System.out.println("MENÚ");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de compra de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    // Lee datos del comprador 
    public Comprador leerComprador() {
        sc.nextLine();
        System.out.println();
        System.out.println("Ingrese los datos del comprador:");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.println("¡GRACIAS! Ahora puedes realizar la solicitud de compra.");

        return new Comprador(nombre, correo);
    }

    public int leerCantidadBoletosAComprar() {
        System.out.print("Cantidad de boletos: ");
        return sc.nextInt();
    }

    public float leerPresupuesto() {
        System.out.print("Presupuesto máximo: ");
        return sc.nextFloat();
    }

    //Muestra mensaje de compra exitosa o compra parcial
    public void mostrarCompra(boolean esParcial, String localidad, int cantidad, float total) {
        DecimalFormat df = new DecimalFormat("$ #,##0.00");
        System.out.println(String.format(
                "%n-------------------------------------%n"
              + (esParcial ? "COMPRA PARCIAL EXITOSA :)%n" : "COMPRA EXITOSA :)%n")
              + "-------------------------------------%n"
              + (esParcial ? "Solo se pudieron vender los boletos disponibles%n" : "")
              + "Detalles:%n"
              + "Localidad: %s%n" 
              + "Cantidad de boletos: %d%n" 
              + "Total pagado: %s%n", 
              localidad,
              cantidad,
              df.format(total)
        ));
    }

    // Muestra mensaje de compra rechazada
    public void mostrarCompraRechazada(int motivo) {
        String mensaje;
        switch (motivo) {
            case 1:
                mensaje = "Su ticket no fue seleccionado para poder comprar boletos.";
                break;
            case 2:
                mensaje = "Sin disponibilidad en la localidad asignada.";
                break;
            case 3:
                mensaje = "Presupuesto insuficiente.";
                break;
            default:
                mensaje = "";
                break;
        }
        System.out.println();
        System.out.println("¡COMPRA FALLIDA! :(");
        System.out.println(mensaje);
    }

    public void mostrarDisponibilidad(String info) {
        System.out.println();
        System.out.println(info);
    }


    public int pedirLocalidad(String localidades) {
        System.out.println("Localidades:");
        System.out.println(localidades);
        System.out.print("Ingrese el número de la localidad:");
        return sc.nextInt();
    }

    public void mostrarReporteCaja(String info) {
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Reporte de caja");
        System.out.println("---------------------------------------");
        System.out.println(info);
    }

    public void mensajeFaltaDatosComprador() {
        System.out.println();
        System.out.println("***No puede comprar sin antes ingresar los datos del comprador en la opción 1 del Menú.");
    }

    public void mensajeOpcionInvalida() {
        System.out.println();
        System.out.println("Opción inválida. Inténtelo nuevamente.");
    }
}