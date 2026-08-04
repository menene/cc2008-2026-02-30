import java.util.Scanner;

public class ControladorVenta {

    private SistemaVenta sistema;
    private VistaConsola vista;
    private Comprador compradorActual;

    public ControladorVenta(){

        sistema = new SistemaVenta();
        vista = new VistaConsola();

    }
    public void iniciar(){

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {

            vista.mostrarMenu();

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){

                case 1:

                    compradorActual = vista.leerComprador();
                    vista.mostrarMensaje("Comprador Registrado");
                    break;

                case 2: 

                    if (compradorActual == null){

                        vista.mostrarMensaje("Debe registrar un comprador");
                    } else{
                        sistema.procesarCompra(compradorActual);
                        vista.mostrarMensaje("Solicitud procesada");

                    }
                    break;

                case 3:

                    Localidad[] localidades = sistema.getLocalidades();

                    for (int i = 0; i < localidades.length; i++) {

                        System.out.println(
                            "Localidad " + localidades[i].getNumero() + "  //Disponibles: " + localidades[i].getDisponibles()
                        );
                    }
                    break;
                
                case 4: 
                    
                    System.out.print("Numero de localidad: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    Localidad localidad = sistema.buscarLocalidad(numero);

                    if (localidad != null) {

                        System.out.println("Disponibles: " + localidad.getDisponibles());
                    } else {

                        vista.mostrarMensaje("Localidad no encontrada");
                    }

                    break;
                
                case 5: 

                    String codigo = vista.leerCodigoAutorizacion();

                    if (sistema.validarCodigo(codigo)) {

                        System.out.println("Caja: Q" + sistema.calcularCaja());
                    } else {

                        vista.mostrarMensaje("Codigo Incorrecto");
                    }

                    break;

                case 6:

                    salir = true;
                    vista.mostrarMensaje("Gracias por utilizar el sistema");
                    break;
                
                default: 

                    vista.mostrarMensaje("Opcion invalida, ingrese una opcion en numeros");





            }
        }
           
            
    }   
}