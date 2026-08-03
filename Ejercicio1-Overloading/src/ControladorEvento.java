public class ControladorEvento {
    //atributos
    private Evento evento;
    private VistaEvento vista_evento;
    private Usuario user;
    private Ticket ticket_actual;

    //constructor
    public ControladorEvento() {
        //se inicializa el evento y la vista para que esten listos para usarse
        this.evento = new Evento ("Mundial Femenino 2027");
        this.vista_evento = new VistaEvento();
    }
    //metodo principal
    public void iniciar() {
        int opcion = 0; //se guarda lo que el usuario digite
        //se usa un ciclo do-while para que el menu se repita hasta que se salga (opcion 6)
        do {
            //se le pide a la vista que muestre el menu y que devuelva el numero elegido
            opcion = vista_evento.mostrarMenu();

            //se evalua la opcion con un switch
            switch()opcion {
                case 1:
                    //si elige 1 se llama al metodo dedicado a crear un usuario
                    crearNuevoComprador();
                    break;

                case 2:
                    //Aqui ira la logica de la compra
                    generarSolicitudboleto();
                    break;
                //Consultas simples
                case 3:
                    consultarDisponibilidadTotal();
                    break;
                case 4:
                    consultarDisponibilidadLocalidad();
                    break;
                case 5:
                    reporteCaja();
                    break;
                case 6:
                    vista_evento.MostrarMensaje("!Gracias por usar el sistema!");
                    break;
                default:
                    //Si el usuario escoge una opcion que no existe
                    vista_evento.mostrarMensaje("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
        while(opcion !=6);
    }
}