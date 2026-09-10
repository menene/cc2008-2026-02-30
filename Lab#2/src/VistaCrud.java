import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaCrud {
    private Scanner scanner;
    public VistaCrud() {
        this.scanner = new Scanner(System.in);
    }

    public String pedirTexto(String mensaje) {
        String texto = "";
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                texto = scanner.nextLine().trim();
                if (texto.isEmpty()) {
                    System.out.println("Texto Vacio");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("Error, esta mal en algo");
            }
        }
        return texto;
    }

    public int pedirEntero(String mensaje ){
        int valor =-1 ; 
        boolean valido = false; 
        while (!valido) {
            try {
                System.out.println(mensaje);
                valor=scanner.nextInt();
                valido=true; 
                
            } catch (InputMismatchException e) {
                System.out.println("El ingreso debe ser un numero valido ");
            }finally{
                scanner.nextLine();
            }
        }
        return valor; 
    }

    public Escenario pedirDatosEscenario(){
        String codigo = pedirTexto("Codigo del escenario: ");
        String nombre = pedirTexto("Nombre del escenario: ");
        String ubicacion = pedirTexto("Ubicacion del escenario");
        int capacidad = pedirEntero("Maxima capacidad del escenario: ");
        String estado = pedirTexto("Estado del escenario: ");
        return new Escenario(codigo, nombre, ubicacion, capacidad, estado);
    }

    public Artista pedirDatosArtista(){
        String codigo = pedirTexto("Codigo del artista: ");
        String nombre = pedirTexto("Nombre del artista: ");
        String genero = pedirTexto("Genero de la musica a tocar: ");
        int duracion = pedirEntero("Ingrese la duracion de la presentacion: ");
        int asistentes = pedirEntero("Ingrese la cantidad de asistentes de apoyo: ");
        return new Artista(codigo, nombre, genero, duracion, asistentes);

    }

    public void mostrarEscenario(Escenario esc){
        System.out.println("Escenario Codigo -> " + esc.getCodigo());
        System.out.println("Nombre: " + esc.getNombre());
        System.out.println("Ubicacion: " + esc.getUbicacion());
        System.out.println("Capacidad: " + esc.getCapacidad());
        System.out.println("Estado: " + esc.getEstado());

    }
    public void mostrarArtista(Artista art){
        System.out.println("Escenario Codigo -> " + art.getCodigo());
        System.out.println("Nombre: " + art.getNombre());
        System.out.println("Genero musical: " + art.getGeneroMusical());
        System.out.println("Duracion: " + art.getDuracion());

    } 
    public int pedirPosicion() {
        return pedirEntero("Ingrese la posicion del escenario en el arreglo 1-5: ");
    }

    public String pedirCodigo() {
        return pedirTexto("Ingrese el codigo a buscar: ");
    }

}
