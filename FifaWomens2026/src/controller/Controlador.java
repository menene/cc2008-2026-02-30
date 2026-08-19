package controller;

import model.Comprador;
import model.Localidad;
import model.Solicitud;
import view.Vista;

/* Clase del controlador. Conecta la vista con el modelo y hace el sorteo. */
public class Controlador {

    private Vista vista;
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;
    private Comprador comprador;
    private Solicitud solicitud;
    private int contadorSolicitudes;

    /* Constructor. Crea la vista y las 3 localidades */
    public Controlador() {
        vista = new Vista();
        localidad1 = new Localidad(1, 100.0);
        localidad5 = new Localidad(5, 500.0);
        localidad10 = new Localidad(10, 1000.0);
        comprador = null;
        solicitud = null;
        contadorSolicitudes = 0;
    }

    /* Constructor sobrecargado, recibe el comprador que crea el Main */
    public Controlador(Comprador comprador) {
        vista = new Vista();
        localidad1 = new Localidad(1, 100.0);
        localidad5 = new Localidad(5, 500.0);
        localidad10 = new Localidad(10, 1000.0);
        this.comprador = comprador;
        solicitud = null;
        contadorSolicitudes = 0;
    }

    /* Repite el menu hasta que el usuario elija salir */
    public void iniciar() {
        int opcion = 0;

        while (opcion != 6) {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            if (opcion == 1) {
                nuevoComprador();
            } else if (opcion == 2) {
                nuevaSolicitud();
            } else if (opcion == 3) {
                disponibilidadTotal();
            } else if (opcion == 4) {
                disponibilidadIndividual();
            } else if (opcion == 5) {
                reporteCaja();
            } else if (opcion == 6) {
                vista.mostrarMensaje("Adios");
            } else {
                vista.mostrarMensaje("Opcion invalida");
            }
        }

        vista.cerrar();
    }

    /* Escoge al azar una de las 3 localidades */
    public Localidad generarLocalidadAleatoria() {
        double numeroDecimal = Math.random() * 3;
        int numeroLocalidad = (int) numeroDecimal + 1;

        if (numeroLocalidad == 1) {
            return localidad1;
        }
        if (numeroLocalidad == 2) {
            return localidad5;
        }
        return localidad10;
    }

    /* Opcion 1. Pide los datos y cambia el comprador activo */
    public void nuevoComprador() {
        vista.mostrarMensaje("");
        vista.mostrarMensaje("NUEVO COMPRADOR");

        String nombre = vista.leerTexto("Nombre: ");
        String email = vista.leerTexto("Email: ");
        int boletosDeseados = vista.leerEntero("Boletos que desea: ");
        double presupuestoMaximo = vista.leerDecimal("Presupuesto maximo: ");

        comprador = new Comprador(nombre, email, boletosDeseados, presupuestoMaximo);

        vista.mostrarMensaje("Comprador registrado");
    }

