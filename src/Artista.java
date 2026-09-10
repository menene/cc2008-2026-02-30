public class Artista {

    private String codigo_id;
    private String nombre_artistico;
    private String genero_musical;
    private float duracion;
    private short asistencia;

    public Artista(String codigo_id, String nombre_artistico,
                   String genero_musical, float duracion,
                   short asistencia) {

        if (duracion <= 0) {
            throw new IllegalArgumentException(
                "La duración debe ser mayor que 0."
            );
        }

        if (asistencia < 0) {
            throw new IllegalArgumentException(
                "La asistencia no puede ser negativa."
            );
        }

        this.codigo_id = codigo_id;
        this.nombre_artistico = nombre_artistico;
        this.genero_musical = genero_musical;
        this.duracion = duracion;
        this.asistencia = asistencia;
    }

    public String GetCodigo_id() {
        return codigo_id;
    }

    public String GetNombre_artistico() {
        return nombre_artistico;
    }

    public String GetGenero_musical() {
        return genero_musical;
    }

    public float Getduracion() {
        return duracion;
    }

    public short Getasistencia() {
        return asistencia;
    }

    public void SetNombre_artistico(String nombre_artistico) {
        this.nombre_artistico = nombre_artistico;
    }

    public void SetGenero_musical(String genero_musical) {
        this.genero_musical = genero_musical;
    }

    public void Setduracion(float duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException(
                "La duración debe ser mayor que 0."
            );
        }
        this.duracion = duracion;
    }

    public void Setasistencia(short asistencia) {
        if (asistencia < 0) {
            throw new IllegalArgumentException(
                "La asistencia no puede ser negativa."
            );
        }
        this.asistencia = asistencia;
    }
}