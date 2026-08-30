import java.util.Scanner;
public class VistaCarrera {
    Scanner scanerloco= new Scanner(System.in);

    public int inicio(){
        System.out.println("====================");
        System.out.println("       CARRERA      ");
        System.out.println("1. Registrar un nuevo intento");
        System.out.println("2. Consultar Tiempos");
        System.out.println("3. Consultar un intento");
        System.out.println("4. Modificar Tiempo");
        System.out.println("5. Mostrar Promedio");
        System.out.println("6. Mostrar mejor tiempo");
        System.out.println("7. Consultar intentos disponibles");
        System.out.println("8. Salir");
        System.out.println("====================");
        int opcion = scanerloco.nextInt();
        return opcion;
    }

    public void toString(String texto){
        System.out.println(texto);
    }
    
    public int Ingreso (String text){
        System.out.println("====================");
        System.out.println("Ingresar "+text);
        int ingreso = scanerloco.nextInt();
        return ingreso;
    }

    public void VerIntento(int indice, int [] copiaIntentos){
        System.out.println("Tiempo No."+(indice+1)+": "+copiaIntentos[indice]);
    }

    // Sip estas siguientes tres pudo haber sido una clase mostrar numero con mensaje pero tengo sueño :D

    public void VerIntentos(int [] copiaIntentos, String mensaje){
        System.out.println("====================");
        toString(mensaje);
        for (int i =0; i<copiaIntentos.length; i++){
            VerIntento(i, copiaIntentos);
        }
    }
    public void MostrarMayor (int mayor){
        System.out.println("El mejor timpo fue: " + mayor);
    }
    public void MostrarPromedio(double num){
        System.out.println("El promedio es de: " + num);
    }

    public void mostrarDisponibles (int disponibles){
        System.out.println("Al atleta le quedan: " + disponibles+" intentos disponibles");
    }


}
