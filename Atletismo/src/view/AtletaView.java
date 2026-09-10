package view;
 
import controller.AtletaController;
import java.util.Scanner;
 
public class AtletaView {
 
    private AtletaController controller;
    private Scanner reader;
 
    public AtletaView(AtletaController controller) {
        this.controller = controller;
        this.reader = new Scanner(System.in);
    }
 
    public void mostrarMenu() {
        boolean salir = false;
 
        while (!salir) {
            System.out.println("\n===== Control de Tiempos - Torneo de Atletismo =====");
            System.out.println("1. Nuevo atleta");
            System.out.println("2. Registrar nuevo intento");
            System.out.println("3. Consultar tiempos");
            System.out.println("4. Consultar un intento");
            System.out.println("5. Modificar tiempo");
            System.out.println("6. Mostrar promedio");
            System.out.println("7. Mostrar mejor y mayor tiempo");
            System.out.println("8. Consultar intentos disponibles");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
 
            int opcion = leerEntero();
 
            switch (opcion) {
                case 1:
                    solicitarNuevoAtleta();
                    break;
                case 2:
                    solicitarNuevoIntento();
                    break;
                case 3:
                    mostrarTiempos();
                    break;
                case 4:
                    mostrarIntento();
                    break;
                case 5:
                    solicitarModificarTiempo();
                    break;
                case 6:
                    mostrarPromedio();
                    break;
                case 7:
                    mostrarMejorYMayor();
                    break;
                case 8:
                    mostrarDisponibilidad();
                    break;
                case 9:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
 
        reader.close();
    }
 
    private void solicitarNuevoAtleta() {
        System.out.print("Nombre del atleta: ");
        String nombre = reader.nextLine();
 
        System.out.print("Número de participante: ");
        int numeroParticipante = leerEntero();
 
        System.out.print("Edad: ");
        int edad = leerEntero();
 
        controller.nuevoAtleta(nombre, numeroParticipante, edad);
        System.out.println("Atleta registrado correctamente. Comienza sin intentos.");
    }
 
    private void solicitarNuevoIntento() {
        if (!hayAtletaActivo()) {
            return;
        }
 
        System.out.print("Tiempo obtenido (segundos): ");
        double tiempo = leerDouble();
 
        boolean registrado = controller.registrarIntento(tiempo);
        if (registrado) {
            System.out.println("Intento registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el intento. Verifique que el tiempo sea "
                    + "mayor que 0 y que todavía existan posiciones disponibles (máximo 10).");
        }
    }
 
    private void mostrarTiempos() {
        if (!hayAtletaActivo()) {
            return;
        }
 
        double[] tiempos = controller.consultarTiempos();
        if (tiempos.length == 0) {
            System.out.println("El atleta todavía no tiene intentos registrados.");
            return;
        }
 
        System.out.println("Tiempos registrados:");
        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("Intento " + (i + 1) + ": " + tiempos[i] + " s");
        }
    }
 
    private void mostrarIntento() {
        if (!hayAtletaActivo()) {
            return;
        }
 
        System.out.print("Número de intento a consultar: ");
        int numeroIntento = leerEntero();
 
        try {
            double tiempo = controller.consultarIntento(numeroIntento);
            System.out.println("Intento " + numeroIntento + ": " + tiempo + " s");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
 
    private void solicitarModificarTiempo() {
        if (!hayAtletaActivo()) {
            return;
        }
 
        System.out.print("Número de intento a modificar: ");
        int numeroIntento = leerEntero();
 
        System.out.print("Nuevo tiempo (segundos): ");
        double nuevoTiempo = leerDouble();
 
        boolean modificado = controller.modificarTiempo(numeroIntento, nuevoTiempo);
        if (modificado) {
            System.out.println("Tiempo modificado correctamente.");
        } else {
            System.out.println("No se pudo modificar el tiempo. Verifique que el intento exista "
                    + "y que el nuevo tiempo sea mayor que 0.");
        }
    }
 
    private void mostrarPromedio() {
        if (!hayAtletaActivo()) {
            return;
        }
 
        try {
            double promedio = controller.obtenerPromedio();
            System.out.printf("Promedio: %.2f s%n", promedio);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
 
    private void mostrarMejorYMayor() {
        if (!hayAtletaActivo()) {
            return;
        }
 
        try {
            double mejor = controller.obtenerMejorTiempo();
            double mayor = controller.obtenerMayorTiempo();
            System.out.println("Mejor tiempo (más bajo): " + mejor + " s");
            System.out.println("Tiempo más alto: " + mayor + " s");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
 
    private void mostrarDisponibilidad() {
        if (!hayAtletaActivo()) {
            return;
        }
 
        int registrados = controller.obtenerCantidadIntentos();
        int disponibles = controller.obtenerIntentosDisponibles();
        System.out.println("Intentos registrados: " + registrados + " / 10");
        System.out.println("Intentos disponibles: " + disponibles);
    }

    private boolean hayAtletaActivo() {
        if (!controller.hayAtletaActivo()) {
            System.out.println("Todavía no hay un atleta activo. Registre uno con la opción 1.");
            return false;
        }
        return true;
    }
 
    private int leerEntero() {
        while (true) {
            try {
                int valor = Integer.parseInt(reader.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número entero: ");
            }
        }
    }
 
    private double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(reader.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número (puede tener decimales): ");
            }
        }
    }
}