public class Escenario{
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidad_maxima;
    private String estado;
    public Escenario(String codigo, String nombre, String ubicacion, int capacidad_maxima, String estado){
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
        setCapacidad(capacidad_maxima);
    }
    public String getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public int getCapacidadMaxima(){
        return capacidad_maxima;
    }
    public String getEstado(){
        return estado;
    }
    public void setCapacidad(int capacidad_maxima){
        ValidarCapacidad(capacidad_maxima);
        this.capacidad_maxima = capacidad_maxima;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void ValidarCapacidad(int capacidad_maxima){
        if (capacidad_maxima<=0){
            throw new IllegalArgumentException("La capacidad maxima no puede ser menor o igual a 0");
        }
    }
}