public class Main {

//Metodo principal con el cual se ejecuta el programa

    public static void main(String[] args) {

        //Se crea un objeto de la clase ControladorVenta y un objeto de la clase Menu, el cual recibe como parametro el objeto controlador creado anteriormente
        ControladorVenta controlador = new ControladorVenta();

        Menu menu = new Menu(controlador);

        menu.Ejecutar();

    }

}