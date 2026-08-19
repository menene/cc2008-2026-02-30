public class Vista {
    public Vista() {
    }
    public void mostrar_Resultado(String ganador) {
        if (ganador == null) {
            System.out.println("La batalla termino en empate");
        } else {
            System.out.println("El ganador de la batalla es: " + ganador);
        }
    }
}