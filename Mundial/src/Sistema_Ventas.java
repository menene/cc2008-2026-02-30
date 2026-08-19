import java.util.Random;
public class Sistema_Ventas {
    private Vista vista;
    private Usuario comprador_actual;
    private Ticket ticket;
    private Localidad localidad;
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;
    private Random random;
    public Sistema_Ventas() {
        vista = new Vista();
        ticket = new Ticket();
        random = new Random();
        localidad1 = new Localidad(1, 20, 100);
        localidad5 = new Localidad(5, 20, 500);
        localidad10 = new Localidad(10, 20, 1000);
    }
    public void iniciar() {
        int opcion;
        do {
            vista.mostrar_Menu();
            opcion = vista.Leer_Opcion();
            switch (opcion) {
                case 1:
                    nuevo_Comprador(vista.leer_Comprador());
                    break;
                case 2:
                    solicitar_Compra();
                    break;
                case 3:
                    consultar_Disponibilidad_Total();
                    break;
                case 4:
                    consultar_Disponibilidad_Individual();
                    break;
                case 5:
                    reporte_Caja();
                    break;
                case 6:
                    System.out.println("Gracias por utilizar el sistema");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }
    public void nuevo_Comprador(Usuario comprador) {
        comprador_actual = comprador;
    }
    public void solicitar_Compra() {
        if (comprador_actual == null) {
            System.out.println("Debe registrar un comprador primero.");
            return;
        }
        ticket.generarTicket();
        ticket.generarNumeros();
        if (!ticket.validacionTicket()) {
            System.out.println("El ticket no fue seleccionado para comprar.");
            return;
        }
        localidad = asignar_Localidad();
        System.out.println("¡Ticket aceptado!");
        System.out.println("Localidad asignada: " + localidad.getNumero_Localidad());
        if (!localidad.hayLugar(comprador_actual.getCantidad_Boletos())) {
            System.out.println("No hay suficientes boletos disponibles.");
            return;
        }
        int total = comprador_actual.getCantidad_Boletos() * localidad.getPrecio_Boleto();
        if (total > comprador_actual.getPresupuesto()) {
            System.out.println("El presupuesto no es suficiente.");
            return;
        }
        localidad.vender_Boletos(comprador_actual.getCantidad_Boletos());
        System.out.println("Compra realizada con éxito.");
        System.out.println("Total pagado: $" + total);
        comprador_actual.actualizar_Presupuesto(total);
        }
    public void consultar_Disponibilidad_Total() {
        System.out.println("Localidad 1: " + localidad1.getCapacidad() + " boletos disponibles.");
        System.out.println("Localidad 5: " + localidad5.getCapacidad() + " boletos disponibles.");
        System.out.println("Localidad 10: " + localidad10.getCapacidad() + " boletos disponibles.");
    }
    public void consultar_Disponibilidad_Individual() {
        System.out.print("Ingrese la localidad (1, 5 o 10): ");
        int numero = vista.Leer_Opcion();
        if (numero == 1) {
            System.out.println("Boletos disponibles: " + localidad1.getCapacidad());
        } else if (numero == 5) {
            System.out.println("Boletos disponibles: " + localidad5.getCapacidad());
        } else if (numero == 10) {
            System.out.println("Boletos disponibles: " + localidad10.getCapacidad());
        } else {
            System.out.println("Localidad no válida.");
        }
    }
    public void reporte_Caja() {
        int total = 0;
        total += localidad1.getBoletosVendidos() * localidad1.getPrecio_Boleto();
        total += localidad5.getBoletosVendidos() * localidad5.getPrecio_Boleto();
        total += localidad10.getBoletosVendidos() * localidad10.getPrecio_Boleto();
        System.out.println("Total generado: $" + total);
    }
    private Localidad asignar_Localidad() {
        int numero = random.nextInt(3);
        if (numero == 0) {
            return localidad1;
        } else if (numero == 1) {
            return localidad5;
        } else {
            return localidad10;
        }
    }
}