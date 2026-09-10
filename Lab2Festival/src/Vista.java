import java.util.Scanner;
public class Vista{

    private Scanner scanner;

    public Vista(){
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== FESTIVAL UNIVERSITARIO =====");
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
        System.out.println("11. Cancelar participacion");
        System.out.println("12. Mostrar reporte");
        System.out.println("13. Salir");
    }

    public String[] pedirdatosFestival(){
        String[] datos = new String[3];

        System.out.print("Nombre del festival: ");
        datos[0] = scanner.nextLine();

        System.out.print("Codigo de identificacion : ");
        datos[1] = scanner.nextLine();

        System.out.print("Nombre del coordinador: ");
        datos[2] = scanner.nextLine();

        return datos;
    }

    public String[] pedirDatosEscenario(){
        String[] datos = new String[5];

        System.out.print("Codigo: ");
        datos[0] = scanner.nextLine();

        System.out.print("Nombre: ");
        datos[1] = scanner.nextLine();

        System.out.print("Ubicacion: ");
        datos[2] = scanner.nextLine();

        System.out.print("Capacidad max: ");
        datos[3]= scanner.nextLine();

        System.out.print("Estado: ");
        datos[4] = scanner.nextLine();

        return datos;
    }

    public String[] pedirDatosArtista(){
        String[] datos= new String[5];
        System.out.print("Codigo: ");
        datos[0] = scanner.nextLine();

        System.out.print("Nombre artistico: ");
        datos[1] = scanner.nextLine();

        System.out.print("Genero musical: ");
        datos[2] = scanner.nextLine();

        System.out.print("Duracion de presentacion: ");
        datos[3] = scanner.nextLine();

        System.out.print("Cantidad estimada de asistentes: ");
        datos[4] = scanner.nextLine();

        return datos;
    }

    public void mostrarEscenario(Escenario escenario){
        if (escenario == null){
            System.out.println("No hay escenario, no existe");
            return;
        }
        System.out.println("Codigo: "+ escenario.getCodigo());
        System.out.println("Nombre: "+ escenario.getNombre());
        System.out.println("Ubic: "+ escenario.getUbicacion());
        System.out.println("Capacidad: "+ escenario.getCapacidad());
        System.out.println("Estado: "+ escenario.getEstado());
    }

    public void mostrarArtista(Artista artista){
        if (artista == null) {
            System.out.println("Artista no encontrado.");
            return;
        }
        System.out.println("Nombre: "+ artista.getNombreArtista());
        System.out.println("Genero: "+ artista.getGeneroMusical());
        System.out.println("Duracion: "+ artista.getDuracion());
        System.out.println("Asistentes: "+ artista.getCantidadAsistentes());  
    }
    public void mostrarReporte(String reporte){
        System.out.println("\n-----------Reporte del festival----------------\n");
        System.out.println(reporte);
    }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public int pedirOpcion() {
        System.out.print("Ingrese una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    public String[] pedirDatosFestival() {
        String[] datos = new String[3];

        System.out.print("Nombre del festival: ");
        datos[0] = scanner.nextLine();

        System.out.print("Codigo de identificacion: ");
        datos[1] = scanner.nextLine();

        System.out.print("Nombre del coordinador: ");
        datos[2] = scanner.nextLine();

        return datos;
    }
    public void cerrarScanner() {
        scanner.close();
    }
    
}