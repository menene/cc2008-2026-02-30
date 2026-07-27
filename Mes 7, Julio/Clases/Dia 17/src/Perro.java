class Perro{
    private int age;
    private String name;
    private String raza;
    public Perro(String name, String raza, int age){
        this.age = age;
        this.raza= raza;
        this.name = name;
    }
    public String GetName(){
        return this.name;
    }
    public int GetAge(){
        return this.age;
    }
    public String GetRaza(){
        return this.raza;
    }
}