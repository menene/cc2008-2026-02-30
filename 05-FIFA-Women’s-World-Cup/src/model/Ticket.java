package model;

import java.util.Random;

public class Ticket {

    private int numeroTicket;
    private boolean aptoCompra;
    private Localidad localidad;

    private int a;
    private int b;

    private final Random random;

    public Ticket() {

        random = new Random();

        generarNumero();

        aptoCompra = false;
        localidad = null;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public boolean isAptoCompra() {
        return aptoCompra;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public void generarNumero() {
        numeroTicket = random.nextInt(15000) + 1;
    }

    public boolean validarTicket() {

        a = random.nextInt(15000) + 1;
        b = random.nextInt(15000) + 1;

        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);

        aptoCompra = (numeroTicket >= menor && numeroTicket <= mayor);

        return aptoCompra;
    }

    public void asignarLocalidad(Localidad[] localidades) {

        int indice = random.nextInt(localidades.length);

        localidad = localidades[indice];
    }
}