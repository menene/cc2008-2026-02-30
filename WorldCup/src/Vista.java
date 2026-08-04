import java.util.Scanner;

public class Vista {
    private Scanner scanner;

    //constructor
    public Vista() {
        scanner = new Scanner(System.in);
        //esto lo copie un poco del palatino de erick haha
    }

    //menu
    public void mostrarMenu() {
        System.out.println("\n===== 2027 FIFA Women's World Cup =====");
        System.out.println("\n");
        System.out.println("1. Comprador nuevo");
        System.out.println("2. Solicitar boletos");
        System.out.println("3. Boletos disponibles en total");
        System.out.println("4. Boletos individuales por localidad");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");

        System.out.print("Selecciona una opcion: ");
    }


    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
        //aca va a mostrar mensajes que le mande despues    
        }


    //y para poder leer al usuario    
    public Scanner getScanner() {
        return scanner;
    }




}