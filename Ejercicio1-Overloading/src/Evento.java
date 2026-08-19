//se importa Random de Util
import java.util.Random;

//atributos
public class Evento {
    private String NombreEvento;
    private Localidad Localidad1;
    private Localidad Localidad2;
    private Localidad Localidad3;

    //constructor para evento
    public Evento(String nombreEvento) {
        this.NombreEvento = nombreEvento;

        //el evento crea sus instancias de localidad
        //se usara 100, 500 y 1000 como precio y 20 de capacidad maxima
        this.Localidad1 = new Localidad(100.0f, 20);
        this.Localidad2 = new Localidad(500.0f, 20);
        this.Localidad3 = new Localidad(1000.0f, 20);    
    }

    // ==================
    // METODOS
    // ==================

    //mecanimso que escoge al azar una de las 3 localidades y la devuelve
    public Localidad seleccionarLocalidadAleatoria() {
        Random aleatorio = new Random();
        int opcion = aleatorio.nextInt(3) + 1; //esto genera 1, 2 o 3
        return getLocalidadPorId(opcion);
    }

    // Buscador de localidad
    public Localidad getLocalidadPorId(int id) {
        switch (id) {
            case 1:
                return this.Localidad1;
            case 2:
                return this.Localidad2;
            case 3:
                return this.Localidad3;
            default:
                return null; //Esto es para evitar que el usuario ponga un caso que no funcione
        }
    }

    //Recuento de boletos disponibles de las 3 localidades
    public int calcularDisponibilidadTotal() {
        return this.Localidad1.getBoletos_disponibles() +
               this.Localidad2.getBoletos_disponibles() +
               this.Localidad3.getBoletos_disponibles();
    }
    
    //Suma de boletos vendidos de las 3 localidades
    public int calcularVendidosTotal() {
        // CORREGIDO: Se agregaron los () a las primeras dos líneas
        return this.Localidad1.getBoletos_vendidos() +
               this.Localidad2.getBoletos_vendidos() +
               this.Localidad3.getBoletos_vendidos();
    }
    
    //Suma del dinero generado por las 3 localidades
    public float calcularCajaTotal() {
        return this.Localidad1.generarGananciaLocalidad() +
               this.Localidad2.generarGananciaLocalidad() +
               this.Localidad3.generarGananciaLocalidad();
    }
}