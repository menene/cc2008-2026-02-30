package controller;

import model.Comprador;
import model.SistemaBoletos;
import view.Vista;

public class Controlador {

    private SistemaBoletos modelo;
    private Vista vista;

    public Controlador() {
        modelo = new SistemaBoletos();
        vista = new Vista();
    }

    public void iniciar() {

        int opcion;

        do {

            opcion = vista.mostrarMenu();

            procesarOpcion(opcion);

        } while (opcion != 6);

    }

    private void procesarOpcion(int opcion) {

        switch (opcion) {

            case 1:

                Comprador comprador = vista.leerComprador();

                modelo.nuevoComprador(comprador);

                vista.mostrarMensaje("Comprador registrado correctamente");

                break;

            case 2:

                vista.mostrarMensaje(modelo.solicitarCompra());

                break;

            case 3:

                vista.mostrarMensaje(modelo.consultarDisponibilidadTotal());

                break;

            case 4:

                int localidad = vista.pedirLocalidad();

                vista.mostrarMensaje(
                        modelo.consultarDisponibilidadIndividual(localidad));

                break;

            case 5:

                vista.mostrarCaja(modelo.reporteCaja());

                break;

            case 6:

                vista.mostrarMensaje("Gracias por utilizar el sistema");

                break;

            default:

                vista.mostrarMensaje("Opción inválida");

        }

    }

}