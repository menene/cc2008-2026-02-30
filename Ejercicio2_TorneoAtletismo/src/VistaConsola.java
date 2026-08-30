import java.util.Scanner;

public class VistaConsola{

    private Scanner scanner;
    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    private int leerEntero(String mensaje){

        while (true) {

            System.out.print(mensaje);

            if (scanner.hasNextInt()) {

                int valor = scanner.nextInt();
                scanner.nextLine();

                return valor;   
            }

            System.out.println("Entrada invalida! Ingrese un numero entero");
            scanner.nextLine();
        }
    }

    private double leerDouble(String mensaje) {

    while (true) {

        System.out.print(mensaje);

            if (scanner.hasNextDouble()) {
            double valor = scanner.nextDouble();
            scanner.nextLine();

            return valor;

            }

            System.out.println("Entrada invalida! Ingrese un número");
            scanner.nextLine();
        }
    }

    public String solicitarNombre(){

        System.out.println("Ingrese el nombre del atleta: ");
        return scanner.nextLine();
    }

    public int solicitarNumeroParticipante(){

        int numero = leerEntero("Ingrese el numero de participante: ");

        while (numero <= 0){

            System.out.println("El numero debe ser mayor que 0");
            numero = leerEntero("Ingrese el numero de participante: ");
        }

        return numero;      
    }

    public int solicitarEdad() {

        int edad = leerEntero("Ingrese la edad: ");

        while (edad <= 0){

            System.out.println("La edad debe ser mayor que 0 ");
            edad = leerEntero("Ingrese la edad: ");
        }

        return edad;    
    }

    public double solicitarTiempo() {

        return leerDouble("Ingrese el tiempo en segundos: ");
    }

    public int solicitarNumeroIntento(){

        return leerEntero("Ingrese el numero de intento: ");
    }

    public int mostrarMenu(){

        System.out.println("\n===== CONTROL DE TIEMPOS =====");
        System.out.println("1. Nuevo atleta");
        System.out.println("2. Registrar nuevo intento");
        System.out.println("3. Consultar tiempos");
        System.out.println("4. Consultar un intento");
        System.out.println("5. Modificar tiempo");
        System.out.println("6. Mostrar promedio");
        System.out.println("7. Mostrar mejor y mayor tiempo");
        System.out.println("8. Consultar intentos disponibles");
        System.out.println("9. Salir");

        return leerEntero("Seleccione una opción: ");
    }

    public void mostrarMensaje(String mensaje){

        System.out.println(mensaje);
    }

    public void mostrarTiempo(int numeroIntento, double tiempo){

        System.out.println("Intento " + numeroIntento + ": " + tiempo + " segundos");

    }
}