import java.util.Scanner;

public class TicketView {

	private final Scanner scanner;
	private final TicketController ticketController;

	public TicketView() {
		scanner = new Scanner(System.in);
		ticketController = new TicketController();
	}

	public void iniciar() {
		int opcion;
		do {
			mostrarMenu();
			opcion = leerEntero("Seleccione una opcion: ");
			if (opcion == 1) {
				realizarCompra();
			} else if (opcion != 2) {
				System.out.println("Opcion invalida.");
			}
		} while (opcion != 2);
		System.out.println("Programa finalizado.");
	}

	private void mostrarMenu() {
		System.out.println();
		System.out.println("--- MENU PRINCIPAL ---");
		System.out.println("1. Comprar boletos");
		System.out.println("2. Salir");
	}

	private void realizarCompra() {
		System.out.print("Nombre completo: ");
		String nombre = scanner.nextLine();
		System.out.print("Correo electronico: ");
		String email = scanner.nextLine();
		int cantidadBoletos = leerEntero("Cantidad de boletos: ");
		double presupuesto = leerDouble("Presupuesto maximo: ");
		String resultado = ticketController.procesarCompra(nombre, email, cantidadBoletos, presupuesto);
        mostrarResultado(resultado);
		System.out.println("Presione Enter para continuar...");
		scanner.nextLine();
	}

	private void mostrarResultado(String resultado) {
		System.out.println();
		System.out.println(resultado);
	}

	private int leerEntero(String mensaje) {
		System.out.print(mensaje);
		int valor = scanner.nextInt();
		scanner.nextLine();
		return valor;
	}

	private double leerDouble(String mensaje) {
		System.out.print(mensaje);
		double valor = scanner.nextDouble();
		scanner.nextLine();
		return valor;
	}
}
