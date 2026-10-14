import java.util.Locale;

/* Programa principal. Crea la vista y arranca el menu de EnviaGT. */
public class Main {

    public static void main(String[] args) {
        /* Para que los montos salgan como Q1,200.00 sin importar la configuracion de la computadora */
        Locale.setDefault(Locale.US);

        Vista vista = new Vista();
        vista.mostrarMenu();
    }
}
