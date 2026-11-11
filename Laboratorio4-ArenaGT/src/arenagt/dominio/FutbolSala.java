package arenagt.dominio;

public final class FutbolSala extends Encuentro {
    FutbolSala(String id, Equipo a, Equipo b, Copa copa) { super(id, a, b, copa); }

    @Override
    protected void validarDeporte(int a, int b) {
        // Cualquier marcador no negativo es válido, incluido el empate.
    }

    @Override
    protected int puntosPara(int favor, int contra) {
        if (favor == contra) return 1;
        return favor > contra ? 3 : 0;
    }

    @Override
    protected String getDeporte() { return "Fútbol sala"; }
}
