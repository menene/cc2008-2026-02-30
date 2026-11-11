import arenagt.dominio.*;
import arenagt.presentacion.Main;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

public final class Pruebas {
    private final Copa copa = new Copa();
    private final LocalDate dia = LocalDate.of(2026, 11, 12);
    private final List<Encuentro> encuentros = new ArrayList<>();
    private int total;

    public static void main(String[] args) throws Exception {
        new Pruebas().ejecutar();
    }

    private void comprobar(String entrada, String esperado, String obtenido) {
        if (!esperado.equals(obtenido)) throw new AssertionError(entrada + ": " + obtenido + " (esperado " + esperado + ")");
        total++;
        System.out.println(entrada + "\t" + esperado + "\t" + obtenido);
    }

    private String tabla() {
        return String.join(", ", copa.getTabla().stream().map(e -> e.getNombre() + " " + e.getPuntosTabla()).toList());
    }

    private String calendario() {
        List<String> filas = new ArrayList<>();
        for (Programable evento : copa) {
            Programacion p = evento.getProgramacion().orElseThrow();
            filas.add(evento.getId() + " " + p.getFecha() + "/" + p.getHora() + "/" + p.getSede());
        }
        return String.join(", ", filas);
    }

    private String estado() {
        StringBuilder s = new StringBuilder(tabla()).append(calendario());
        for (Encuentro e : encuentros) s.append(e.getEstado()).append(e.getMarcadorA()).append(e.getMarcadorB());
        return s.toString();
    }

    private void rechazo(String entrada, String mensaje, Runnable accion) {
        String antes = estado();
        try {
            accion.run();
            throw new AssertionError("Se aceptó: " + entrada);
        } catch (IllegalStateException | IllegalArgumentException error) {
            comprobar(entrada, mensaje + " Estado intacto.", error.getMessage() +
                    (antes.equals(estado()) ? " Estado intacto." : " Estado alterado."));
        }
    }

