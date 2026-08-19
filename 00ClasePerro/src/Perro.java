class Perro {
    private String nombre;

    public String getNombre(){
        return nombre;
    }

    public String setNombre(String n){
        this.nombre = n;
    }

    public void ladrar() {
        System.out.println("Guau");
    }
}