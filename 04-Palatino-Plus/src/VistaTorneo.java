import java.util.Scanner;

public class VistaTorneo {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENU TORNEO =====");
        System.out.println("1. Resumen general del torneo");
        System.out.println("2. Consultar estadisticas de un equipo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");

        return Integer.parseInt(sc.nextLine());
    }

    public void resumen(Torneo t) {
        System.out.println("\n----- RESUMEN GENERAL -----");
        System.out.println(t.resumen());
    }

    public String leerNombreEquipo(Torneo t) {
        System.out.println("\nEquipos disponibles:");
        System.out.println(t.listaEquipos());
        System.out.print("Escriba el nombre o alias del equipo: ");
        return sc.nextLine();
    }

    public void estadisticasEquipo(Torneo t, String nombre) {
        System.out.println("\n" + t.estadisticasEquipo(nombre));
    }
}
