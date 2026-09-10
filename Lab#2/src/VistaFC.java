import java.util.InputMismatchException;
import java.util.Scanner;
public class VistaFC{
    private Scanner scanner;

    public VistaFC() {
        this.scanner = new Scanner(System.in);
    }

    public void ImprTextoGen(String texto) {
        System.out.println(texto);
    }

    public void ImprNumGen(int numero) {
        System.out.println(numero);
    }

    public void ImprTitulosGen(String titulo) {
        System.out.println("\n");
        System.out.println("  " + titulo.toUpperCase());
        System.out.println("______________________________");
    }

    public int Menu() {
        System.out.println("\n");
        System.out.println(" Festival de musica ");
        System.out.println("--------------------");
        System.out.println("1. Nuevo festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar escenarios");
        System.out.println("4. Consultar un escenario");
        System.out.println("5. Modificar escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar artistas");
        System.out.println("9. Buscar artista");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participacion de artista");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
        
        return InputInt("-> ");
    }

    public int InputInt(String mensaje) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero valido.");
            } finally {
                scanner.nextLine(); // Limpiar bufer
            }
        }
        return valor;
    }

    public String InputText(String mensaje) {
        String texto = "";
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                texto = scanner.nextLine().trim();
                if (!texto.isEmpty()) {
                    valido = true;
                } else {
                    System.out.println("Error: El texto no puede estar vacio.");
                }
            } catch (Exception e) {
                System.out.println("Error al leer la entrada.");
            }
        }
        return texto;
    }
}