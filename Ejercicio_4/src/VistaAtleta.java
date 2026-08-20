import java.util.Scanner;
public class VistaAtleta {
    private Scanner scanner;
    public VistaAtleta() {
        scanner = new Scanner(System.in);
    }
    public void mostrarMenu() {
    System.out.println("\n MENU PRINCIPAL ");
    System.out.println("1. Agregar nuevo atleta");
    System.out.println("2. Registrar intento");
    System.out.println("3. Mostrar tiempos");
    System.out.println("4. Modificar intento");
    System.out.println("5. Mostrar promedio");
    System.out.println("6. Mostrar mejor tiempo");
    System.out.println("7. Mostrar mayor tiempo");
    System.out.println("8. Mostrar intentos disponibles");
    System.out.println("9. Salir");
}
    public int solicitarOpcion(){
        System.out.print("Seleccione una opcion: ");
        return scanner.nextInt();
    }
    public String solicitarNombre(){
        scanner.nextLine();
        System.out.print("Ingrese el nombre del atleta: ");
        return scanner.nextLine();
    }
    public int solicitarNumeroParticipante(){
        System.out.print("Ingrese el numero del participante: ");
        return scanner.nextInt();
    }
    public int solicitarEdad(){
        System.out.print("Ingrese la edad del atleta: ");
        return scanner.nextInt();
    }
    public double solicitarTiempo(){
        System.out.print("Ingrese el tiempo obtenido: ");
        return scanner.nextDouble();
    }
    public int solicitarNumeroIntento(){
        System.out.print("Ingrese el numero de intento: ");
        return scanner.nextInt();
    }
    public void MostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void mostrarTiempo(int numeroIntento, double tiempo){
        System.out.println(
                "Intento " + numeroIntento + ": " + tiempo);
    }
    public void mostrarResultado(String descripcion, double resultado){
        System.out.println(descripcion + ": " + resultado);
    }
}