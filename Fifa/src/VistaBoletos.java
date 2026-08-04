import java.util.Scanner;

public class VistaBoletos {
    private Scanner sc = new Scanner(System.in);


    public int mostrarMenu() {
        System.out.println("\n===== MENU ENTRADAS FIFA WORLD CUP =====");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual (Opción 1,5,10)");
        System.out.println("5. Reporte de caja");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        return Integer.parseInt(sc.nextLine());

    }
         
    public Cliente leerDatosCliente() {
        System.out.println("\n------Datos cliente----");
        System.out.println("nombre: ");
        String nombre = sc.nextLine();

        System.out.println("email: ");
        String email = sc.nextLine();

        System.out.println("Cantidad de boletos: ");
        int cantidadBoletos = Integer.parseInt(sc.nextLine());

        System.out.println("Presupuesto para boletos: ");
        float presupuestoMax = Float.parseFloat(sc.nextLine());

        return new Cliente(nombre, email, cantidadBoletos, presupuestoMax);
    }
    public void mostrarFaltaCliente() {
        System.out.println("No existe cliente, crea un cliente para poder continuar.");
    }

    public void mostarTicketRechazado() {
        System.out.println("Tu número de ticket fue rechazado. Vuelve a intentar.");
    }

    public void mostrarDisponibilidadTotal(Localidad localidad1, Localidad localidad5, Localidad localidad10) {
        System.out.println("------- Disponibilidad total -------");
        System.out.println("Localidad 1");
        System.out.println("\n Boletos disponibles" + localidad1.espaciosDisponibles());

        System.out.println("\n Localidad 5");
        System.out.println("\n Boletos disponibles" + localidad5.espaciosDisponibles());

        System.out.println("\n Localidad 10");
        System.out.println("\n Boletos disponibles" + localidad10.espaciosDisponibles());
    }


    public int leerLocalidad() {
                System.out.println("Opciones de consulta ");
        System.out.println("1. Localidad 1");
        System.out.println("2. Localidad 5");
        System.out.println("3. Localidad 10");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(sc.nextLine());
    }
    public void mostrarDisponibilidadIndividual (Localidad localidad) {

        System.out.println("\n ------ Disponibilidad individual ------ ");
        System.out.println("\n Boletos disponibles: " + localidad.espaciosDisponibles());
        System.out.println("\n Boletos vendidos: " + localidad.getBoletosVendidos());
    }
    public void mostrarLocalidadLlena(){
        System.out.println("La localidad ya está llena, no puede comprar.");
    }

    public void mostrarPresupuestoInsuficiente(){
        System.out.println("No tienes presupuesto suficiente, no puedes comprar");
    }

    public void mostrarCompra() {
        System.out.println("La compra fue realizada.");
    }
    public void reporteCaja (Localidad localidad1, Localidad localidad5, Localidad localidad10) {

        System.out.println("\n -------Reporte de caja-------");
        System.out.println("Localidad 1: $ " + localidad1.getCaja());
        System.out.println("Localidad 5: $ " +localidad5.getCaja());
        System.out.println("Localidad 10: $ " +localidad10.getCaja());
        
        float total = localidad1.getCaja()+ localidad5.getCaja() + localidad10.getCaja();
        System.out.println("\n En total se han generado: $" + total);
        
    }
}
