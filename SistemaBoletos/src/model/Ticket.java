package model;

import java.util.Random;

public class Ticket {
    // Atributos
    private int numero;
    private int limiteInferior;
    private int limiteSuperior;
    private boolean valido;

    // Metodos

    // Al construir un objeto se valida de una vez
    public Ticket() {
        validarTicket();
    }

    // Genera un número random de 1 a 15000 para asignarle al Ticket
    private void generarNumero() {
        Random random = new Random();
        this.numero = random.nextInt(15000) + 1;
    }

    // Genera los límites y determina cual es el inferior y el superior
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

    // Valida que el numero del ticket se encuentre entre los límites
    public void validarTicket() {
        generarNumero();
        generarLimites();
        this.valido = numero <= limiteSuperior && numero >= limiteInferior;
    }

    // Devuelve la validez del ticket
    public boolean getValido() {
        return valido;
    }

}