import java.util.Scanner;
public class Vista{
    public String getName(int entrenador){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del entrenador "+entrenador+": ");
        return sc.nextLine();
    }
    public void mostrarResultados(String resultados){
        System.out.println(resultados);
    }
}