import java.util.Scanner;
public class Vista{

    private Scanner sc=new Scanner(System.in);
    
    public int mostrarMenu(){
        System.out.println("\nBienvenido a la Competencia.");
        System.out.println("===========================");
        System.out.println("Opciones disponibles:");
        System.out.println("1. Reemplazar el atleta activo.");
        System.out.println("2. Registrar un nuevo intento.");
        System.out.println("3. Consultar tiempos registrados.");
        System.out.println("4. Consultar un intento registrado.");
        System.out.println("5. Modificar un intento registrado.");
        System.out.println("6. Mostrar promedio del atleta.");
        System.out.println("7. Mostrar mejor y peor tiempo.");
        System.out.println("8. Consultar intentos restantes.");
        System.out.println("9. Salir.");
        System.out.print("Ingrese el número de la acción que quiere realizar: ");

        return Integer.parseInt(sc.nextLine());
    }

    public String pedirNombre(){
        System.out.print("\nIngrese el nombre del atleta: ");
        return sc.nextLine();
    }

    public int pedirNumero(){
        System.out.print("\nIngrese el número del atleta: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int pedirEdad(){
        System.out.print("\nIngrese la edad del atleta: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void error(){
        System.out.println("\nOpcion invalida. Intentalo nuevamente.");
    }

    public double pedirTiempo(){
        System.out.print("\nIngrese el tiempo a registrar: ");
        return Double.parseDouble(sc.nextLine());
    }

    public int pedirIntento(){
        System.out.print("\nIngrese el número de intento: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void mostrarTiempos(double[] tiempos, int intentos){
        if(intentos==0){
            System.out.println("\nNo hay tiempos registrados.");
        }else{
            System.out.println("\nTiempos registrados:");
            for(int i=0;i<intentos;i++){
                System.out.println("Intento "+(i+1)+": "+tiempos[i]+" segundos.");
            }
        }
    }

    public void mostrarIntento(int intento, double tiempo){
        System.out.println("\nIntento "+intento+": "+tiempo+" segundos.");
    }

    public void mostrarPromedio(double promedio){
        System.out.println("\nPromedio: "+promedio+" segundos.");
    }

    public void mostrarMinMax(double mejor, double mayor){
        System.out.println("\nMejor tiempo: "+mejor+" segundos.");
        System.out.println("Mayor tiempo: "+mayor+" segundos.");
    }

    public void mostrarIntentos(int registrados, int disponibles){
        System.out.println("\nIntentos registrados: "+registrados);
        System.out.println("Intentos disponibles: "+disponibles);
    }

    public void exito(){
        System.out.println("\nOperacion realizada correctamente.");
    }
}
