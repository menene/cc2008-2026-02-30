public class Torneo {
    private Atleta atletaActivo;

    public Torneo() {
        atletaActivo = new Atleta("Angel", 1, 19);
    }

    public Atleta getAtletaActivo() {
        return atletaActivo;
    }

    public void setAtletaActivo(Atleta atleta) {
        atletaActivo = atleta;
    }

    public boolean hayAtletaActivo() {
        return atletaActivo != null;
    }

}
