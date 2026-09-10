import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VistaFestival {

    private final Scanner teclado;

    public VistaFestival() {
        teclado = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n============== MENU ==============");
        System.out.println("1. Crear o reemplazar festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar todos los escenarios");
        System.out.println("4. Consultar escenario por posicion");
        System.out.println("5. Modificar un escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar todos los artistas");
        System.out.println("9. Buscar artista por codigo");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participacion");
        System.out.println("12. Mostrar reporte");
        System.out.println("0. Salir");
        System.out.println("==================================");
    }

    public String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            String valor = teclado.nextLine().trim();

            if (!valor.isEmpty()) {
                return valor;
            }

            mostrarError("El valor no puede estar vacio.");
        }
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            String valor = teclado.nextLine().trim();

            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException excepcion) {
                mostrarError("Ingrese un numero entero valido.");
            }
        }
    }

    public double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            String valor = teclado.nextLine()
                    .trim()
                    .replace(',', '.');

            try {
                double numero = Double.parseDouble(valor);

                if (!Double.isFinite(numero)) {
                    throw new NumberFormatException();
                }

                return numero;
            } catch (NumberFormatException excepcion) {
                mostrarError("Ingrese un numero decimal valido.");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    public void mostrarEscenarios(List<Escenario> escenarios) {
        System.out.println("\n--- ESCENARIOS DEL FESTIVAL ---");

        for (int i = 0; i < escenarios.size(); i++) {
            Escenario escenario = escenarios.get(i);

            System.out.print("Posicion " + (i + 1) + ": ");

            if (escenario == null) {
                System.out.println("Disponible");
            } else {
                System.out.println(escenario);
            }
        }
    }

    public void mostrarEscenario(int posicion,
                                 Escenario escenario) {

        if (escenario == null) {
            System.out.println(
                    "La posicion " + posicion + " esta disponible."
            );
        } else {
            System.out.println(escenario);
        }
    }

    public void mostrarArtistas(List<Artista> artistas) {
        System.out.println("\n--- ARTISTAS REGISTRADOS ---");

        if (artistas.isEmpty()) {
            System.out.println("No hay artistas registrados.");
            return;
        }

        for (Artista artista : artistas) {
            System.out.println(artista);
        }
    }

    public void mostrarArtista(Artista artista) {
        if (artista == null) {
            System.out.println("Artista no encontrado.");
        } else {
            System.out.println(artista);
        }
    }

    public void mostrarReporte(Festival festival) {
        Escenario escenarioMayor =
                festival.getEscenarioMayorCapacidad();

        Artista artistaMayorDuracion =
                festival.getArtistaMayorDuracion();

        Artista artistaMayorAsistencia =
                festival.getArtistaMayorAsistencia();

        System.out.println(
                "\n========== REPORTE DEL FESTIVAL =========="
        );

        System.out.println(
                "Festival: " + festival.getNombre()
                        + " (" + festival.getCodigo() + ")"
        );

        System.out.println(
                "Coordinador: " + festival.getCoordinador()
        );

        mostrarEscenarios(festival.consultarEscenarios());

        System.out.println(
                "Escenarios configurados: "
                        + festival.getCantidadEscenariosConfigurados()
        );

        System.out.println(
                "Posiciones disponibles: "
                        + festival.getCantidadPosicionesDisponibles()
        );

        System.out.println(
                "Escenario con mayor capacidad: "
                        + (escenarioMayor == null
                        ? "No hay escenarios configurados"
                        : escenarioMayor)
        );

        System.out.println(
                "Cantidad de artistas: "
                        + festival.getCantidadArtistas()
        );

        System.out.println(
                "Artista con mayor duracion: "
                        + (artistaMayorDuracion == null
                        ? "No hay artistas registrados"
                        : artistaMayorDuracion)
        );

        System.out.println(
                "Artista con mayor asistencia: "
                        + (artistaMayorAsistencia == null
                        ? "No hay artistas registrados"
                        : artistaMayorAsistencia)
        );

        System.out.printf(
                Locale.US,
                "Promedio de duracion: %.2f minutos%n",
                festival.getPromedioDuracion()
        );

        System.out.println(
                "=========================================="
        );
    }

    public void cerrar() {
        teclado.close();
    }
}