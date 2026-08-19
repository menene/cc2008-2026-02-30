import java.util.Random; 

public class ControladorBoletos {
    private Cliente cliente; 
    private VistaBoletos vista = new VistaBoletos();
    private Localidad localidad1;
    private Localidad localidad5; 
    private Localidad localidad10; 

    public ControladorBoletos() {
        localidad1 = new Localidad("Localidad 1", 100);
        localidad5 = new Localidad("Localidad 5", 500);
        localidad10 = new Localidad("Localidad 10", 1000);
    }
    
    private Localidad asignarLocalidad() {
        Random random = new Random(); 
        int opcion = random.nextInt(3);

        if (opcion == 0){
            return localidad1;
        } else if (opcion == 1) {
            return localidad5; 
        } else {
            return localidad10; 
        }
    }

    public void iniciar() {

        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();


            if (opcion ==1 ) {
                nuevoComprador();
            } else if (opcion == 2) {
                nuevaSolicitud();
            } else if (opcion == 3) {
                consultaDisponibilidadTotal(); 
            } else if (opcion == 4) {
                consultaDisponibilidadIndividual();
            } else if (opcion == 5){
                reporteCaja(); 
            } else if (opcion == 0) {
                continuar = false;
            } else {
                System.out.println("Opcion invalida. Intentalo nuevamente");
            }
        }
    }

    private void nuevoComprador() {
        cliente = vista.leerDatosCliente();
    } 
    
    private void nuevaSolicitud() {
        if (cliente == null) {
            vista.mostrarFaltaCliente();
            return; 
        }
        Ticket ticket = new Ticket();
            if (ticket.isValid()) { 
                Localidad localidadElegida = asignarLocalidad(); 
                    if (localidadElegida.espaciosDisponibles() > 0) {
                        int compraBoletos = localidadElegida.boletosDisponibles(cliente.getCantidadBoletos());
                            if (localidadElegida.validarPresupuesto(cliente.getPresupuestoMax())) {
                                localidadElegida.agregarVentas(compraBoletos);
                                vista.mostrarCompra();
                            } else {
                                vista.mostrarPresupuestoInsuficiente();
                                return; 
                            }

                    } else{
                        vista.mostrarLocalidadLlena();
                        return;
                    }   
            } else {
                vista.mostarTicketRechazado();
                return;
            }
    }

    private void consultaDisponibilidadTotal(){
        vista.mostrarDisponibilidadTotal(localidad1, localidad5, localidad10);
    }

    private void consultaDisponibilidadIndividual(){
        int opcion = vista.leerLocalidad(); 
        if (opcion == 1) {
            vista.mostrarDisponibilidadIndividual(localidad1);
        } else if (opcion == 2) {
            vista.mostrarDisponibilidadIndividual(localidad5);
        } else if (opcion == 3) {
            vista.mostrarDisponibilidadIndividual(localidad10);
        } else {
            System.out.println("No existe dicha localidad, vuelve a intentar.");
        }

    }

    private void reporteCaja(){
        vista.reporteCaja(localidad1, localidad5, localidad10);      
    }

    
}



