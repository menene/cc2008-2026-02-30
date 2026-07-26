public class Main {

    public static void main(String[] args) {

        // Perro p1 = new Perro();
        // p1.setNombre("Scooby-Doo");
        // p1.ladrar();

        // Perro p3 = new Perro();
        // p3.setNombre("Firulais");
        // p3.ladrar();

        Perro p1 = new Perro("Scooby-Doo", "Grán Danés", 5);
        Perro p3 = new Perro("Angelito", "Pitt-Bull", 2);

        System.out.println("Perro " + p1.getNombre() + " de raza " + p1.getRaza() + " dice:");
        p1.ladrar();

        System.out.println("Perro " + p3.getNombre() + " de raza " + p3.getRaza() + " dice:");
        p3.ladrar();

        System.out.println(p1);
        System.out.println(p3);
    
    }

}