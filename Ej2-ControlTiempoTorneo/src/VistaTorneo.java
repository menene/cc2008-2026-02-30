import java.util.Scanner;

public class VistaTorneo {
    public Scanner sc;

    public  VistaTorneo(){
        sc = new Scanner;
    }
    public int mostrarMenu(String datosAtleta ){

        String.format(
            """
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
            9. Salir


            Selecciones una opción: 
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
            """
        );
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
        System.out.println(mensaje);
    }

    public int pedirIntento() {
        System.out.print("Ingrese el número de intento: ");

        int intento = sc.nextInt();
        sc.nextLine();

        return intento;
    }


}