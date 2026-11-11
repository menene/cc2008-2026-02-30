package arenagt.dominio;

public final class Baloncesto extends Encuentro {
    Baloncesto(String id, Equipo a, Equipo b, Copa copa) { super(id, a, b, copa); }

    @Override
    protected void validarDeporte(int a, int b) {
        if (a == b) throw new IllegalArgumentException("En baloncesto no se permite empate.");
    }

    @Override
    protected int puntosPara(int favor, int contra) {
        return favor > contra ? 2 : 1;
    }

    @Override
    protected String getDeporte() { return "Baloncesto"; }
}
