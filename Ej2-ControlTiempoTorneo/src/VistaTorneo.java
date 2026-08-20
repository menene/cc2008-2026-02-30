import java.util.Scanner;

public class VistaTorneo {
    public Scanner sc;
    int error = 0;
    public VistaTorneo(){
        this.sc = new Scanner(System.in);
    }


    public int mostrarMenuAtletas(String datosAtletas) {

        String mensaje = String.format(
            """

            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                    ATLETAS DISPONIBLES
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

            %s
            0. Salir

            Ingrese el número de participante: 
            """,
            datosAtletas
        );
        int numeroParticipante = 0;
        do{
         System.out.print(mensaje);
         if (sc.hasNextInt()) {
            
            numeroParticipante = sc.nextInt();
             sc.nextLine();
             error = 0;

            } else {
             error = 1;
             sc.nextLine(); 
             System.out.println("Ingrese un número válido. WAZA ");

            }
        } while (error != 0);
        

        return numeroParticipante;
    }

    public int mostrarMenu(String datosAtleta ){

        String mensaje = String.format(
            """

            %s
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                            MENÚ
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
            1. Registrar Nuevo Intento
            2. Consultar Tiempos
            3. Consultar un Intento
            4. Modificar Tiempo
            5. Mostrar Promedio
            6. Mostrar Mejor Y Mayor Tiempo
            7. Consultar Intentos Disponibles
            8. Cambiar Atleta
            0. Salir
            
            Seleccione una opción:
            """,
            datosAtleta
        );
        int opcion = 0;

        do{
         System.out.print(mensaje);
         if (sc.hasNextInt()) {
            
            opcion = sc.nextInt();
             sc.nextLine();
             error = 0;

            } else {
             error = 1;
             sc.nextLine(); 
             System.out.println("Ingrese un número válido. UnU ");

            }
        } while (error != 0);
        
        return opcion;
    }

    public float pedirTiempo(String mensaje) {
    
        
        float tiempo = 0;

        do{
         System.out.print(mensaje);
         if (sc.hasNextFloat()) {
            
            tiempo = sc.nextFloat();
             sc.nextLine();
             error = 0;

            } else {
             error = 1;
             sc.nextLine(); 
             System.out.println("Ingrese un número válido. Genio ");

            }
        } while (error != 0);
        

        return tiempo;
    }

    public void imprimirMensaje(String mensaje) {
        System.out.println();
        System.out.println(mensaje);
    }

    public int pedirIntento() {
        
        int intento = 0;

         do{
         System.out.print("Ingrese el número de intento: ");
         if (sc.hasNextInt()) {
            intento = sc.nextInt();
             sc.nextLine();
             error = 0;

            } else {
             error = 1;
             sc.nextLine(); 
             System.out.println("Ingrese un número válido. ( ͡° ͜ʖ ͡°)");

            }
        } while (error != 0);
        return intento;
    }


}