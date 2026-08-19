public class Controlador {

    private Comprador comprador;
    private Ticket ticket;
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;
    private Vista vista;

    //constructor
    public Controlador() {

        vista = new Vista();
        ticket = new Ticket();

        localidad1 = new Localidad(1, 100, 20);
        localidad5 = new Localidad(5, 500, 20);
        localidad10 = new Localidad(10, 1000, 20);

    }

    public void iniciar() {
        //inicia en 0
        int opcion = 0;
        //si es 6 es salir, si no sigue
        while (opcion != 6) {

            //muestra el menu desde vista
            vista.mostrarMenu();
            //es lo que ingrese el usuario
            opcion = vista.getScanner().nextInt();

            switch (opcion) {

                case 1:
                    nuevoComprador();
                    break;

                case 2:
                    nuevaSolicitud();
                    break;

                case 3:
                    //en vista, muestra los mensajes
                    vista.mostrarMensaje("===== DISPONIBILIDAD TOTAL =====");

                    //1ra localidad
                    vista.mostrarMensaje("Localidad 1");
                    //a localidad1 le aplico el get de boletos ya vendidos
                    vista.mostrarMensaje("Vendidos: " + localidad1.getBoletosVendidos());
                    //a localidad1 le aplico el metodo de boletos aun disponibles
                    vista.mostrarMensaje("Disponibles: " + localidad1.boletosDisponibles());

                    //2da localidad
                    vista.mostrarMensaje("Localidad 5");
                    vista.mostrarMensaje("Vendidos: " + localidad5.getBoletosVendidos());
                    vista.mostrarMensaje("Disponibles: " + localidad5.boletosDisponibles());

                    //3ra localidad
                    vista.mostrarMensaje("Localidad 10");
                    vista.mostrarMensaje("Vendidos: " + localidad10.getBoletosVendidos());
                    vista.mostrarMensaje("Disponibles: " + localidad10.boletosDisponibles());

                    break;

                case 4:
                    //en vista, muestra los mensajes
                    vista.mostrarMensaje("Ingrese la localidad (1, 5 o 10): ");
                    //este numero es otra variable que no inclui en el analisis, pero es solo para el if
                    //numero es lo que diga el usuario
                    int numero = vista.getScanner().nextInt();

                    if (numero == 1) {
                        vista.mostrarMensaje("Disponibles: " + localidad1.boletosDisponibles());

                    } 
                    else if (numero == 5) {
                        vista.mostrarMensaje("Disponibles: " + localidad5.boletosDisponibles());

                    } 
                    else if (numero == 10) {
                        vista.mostrarMensaje("Disponibles: " + localidad10.boletosDisponibles());

                    } 
                    else {
                        vista.mostrarMensaje("Localidad no es correcta.");
                    }

                    break;

                case 5:
                    //esto es la suma de boletos de cda localidad y su precio para saber cuando hay en total
                    int caja = (localidad1.getBoletosVendidos() * localidad1.getPrecioLocalidad()) 
                    + (localidad5.getBoletosVendidos() * localidad5.getPrecioLocalidad()) 
                    + (localidad10.getBoletosVendidos() * localidad10.getPrecioLocalidad());

                    //en vista, muestra los mensajes
                    vista.mostrarMensaje("Total recaudado: Q" + caja);
                    break;

                case 6:
                    //salir
                    vista.mostrarMensaje("Gracias por usar mi programa :)");
                    break;

                default:
                    //x si no es ninguna 
                    vista.mostrarMensaje("Opción inválida");
                    break;

            }

        }

    }


    public void nuevoComprador() {

        vista.mostrarMensaje("===== NUEVO COMPRADOR =====");
        
        //nombre
        vista.mostrarMensaje("Ingrese el nombre:");
        //limpia el enter (creo)
        vista.getScanner().nextLine(); 
        String nombre = vista.getScanner().nextLine();

        //email
        vista.mostrarMensaje("Ingrese el correo electrónico:");
        String email = vista.getScanner().nextLine();

        //cant boletos
        vista.mostrarMensaje("Ingrese la cantidad de boletos:");
        int cantidadBoletos = vista.getScanner().nextInt();

        //presupuesto
        vista.mostrarMensaje("Ingrese el presupuesto maximo:");
        float presupuestoMaximo = vista.getScanner().nextFloat();

        //ahroa le da esos datos a comprador y hace uno nuevo
        comprador = new Comprador(nombre, email, cantidadBoletos, presupuestoMaximo);
        vista.mostrarMensaje("listo ya estas registrado");

        }


    public void nuevaSolicitud() {

        //null, osea si no esta registrado
        if (comprador == null) {
            vista.mostrarMensaje("Primero tenes que registrar un comprador");
            //regresa al menu
            return;
        }

        //aca genera el ticket aleatorio
        int numeroTicket = ticket.generarTicket();
        //y se lo da al comprador
        comprador.setTicket(numeroTicket);

        //el rango de tickets, superior/inferior
        ticket.generarRango();

        //! significa que no, osea SI el ticket no esta en el rango, entonces no puede
        if (!ticket.validarTicket(numeroTicket)) {
            vista.mostrarMensaje("Quedas fuera del rango, no puedes comprar :(");
            //y te regresa
            return;
        }

        //genera una localidad aleatoria entre 1 y 3
        int localidadAleatoria = ticket.generarLocalidad();

        //si sale localidad 1
        if (localidadAleatoria == 1) {

            if (!localidad1.hayEspacio()) {
                vista.mostrarMensaje("La localidad 1 esta llena");
                return;
            }

            int boletos = comprador.getCantidadBoletos();

            if (boletos > localidad1.boletosDisponibles()) {
                boletos = localidad1.boletosDisponibles();
            }

            int total = boletos * localidad1.getPrecioLocalidad();

            if (total > comprador.getPresupuestoMaximo()) {
                vista.mostrarMensaje("El presupuesto no te alcanza");
                return;
            }

            localidad1.setBoletosVendidos(localidad1.getBoletosVendidos() + boletos);

            vista.mostrarMensaje("Compra realizada :)");
            vista.mostrarMensaje("Ticket: " + numeroTicket);
            vista.mostrarMensaje("Localidad: " + localidad1.getLocalidad());
            vista.mostrarMensaje("Boletos comprados: " + boletos);
            vista.mostrarMensaje("Total pagado: Q" + total);

        }

        //si sale localidad 5
        else if (localidadAleatoria == 2) {

            if (!localidad5.hayEspacio()) {
                vista.mostrarMensaje("La localidad 5 esta llena :(");
                return;
            }

            int boletos = comprador.getCantidadBoletos();

            if (boletos > localidad5.boletosDisponibles()) {
                boletos = localidad5.boletosDisponibles();
            }

            int total = boletos * localidad5.getPrecioLocalidad();

            if (total > comprador.getPresupuestoMaximo()) {
                vista.mostrarMensaje("El presupuesto no alcanza");
                return;
            }

            localidad5.setBoletosVendidos(localidad5.getBoletosVendidos() + boletos);

            vista.mostrarMensaje("Compra realizada :)");
            vista.mostrarMensaje("Ticket: " + numeroTicket);
            vista.mostrarMensaje("Localidad: " + localidad5.getLocalidad());
            vista.mostrarMensaje("Boletos comprados: " + boletos);
            vista.mostrarMensaje("Total pagado: Q" + total);

        }

        //si sale localidad 10
        else {

            if (!localidad10.hayEspacio()) {
                vista.mostrarMensaje("La localidad 10 esta llena :(");
                return;
            }

            int boletos = comprador.getCantidadBoletos();

            if (boletos > localidad10.boletosDisponibles()) {
                boletos = localidad10.boletosDisponibles();
            }

            int total = boletos * localidad10.getPrecioLocalidad();

            if (total > comprador.getPresupuestoMaximo()) {
                vista.mostrarMensaje("El presupuesto no alcanza");
                return;
            }

            localidad10.setBoletosVendidos(localidad10.getBoletosVendidos() + boletos);

            vista.mostrarMensaje("Compra realizada:)");
            vista.mostrarMensaje("Ticket: " + numeroTicket);
            vista.mostrarMensaje("Localidad: " + localidad10.getLocalidad());
            vista.mostrarMensaje("Boletos comprados: " + boletos);
            vista.mostrarMensaje("Total pagado: Q" + total);

        }

    }
}