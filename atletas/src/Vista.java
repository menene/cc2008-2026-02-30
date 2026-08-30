import java.util.Scanner;

public class Vista{
    private Scanner sc = new Scanner(System.in);
    
    public int mostrarMenu() {
      System.out.println("--------Menú de los tiempos del atleta---------");
      System.out.println("1. Ingresar un nuevo atleta");
      System.out.println("2. Ingresar un nuevo intento");
      System.out.println("3. Consultar los tiempos registrados");
      System.out.println("4. Consultar el registro de un intento");
      System.out.println("5. Modificar el tiempo de un intento ");
      System.out.println("6. Mostrar promedio de intentos ");
      System.out.println("7. Mostrar el mejor tiempo y el tiempo más alto"); 
      System.out.println("8. Consultar registros disponibles"); 
      System.out.println("9. Salir"); 

      return Integer.parseInt(sc.nextLine());

    }

    public Atleta leerAtleta(){
      System.out.println("\n------Datos del atleta----");
        System.out.println("nombre: ");
        String nombre = sc.nextLine();

        System.out.println("numero participante: ");
        int numeroParticipante = Integer.parseInt(sc.nextLine());

        System.out.println("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        return new Atleta(nombre, numeroParticipante, edad);
    }
    

    public int solicitarTiempo() {
      System.out.println("Ingresa el tiempo a registrar en segundos: ");
      int tiempo = Integer.parseInt(sc.nextLine());

      if (tiempo <=0){
        System.out.println("Debe ser un tiempo mayor que 0");
      } return tiempo; 
    }

    public int pedirNumeroIntento() {
      System.out.println("Ingresa el intento a consultar: ");
      return Integer.parseInt(sc.nextLine());
    }
    
    public void mostrarIntentosRestantes( int intentosRestantes){ 
      System.out.println("Intentos restantes: " + intentosRestantes); 
    }

    public void mostrarIntentosRealizados( int intentosRealizados){
      System.out.println("Intentos realizados: " + intentosRealizados); 
    }

    public void mostrarMejorTiempo(int mejorTiempo) {
      if (mejorTiempo == 0){
        System.out.println("No hay registros");
      }else {
      System.out.println("El mejor tiempo registrado es: " + mejorTiempo); 
      }
    }

    public void mostrarPeorTiempo(int peorTiempo){
      if (peorTiempo == 0){
        System.out.println("No hay registros");
      }else {
      System.out.println("El tiempo más alto registrado es: " + peorTiempo);
      }
    }


    public void mostrarPromedioIntentos( int promedioIntentos){
      if (promedioIntentos == 0){
        System.out.println("No puede calcularse el promedio sin registros");
      } else {
        System.out.println("Promedio de los tiempos registrados: " + promedioIntentos);
      }
      
    }

    public void mostrarTiempos( int[] intentos, int cantidadIntentos){
      if (cantidadIntentos ==0){
        System.out.println("No hay tiempos registrados aún");
      }else {
        for (int i = 0; i < cantidadIntentos; i++) {
          System.out.println("Intento seleccionado: " + (i +1));
          System.out.println("Tiempos registrados: " + intentos[i]);
      }  
      }
    
    }

    public void mostrarIntento(int numeroIntento, int tiempo){
      if (tiempo > 0){
        System.out.println("El intento numero " + numeroIntento);
        System.out.println("tiene registrado: " + tiempo + " segundos");
      } else {
        System.out.println("No existe registro en ese intento");
      }
      
    }

    public void mostrarDisponibles(int intentosRealizados, int intentosRestantes) {
      System.out.println("Los intentos realizados son: " + intentosRealizados );
      System.out.println("Los intentos restantes son: " + intentosRestantes);

    }

}