import java.util.Scanner;

public class VistaTorneo {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENU TORNEO =====");
        System.out.println("1. Resumen general del torneo");
        System.out.println("2. Consultar estadisticas de un equipo");
        System.out.println("3. Agregar un equipo nuevo");
        System.out.println("4. Eliminar un equipo");
        System.out.println("5. Ver la lista de equipos");
        System.out.println("0. Salir");

        return leerEntero("Seleccione una opcion: ");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();

            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] \"" + entrada + "\" no es un numero entero. Intente de nuevo.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public String leerNombreEquipo(Torneo t) {
        System.out.println("\nEquipos disponibles:");
        System.out.println(t.listaEquipos());
        return leerTexto("Escriba el nombre o alias del equipo: ");
    }

    public Equipo leerNuevoEquipo(int lugar) {
        System.out.println("\n----- NUEVO EQUIPO -----");
        String nombre = leerTexto("Nombre: ");
        String alias = leerTexto("Alias: ");
        int goles = leerEntero("Goles: ");
        int tirosAGol = leerEntero("Tiros a gol: ");
        int tirosEsquina = leerEntero("Tiros de esquina: ");
        int amarillas = leerEntero("Tarjetas amarillas: ");
        int rojas = leerEntero("Tarjetas rojas: ");

        int juegosGanados = 0;
        int juegosPerdidos = 0;
        int faltas = 0;

        return new Equipo(nombre, alias, lugar, tirosEsquina, juegosGanados, juegosPerdidos,
                          tirosAGol, goles, amarillas, rojas, faltas);
    }

    public void resumen(Torneo t) {
        System.out.println("\n----- RESUMEN GENERAL -----");
        System.out.println(t);
    }

    public void listaEquipos(Torneo t) {
        System.out.println("\n----- EQUIPOS INSCRITOS (" + t.cantidadEquipos() + ") -----");
        System.out.println(t.listaEquipos());
    }

    public void estadisticasEquipo(Equipo e) {
        System.out.println();
        System.out.println(e);
    }

    public void mensaje(String texto) {
        System.out.println(texto);
    }

    public void error(String texto) {
        System.out.println("  [ERROR] " + texto);
    }
}
