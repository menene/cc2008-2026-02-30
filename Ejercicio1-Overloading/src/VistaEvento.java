//Se importa Scanner de utils para poder leer lo que ingrese el usuario
import java.util.Scanner;

public class VistaEvento {
    //Atributos
    //El scannner permite leer el teclado
    private Scanner teclado;

    //Constructor
    public VistaEvento() {
        //Se inicializa el scanner para que lea la entrada del sistema 
        //(system.in)
        this.teclado = new Scanner(System.in);
    }
}

//Metodos del menu y salida

//Muestra el menu principar y devuelve el numer oque eligio el usuario
public int mostrarMenu() {
    System.out.println("\n===========================================");
    Sytem.out.println("    Mundial Femenino 2027 - Boletos");
    System.out.println("=====================================")
    System.out.println("1. Nuevo comprador");
    System.out.println("2. Nueva solicitud de boletos");
    System.out.println("3. Consultar disponibilidad total");
    System.out.println("4. Consultar disponiblidad por localidad");
    System.out.println("5. Reporte de caja");
    System.out.println("6. Salir");
    System.out.println("Elige una opción: ");

    //Se lee el texto y se convierte a numero para evitar errores de salto de linea
    return Integer.parseInt(teclado.nextLine());
}

//metodos que pide datos al usuario

public String pedir Nombre() {
    System.out.print("Ingresa tu nombre: ");
    return teclado.nextLine();
}

public String pedirCorreo() {
    System.out.print("Ingresa tu correo: ");
    return teclado.nextLine();
}

public int pedirBoletos() {
    System.out.print("¿Cuántos boletos deseas comprar?: ")
    return Integer.parseInt(teclado.nextLine());
}

public float pedirPresupuesto() {
    System.out.print("Cuál es tu presupuesto máximo?: $");
    return Float.parseFloat(teclado.nextLine());
}