    private void ejecutar() throws Exception {
        copa.registrarEquipo("S", "Sol", "Sur");
        copa.registrarEquipo("F", "Faro", "Norte");
        Encuentro f = copa.crearFutbolSala("F1", "F", "S");
        Encuentro b = copa.crearBaloncesto("B1", "S", "F");
        encuentros.addAll(List.of(f, b));
        Exhibicion x = copa.crearExhibicion("X", "Clínica");
        comprobar("Crear dos equipos y tres eventos sin fecha", "Faro 0, Sol 0 / SIN_PROGRAMAR / SIN_PROGRAMAR / ",
                tabla() + " / " + f.getEstado() + " / " + x.getEstado() + " / " + calendario());
        rechazo("Equipo con código vacío", "El campo código es obligatorio.", () -> copa.registrarEquipo(" ", "Otro", "E"));
        rechazo("Código repetido con espacios: ' S '", "Código de equipo repetido: S", () -> copa.registrarEquipo(" S ", "Otro", "E"));
        rechazo("Nombre vacío", "El campo nombre es obligatorio.", () -> copa.registrarEquipo("Z", "", "E"));
        rechazo("Empresa vacía", "El campo empresa es obligatorio.", () -> copa.registrarEquipo("Z", "Otro", ""));
        rechazo("Evento sin id", "El campo id de evento es obligatorio.", () -> copa.crearExhibicion("", "Arte"));
        rechazo("Exhibición sin título", "El campo título es obligatorio.", () -> copa.crearExhibicion("Z", " "));
        rechazo("Id compartido por dos tipos", "Id de evento repetido: F1", () -> copa.crearExhibicion(" F1 ", "Arte"));
        rechazo("Fútbol: F contra F", "El encuentro requiere dos equipos distintos.", () -> copa.crearFutbolSala("Z", "F", "F"));
        rechazo("Baloncesto: F contra Z", "Equipo desconocido: Z", () -> copa.crearBaloncesto("Z", "F", "Z"));
        rechazo("Buscar Z después de altas inválidas", "Evento desconocido: Z", () -> copa.buscarEvento("Z"));
        rechazo("Resultado para X", "Este evento no admite resultados.", () -> copa.buscarPuntuable("X"));
        rechazo("F1 todavía sin fecha: 2-2", "Primero debe programar el encuentro.", () -> f.registrarResultado(2, 2));
        f.programar(dia, 0, "A");
        x.programar(dia, 0, "B");
        b.programar(dia.plusDays(1), 23, "A");
        comprobar("Mezclar eventos; horas límite 0 y 23", "F1 2026-11-12/0/A, X 2026-11-12/0/B, B1 2026-11-13/23/A", calendario());
        rechazo("Mover X a la reserva de F1", "Sede ocupada por F1.", () -> x.programar(dia, 0, " A "));
        rechazo("Mover B1 a otra sede a la hora de F1", "Un equipo ya juega a esa hora en F1.", () -> b.programar(dia, 0, "C"));
        rechazo("Hora -1", "La hora debe estar entre 0 y 23.", () -> b.programar(dia, -1, "C"));
        rechazo("Hora 24", "La hora debe estar entre 0 y 23.", () -> b.programar(dia, 24, "C"));
        rechazo("Fecha nula", "La fecha es obligatoria.", () -> b.programar(null, 3, "C"));
        rechazo("Sede vacía", "El campo sede es obligatorio.", () -> x.programar(dia, 3, " "));
        b.programar(dia, 1, "A");
        b.programar(dia, 1, "A");
        x.programar(dia, 2, "A");
        comprobar("Reprogramar B1, repetir su reserva y mover X", "F1 2026-11-12/0/A, B1 2026-11-12/1/A, X 2026-11-12/2/A", calendario());
        rechazo("F1: -1 a 0", "Los marcadores deben ser enteros no negativos.", () -> f.registrarResultado(-1, 0));
        rechazo("B1: 3 a -1", "Los marcadores deben ser enteros no negativos.", () -> b.registrarResultado(3, -1));
        rechazo("B1: 70 a 70", "En baloncesto no se permite empate.", () -> b.registrarResultado(70, 70));
        f.registrarResultado(2, 2);
        comprobar("F1: empate 2-2 y desempate por nombre", "Faro 1, Sol 1 / FINALIZADO", tabla() + " / " + f.getEstado());
        rechazo("Repetir resultado de F1", "El encuentro ya está finalizado.", () -> f.registrarResultado(3, 0));
        rechazo("Mover F1 finalizado", "Un encuentro finalizado no se puede reprogramar.", () -> f.programar(dia, 5, "C"));
        b.registrarResultado(74, 78);
        comprobar("B1: Sol 74, Faro 78 (1 y 2 puntos)", "Faro 3, Sol 2", tabla());
        Encuentro vuelta = copa.crearFutbolSala("V", "F", "S");
        vuelta.programar(dia, 3, "A");
        vuelta.registrarResultado(0, 3);
        comprobar("V: Faro 0, Sol 3 (0 y 3 puntos)", "Sol 5, Faro 3", tabla());
        String menu = consola("6\n7\n0\n");
        comprobar("Arranque: tabla de cuatro equipos", "Luna, Faro, Río, Sol", orden(menu, "2 | LUN", "1 | FAR", "1 | RIO", "1 | SOL") ? "Luna, Faro, Río, Sol" : "Orden incorrecto");
        comprobar("Arranque: calendario y marcadores", "E1 2–2, X1, E2 78–74, E3; E4 sin fecha",
                orden(menu, "| E1 |", "(2–2)", "| X1 |", "| E2 |", "(78–74)", "| E3 |") && !menu.contains("| E4 |")
                        ? "E1 2–2, X1, E2 78–74, E3; E4 sin fecha" : "Calendario incorrecto");

        String inicial = seccion(menu, "Puntos | Código");
        for (String[] caso : new String[][] {
            {"9", "Opción desconocida"}, {"2\n3", "Deporte desconocido"},
            {"4\nE3\n2026-02-30", "fecha válida"}, {"4\nE3\n2026-11-15\nnueve", "número entero"},
            {"5\nE3\n2\nx", "número entero"}, {"5\nE3\n2147483648", "número entero"}
        }) {
            String salida = consola(caso[0] + "\n6\n7\n0\n");
            String evidencia = caso[1] + "; tabla y calendario intactos";
            comprobar("Menú: " + caso[0].replace("\n", " / "), evidencia,
                    salida.contains("Error:") && salida.contains(caso[1]) && inicial.equals(seccion(salida, "Puntos | Código"))
                            ? evidencia : "Salida distinta");
        }
        String altas = consola("1\nN\nNube\nNorte\n2\n2\nB5\nN\nFAR\n3\nX2\nClínica nueva\n4\nX2\n2026-12-01\n8\nB\n4\nB5\n2026-12-01\n9\nA\n5\nB5\n8\n3\n6\n7\n0\n");
        comprobar("Menú: altas N, B5 y X2; programar y registrar 8-3", "Nube 2; X2 y B5 visibles",
                altas.contains("2 | N | Nube") && orden(altas, "| X2 |", "| B5 |", "(8–3)") ? "Nube 2; X2 y B5 visibles" : "Salida distinta");
        System.out.println("Total aprobado: " + total);
    }

    private static String seccion(String texto, String inicio) { return texto.substring(texto.indexOf(inicio)); }

    private static boolean orden(String texto, String... partes) {
        int desde = 0;
        for (String parte : partes) {
            int indice = texto.indexOf(parte, desde);
            if (indice < 0) return false;
            desde = indice + parte.length();
        }
        return true;
    }

    private static String consola(String entrada) throws Exception {
        InputStream original = System.in;
        PrintStream pantalla = System.out;
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        try (PrintStream captura = new PrintStream(salida, true, StandardCharsets.UTF_8)) {
            System.setIn(new ByteArrayInputStream(entrada.getBytes(java.nio.charset.Charset.defaultCharset())));
            System.setOut(captura);
            Main.main(new String[0]);
        } finally {
            System.setIn(original);
            System.setOut(pantalla);
        }
        return salida.toString(StandardCharsets.UTF_8);
    }
}
