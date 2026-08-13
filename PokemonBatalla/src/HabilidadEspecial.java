public class HabilidadEspecial {
    private String nombre;
    private int probabilidadEspecial;

    public HabilidadEspecial() {
    }

    public HabilidadEspecial(String nombre, int probabilidadEspecial) {
        this.nombre = nombre;
        this.probabilidadEspecial = probabilidadEspecial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProbabilidadEspecial() {
        return probabilidadEspecial;
    }

    public void setProbabilidadEspecial(int probabilidadEspecial) {
        this.probabilidadEspecial = probabilidadEspecial;
    }
}