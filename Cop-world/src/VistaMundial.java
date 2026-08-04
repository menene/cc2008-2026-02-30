import java.util.Scanner;

public class VistaMundial{
    // atributos
    private Scanner sc = new Scanner(System.in);

    // métodos
    public void mostrarMenu(){
        System.out.println("\n===== MENU DE COMPRAS DE TICKET PARA EL MUNDIAL =====");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Mostrar reporte de caja");
        System.out.println("6. Salir del programa");
        System.out.println();
        System.out.print("Seleccione una opcion: ");

    }   

    public int leerOpcion(){
        int opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    public String[] pedirDatosComprador(){
        System.out.println("\n===== INGRESAR LOS DATOS DEL NUEVO COMPRADOR =====");

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Email:");
        String email = sc.nextLine();

        int boletosQuerer;
        while (true){
            System.out.println("¿Cuántos boletos desea? ");

            try{
                boletosQuerer = Integer.parseInt(sc.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Error: ingrese un número válido");
            }
        }

        int presupuesto;
        while (true) {
            System.out.print("¿Cuál es su presupuesto máximo? ");

            try {
                presupuesto = Integer.parseInt(sc.nextLine());
                break;
            } 
            catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
            }
        }

        // la vista solo recibe y regresa datos en crudo, no procesa nada
        return new String[]{
            nombre,
            email,
            Integer.toString(boletosQuerer),
            Integer.toString(presupuesto)
        };
    }

    public void mostrarMensaje(Comprador compradorFinal){
        System.out.println("\n===== RESULTADO DE LA SOLICITUD =====");
        System.out.println("Nombre: " + compradorFinal.getNombre());
        System.out.println("Ticket generado: " + compradorFinal.getTicket());
        System.out.println("¿Es apto para comprar?: " + compradorFinal.getEsApto());

        if (compradorFinal.getEsApto() == true){
            if (compradorFinal.getLocalidad() != null){
                System.out.println("Localidad asignada: " + compradorFinal.getLocalidad().getNombre());
            }

            System.out.println("Boletos comprados: " + compradorFinal.getBoletosTener());

        }
    }

    public String pedirNombreLocalidad(){
        System.out.print("Ingrese el nombre de la localidad: ");
        String nombre = sc.nextLine();
        return nombre;
    }

    public void mostrarDisponibles(String[] nombres, int[] vendidos, int[] disponibles){
        System.out.println("\n===== DISPONIBILIDAD DE BOLETOS =====");
        for (int i = 0; i < nombres.length; i++){
            System.out.println(nombres[i] + " - Vendidos: " + vendidos[i] + " - Disponibles: " + disponibles[i]);
        }
    }

    public void mostarReporte(int totalRecaudado){
        System.out.println("\n===== REPORTE DE CAJA =====");
        System.out.println("Total recaudado: $" + totalRecaudado);
    }
}
