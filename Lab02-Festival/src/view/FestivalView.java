package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Artista;
import model.Escenario;

public class FestivalView {
    private final Scanner scanner;

    public FestivalView() { scanner = new Scanner(System.in); }

    public void mostrarMenu() {
        System.out.println("\n=== FESTIVAL UNIVERSITARIO DE MÚSICA ===");
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
        System.out.println("11. Cancelar participación");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un número entero válido.");
                scanner.nextLine();
            }
        }
    }

    public String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) return texto;
            System.out.println("Error: el texto no puede quedar vacío.");
        }
    }

    public void mostrarEscenarios(Escenario[] escenarios) {
        boolean existen = false;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                System.out.println("Posición " + (i + 1) + ": " + escenarios[i]);
                existen = true;
            }
        }
        if (!existen) mostrarMensaje("No hay escenarios configurados.");
    }

    public void mostrarEscenario(Escenario escenario) { 
        System.out.println(escenario); 
    }

    public void mostrarArtistas(ArrayList<Artista> artistas) {
        if (artistas.isEmpty()) {
            mostrarMensaje("No hay artistas registrados.");
            return;
        }
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + ". " + artistas.get(i));
        }
    }

    public void mostrarArtista(Artista artista) { 
        System.out.println(artista); 
    }

    public void mostrarReporte(String reporte) { 
        System.out.println(reporte); 
    }

    public void mostrarMensaje(String mensaje) { 
        System.out.println(mensaje); 
    }

    public void mostrarError(String mensaje) { 
        System.out.println("Error: " + mensaje); 
    }

    public void cerrar() { 
        scanner.close(); 
    }
}
