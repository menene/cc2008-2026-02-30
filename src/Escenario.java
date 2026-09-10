public class Escenario {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String estado;

    //constructor
    public Escenario(String codigo, String nombre, String ubicacion, 
                    int capacidadMaxima, String estado){
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;

        //se evalua primero que no sea 0 o un numero negativo antes de asignarle el valor
        if (capacidadMaxima <= 0) {
            //si es 0 o menor lanzamos un illegalArgumentException para que no muera
            throw new IllegalArgumentException("la capacidad maxima debe ser mayor que 0");
        }
        this.capacidadMaxima = capacidadMaxima;

        this.estado = estado;
        
    }

    //getters
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
        return capacidadMaxima;
    }

    public String getEstado(){
        return estado;
    }

    //setters
    public void setCapacidadMaxima(int capacidadMaxima){
        //mayor que 0 para que no muera
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                "La capacidad máxima debe ser mayor que 0."
            );
        }

        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



}
