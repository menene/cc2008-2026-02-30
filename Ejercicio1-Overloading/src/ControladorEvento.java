public class ControladorEvento {
    //atributos
    private Evento evento;
    private VistaEvento vista_evento;
    private Usuario User;
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
            switch(opcion) {
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
                    vista_evento.mostrarMensaje("¡Gracias por usar el sistema!");
                    break;
                default:
                    //Si el usuario escoge una opcion que no existe
                    vista_evento.mostrarMensaje("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
        while(opcion !=6);
    }
    //Logica de negocio
    private void crearNuevoComprador() {
        vista_evento.mostrarMensaje("\n--- Registro de Nuevo Comprador ---");

        //El controlador le ordena a la Vista que pregunte los datos
        String nombre = vista_evento.pedirNombre();
        String correo = vista_evento.pedirCorreo();
        int boletos = vista_evento.pedirBoletos();
        float presupuesto = vista_evento.pedirPresupuesto();

        //con los datos el controlador construye el objeto usuario
        this.User = new Usuario (nombre, correo, boletos, presupuesto);

        //le avisa al ciente que todo funciono
        vista_evento.mostrarMensaje("!Usuario registrado con éxito! Ya puedes solicitar boletos.");
    }
    private void generarSolicitudboleto() {
        vista_evento.mostrarMensaje("\n--- Solicitud de boletos ---");
        
        //Validar que exista un comprador registrado
        //Si this.User es 'Null' significa que no ha pasado por el registro
        if(this.User == null) {
            vista_evento.mostrarMensaje("Error: Debes registrar un comprador primero (Opción 1).");
            return; //Este return te detiene y regresa al menu
        }
        
        //Generar el ticket y probar si se valida con suerte
        Ticket nuevoTicket = new Ticket();
        vista_evento.mostrarMensaje("Tu número de ticket generado es: " + nuevoTicket.getNumero_Ticket());

        //Validacion de si el ticket es apto
        if (nuevoTicket.esAptoParaCompra()) {
            vista_evento.mostrarMensaje("¡Felicidades! Tu ticket fue seleccionado.");

            //El evento elige una localidad al azar
           Localidad localidadAsignada = this.evento.seleccionarLocalidadAleatoria();
            vista_evento.mostrarMensaje("Se te asignó una localidad con precio de: $" + localidadAsignada.getPrecio());

            //validacion de si la localidad aun tiene asientos disponibles
            if (localidadAsignada.validarEspacio()) {

                //Calculo de costo total
                //Primero se valida con la localidad cuantos boletos se le pueden vender al usuario
                int boletosAVender = localidadAsignada.calcularBoletosAVender(this.User.getBoletos_A_Comprar());
                float costoTotal = localidadAsignada.calcularCostoVenta(boletosAVender); //se delega la multiplicacion a la localidad para un mvc puro

                //Comprobacion de si el presupuesto del user es mayor o igual al costo total
                if (this.User.getPresupuesto() >= costoTotal) {

                    //En caso de que todo bien se registra la venta en la localidad
                    localidadAsignada.registrarVenta(boletosAVender);
                    vista_evento.mostrarMensaje("¡Compra exitosa! Se han vendido " + boletosAVender + " boletos.");
                    vista_evento.mostrarMensaje("Total pagado: $" + costoTotal);
                } 
                
                //en caso de que no alcance el presupuesto del usuario
                else {
                    vista_evento.mostrarMensaje("Lo sentimos, tu presupuesto de $" + this.User.getPresupuesto() + " no alcanza para pagar $" + costoTotal + ".");
                }
               //En caso de que se quede sin lugar el usuario 
            } else {
                vista_evento.mostrarMensaje("Lo sentimos, la localidad asignada ya está llena.");
            }
            //En caso de que el usuario no quede con un ticket valido
        } else {
            vista_evento.mostrarMensaje("Mala suerte. Tu ticket no quedó en el rango ganador. Intenta de nuevo.");
        }
    }
    
    private void consultarDisponibilidadTotal() {
        vista_evento.mostrarMensaje("\n--- DISPONIBILIDAD TOTAL ---");
        
        // Le pedimos al evento que haga las sumas
        int disponibles = this.evento.calcularDisponibilidadTotal();
        int vendidos = this.evento.calcularVendidosTotal();
        
        // La vista imprime los resultados
        vista_evento.mostrarMensaje("Boletos vendidos en total: " + vendidos);
        vista_evento.mostrarMensaje("Boletos disponibles en total: " + disponibles);
    }

    private void consultarDisponibilidadLocalidad() {
        vista_evento.mostrarMensaje("\n--- DISPONIBILIDAD POR LOCALIDAD ---");
        
        // Usamos un ciclo for para revisar las 3 localidades una por una
        for (int i = 1; i <= 3; i++) {
            Localidad loc = this.evento.getLocalidadPorId(i);
            vista_evento.mostrarMensaje("Localidad " + i + " (Precio: $" + loc.getPrecio() + "):");
            vista_evento.mostrarMensaje("  - Vendidos: " + loc.getBoletos_vendidos());
            vista_evento.mostrarMensaje("  - Disponibles: " + loc.getBoletos_disponibles());
        }
    }

    private void reporteCaja() {
        vista_evento.mostrarMensaje("\n--- REPORTE DE CAJA ---");
        
        // Le pedimos al evento que sume todo el dinero
        float totalCaja = this.evento.calcularCajaTotal();
        vista_evento.mostrarMensaje("El total de dinero recaudado en el evento es: $" + totalCaja);
    }
}