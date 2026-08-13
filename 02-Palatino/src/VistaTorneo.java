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
// mensaje menjase
    public EquipoPokemon leerDatosEquipo() {
        System.out.println("\n--- Datos del equipo ---");
        System.out.print("Nombre del equipo: ");
        String nombre = sc.nextLine();
        System.out.print("Lugar: ");
        int lugar = Integer.parseInt(sc.nextLine());
        System.out.print("Tiros de esquina: ");
        int tirosEsquina = Integer.parseInt(sc.nextLine());
        System.out.print("Juegos ganados: ");
        int juegosGanados = Integer.parseInt(sc.nextLine());
        System.out.print("Juegos perdidos: ");
        int juegosPerdidos = Integer.parseInt(sc.nextLine());
        System.out.print("Tiros a gol: ");
        int tirosAGol = Integer.parseInt(sc.nextLine());
        System.out.print("Goles: ");
        int goles = Integer.parseInt(sc.nextLine());
        System.out.print("Tarjetas amarillas: ");
        int tarjetasAmarillas = Integer.parseInt(sc.nextLine());
        System.out.print("Tarjetas rojas: ");
        int tarjetasRojas = Integer.parseInt(sc.nextLine());
        System.out.print("Faltas: ");
        int faltas = Integer.parseInt(sc.nextLine());

        return new EquipoPokemon(nombre, lugar, tirosEsquina, juegosGanados, juegosPerdidos,
                          tirosAGol, goles, tarjetasAmarillas, tarjetasRojas, faltas);
    }

    public String leerNombreTorneo() {
        System.out.print("Nombre del torneo: ");
        return sc.nextLine();
    }

    public void resumen(Torneo t) {
        System.out.println("\n----- RESUMEN GENERAL -----");
        System.out.println(t.resumen());
    }

    public int leerNumeroEquipo(Torneo t) {
        System.out.println("\nSeleccione un equipo:");
        System.out.println(t.listaEquipos());
        System.out.print("Opcion: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void estadisticasEquipo(Torneo t, int numero) {
        System.out.println("\n" + t.estadisticasEquipo(numero));
    }
}
