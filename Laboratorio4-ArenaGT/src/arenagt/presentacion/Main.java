package arenagt.presentacion;

import arenagt.dominio.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        Copa copa = new Copa();
        cargarDatos(copa);
        try (Scanner entrada = new Scanner(System.in)) {
            ejecutarMenu(copa, entrada);
        }
    }

    private static void cargarDatos(Copa copa) {
        copa.registrarEquipo("FAR", "Faro", "Empresa Norte");
        copa.registrarEquipo("SOL", "Sol", "Empresa Sur");
        copa.registrarEquipo("LUN", "Luna", "Empresa Norte");
        copa.registrarEquipo("RIO", "Río", "Empresa Sur");
        LocalDate fecha = LocalDate.of(2026, 11, 12);
        Encuentro e1 = copa.crearFutbolSala("E1", "FAR", "SOL");
        e1.programar(fecha, 9, "Arena A");
        e1.registrarResultado(2, 2);
        Encuentro e2 = copa.crearBaloncesto("E2", "LUN", "RIO");
        e2.programar(fecha, 10, "Arena A");
        e2.registrarResultado(78, 74);
        copa.crearFutbolSala("E3", "FAR", "LUN").programar(fecha.plusDays(1), 9, "Arena A");
        copa.crearBaloncesto("E4", "SOL", "RIO");
        copa.crearExhibicion("X1", "Clínica de baloncesto").programar(fecha, 9, "Arena B");
    }

    private static void ejecutarMenu(Copa copa, Scanner entrada) {
        while (true) {
            System.out.println("\nArenaGT | 1 Registrar equipo | 2 Crear encuentro | 3 Crear exhibición");
            System.out.println("4 Programar o reprogramar | 5 Registrar resultado | 6 Tabla | 7 Calendario | 0 Salir");
            try {
                switch (leer(entrada, "Opción")) {
                    case "0" -> { return; }
                    case "1" -> copa.registrarEquipo(leer(entrada, "Código"), leer(entrada, "Nombre"), leer(entrada, "Empresa"));
                    case "2" -> crearEncuentro(copa, entrada);
                    case "3" -> copa.crearExhibicion(leer(entrada, "Id"), leer(entrada, "Título"));
                    case "4" -> {
                        Programable evento = copa.buscarEvento(leer(entrada, "Id"));
                        LocalDate fecha = LocalDate.parse(leer(entrada, "Fecha (AAAA-MM-DD)"));
                        evento.programar(fecha, entero(entrada, "Hora (0–23)"), leer(entrada, "Sede"));
                    }
                    case "5" -> {
                        String id = leer(entrada, "Id");
                        Puntuable encuentro = copa.buscarPuntuable(id);
                        System.out.println(copa.buscarEvento(id).getDescripcion());
                        encuentro.registrarResultado(entero(entrada, "Marcador del primer equipo"), entero(entrada, "Marcador del segundo equipo"));
                    }
                    case "6" -> { mostrarTabla(copa); continue; }
                    case "7" -> { mostrarCalendario(copa); continue; }
                    default -> throw new IllegalArgumentException("Opción desconocida. Elija de 0 a 7.");
                }
                System.out.println("Operación registrada.");
            } catch (DateTimeParseException e) {
                System.out.println("Error: ingrese una fecha válida en formato AAAA-MM-DD.");
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NoSuchElementException e) {
                return; // Fin de la entrada, incluso durante una operación.
            }
        }
    }

    private static void crearEncuentro(Copa copa, Scanner entrada) {
        String deporte = leer(entrada, "Deporte (1 fútbol sala, 2 baloncesto)");
        if (!deporte.equals("1") && !deporte.equals("2")) throw new IllegalArgumentException("Deporte desconocido.");
        String id = leer(entrada, "Id");
        String a = leer(entrada, "Código del primer equipo");
        String b = leer(entrada, "Código del segundo equipo");
        if (deporte.equals("1")) copa.crearFutbolSala(id, a, b);
        else copa.crearBaloncesto(id, a, b);
    }

    private static String leer(Scanner entrada, String etiqueta) {
        System.out.print(etiqueta + ": ");
        return entrada.nextLine().trim();
    }

    private static int entero(Scanner entrada, String etiqueta) {
        try {
            return Integer.parseInt(leer(entrada, etiqueta));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(etiqueta + " debe ser un número entero en el rango de int.");
        }
    }

    private static void mostrarTabla(Copa copa) {
        System.out.println("Puntos | Código | Equipo | Empresa");
        for (Equipo equipo : copa.getTabla()) {
            System.out.printf("%d | %s | %s | %s%n", equipo.getPuntosTabla(), equipo.getCodigo(), equipo.getNombre(), equipo.getEmpresa());
        }
    }

    private static void mostrarCalendario(Copa copa) {
        for (Programable evento : copa) {
            Programacion p = evento.getProgramacion().orElseThrow();
            System.out.printf("%s %02d:00 | %s | %s | %s%n", p.getFecha(), p.getHora(), p.getSede(), evento.getId(), evento.getDescripcion());
        }
    }
}
