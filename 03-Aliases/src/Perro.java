class Perro {

    private String nombre;
    private String raza;
    private int edad;

    public Perro(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void ladrar() {
        System.out.println("Woof Woof");
    }

    // @Override
    public boolean equals(Perro obj) {
        return this.nombre.equals(obj.getNombre());
    }

    // @Override
    public String toString() {
        return this.nombre + " - " + this.raza;
    }

}