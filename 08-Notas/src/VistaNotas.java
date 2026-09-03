import java.util.ArrayList;
import java.util.Scanner;

public class VistaNotas {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENU DE NOTAS =====");
        System.out.println("1. Ver matriz de promedios");
        System.out.println("2. Agregar una nota");
        System.out.println("3. Consultar estudiante");
        System.out.println("4. Consultar curso");
        System.out.println("0. Salir");
        return leerEntero("Seleccione una opcion: ");
    }

    public void mostrarMatriz(Notas notas) {
        System.out.println("\n----- MATRIZ DE PROMEDIOS -----");
        System.out.printf("%-12s", "Estudiante");
        for (int curso = 0; curso < notas.cantidadCursos(); curso++) {
            System.out.printf("%15s", notas.getCurso(curso));
        }
        System.out.println();

        for (int estudiante = 0; estudiante < notas.cantidadEstudiantes(); estudiante++) {
            System.out.printf("%-12s", notas.getEstudiante(estudiante));
            for (int curso = 0; curso < notas.cantidadCursos(); curso++) {
                ArrayList<Double> celda = notas.obtenerNotas(estudiante, curso);
                String promedio = celda.isEmpty() ? "-" : String.format("%.2f", notas.promedio(estudiante, curso));
                System.out.printf("%15s", promedio);
            }
            System.out.println();
        }
        System.out.println("Cada celda es un ArrayList con una o varias notas.");
    }

    public void mostrarDetalleEstudiante(Notas notas, int estudiante) {
        System.out.println("\n----- " + notas.getEstudiante(estudiante) + " -----");
        for (int curso = 0; curso < notas.cantidadCursos(); curso++) {
            System.out.printf("%s: %s | Promedio: %.2f%n", notas.getCurso(curso),
                    notas.obtenerNotas(estudiante, curso), notas.promedio(estudiante, curso));
        }
        System.out.printf("Promedio general: %.2f%n", notas.promedioEstudiante(estudiante));
    }

    public void mostrarDetalleCurso(Notas notas, int curso) {
        System.out.println("\n----- " + notas.getCurso(curso) + " -----");
        for (int estudiante = 0; estudiante < notas.cantidadEstudiantes(); estudiante++) {
            System.out.printf("%s: %s | Promedio: %.2f%n", notas.getEstudiante(estudiante),
                    notas.obtenerNotas(estudiante, curso), notas.promedio(estudiante, curso));
        }
        System.out.printf("Promedio del curso: %.2f%n", notas.promedioCurso(curso));
    }

    public void mostrarEstudiantes(Notas notas) {
        System.out.println("\nEstudiantes:");
        for (int i = 0; i < notas.cantidadEstudiantes(); i++) {
            System.out.println((i + 1) + ". " + notas.getEstudiante(i));
        }
    }

    public void mostrarCursos(Notas notas) {
        System.out.println("\nCursos:");
        for (int i = 0; i < notas.cantidadCursos(); i++) {
            System.out.println((i + 1) + ". " + notas.getCurso(i));
        }
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Escriba un numero entero.");
            }
        }
    }

    public double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Escriba un numero valido.");
            }
        }
    }

    public void mensaje(String texto) {
        System.out.println(texto);
    }

    public void error(String texto) {
        System.out.println("[ERROR] " + texto);
    }
}
