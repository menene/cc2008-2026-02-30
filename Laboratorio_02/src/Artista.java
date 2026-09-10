public class Artista{
    private String codigo;
    private String nombre;
    private String genero;
    private int duracion;
    private int asistentes;
    public Artista(String codigo, String nombre, String genero, int duracion, int asistentes){
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        setDuracion(duracion);
        setAsistencia(asistentes);
    }
    public String getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getGenero(){
        return genero;
    }
    public int getDuracion(){
        return duracion;
    }
    public int getAsistencia(){
        return asistentes;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDuracion(int duracion){
        ValidarDuracion(duracion);
        this.duracion = duracion;
    }
    public void setAsistencia(int asistentes){
        ValidarAsistencia(asistentes);
        this.asistentes = asistentes;
    }
    public void ValidarDuracion(int duracion){
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duracion de la presentacion debe ser mayor que cero.");
        } 
    }
    public void ValidarAsistencia(int asistentes){
        if (asistentes<0){
            throw new IllegalArgumentException("La cantidad de asistentes no puede ser menor a 0");
        }
    }
}