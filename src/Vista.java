import java.util.Scanner;

public class Vista {
    private Scanner scanner = new Scanner(System.in);
    public int mostrarMenu() {
        System.out.println("===== FESTIVAL UNIVERSITARIO DE MUSICA =====");
        System.out.println("1. Nuevo festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar escenarios");
        System.out.println("4. Consultar un escenario");
        System.out.println("5. Modificar escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar artistas");
        System.out.println("9. Buscar artista");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participación");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Festival leerFestival() {
        scanner.nextLine();
        System.out.println("===== NUEVO FESTIVAL =====");
        System.out.print("Ingrese el código del festival: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el nombre del festival: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nombre del coordinador: ");
        String nombre_coordinador = scanner.nextLine();

        return new Festival(
            codigo,
            nombre,
            nombre_coordinador
        );
    }

    public Escenario leerEscenario() {
        System.out.println("===== NUEVO ESCENARIO =====");
        System.out.print("Ingrese el código del escenario: ");
        String codigo_escenario = scanner.nextLine();
        System.out.print("Ingrese el nombre del escenario: ");
        String nombre_escenario = scanner.nextLine();
        System.out.print("Ingrese la ubicación del escenario: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Ingrese la capacidad máxima: ");
        short cap_max = scanner.nextShort();
        System.out.print(
            "Ingrese el estado (true = ocupado, false = libre): "
        );

        boolean estado = scanner.nextBoolean();
        scanner.nextLine();
        Escenario escenario = new Escenario(
            codigo_escenario,
            nombre_escenario,
            ubicacion,
            cap_max
        );

        escenario.Setestado(estado);
        return escenario;
    }

    public Artista leerArtista() {
        System.out.println("===== NUEVO ARTISTA =====");
        System.out.print("Ingrese el código del artista: ");
        String codigo_id = scanner.nextLine();
        System.out.print("Ingrese el nombre artístico: ");
        String nombre_artistico = scanner.nextLine();
        System.out.print("Ingrese el género musical: ");
        String genero_musical = scanner.nextLine();
        System.out.print("Ingrese la duración de la presentación: ");
        float duracion = scanner.nextFloat();
        System.out.print("Ingrese la cantidad estimada de asistentes: ");
        short asistencia = scanner.nextShort();
        scanner.nextLine();

        return new Artista(
            codigo_id,
            nombre_artistico,
            genero_musical,
            duracion,
            asistencia
        );
    }

    public void mostrarFestival(Festival festival) {
        System.out.println("===== INFORMACIÓN DEL FESTIVAL =====");
        System.out.println(
            "Código: " + festival.Getcodigo()
        );
        System.out.println(
            "Nombre: " + festival.Getnombre()
        );
        System.out.println(
            "Coordinador: " + festival.Getnombre_coordinador()
        );
    }

    public void mostrarEscenario(Escenario escenario) {
        System.out.println("----- ESCENARIO -----");
        System.out.println(
            "Código: " + escenario.GetCodigo_escenario()
        );
        System.out.println(
            "Nombre: " + escenario.GetNombre_escenario()
        );
        System.out.println(
            "Ubicación: " + escenario.GetUbicación()
        );
        System.out.println(
            "Capacidad máxima: " + escenario.GetCap_max()
        );
        System.out.println(
            "Estado: " + escenario.Getestado()
        );
    }

    public void mostrarArtista(Artista artista) {
        System.out.println("----- ARTISTA -----");
        System.out.println(
            "Código: " + artista.GetCodigo_id()
        );
        System.out.println(
            "Nombre artístico: " + artista.GetNombre_artistico()
        );
        System.out.println(
            "Género musical: " + artista.GetGenero_musical()
        );
        System.out.println(
            "Duración: " + artista.Getduracion() + " minutos"
        );
        System.out.println(
            "Asistencia estimada: " + artista.Getasistencia()
        );
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}