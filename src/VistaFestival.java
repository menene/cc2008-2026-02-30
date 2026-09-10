import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaFestival {

    //atributos
    
    private Scanner datos = new Scanner(System.in);


    // métodos

    // Muestra un mensaje y lee una cadena de texto ingresada por el usuario; es generico para no crear un metodo por cada campo especifico.
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return datos.nextLine();
    }

    // Muestra un mensaje y lee un valor entero; captura InputMismatchException si el usuario ingresa un valor que no corresponde al tipo solicitado, limpia la entrada incorrecta y evita que el programa finalice inesperadamente.
    public int leerEntero(String mensaje) {
        while (true){
            try{
                System.out.print(mensaje);
                int valor = datos.nextInt();
                datos.nextLine();
                return valor;
            } 
            catch (InputMismatchException e){
                datos.nextLine();
                System.out.println("Valor no valido. Ingrese un numero entero.");
            }
        }    
    }

    // Muestra mensajes genericos que le envia el controlador, como confirmaciones, advertencias y errores.
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Da la bienvenida al programa y muestra el menu con las 13 opciones disponibles.
    public void mostrarBienvenida() {
        System.out.println();
        System.out.println("¡Biembenidos al Programa que facilitará tu Festival!");
        System.out.println();
        System.out.println("\n==== MENÚ FESTIVAL ====");
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
        System.out.println();
    }

    // Lee del Scanner la opcion elegida por el usuario en el menu.
    public int leerOpcion() {
        return leerEntero("Ingresa la opcion que desees: ");
    }

    // Muestra toda la informacion de un escenario especifico recibida como parametros simples: posicion, codigo, nombre, ubicacion, capacidad maxima y estado.
    public void mostrarEscenario(int posicion, String codigo, String nombre, String ubicacion, int capacidadMaxima, String estado) {
        System.out.println("\nEscenario en posicion " + posicion);
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicacion: " + ubicacion);
        System.out.println("Capacidad maxima: " + capacidadMaxima);
        System.out.println("Estado: " + estado);
    }

    // Muestra toda la informacion de un artista especifico recibida como parametros simples: codigo, nombre artistico, genero musical, duracion y cantidad estimada de asistentes.
    public void mostrarArtista(String codigo, String nombreArtistico, String generoMusical, int duracionPresentacion, int cantidadEstimadaAsistentes) {
        System.out.println("\nArtista");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre artistico: " + nombreArtistico);
        System.out.println("Genero musical: " + generoMusical);
        System.out.println("Duracion de presentacion: " + duracionPresentacion + " minutos");
        System.out.println("Cantidad estimada de asistentes: " + cantidadEstimadaAsistentes);
    }

    // Muestra el reporte completo del festival con los resultados de los calculos realizados por el controlador.
    public void mostrarReporteFestival(int cantidadEscenarios, int espaciosDisponibles, String escenarioMayorCapacidad, int cantidadArtistas, String artistaMayorDuracion, String artistaMayorAsistentes, double promedioDuracion) {
        System.out.println("\n==== REPORTE DEL FESTIVAL ====");
        System.out.println("Escenarios configurados: " + cantidadEscenarios);
        System.out.println("Espacios disponibles: " + espaciosDisponibles);
        System.out.println("Escenario con mayor capacidad: " + escenarioMayorCapacidad);
        System.out.println("Artistas registrados: " + cantidadArtistas);
        System.out.println("Artista con mayor duracion: " + artistaMayorDuracion);
        System.out.println("Artista con mayor cantidad estimada de asistentes: " + artistaMayorAsistentes);
        System.out.println("Promedio de duracion: " + promedioDuracion);
    }
}
