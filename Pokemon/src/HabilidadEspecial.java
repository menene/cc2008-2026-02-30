public class HabilidadEspecial {
    private String nombre;
    private double probabilidadActivacion;

    public HabilidadEspecial(String nombre, double probabilidadActivacion) {
        this.nombre = nombre;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public boolean calcularSiSeActiva() {
        double aleatorio = Math.random() * 100;
        return aleatorio <= probabilidadActivacion;
    }

    public double calcularPotenciador() {
        return Math.random() * 0.25; // Retorna un valor entre 0 y 0.25
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getProbabilidadActivacion() { return probabilidadActivacion; }
    public void setProbabilidadActivacion(double probabilidadActivacion) { this.probabilidadActivacion = probabilidadActivacion; }
}