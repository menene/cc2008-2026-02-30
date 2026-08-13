public class HabilidadEspecial {
    private String nombreHabilidad;
    private int probabilidadActivacion;

    public HabilidadEspecial (String nombreHabilidad, int probabilidadActivacion) {
        this.nombreHabilidad = nombreHabilidad;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }
        
    public boolean intentarActivacion() {
        int numero = (int)(Math.random()*101);
        return numero <= probabilidadActivacion;
    }

    public int generarPotenciador() {
        return (int)(Math.random()*26);
    }

}