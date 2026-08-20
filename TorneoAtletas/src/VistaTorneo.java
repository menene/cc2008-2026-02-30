import java.util.Scanner;

public class VistaTorneo{

    // atributos

    Scanner datos = new Scanner(System.in);


    // métodos 
    
    // Dar la biembenida al programa y mostrar el menú
    public void mostrarBiembenida(){
        System.out.println("\n===== MENU DEL SISTEMA DE REGISTRO DE TIEMPO EN CARRERA UVG =====");
        System.out.println("1. Nuevo atleta");
        System.out.println("2. Registar nuevo intento de tiempo");
        System.out.println("3. Consultar tiempo ingresados");
        System.out.println("4. Consultar un intento especifico");
        System.out.println("5. Modificar un intento ya realizado");
        System.out.println("6. Mostrar el promedio de los intentos ya registrados");
        System.out.println("7. Mostrar mejor y peor tiempo");
        System.out.println("8. Consultar intentos disponibles");
        System.out.println("9. Salir del programa");
        System.out.println();
        System.out.print("Seleccione una opcion: ");
    }

    // lee del Scanner la opción elegida
    public int leerOpcion(){
        int opcion = Integer.parseInt(datos.nextLine());
        return opcion;
    }

    // muestra un mensaje y lee el cadenas, son genericos para no usar una por cadena especifica
    public String leerTexto(String mensaje){
        System.out.println(mensaje);

        String texto = datos.nextLine();
        return texto;
    }
    
    // muestra un mensaje y lee un entero,  son genericos para no usar una por cadena especifica
    public int leerEntero(String mensaje){
        System.out.println(mensaje);

        int valor = Integer.parseInt(datos.nextLine());
        return valor;

    }

    // muestra mensajes genericos que le envia el controlador como los errores y las confirmaciones
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    // imprrime los intentos que el atleta lleva registrados hasta el momento
    public void mostrarIntentos(int[] intentosValidos){
        mostrarMensaje("Estos son los intentos que ya realizo el atleta: ");
        for(int i = 0; i < intentosValidos.length; i++){
            mostrarMensaje("Intento " + (i+1) + " con un tiempo de: " + intentosValidos[i]);
        }
        
    }

    public void mostrarIntentoEspecifico(int numeroIntento, int tiempo){
        mostrarMensaje("El atleta en su intento " + numeroIntento + " tuvo un tiempo de: " + tiempo + "segundos");
    }
    
    // muestra el promedio recibido del controlador
    public void mostrarPromedio(int promedio){
        mostrarMensaje("El promedio de intentos que ha realizado el atleta es de: " + promedio);
    }
    
    // muestra ambos valores
    public void mostrarMejorYPeorTiempo(int mejorTiempo, int peorTiempo){
        mostrarMensaje("El atlteta ha obtenido su MEJOR tiempo de " + mejorTiempo + " segundos");
        mostrarMensaje("El atlteta ha obtenido su PEOR tiempo de " + peorTiempo + " segundos");

    }
    
    // muestra intentos realizados y disponibles 
    public void mostrarIntentosDisponibles(int[] intentosDisponibles){
        mostrarMensaje("El atleta tiene REGISTRADOS " + intentosDisponibles[0] + " intentos");
        mostrarMensaje("El atleta tiene DISPONIBLES " + intentosDisponibles[1] + " intentos");

    }

}