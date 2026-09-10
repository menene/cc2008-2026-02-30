public class Artista {
    private String codigo;
    private String nombre;
    private String generoMusical;
    private int duracion;
    private int asistentes;

    public Artista(String cod, String nomb, String genM, int dur, int asis) {
        this.codigo = cod;
        this.nombre = nomb;
        this.generoMusical = genM;
        this.duracion = dur;
        this.asistentes = asis;
    }

    public String getCodigo() {
        return (this.codigo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("Duracion debe ser mayor a 0 min1");
        }
        this.duracion = duracion;
    }

    public int getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(int asistentes) {
        if (asistentes < 0) {
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa.");
        }
        this.asistentes = asistentes;
    }

    public String GetArtista() {
        return ("Artista\n ->Codigo: " + codigo + "\n -> Nombre:" + nombre + "\n ->Genero Musical" + generoMusical +
                "\n ->Duracion: " + duracion + "\n -> Asistentes: " + asistentes);
    }

}