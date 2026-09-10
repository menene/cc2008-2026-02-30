import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            View view = new View(scanner);
            view.start();
        } finally {
            scanner.close();

            System.out.println(
                "Recursos cerrados correctamente."
            );
        }
    }
}