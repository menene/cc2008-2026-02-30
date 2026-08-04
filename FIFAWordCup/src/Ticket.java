public class Ticket {
    private int numeroTicket;
    private int numeroA;
    private int numeroB;
    private boolean esApto;
    private Localidad localidadAsignada;

    public void generarNumeroTicket() {
        numeroTicket = (int) (Math.random() * 15000) + 1;
    }

    public void generarRangoAB() {
        numeroA = (int) (Math.random() * 15000) + 1;
        numeroB = (int) (Math.random() * 15000) + 1;
    }

    public boolean validarRango() {
        int minimo = Math.min(numeroA, numeroB);
        int maximo = Math.max(numeroA, numeroB);

        if (numeroTicket >= minimo && numeroTicket <= maximo) {
            esApto = true;
        } else {
            esApto = false;
        }

        return esApto;
    }

    public void asignarLocalidadAleatoria(Localidad loc1, Localidad loc2, Localidad loc3) {
        int numero = (int) (Math.random() * 3) + 1;

        if (numero == 1) {
            localidadAsignada = loc1;
        } else if (numero == 2) {
            localidadAsignada = loc2;
        } else {
            localidadAsignada = loc3;
        }
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public int getNumeroA() {
        return numeroA;
    }

    public int getNumeroB() {
        return numeroB;
    }

    public boolean isEsApto() {
        return esApto;
    }

    public Localidad getLocalidadAsignada() {
        return localidadAsignada;
    }
}
