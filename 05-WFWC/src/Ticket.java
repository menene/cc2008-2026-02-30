public class Ticket {
    private int numeroAleatorio;
    private boolean valido;
    private Localidad localidadAsignada;

    public Ticket() {
        this.numeroAleatorio = 0;
        this.valido = false;
        this.localidadAsignada = null;
    }

    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public void setNumeroAleatorio(int numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public Localidad getLocalidadAsignada() {
        return localidadAsignada;
    }

    public void setLocalidadAsignada(Localidad localidad) {
        this.localidadAsignada = localidad;
    }
}