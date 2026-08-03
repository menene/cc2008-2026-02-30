import java.util.Scanner;
public class Vista {

    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {

        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud");
        System.out.println("3. Disponibilidad total");
        System.out.println("4. Disponibilidad individual");
        System.out.println("5. Reporte caja");
        System.out.println("6. Salir");

        return sc.nextInt();
    }

}