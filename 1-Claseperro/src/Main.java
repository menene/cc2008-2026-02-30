public class Main {
    public static void main(String[] args) {
        // crear un objeto de la clase Perro

        Perro miPerro = new Perro();
        // establecer el nombre del perro

        miPerro.setNombre("Loki");
        // obtener el nombre del perro

        System.out.println("El nombre de mi perro es: " + miPerro.getNombre());
        // hacer que el perro ladre

        miPerro.ladrar();
    }
} 