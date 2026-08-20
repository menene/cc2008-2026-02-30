import java.util.Scanner;

public class VistaTorneo {
    public Scanner sc;

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

        System.out.print(mensaje);
        int numeroParticipante = sc.nextInt();
        sc.nextLine();

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
        System.out.print(mensaje);
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public float pedirTiempo(String mensaje) {
        System.out.print(mensaje);

        float tiempo = sc.nextFloat();
        sc.nextLine();

        return tiempo;
    }

    public void imprimirMensaje(String mensaje) {
        System.out.println();
        System.out.println(mensaje);
    }

    public int pedirIntento() {
        System.out.print("Ingrese el número de intento: ");

        int intento = sc.nextInt();
        sc.nextLine();

        return intento;
    }


}