package model;

/* Clase de la solicitud. Genera el ticket y los numeros a y b del sorteo. */
public class Solicitud {

    private int numeroSolicitud;
    private int numeroTicketAleatorio;
    private int limiteNum1;
    private int limiteNum2;
    private Comprador comprador;
    private Localidad localidadAsignada;

    /* Constructor. Recibe el comprador que hace la solicitud */
    public Solicitud(Comprador comprador) {
        this.comprador = comprador;
        numeroSolicitud = 1;
        numeroTicketAleatorio = 0;
        limiteNum1 = 0;
        limiteNum2 = 0;
        localidadAsignada = null;
    }

    /* Constructor sobrecargado, recibe tambien el numero de la solicitud */
    public Solicitud(Comprador comprador, int numeroSolicitud) {
        this.comprador = comprador;
        this.numeroSolicitud = numeroSolicitud;
        numeroTicketAleatorio = 0;
        limiteNum1 = 0;
        limiteNum2 = 0;
        localidadAsignada = null;
    }

    /* Saca el numero de ticket y los dos numeros del rango */
    public void generarSolicitud() {
        numeroTicketAleatorio = generarNumAleatorio();
        limiteNum1 = generarNumAleatorio();
        limiteNum2 = generarNumAleatorio();
    }

    /* Saca un numero al azar del 1 al 15000 */
    public int generarNumAleatorio() {
        return generarNumAleatorio(1, 15000);
    }

    /* Sobrecarga. Saca un numero al azar entre los limites que le manden */
    public int generarNumAleatorio(int limiteInferior, int limiteSuperior) {
        int cantidadNumeros = limiteSuperior - limiteInferior + 1;
        double numeroDecimal = Math.random() * cantidadNumeros;
        int numeroEntero = (int) numeroDecimal;
        return numeroEntero + limiteInferior;
    }

    /* Dice si el ticket cayo entre los numeros a y b */
    public boolean validarRangoNumAleatorio() {
        int menor = limiteNum1;
        int mayor = limiteNum2;

        /* Se ordenan porque a veces el segundo numero sale mas pequeno */
        if (limiteNum1 > limiteNum2) {
            menor = limiteNum2;
            mayor = limiteNum1;
        }

        if (numeroTicketAleatorio >= menor && numeroTicketAleatorio <= mayor) {
            return true;
        }
        return false;
    }

    /* Guarda la localidad que le toco al comprador */
    public void asignarLocalidad(Localidad localidadAsignada) {
        this.localidadAsignada = localidadAsignada;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Localidad getLocalidadAsignada() {
        return localidadAsignada;
    }

    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public int getNumeroTicketAleatorio() {
        return numeroTicketAleatorio;
    }

    public int getLimiteNum1() {
        return limiteNum1;
    }

    public int getLimiteNum2() {
        return limiteNum2;
    }
}
