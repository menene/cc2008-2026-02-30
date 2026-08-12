public class HabilidadesEspeciales{
    private String nombre;
    private double probabilidadActivar;

    public HabilidadesEspeciales(String nombre, double probabilidadActivar) {
        this.nombre = nombre;
        this.probabilidadActivar = probabilidadActivar;
    }

    public String getNombre() {
        return nombre;
    }

    public double getProbabilidadActivar() {
        return probabilidadActivar;
    }

    public boolean seActiva() {
        return Math.random() * 100 <= probabilidadActivar;
    }

    public double generarPotenciador() {
        return Math.random() * 25;
    }
}