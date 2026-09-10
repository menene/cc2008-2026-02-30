public class Escenario{

    private int codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMax;
    private boolean estado;

    public Escenario(int codigo, String nombre,String ubicacion, int capacidadMax, boolean estado){
        if (capacidadMax <= 0){
            throw new IllegalArgumentException("La capacidad no es valida");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMax = capacidadMax;
        this.estado = estado;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion(){
        return ubicacion;
    }

    public int getCapacidad(){
        return capacidadMax;
    }

    public boolean getEstado(){
        return estado;
    }

    //editar capacidad

    public void setCapacidad(int capacidad){
        if(capacidad<=0){
            throw new IllegalArgumentException("Capacidad que no es valida");
        }
        this.capacidadMax = capacidad;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}