package model;

import java.util.Random;

public class Ticket {
    private int numero;
    private int limiteInferior;
    private int limiteSuperior;
    private boolean valido;

    public Ticket() {
        validarTicket();
    }

    private void generarNumero() {
        Random random = new Random();
        this.numero = random.nextInt(15000) + 1;
    }

    public void generarLimites() {
        Random random = new Random();
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;

        if (a < b) {
            limiteInferior = a;
            limiteSuperior = b;
        } else {
            limiteInferior = b;
            limiteSuperior = a;
        }
    }

    public void validarTicket() {
        generarNumero();
        generarLimites();
        this.valido = numero <= limiteSuperior && numero >= limiteInferior;
    }

    public boolean getValido() {
        return valido;
    }

}