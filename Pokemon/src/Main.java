/**
 * Autor: Daniel Eduardo Sacol Cojón - 26870
 * Laboratorio 1 - Programación Orientada a Objetos
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Combate Pokemon...");

        ConfiguradorJuego config = new ConfiguradorJuego();
        ControladorCombate controlador = config.armarEscenario();
        
        controlador.iniciarCombate();
    }
}