public class Torneo {

    private Atleta[] atletas;
    private int cantidadAtletas;
    private Atleta atletaActivo; // agregamos atletaActivo para facilitar el codigo y hacerlo escalable (no se puso en el uml.)

    public Torneo() {
        atletas = new Atleta[20];
        cantidadAtletas = 0;
        atletaActivo = null;

    }

    public boolean agregarAtleta(Atleta atleta) {
        if (cantidadAtletas >= atletas.length) {
            return false;
        }

        atletas[cantidadAtletas] = atleta;
        cantidadAtletas++;
        atletaActivo = atleta;

        return true;
    }

    public Atleta obtenerAtleta(int indice) {
        if (indice < 0 || indice >= cantidadAtletas) {
            return null;
        }

        return atletas[indice];
    }

    public double calcularPromedio(Atleta atleta) {
        if (atleta == null || atleta.getCantidadIntentos() == 0) {
            return -1;
        }

        double suma = 0;

        for (int i = 0; i < atleta.getCantidadIntentos(); i++) {
            suma += atleta.obtenerTiempo(i);
        }

        return suma / atleta.getCantidadIntentos();
    }

    public double obtenerMejorTiempo(Atleta atleta) {
        if (atleta == null || atleta.getCantidadIntentos() == 0) {
            return -1;
        }

        double mejorTiempo = atleta.obtenerTiempo(0);

        for (int i = 1; i < atleta.getCantidadIntentos(); i++) {
            double tiempo = atleta.obtenerTiempo(i);

            if (tiempo < mejorTiempo) {
                mejorTiempo = tiempo;
            }
        }

        return mejorTiempo;
    }

    public double obtenerMayorTiempo(Atleta atleta) {
        if (atleta == null || atleta.getCantidadIntentos() == 0) {
            return -1;
        }

        double mayorTiempo = atleta.obtenerTiempo(0);

        for (int i = 1; i < atleta.getCantidadIntentos(); i++) {
            double tiempo = atleta.obtenerTiempo(i);

            if (tiempo > mayorTiempo) {
                mayorTiempo = tiempo;
            }
        }
        return mayorTiempo;
    }

    public Atleta obtenerMejorAtleta() {
        if (cantidadAtletas == 0) {
            return null;
        }

        Atleta mejorAtleta = null;
        double mejorTiempo = Double.MAX_VALUE;

        for (int i = 0; i < cantidadAtletas; i++) {
            double tiempo = obtenerMejorTiempo(atletas[i]);

            if (tiempo < mejorTiempo) {
                mejorTiempo = tiempo;
                mejorAtleta = atletas[i];
            }
        }

        return mejorAtleta;
    }

    public Atleta getAtletaActivo() {
        return atletaActivo;
    }

    public int getCantidadAtletas() {
        return cantidadAtletas;
    }
}

