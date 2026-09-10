import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {
    private Scanner sc = new Scanner(System.in); 


    public int mostrarMenu() {
        System.out.println("\n===== MENU FESTIVAL UNIVERSITARIO DE MUSICA =====");
        System.out.println("1. Nuevo festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar escenarios");
        System.out.println("4. Consultar un escenario por posicion");
        System.out.println("5. Modificar escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar artistas");
        System.out.println("9. Buscar artista por codigo");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participación de un artista");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
        
        return pedirDatosNumericos("Seleccione una opción: ");
    }

    public int pedirDatosNumericos(String texto) {
        boolean solicitudNumero = true; 
        int numero = 0;
        while (solicitudNumero){
            try {
                System.out.println(texto);
                numero = sc.nextInt();
                sc.nextLine(); 
                solicitudNumero = false;  
            } catch (InputMismatchException e) { 
                sc.nextLine();
                error("Debe ingresar un numero. ");
            }
        }
        return numero; 
    }


    public String pedirTexto(String texto){
        System.out.println(texto + "");
        return sc.nextLine(); 

    }

    public void mensaje(String texto) {
        System.out.println(texto);
    }

    public void error(String texto){
        System.out.println(texto);

    }

    public void mostrarEscenarios( Escenario [] escenarios){
        boolean listado = false; 
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                listado = true;
                mostrarEscenarioEsp(escenarios[i], i +1);
            } 
        }
        if (listado == false){
            error("No hay escenarios en la lista.");
        }
        
    }

    public void mostrarEscenarioEsp( Escenario e, int posicion){
        System.out.println("La posición del escenario es: " + posicion);
        System.out.println("Código del escenario: " + e.getCodigoEsc());
        System.out.println("Nombre del escenario: " + e.getNombreEsc());
        System.out.println("Ubicación: " +e.getUbicacion());
        System.out.println("Capacidad máxima de: " + e.getCapMaxAsist());
        
        if (e.getEstado()) {
            System.out.println("Estado: Disponible");
        } else {
            System.out.println("Estado: No disponible");
        }
    }

    public void mostrarArtistas( ArrayList<Artista> artistas){ 
        
        if (artistas.isEmpty()){
            error("No hay artistas registrados en el sistema");
        }else{
            for (Artista artista: artistas) {
                mostrarArtista(artista);
            }
        } 
    }

    public void mostrarArtista(Artista artista){
        System.out.println("======INFORMACIÖN ARTISTA========");
        System.out.println("Código del artista: " + artista.getCodigoArt());
        System.out.println("Nombre artístico: " + artista.getNombreArt());
        System.out.println("Genero musical: " + artista.getGeneroMusc());
        System.out.println("Duración de la presentación (min): "+ artista.getDuracionMin());
        System.out.println("Cantidad estimada de asistentes en la presentación: " + artista.getCantidadEst());

    }

    public void mostrarReporte(int numEscenarios, int espaciosDisponibles, Escenario escMayorCapacidad, int numArtistas, Artista mayorDuracionArt, Artista mayorCantidadEst, double promedioDuracion){
        System.out.println("======= REPORTE GENERAL DE FESTIVAL========");
        System.out.println("Escenarios registrados: " + numEscenarios);
        System.out.println("Espacios disponibles en la lista: " + espaciosDisponibles); 

        if (escMayorCapacidad == null){
            mensaje("No hay escenarios registrados, no se puede mostrar el dato");
        } else {
            System.out.println("El escenario con mayor capacidad es: " +escMayorCapacidad.getNombreEsc());
            System.out.println("Tiene una capacidad máxima de: " + escMayorCapacidad.getCapMaxAsist());
        }

        System.out.println("Artistas registrados: " +numArtistas);
        if (mayorDuracionArt == null){
            mensaje("No hay artistas en el registro, no se puede mostrar el dato");
            } else {
                System.out.println("El artista con la presentacion de mayor duración es: " + mayorDuracionArt.getNombreArt());
                System.out.println("Su presentación dura (min): " + mayorDuracionArt.getDuracionMin());
            }

        System.out.println("Promedio de duración de las presentaciones (min): " + promedioDuracion);

        
        if (mayorCantidadEst == null){
            mensaje("No hay artistas en el registro, no se puede mostrar el dato");
            } else {
                System.out.println("El artista con mayor cantidad de asistentes estimados es: " + mayorCantidadEst.getNombreArt());
                System.out.println("La cantidad estimada es: " + mayorCantidadEst.getCantidadEst());
            }
    }   

}
