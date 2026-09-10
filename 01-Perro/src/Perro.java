class Perro {

    // attrs
    private String nombre;
    private String raza;
    private int edad;

    public Perro(String n, String raza, int edad) {
        this.nombre = n;
        this.raza = raza;
        this.edad = edad;
    }

    // getter
    public String getNombre() {
        return this.nombre;
    }

    public String getRaza() {
        return this.raza;
    }

    // // setter
    // public void setNombre(String nombre) {
    //     this.nombre = nombre;
    // }

    // metodos
    public void ladrar() {
        System.out.println("Woof Woof");
    }

}