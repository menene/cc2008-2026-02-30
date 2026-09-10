public class Main {
    public static void main(String[] args) {

        Perro p1 = new Perro("Scobby-Doo", "Grán Danés", 5);

        // PRUEBA 1 ========================================
        // no instancia nueva, alias!
        // Perro p2 = p1;

        // System.out.println(p2.getNombre());
        // System.out.println(p1.getNombre());

        // p2.setNombre("Scrappy-Doo");

        // System.out.println(p2.getNombre());
        // System.out.println(p1.getNombre());

        // PRUEBA 2 ========================================
        // nuevo objeto, diferente espacio memoria
        // Perro p3 = new Perro("generico", "Grán Danés", 3);
        // p3.setNombre(p1.getNombre());

        // p3.setNombre("Scrappy-Doo");

        // System.out.println(p3.getNombre());
        // System.out.println(p1.getNombre());

        // PRUEBA 3 ========================================
        // Perro p4 = p1;

        // System.out.println(p4);
        // System.out.println(p1);

        // if (p1 == p4) {
        //     System.out.println("Mísmo perro...");
        // } else {
        //     System.out.println("Perro diferente...");
        // }

        // PRUEBA 4 ========================================
        // Perro p5 = new Perro("Scobby-Doo", "Grán Danés", 5);

        // System.out.println(p5);
        // System.out.println(p1);

        // if (p1 == p5) {
        //     System.out.println("Mísmo perro...");
        // } else {
        //     System.out.println("Perro diferente...");
        // }

        // if (p1.equals(p5)) {
        //     System.out.println("Mísmo perro...");
        // } else {
        //     System.out.println("Perro diferente...");
        // }


        // PRUEBA 5 ========================================
        String a = "Hola";
        String b = "Hola";

        System.out.println(a);
        System.out.println(b);

        if (a == b) {
            System.out.println("Mísmo string...");
        } else {
            System.out.println("String diferente...");
        }

        if (a.equals(b)) {
            System.out.println("Mísmo string...");
        } else {
            System.out.println("String diferente...");
        }
    }
}
