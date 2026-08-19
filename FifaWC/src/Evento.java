import java.util.Random;

public class Evento {

    private int primer_Sorteo;
    private int segundo_Sorteo;
    private int tercer_Sorteo;
    private boolean sorteo1;

    public Evento() {

        primer_Sorteo = 0;
        segundo_Sorteo = 0;
        tercer_Sorteo = 0;
        sorteo1 = false;

    }

    public void generarPrimer_Sorteo() {

        Random random = new Random();
        primer_Sorteo = random.nextInt(15000) + 1;

    }

    public void generarSegundo_Sorteo() {

        Random random = new Random();
        segundo_Sorteo = random.nextInt(15000) + 1;

    }

    public void generarTercer_Sorteo() {

        Random random = new Random();
        tercer_Sorteo = random.nextInt(15000) + 1;

    }

    public boolean validarSorteo1() {

        int menor = Math.min(segundo_Sorteo, tercer_Sorteo);
        int mayor = Math.max(segundo_Sorteo, tercer_Sorteo);

        if (primer_Sorteo >= menor && primer_Sorteo <= mayor) {
            sorteo1 = true;
        } else {
            sorteo1 = false;
        }

        return sorteo1;

    }

    public int getPrimer_Sorteo() {

        return primer_Sorteo;

    }

}