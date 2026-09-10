import java.util.InputMismatchException;
import java.util.Scanner;
public class OrdenView{
    Scanner scannerLoco= new Scanner(System.in);
    int opc;
    public int MostrarMenu(){
        System.out.println("====================");
        System.out.println("1. Registrar Orden");
        System.out.println("2. Consultar ordenes ");
        System.out.println("3. Buscar ordenes"); //control de excepciones
        System.out.println("4. Modificar Ordenes");//minimo de modificacion
        System.out.println("5. Cancelar Orden");//Eliminar objeto de array (Stack overflowErorr)
        System.out.println("6. Consultar Orden por placa"); //un vehiculo varias placas o algo asi 
        System.out.println("7. Reporte de costos");
        System.out.println("8. Orden de mayor costo");
        System.out.println("9. Cantidad de órdenes");
        System.out.println("10. Salir");
       
        return ingresoDatosNumericos();
        //Errores a evitar ()
    }

    public int ingresoDatosNumericos() throws InputMismatchException {
        if (!scannerLoco.hasNextInt()) {
            scannerLoco.next();
            throw new InputMismatchException("Dato invalido ");
        }
        opc = scannerLoco.nextInt();
        return opc;
    }
    public double ingresoDatosdouble() throws InputMismatchException {
        if (!scannerLoco.hasNextDouble()) {
            scannerLoco.next();
            throw new InputMismatchException("Dato invalido ");
        }
        double valor = scannerLoco.nextDouble();
        return valor;
    }
    public String IngresoDatosTexto() {
        String entrada = scannerLoco.next();
        if (entrada.trim().isEmpty()) {
            throw new InputMismatchException("El texto no puede estar vacío.");
        }
        return entrada;
    }

    public int NumerosIngreso(String Text){
        System.out.println(Text+": ");
        return ingresoDatosNumericos();
    }
    public double DoubleIngreso(String Text){
        System.out.println(Text+": ");
        return ingresoDatosdouble();
    }
    public String TextoIngreso(String Text){
        System.out.println(Text+": ");
        return IngresoDatosTexto();
    }
    public void TextoGenerico(String texto){
        System.out.println(texto); 
    }

    public void mostrarOrden(Orden orden) {
        if (orden == null) {
            System.out.println("Error: No hay datos de orden.");
            return;
        }

        System.out.println("================================");
        System.out.println("numero: " + orden.getNumeroOrden());
        System.out.println("Nombre: " + orden.getNombrePropietario());
        System.out.println("placa: " + orden.getPlacaVehiculo());
        System.out.println("Descripcion: " + orden.getDescripcion());
        System.out.println("Costo estimado: " + orden.getCostoEstimado());
        System.out.println("================================");

    }

    public int buscarOrdenes(){
        System.out.println("Ingrese el numero de orden a buscar: ");
        return ingresoDatosNumericos();
    }
    
    // no jovenes ya no quiero 

    
}