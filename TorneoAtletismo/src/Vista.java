import java.util.Scanner;

public class Vista {
    private final Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombre() {
        while (true) {
            System.out.print("Nombre del atleta: ");
            String nombre = scanner.nextLine().trim();
            if (!nombre.isEmpty()) {
                return nombre;
            }
            System.out.println("El nombre no puede estar vacio.");
        }
    }

    public int solicitarNumeroParticipante() {
        return solicitarEnteroPositivo("Numero de participante: ");
    }

    public int solicitarEdad() {
        return solicitarEnteroPositivo("Edad: ");
    }

    public double solicitarTiempo() {
        while (true) {
            System.out.print("Tiempo en segundos: ");
            try {
                double tiempo = Double.parseDouble(scanner.nextLine().trim());
                if (tiempo > 0) {
                    return tiempo;
                }
            } catch (NumberFormatException excepcion) {
            }
            System.out.println("El tiempo debe ser un numero mayor que 0.");
        }
    }

    public int solicitarNumeroIntento() {
        return solicitarEnteroPositivo("Numero de intento: ");
    }

    public int mostrarMenu() {
        System.out.println("\n===== TORNEO DE ATLETISMO =====");
        System.out.println("1. Nuevo atleta.");
        System.out.println("2. Registrar nuevo intento.");
        System.out.println("3. Consultar tiempos.");
        System.out.println("4. Consultar un intento.");
        System.out.println("5. Modificar tiempo.");
        System.out.println("6. Mostrar promedio.");
        System.out.println("7. Mostrar mejor y mayor tiempo.");
        System.out.println("8. Consultar intentos disponibles.");
        System.out.println("9. Salir.");
        return solicitarEnteroEnRango("Selecciona una opcion: ", 1, 9);
    }

    public void mostrarAtleta(Atleta atleta) {
        System.out.println("\nAtleta activo: " + atleta.getNombreAtleta()
                + " | Participante: " + atleta.getNumeroParticipante()
                + " | Edad: " + atleta.getEdad());
    }

    public void mostrarTiempo(int numeroIntento, Tiempo tiempo) {
        System.out.printf("Intento %d: %.2f segundos%n", numeroIntento, tiempo.getSegundos());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void esperarEnter() {
        System.out.print("Presiona Enter para volver al menu...");
        scanner.nextLine();
    }

    public void mostrarPromedio(double promedio) {
        System.out.printf("Promedio: %.2f segundos%n", promedio);
    }

    public void mostrarIntentos(int intentos, int disponibles) {
        System.out.println("Intentos realizados: " + intentos);
        System.out.println("Intentos disponibles: " + disponibles);
    }

    private int solicitarEnteroPositivo(String mensaje) {
        return solicitarEnteroEnRango(mensaje, 1, Integer.MAX_VALUE);
    }

    private int solicitarEnteroEnRango(String mensaje, int minimo, int maximo) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }
            } catch (NumberFormatException excepcion) {
            }
            System.out.println("Ingresa un valor valido.");
        }
    }
}