import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaFestival {

    private Scanner scanner;

    public VistaFestival() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("========== FESTIVAL UNIVERSITARIO DE MÚSICA ==========");
        System.out.println(" 1. Nuevo festival");
        System.out.println(" 2. Configurar escenario");
        System.out.println(" 3. Consultar escenarios");
        System.out.println(" 4. Consultar un escenario");
        System.out.println(" 5. Modificar escenario");
        System.out.println(" 6. Retirar escenario");
        System.out.println(" 7. Registrar artista");
        System.out.println(" 8. Consultar artistas");
        System.out.println(" 9. Buscar artista");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participación");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println(" 0. Salir");
        System.out.println("=======================================================");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                if (entrada == null || entrada.isBlank()) {
                    throw new InputMismatchException("La entrada no puede estar vacía.");
                }
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException | InputMismatchException e) {
                mostrarMensaje("Entrada inválida: debe ingresar un número entero. Intente de nuevo.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public String leerTextoNoVacio(String mensaje) {
        String texto = leerTexto(mensaje);
        while (texto == null || texto.isBlank()) {
            mostrarMensaje("Este dato no puede estar vacío. Intente de nuevo.");
            texto = leerTexto(mensaje);
        }
        return texto;
    }

    public int leerEnteroPositivo(String mensaje) {
        int valor = leerEntero(mensaje);
        while (valor <= 0) {
            mostrarMensaje("El valor debe ser mayor que 0. Intente de nuevo.");
            valor = leerEntero(mensaje);
        }
        return valor;
    }

    public int leerEnteroNoNegativo(String mensaje) {
        int valor = leerEntero(mensaje);
        while (valor < 0) {
            mostrarMensaje("El valor no puede ser negativo. Intente de nuevo.");
            valor = leerEntero(mensaje);
        }
        return valor;
    }

    public int leerEnteroEnRango(String mensaje, int minimo, int maximo) {
        int valor = leerEntero(mensaje);
        while (valor < minimo || valor > maximo) {
            mostrarMensaje("El valor debe estar entre " + minimo + " y " + maximo + ". Intente de nuevo.");
            valor = leerEntero(mensaje);
        }
        return valor;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEscenario(int posicion, Escenario escenario) {
        System.out.println("[Posición " + posicion + "] " + escenario);
    }

    public void mostrarArtista(Artista artista) {
        System.out.println(artista);
    }

    public void mostrarReporte(int configurados, int disponibles, Escenario mayorCapacidad,
                                int artistasRegistrados, Artista mayorDuracion,
                                Artista mayorAsistencia, double promedio) {
        System.out.println();
        System.out.println("---------- REPORTE DEL FESTIVAL ----------");
        System.out.println("Escenarios configurados: " + configurados);
        System.out.println("Espacios disponibles: " + disponibles);
        System.out.println("Escenario con mayor capacidad: "
                + (mayorCapacidad == null ? "No hay escenarios configurados." : mayorCapacidad));
        System.out.println("Artistas registrados: " + artistasRegistrados);
        System.out.println("Artista con presentación de mayor duración: "
                + (mayorDuracion == null ? "No hay artistas registrados." : mayorDuracion));
        System.out.println("Artista con mayor cantidad estimada de asistentes: "
                + (mayorAsistencia == null ? "No hay artistas registrados." : mayorAsistencia));
        System.out.printf("Promedio de duración de las presentaciones: %.2f minutos%n", promedio);
        System.out.println("-------------------------------------------");
    }

    public void cerrar() {
        scanner.close();
    }
}