    /* Opcion 2. Hace el sorteo y vende los boletos si se puede */
    public void nuevaSolicitud() {
        vista.mostrarMensaje("");
        vista.mostrarMensaje("NUEVA SOLICITUD");

        if (comprador == null) {
            vista.mostrarMensaje("No hay comprador. Use la opcion 1");
            return;
        }
        if (comprador.getBoletosDeseados() <= 0) {
            vista.mostrarMensaje("El comprador no ha pedido boletos. Use la opcion 1");
            return;
        }

        contadorSolicitudes = contadorSolicitudes + 1;
        solicitud = new Solicitud(comprador, contadorSolicitudes);
        solicitud.generarSolicitud();

        vista.mostrarMensaje("Solicitud numero: " + solicitud.getNumeroSolicitud());
        vista.mostrarMensaje("Comprador: " + comprador.getNombreComprador());
        vista.mostrarMensaje("Ticket: " + solicitud.getNumeroTicketAleatorio());
        vista.mostrarMensaje("Numero a: " + solicitud.getLimiteNum1());
        vista.mostrarMensaje("Numero b: " + solicitud.getLimiteNum2());

        /* Si el ticket no cae en el rango se termina el proceso */
        if (solicitud.validarRangoNumAleatorio() == false) {
            vista.mostrarMensaje("El ticket no esta en el rango. No puede comprar");
            return;
        }
        vista.mostrarMensaje("El ticket si esta en el rango");

        Localidad localidadAsignada = generarLocalidadAleatoria();
        solicitud.asignarLocalidad(localidadAsignada);

        vista.mostrarMensaje("Localidad asignada: " + localidadAsignada.getIdentificadorLocalidad());
        vista.mostrarMensaje("Precio del boleto: " + localidadAsignada.getPrecioBoleto());

        /* Validacion 1 */
        if (localidadAsignada.validarEspacio() == false) {
            vista.mostrarMensaje("La localidad ya se lleno. No puede comprar");
            return;
        }

        /* Validacion 2 */
        int boletosAVender = localidadAsignada.validarDisponibilidad(comprador.getBoletosDeseados());
        if (boletosAVender < comprador.getBoletosDeseados()) {
            vista.mostrarMensaje("Solo hay espacio para: " + boletosAVender);
        }

        /* Validacion 3 */
        if (localidadAsignada.validarPrecio(comprador.getPresupuestoMaximo()) == false) {
            vista.mostrarMensaje("El precio pasa su presupuesto. No puede comprar");
            return;
        }

        double montoCobrado = localidadAsignada.venderBoletos(boletosAVender);
        comprador.comprarBoleto(boletosAVender, localidadAsignada.getPrecioBoleto());

        vista.mostrarMensaje("Venta realizada");
        vista.mostrarMensaje("Boletos vendidos: " + boletosAVender);
        vista.mostrarMensaje("Total cobrado: " + montoCobrado);
    }

    /* Opcion 3 Muestra las 3 localidades y los totales */
    public void disponibilidadTotal() {
        int vendidosTotales = localidad1.getBoletosVendidos() + localidad5.getBoletosVendidos() + localidad10.getBoletosVendidos();
        int disponiblesTotales = localidad1.getBoletosDisponibles() + localidad5.getBoletosDisponibles() + localidad10.getBoletosDisponibles();

        vista.mostrarMensaje("");
        vista.mostrarMensaje("DISPONIBILIDAD TOTAL");
        mostrarLocalidad(localidad1);
        mostrarLocalidad(localidad5);
        mostrarLocalidad(localidad10);
        vista.mostrarMensaje("Vendidos en total: " + vendidosTotales);
        vista.mostrarMensaje("Disponibles en total: " + disponiblesTotales);
    }

    /* Opcion 4 Muestra solo la localidad que pida el usuario */
    public void disponibilidadIndividual() {
        vista.mostrarMensaje("");
        vista.mostrarMensaje("DISPONIBILIDAD INDIVIDUAL");

        int identificador = vista.leerEntero("Localidad (1, 5 o 10): ");

        if (identificador == 1) {
            mostrarLocalidad(localidad1);
        } else if (identificador == 5) {
            mostrarLocalidad(localidad5);
        } else if (identificador == 10) {
            mostrarLocalidad(localidad10);
        } else {
            vista.mostrarMensaje("Esa localidad no existe");
        }
    }

    /* Opcion 5 Muestra el dinero de cada localidad y el total */
    public void reporteCaja() {
        double totalRecaudado = localidad1.getDineroRecaudado() + localidad5.getDineroRecaudado() + localidad10.getDineroRecaudado();

        vista.mostrarMensaje("");
        vista.mostrarMensaje("REPORTE DE CAJA");
        vista.mostrarMensaje("Localidad 1: " + localidad1.getDineroRecaudado());
        vista.mostrarMensaje("Localidad 5: " + localidad5.getDineroRecaudado());
        vista.mostrarMensaje("Localidad 10: " + localidad10.getDineroRecaudado());
        vista.mostrarMensaje("Total recaudado: " + totalRecaudado);
    }

    /* Imprime en una linea el estado de una localidad */
    private void mostrarLocalidad(Localidad localidad) {
        vista.mostrarMensaje("Localidad " + localidad.getIdentificadorLocalidad() + " - Vendidos: " + localidad.getBoletosVendidos() + " - Disponibles: " + localidad.getBoletosDisponibles());
    }
}
